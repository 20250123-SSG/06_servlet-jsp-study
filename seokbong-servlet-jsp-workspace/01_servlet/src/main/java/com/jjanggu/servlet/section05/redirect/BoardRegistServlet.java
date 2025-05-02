package com.jjanggu.servlet.section05.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/regist")
public class BoardRegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("게시글 등록용 Servlet 실행");
        // 요청시 전달되는 데이터 뽑기
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // Dto에 데이터 담기
        // db에 insert해야됨
//        int result = new BoardService().insertBoard(board);

        // 응답페이지 : 게시글 목록 페이지 (단, 새로 추가된 데이터도 조회돼서 보여져야됨)

        // 잘못된 응답방법 : forward
//        req.getRequestDispatcher("/board/boardList.html").forward(req, resp);
        // 문제점1. 포워딩을 통해서 해당 페이지가 띄워지긴하나 url에는 여전히 /servlet/board/regist 보여짐
        // 문제점2. 새로 추가된 데이터를 다시 조회해서 뿌려야되는데 조회가 진행되지 않음
        // 해결방법. 게시글 데이터를 db로부터 조회해서 boardList.html로 포워딩해주는 Servlet이 이미 존재함 (BoardListServlet)
        //           해당 Servlet을 재호출하면됨 (url재요청 == /board/list redirect)
        resp.sendRedirect("/servlet/board/list");

    }

}
