package com.vs.authorizationService.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import javax.servlet.*;
import java.util.logging.Logger;

@Component
public class CustomFilterURL implements Filter {

    //Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //logger.info("CustomFilter is invoked");
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {

    }
}
