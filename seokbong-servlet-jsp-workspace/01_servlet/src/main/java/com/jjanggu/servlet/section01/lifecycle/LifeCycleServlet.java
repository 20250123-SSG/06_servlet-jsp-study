package com.jjanggu.servlet.section01.lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    * 해당 Servlet의 url mapping
    * -/lifecycle 요청시 실행되도록
     - http://localhost:8080/servlet/lifecycle url로 요청해야 작동됨
 */

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("LifeCycleServlet - 생성자 실행");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycleServlet - init() 메소드 실행");
    }

    /*
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - service() 메소드 실행 ");

        switch(req.getMethod().toUpperCase()){
            case "GET":
                System.out.println("=> GET 방식으로 요청됨");
                break;
            case "POST":
                System.out.println("=> POST 방식으로 요청도;ㅁ ");
                break;
        }
    }
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - doGet() 메소드 실행");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - doPost() 메소드 실행");
    }


    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet - destroy() 메소드 실행");
    }
}
