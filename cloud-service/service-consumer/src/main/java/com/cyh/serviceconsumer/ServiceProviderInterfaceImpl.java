package com.cyh.serviceconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yunhai.chen
 * @date 2018/6/26 19:41<br>
 * Description:
 **/
@Component
public class ServiceProviderInterfaceImpl implements ServiceProviderInterface {
    @Override
    public int add(@RequestParam("number1") int number1, @RequestParam("number2") int number2) {
        return -1;
    }
}
