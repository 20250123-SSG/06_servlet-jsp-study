package com.sotogito.servlet.section06.filter;


import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("LifeCycleFilter constructor~~~~");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LifeCycleFilter init~~~~");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LifeCycleFilter doFilter~~~~`");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleFilter destroy~~~~~");


    }
}
