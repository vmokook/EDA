package com.study.config;

import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;
=======
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

<<<<<<< HEAD
@Configuration
=======
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
public class WebConfig {
    @Bean
    public ViewResolver xsltViewResolver(){
        XsltViewResolver viewResolver = new XsltViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setViewClass(XsltView.class);
        viewResolver.setViewNames("debtorXSL", "apartmentXSL","houseXSL");
        viewResolver.setPrefix("classpath:/xsl/");
        viewResolver.setSuffix(".xsl");
        return viewResolver;
    }
}

