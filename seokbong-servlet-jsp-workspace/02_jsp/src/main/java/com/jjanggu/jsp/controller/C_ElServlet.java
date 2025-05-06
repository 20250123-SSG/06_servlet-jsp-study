package com.jjanggu.jsp.controller;

import com.jjanggu.jsp.dto.BookDto;
import com.jjanggu.jsp.dto.PersonDto;
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

@WebServlet("/el")
public class C_ElServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // request Scope 에 attribute 담기
        req.setAttribute("classRoom", "2강의장");
        req.setAttribute("student", new PersonDto("홍길동", 20, "남자"));

        // session Scope에 attribute 담기
        HttpSession session = req.getSession();
        session.setAttribute("teacher" , new PersonDto("김말순", 36, "여자"));

        // application Scope에 attribute 담기
        ServletContext application = req.getServletContext();
        application.setAttribute("academy", "SSG I&C");

        // request, session,application에 동일한 attribute 담기
        req.setAttribute("scope", "request에 담긴 데이터 ");
        session.setAttribute("scope", "session에 담긴 데이터 ");
        application.setAttribute("scope", "application에 담긴 데이터 ");


        // 연산자 테스트 위한 값
        req.setAttribute("big", 10);
        req.setAttribute("small", 3);
        
        req.setAttribute("str1", "안녕");
        req.setAttribute("str2", "안녕");
        req.setAttribute("str3", "잘가");

        req.setAttribute("book1", new BookDto(1, "도서", "저자"));
        req.setAttribute("book2", null);

        List<PersonDto> list1 = List.of(
                new PersonDto("홍길동", 20, "남자"),
                new PersonDto("강길순", 23, "여자"),
                new PersonDto("강개똥", 25, "남자")
        ); // 조회결과가 여러행일 경우
        List<PersonDto> list2 = new ArrayList<>(); // 조회결과가 없을경우 => 텅빈리스트
        req.setAttribute("list1" , list1);
        req.setAttribute("list2" , list2);


        req.getRequestDispatcher("/section03/el.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
