package com.sotogito.jsp.controller;


import com.sotogito.jsp.dto.BookDto;
import com.sotogito.jsp.dto.PersonDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/tag-element")
public class A_TagElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /// 요청 처리(db에 쿼리 실행) => 조회되었다는 가정하로 진행
        int no = Integer.parseInt(req.getParameter("no"));
        BookDto book = new BookDto(1, "jsp 마스터", "떙떄ㅑㅇ"); ///넘어온 번호로 조회된 도서 객체 -임의

        List<PersonDto> personList = List.of(
                new PersonDto("홍길동", 20, "남자"),
                new PersonDto("강길순", 23, "여자"),
                new PersonDto("홍갣ㅇ", 25, "남자")
        );


        /// 데이터 request에 담기
        req.setAttribute("book", book); //request 객체는 servelt단에서 선언이 되어있음 => 바로 접근 가능
        req.getSession().setAttribute("personList", personList); //session객체는 선언되어있지 않아 객체를 get해와야함
        ServletContext app = req.getServletContext();
        app.setAttribute("academy", "ssg");

        /// 응답페이지 제작 =>jsp에게 위임 (RequestDispatcher)
        RequestDispatcher rd = req.getRequestDispatcher("/section01/tagElement.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
