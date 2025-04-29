package com.ino.servlet.section04.forward;

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
        System.out.println("first dest");

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        System.out.println("name: " + name + "age : " + age);

        // Servlet to Servlet : forwarding(RequesetDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/second-step");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}