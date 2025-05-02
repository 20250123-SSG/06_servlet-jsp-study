package com.seungjoo.servlet.section03;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //아이디,비번 추출
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        //보통 전달된 데이터를 서비스 전송 -> dao전송 -> 쿼리 실행해서 결과 가져옴

        /*
        * 응답 content 타입 설정
        1) HTML : text/html
        2) XML : application/xml
        3) JSON : application/json
         */
        resp.setContentType("text/html;charset=utf-8");
        /*
        응답할 출력 스트림 알아내기
         */
        PrintWriter out = resp.getWriter(); //이러고 출력하면 출력된 데이터가 사용자에게 보여질 것임
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<head>");
        out.println("<body>");

        out.println("<body>");
        out.println("<html>");
    }


}