package com.seungjoo.servlet.secion01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet - 생성자 실행");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 메소드 실행");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("service()메소드 실행");

        switch (req.getMethod().toUpperCase()) {
            case "GET":
                System.out.println("get방식으로 요청");
                break;
            case "POST":
                System.out.println("Post 방식으로 요청");
                break;
        }
    }



   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
*/


    @Override
    public void destroy() {
        System.out.println("destroy메서드 실행");
    }
}
