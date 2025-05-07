package com.ibe6.jsp.controller;


import com.ibe6.jsp.dto.BookDto;
import com.ibe6.jsp.dto.PersonDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/tag-element")
public class A_TagElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 요청처리 (db에 쿼리실행) => 조회되었다는 가정하로 진행
        int no = Integer.parseInt(req.getParameter("no"));
        BookDto bk = new BookDto(1, "JSP 마스터", "김땡땡"); // 넘어온 번호로 조회된 도서객체

        List<PersonDto> list = List.of(
                new PersonDto("홍길동", 20, "남자"),
                new PersonDto("강길순", 23, "여자"),
                new PersonDto("강개똥", 25, "남자")
        );

        // request 객체는 이미 Servlet단에서 선언이 되어있음 => 바로 접근 가능
        req.setAttribute("book", bk);

        // session 객체는 Servlet단에서 선언되어있지 않음 = > HttpSession객체 얻기
        HttpSession session = req.getSession();
        session.setAttribute("list", list);

        ServletContext application = req.getServletContext();
        application.setAttribute("academy", "SSG I&C");

        // 응답페이지 제작 => jsp에게 위임 (RequestDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/section01/tagElement.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
