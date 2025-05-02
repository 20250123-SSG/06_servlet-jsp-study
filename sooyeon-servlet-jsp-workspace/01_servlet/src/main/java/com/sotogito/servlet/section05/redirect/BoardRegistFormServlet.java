package com.sotogito.servlet.section05.redirect;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/registform")
public class BoardRegistFormServlet extends HttpServlet {

    @Override //입력 폼을 보냄
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("게시글 작성 페이지 이동용 Servlet 실행");

        //응답 페이지 => location.href = '/servlet/board/registform';
        req.getRequestDispatcher("/board/boardRegist.html").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
