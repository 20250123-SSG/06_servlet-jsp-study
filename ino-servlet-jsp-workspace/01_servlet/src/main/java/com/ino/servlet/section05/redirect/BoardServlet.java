package com.ino.servlet.section05.redirect;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/list.bo")
public class BoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("조회용 servlet");
        // db로부터 데이터 조회 => service => dao => querying

        RequestDispatcher rd = req.getRequestDispatcher("/board/boardList.html");
        rd.forward(req, resp);
        // 위 내용이 진행되었다는 가정하에 응답페이지 : 웹컨테이너/board/boardList.html
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}