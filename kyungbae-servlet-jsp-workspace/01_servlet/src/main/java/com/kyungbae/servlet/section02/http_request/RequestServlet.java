package com.kyungbae.servlet.section02.http_request;

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
        System.out.println("RequestServlet - doGet()");
        System.out.println("contextPath: " + req.getContextPath());
        System.out.println("URI: " + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());

        String name = req.getParameter("name");
        System.out.println("name: " + name);

        int age = Integer.parseInt(req.getParameter("age")); // 항상 String 으로 반환
        // 빈문자열이 넘어올 경우 NumberFormatException 발생
        System.out.println("age: " + age);

        String[] hobbyList = req.getParameterValues("hobby");
        System.out.println("hobby: " + Arrays.toString(hobbyList));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestServlet - doPost()");

        /*
        * POST 방식 요청일 경우
        * 1) 파라미터들이 HTTP 본문(body)에 담겨 넘어오기 때문에 별도의인코딩 처리필요
        * 2) 파라미터 추출 전에 인코딩 처리하는 setCharacterEncoding() 메소드 실행
        * */

        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        System.out.println("name: " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("age: " + age);

        String[] hobbyList = req.getParameterValues("hobby");
        System.out.println("hobby: " + Arrays.toString(hobbyList));
    }

}
