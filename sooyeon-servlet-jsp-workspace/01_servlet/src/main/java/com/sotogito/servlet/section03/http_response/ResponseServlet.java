package com.sotogito.servlet.section03.http_response;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("userId");
        String pwd = req.getParameter("userPwd");
        /**
         * 응답 content-type 설정
         * 1. HTML : text/html
         * 2. XML : application/xml
         * 3. JSON : application/json
         */
        resp.setContentType("text/html;charset=UTF-8");

        /// 응답할 출력 스트림 알아내기
        PrintWriter out = resp.getWriter();

        /// 응답 전송 = JAVA에서 HTML작성하ㅣ
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>응답페이지</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>alert('~~~');</script>");
        out.println("<h1>반갑습니다."+ id +"님</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

}
