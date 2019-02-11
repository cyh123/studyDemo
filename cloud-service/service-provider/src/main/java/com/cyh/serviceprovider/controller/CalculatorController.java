package com.cyh.serviceprovider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunhai.chen
 * @date 2018/6/26 18:29<br>
 * Description:
 **/
@RestController
public class CalculatorController {
    private final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/add")
    public int add(@RequestParam("number1") int number1, @RequestParam("number2") int number2) {
        logger.info("the result is {}", (number1 + number2));
        return number1 + number2;
    }
}
