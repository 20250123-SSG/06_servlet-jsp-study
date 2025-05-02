package com.sotogito.servlet.section04.forward;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second-step")
public class SecondStepServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("두번째 목적지 도착");

        /// 포워딩으로 첫번째 목적지에서 req, resp전달 했음
        System.out.println("name" + req.getParameter("name"));
        System.out.println("age" + req.getParameter("age"));

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("alert('최종목적지도착')");
        out.println("</script>");
        out.flush();
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}
