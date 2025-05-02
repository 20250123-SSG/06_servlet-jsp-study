package com.ino.servlet.section02.http_request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;


// urlmapping : /request

@WebServlet("/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getParameter("name"));

        System.out.println("RequestServlet - doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestServlet - doPost()");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        System.out.println("name: " + name);
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age: " + age);
        String[] hobby = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
    }
}