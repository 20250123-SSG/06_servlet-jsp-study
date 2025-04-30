package com.younggalee.section05.redirect;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class boardRegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {String title = req.getParameter("title");
       String content = req.getParameter("content");

       // 잘못된 응답방법 : forward
        //req.getRequestDispatcher("/board/boardList.html").forward(req, resp);
        // 문1. 포워딩을  통해서 해당 페이지가 띄워지긴하나, url에는 여전히 /servlet/board/regist 보여짐
        // 문2. 새로 추가된 데이터를 다시 조회해서 뿌려야되는데 조회가 진행되지 않음
        // 해결방법. 게시글 데이터를 db로 부터 조회해서 boardList.html로 포워딩해주는
        //           서블릿이 이미 존재함 (BoardListServlet)  해당 Servlet을 재호출하면 됨.(url재요청 == /board/list redirect)
        resp.sendRedirect("/servlet/board/list");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeCycleServlet - doPost() 메소드 실행");
    }
}

