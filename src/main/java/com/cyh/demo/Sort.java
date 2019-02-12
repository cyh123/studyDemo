import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {1,5,12,7,34,2,0};
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {1,5,12,7,34,2,0};
        System.out.println(Arrays.toString(array2));
        bubbleSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {1,5,12,7,34,2,0};
        System.out.println(Arrays.toString(array3));
        selectSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {1,5,12,7,34,2,0};
        System.out.println(Arrays.toString(array4));
        quickSort(array4, 0, array4.length - 1);
        System.out.println(Arrays.toString(array4));

        int[] array5 = {1,5,12,7,34,2,0};
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(mergeSort(array5)));
    }

    public static void insertSort(int[] array) {
        for (int i=1; i < array.length; i++) {
            int newIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if(array[i] < array[j]) {
                    newIndex = j;
                }
            }
            int value = array[i];
            for (int index = i; index > newIndex; index--) {
                array[index] = array[index - 1];
            }
            array[newIndex] = value;
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int index = 0;
            for (int j = 0; j < array.length - i; j++) {
                if(array[j] > array[index]) {
                    index = j;
                }
            }
            swap(array, index, array.length - i - 1);
        }
    }

    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    static void quickSort(int[] array, int low, int high) {
        int left = low;
        int right = high;
        if(left >= right) {
            return;
        }

        int tmp = array[left];

        while (left < right) {
            while (left < right && array[right] > tmp) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] < tmp) {
                left++;
            }
            array[right] = array[left];
        }

        array[left] = tmp;

        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);
    }

    static void swap(int[] array, int oldIndex, int newIndex) {
        int tmp = array[newIndex];
        array[newIndex] = array[oldIndex];
        array[oldIndex] = tmp;
    }

    static int[] mergeSort(int[] array) {
        int index = array.length / 2;
        if(index < 1) {
            return array;
        }
        return mergeTwoArray(mergeSort(Arrays.copyOfRange(array, 0, index)), mergeSort(Arrays.copyOfRange(array, index, array.length)));
    }

    static int[] mergeTwoArray(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        while (j < array2.length) {
            result[k++] = array2[j++];
        }
        return result;
    }
}
