package com.ino.servlet.section04.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second-step")
public class SecondStepServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("final dest");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("on second-step name: " + name + "age" + age);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<script>alert('successfully reached final dest')</script>");
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}