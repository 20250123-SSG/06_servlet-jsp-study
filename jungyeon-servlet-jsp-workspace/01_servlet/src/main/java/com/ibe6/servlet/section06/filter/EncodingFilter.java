package com.ibe6.servlet.section06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/board/*") // /board/list(get), /board/registform(get), /board/regist(post)
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("======EncodigFilter 동작======");

        if("post".equals( ((HttpServletRequest)servletRequest ).getMethod().toLowerCase() )){
            System.out.println("post방식 요청이므로 인코딩 처리를 하겠습니다.");
            servletRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(servletRequest, servletResponse); // 다음 필터 및 Servlet 실행

    }

}
