package com.cyh.serviceconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yunhai.chen
 * @date 2018/6/26 18:38<br>
 * Description:
 **/
@RestController
public class ConsumerController {
    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ServiceProviderInterface serviceProviderInterface;

    @Autowired
    private Add2Service add2Service;

    // 采用FeignClient的方式来实现接口的调用
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam("number1") int number1, @RequestParam("number2") int number2) {
        logger.info(" -- add | consumer info");
        return Integer.toString(serviceProviderInterface.add(number1,number2));
    }

    // 采用普通的服务路径查找的方式来实现接口的调用
    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public String add2(@RequestParam("number1") int number1, @RequestParam("number2") int number2) {
        logger.info(" -- add2 | consumer info");
        return add2Service.add(number1, number2);
    }
}
