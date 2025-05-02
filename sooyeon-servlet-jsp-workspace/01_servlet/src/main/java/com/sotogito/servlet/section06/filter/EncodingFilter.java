package com.sotogito.servlet.section06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/board/*") /// board~로 시작하는 url의 요청에있어 거처가는 필터, servlet보다 먼저
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("EncodingFilter doFilter-------------");
        
        //get만 쳐주기에는 요청이null타입일 가능성이 있어 조건달기
        if ("post".equalsIgnoreCase(((HttpServletRequest) servletRequest).getMethod())) { //요청의 방식을 알기 위해 ServletRequest -> HttpServletRequest으로 다운케스팅
            System.out.println("POST 방식으로 인코딩 필터 처리");
            
            servletRequest.setCharacterEncoding("UTF-8"); //servlet 의 post마다 작성해야하는 코드를 필터에 한번만 작성
        }
        filterChain.doFilter(servletRequest, servletResponse); //다음 필터 -> servlet을 실행
    }
}
