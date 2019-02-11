package com.cyh.serviceconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yunhai.chen
 * @date 2018/6/26 19:24<br>
 * Description:
 **/
@FeignClient(value = "service-provider", fallback = ServiceProviderInterfaceImpl.class)
public interface ServiceProviderInterface {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    int add(@RequestParam("number1") int number1, @RequestParam("number2") int number2);
}
