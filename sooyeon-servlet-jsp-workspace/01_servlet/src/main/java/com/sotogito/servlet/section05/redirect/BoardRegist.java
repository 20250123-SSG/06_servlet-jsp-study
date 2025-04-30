package com.sotogito.servlet.section05.redirect;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/regist")
public class BoardRegist extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("게시글 등록용 servlet 실행");

        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        //응답 -> 게시글 목록 페이지(단, 새로 추가된 데이터도 보여줘야함)
//        req.getRequestDispatcher("/board/boardList.html").forward(req, resp);
        /**
         * forward로 결과 반환은잘몫괸 응답 방법
         * 1. 포워딩을 통해서 해당 페이지가띄워지는 하지만 URL에는 여전히 http://localhost:8080/servlet/board/regist
         * 2. 새로 추가된 데이터를 다시 조회해야하는데 조회 안됨
         *
         * 보드리스트로 넘겨야되는데 이미 페이지를반환하는 doGet메서드는 정의되어있다.
         * 그럼 그 메서드에 결과를 받는로직을 추가 작성해주면 된다
         * 단순히 form 페이지를 띄우는게 아니라 데이터를 처리야함으로 html이 아니라 url로 넘겨야한다.=> redirect
         */
        resp.sendRedirect("/servlet/board/list");
        /**
         * 왜 forward로 넘기지 않을까?
         *get의 경우에는 서버에서 브라우저로 결과를 반환하는 것이기 때문에 실행이 되지만
         * POST의 경우에는 말 그대로 받아온 데이터를 전달하고 처리해달라는 요청인데 GET과는 성질이 다르다.
         * 때문에 FORWARD를 할 경우 서버 내부에서만 적용될 뿐 브라우저에게 보내지는 것은 없다.
         * 즉 서버에서는 LIST로 업데이트가 되고, 주소창은 바뀌지 않는다
         *
         * get의 forward의 경우 만약 '/servlet/board/registform'로 이동을 한다고 가정했을 때 받아서 처리해야될 데이터 없이 html을 받아 다시 띄우면 된다.
         *
         * 하지만 post에의 forward는 페이지는이동이 되지만 POST방식이 브라우저에 남아있기 때문에=   <form action="/servlet/board/regist" method="post">
         * url은 여전히"/servlet/board/regist로 뜬다. forward로 화면은 바꾸어 보여주지만 브라우저의 반환 형태는 여전히 post이다.
         * post는 바당온 데이터를 처리해야하기 때문에 새로고침을 하게될 경우 데이터가 다시 요청이 되어 중복 처리될 가능성이 있다.
         *
         */


    }
    }
