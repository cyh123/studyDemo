package com.cyh.servicezuul.filter;

import com.cyh.servicezuul.config.SampleProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yunhai.chen
 * @date 2018/8/30 14:26<br>
 * Description:
 **/
@Component
public class FirstZuulFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(FirstZuulFilter.class);

    @Value("${username}")
    private String username;

    private final SampleProperties sampleProperties;

    @Autowired
    public FirstZuulFilter(SampleProperties sampleProperties) {
        this.sampleProperties = sampleProperties;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("-- FirstZuulFilter | this sampleProperties username is {}", sampleProperties.getUsername());
        logger.info("-- FirstZuulFilter | the username is {}", username);
        RequestContext currentContext = RequestContext.getCurrentContext();
        logger.info("-- SecondZuulFilter | request from {}", currentContext.getRequest().getRemoteAddr() + ":" + currentContext.getRequest().getRemotePort());
        return null;
    }
}
