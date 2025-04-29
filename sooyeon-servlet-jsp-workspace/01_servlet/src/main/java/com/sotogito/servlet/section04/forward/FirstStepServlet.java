package com.sotogito.servlet.section04.forward;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first-step")
public class FirstStepServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("첫번째 목적지(경유지) 도착");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("name=" + name + ", age=" + age);


        /// 현재 servlet에서 다른 servlet으로 이동 : forwarding (RequestDispatcher) /Dispatcher:보내는 사람
        RequestDispatcher rd = req.getRequestDispatcher("/second-step"); /// 서블릿 -> 서블릿
        rd.forward(req, resp); //mybatis에서 트랜젝션을 위하여 sqlSession넘겨주는거마냥 req,resp를  같이 넘겨줘야됨
        //단 url은 first-step, 클라이언크는 중간에 이동된 forward를 알 수 없음
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
