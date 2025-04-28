package com.kyungbae.servlet.section04.forward;

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
        System.out.println("첫번째 서블릿");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        System.out.printf("name: %s, age: %d\n", name, age);

        // servlet 에서 다른 servlet으로 이동 : forwarding (RequestDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/second-step");
        rd.forward(req, resp);
        // 현재 Servlet에서 생성된 req, resp 객체를 함께 전송해주어야 함
        // 이동되는 Servlet에서 해당 이 객체를 사용
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
