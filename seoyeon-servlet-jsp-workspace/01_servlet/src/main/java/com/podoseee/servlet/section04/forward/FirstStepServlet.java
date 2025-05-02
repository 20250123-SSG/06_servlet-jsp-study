package com.podoseee.servlet.section04.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first-step")
public class FirstStepServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("첫 번째 목적지(경유지) 도착");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        System.out.println("name: " + name + ", age: " + age);

        // Servlet에서 다른 Servlet으로 이동 : forwarding (RequestDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/second-step");
        rd.forward(req, resp); // 현재 Servlet에서 생성된 req, resp 객체를 같이 전송해야됨
                               // 이동되는 Servlet에서 해당 이 객체를 사용

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}