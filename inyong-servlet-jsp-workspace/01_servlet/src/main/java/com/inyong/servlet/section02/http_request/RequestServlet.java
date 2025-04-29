package com.inyong.servlet.section02.http_request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        System.out.println("contextPath: " + req.getContextPath());
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());

        String name = req.getParameter("name");
        System.out.println("param name " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("param age " + age);

        String[] hobbyList = req.getParameterValues("hobby"); //[sports, reading]
        System.out.println("param hobbyList " + Arrays.toString(hobbyList));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");

        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        System.out.println("param name " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("param age " + age);

        String[] hobbyList = req.getParameterValues("hobby"); //[sports, reading]
        System.out.println("param hobbyList " + Arrays.toString(hobbyList));

    }
}
