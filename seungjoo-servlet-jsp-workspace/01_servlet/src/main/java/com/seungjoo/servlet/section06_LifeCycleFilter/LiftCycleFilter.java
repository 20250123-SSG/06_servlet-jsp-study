package com.seungjoo.servlet.section06_LifeCycleFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;


public class LiftCycleFilter implements Filter {

    public LiftCycleFilter() {
        System.out.println("생성자 실행");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        System.out.println("destroy 메소드 실행");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("실행전");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("실행후");
    }
}
