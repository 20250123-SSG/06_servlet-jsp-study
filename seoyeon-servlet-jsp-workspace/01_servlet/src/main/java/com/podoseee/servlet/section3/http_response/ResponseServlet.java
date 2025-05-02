package com.podoseee.servlet.section3.http_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        
        // 아이디, 비밀번호 추출
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        // 보통 전달된 데이터를 service 전송 => dao 전송 => 쿼리 실행해서 결과 가져옴
        // 성공적으로 가입되었다는 가정하에 응답

        /*
            * 응답 Content-type 설정
            1) HTML : text/html
            2) XML  : application/xml
            3) JSON : application/json
         */
        resp.setContentType("text/html; charset=UTF-8");

        /*
            * 응답할 출력 스트림 알아내기
         */
        PrintWriter out = resp.getWriter();

        /*  * 응답 전송  */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>응답페이지</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>alert('짝짝짝!');</script>");
        out.println("<h1>반갑습니다 회원님!" + userId + "계정으로 성종적으로 가입되셨습니다!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
    
}