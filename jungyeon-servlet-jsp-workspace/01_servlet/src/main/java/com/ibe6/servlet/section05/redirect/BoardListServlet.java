package com.ibe6.servlet.section05.redirect;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("게시글 전체 조회용 Servlet 실행");
        // db로부터 데이터 조회 (=> service => dao => 쿼리실행)

        // 위의 내용이 진행되었다는 가정하에 응답페이지 : 웹컨테이너/boardList.html
        req.getRequestDispatcher("/board/boardList.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
