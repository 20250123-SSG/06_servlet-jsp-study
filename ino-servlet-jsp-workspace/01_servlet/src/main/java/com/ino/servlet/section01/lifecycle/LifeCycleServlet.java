package com.ino.servlet.section01.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("LifeCycleServlet - Run Constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycleServlet - Run init()");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("LifeCycleServlet - Run service()");
//        switch (req.getMethod().toUpperCase()){
//            case "GET":
//                System.out.println("=> GET request");
//                break;
//            case "POST":
//                System.out.println("=> POST request");
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - Run doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - Run doPost()");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet - Run destroy()");
    }
}
