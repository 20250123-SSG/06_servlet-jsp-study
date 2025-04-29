package com.sotogito.servlet.section01.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 해당 Servlet의 url mapping
 * - /lifecycle 요청시 실행되도록
 * - http://localhost:8080/servlet/lifecycle url로 요청해야 작동함
 *
 */

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet 생성자 실행");
    }

    @Override  //처음 요청할때만 실행
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycleServlet init");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.print("LifeCycleServlet service =====> ");
//
//        switch (req.getMethod().toUpperCase()){
//            case "GET":
//                doGet(req, resp); break;
//            case "POST":
//                doPost(req, resp); break;
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet doPost");
    }

    @Override //서버가 다운될 때 실행
    public void destroy() {
        System.out.println("LifeCycleServlet destroy");
    }


}
