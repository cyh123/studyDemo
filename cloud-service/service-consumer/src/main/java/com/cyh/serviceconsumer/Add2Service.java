package com.cyh.serviceconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yunhai.chen
 * @date 2018/6/26 19:42<br>
 * Description:
 **/
@Service
public class Add2Service {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String add(int number1, int number2) {
        return restTemplate.getForEntity(StringFormatter.format("http://SERVICE-PROVIDER/add?number1=%d&number2=%d", number1, number2).getValue(), String.class).getBody();
    }

    public String addServiceFallback(int number1, int number2) {
        return Integer.toString(-1);
    }
}
