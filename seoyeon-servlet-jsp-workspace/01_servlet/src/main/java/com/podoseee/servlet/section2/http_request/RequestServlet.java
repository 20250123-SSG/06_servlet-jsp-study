package com.podoseee.servlet.section2.http_request;

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
        System.out.println("RequestServlet - doGet() 메소드 실행");
        System.out.println("contextPath: " + req.getContextPath());
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());

        String name = req.getParameter("name"); // "이마크"
        System.out.println("param(name): " + name);

        int age = Integer.parseInt(req.getParameter("age"));  // "27" => 27 | "" => NumberFormatException
        System.out.println("param(age): " + age);

        String[] hobbyList = req.getParameterValues("hobby"); // ["sports", "reading"]
        System.out.println("param(hobby): " + Arrays.toString(hobbyList));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestServlet - doPost() 메소드 실행");
        System.out.println("contextPath: " + req.getContextPath());
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());
    }
}
