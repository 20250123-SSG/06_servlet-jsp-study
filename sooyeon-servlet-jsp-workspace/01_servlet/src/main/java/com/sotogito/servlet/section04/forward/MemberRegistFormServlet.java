package com.sotogito.servlet.section04.forward;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registForm.me")
public class MemberRegistFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /// 단순페이지(/member/memberRegist.html) 이동,
        /// url은 /registForm.me라고 찍히고 띄우는 건 html파일
        req.getRequestDispatcher("/member/memberRegist.html").forward(req, resp); ///서블릿 -> HTML

        //http://localhost:8080/servlet/registForm.me
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
