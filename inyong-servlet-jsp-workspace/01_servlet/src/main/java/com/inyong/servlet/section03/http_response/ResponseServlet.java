package com.inyong.servlet.section03.http_response;
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

        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        // service -> dao -> 쿼리

        /*
        1. HTML : text/html
        2. XML  : application/xml
        3. JSON : application/json
         */

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html");
        out.println("<html>");

        out.println("<head>");
        out.println("<title>응답페이지</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<script>alert('ㅉㅉㅉ!');</script>");
        out.println("<h1>반갑습니다 회원님!" + userId + "계정으로 가입 성공되셨습니다.");

        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();

    }
}
