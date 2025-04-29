package com.seungjoo.servlet.section02.http_request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/request")
public class RequestServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getContextPath());

        String name = req.getParameter("name");

        int age = Integer.parseInt(req.getParameter("age"));

        String[] hobbyList = req.getParameterValues("hobby");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("name");
        String name = req.getParameter("name");

        int age = Integer.parseInt(req.getParameter("age"));

        String[] hobbyList = req.getParameterValues("hobby");
    }


}