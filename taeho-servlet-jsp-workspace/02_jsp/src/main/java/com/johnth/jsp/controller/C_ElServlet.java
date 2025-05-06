package com.johnth.jsp.controller;

import com.johnth.jsp.dto.BookDto;
import com.johnth.jsp.dto.PersonDto;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/expression-language")
public class C_ElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // request Scope에 attribute 담기
        req.setAttribute("classRoom", "2강의장");
        req.setAttribute("student", new PersonDto("홍길",20,"남"));

        // session Scope에 Attribute담기
        HttpSession session = req.getSession();
        session.setAttribute("teacher", new PersonDto("강",30,"여"));

        // application Scope에 attribute담기
        ServletContext application = req.getServletContext();
        application.setAttribute("academy", "SSG");

        req.setAttribute("scope", "request에 담긴 데이터");
        session.setAttribute("scope", "session에 담긴 데이터");
        application.setAttribute("application", "application에 담긴 데이터");

        req.getRequestDispatcher("/section03/el.jsp").forward(req, res);

        req.setAttribute("big",10);
        req.setAttribute("small",3);

        req.setAttribute("str1", "안녕");
        req.setAttribute("str2", "안녕");
        req.setAttribute("str3", "바이");

        req.setAttribute("book1", new BookDto(1, "도서", "저자"));
        req.setAttribute("book2", null);

        List<PersonDto> list = List.of(
                new PersonDto("홍", 20,"남")
                , new PersonDto("김", 20,"여")
                , new PersonDto("박", 20,"남")
        );

        List<PersonDto> list2 = new ArrayList<PersonDto>();
        req.setAttribute("list", list);
        req.setAttribute("list2", list2);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
