package com.podoseee.servlet.section06.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("*********LifeCycleFilter - 생성자 실행*********");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("*********LifeCycleFilter - init() 메소드 실행*********");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // Servlet 실행 전 실행할 코드
        System.out.println("*********LifeCycleFilter - doFilter() 메소드 실행 - Servlet 실행 전 시점");

        filterChain.doFilter(servletRequest, servletResponse); // 다음 필터 및 Servlet 실행

        // Servlet 실행 후 실행할 코드
        System.out.println("*********LifeCycleFilter - doFilter() 메소드 실행 - Servlet 실행 후 시점");

    }

    @Override
    public void destroy() {
        System.out.println("*********LifeCycleFilter - destroy() 메소드 실행");
    }

}
