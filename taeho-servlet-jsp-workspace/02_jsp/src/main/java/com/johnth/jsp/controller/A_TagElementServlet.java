package com.johnth.jsp.controller;

import com.johnth.jsp.dto.BookDto;
import com.johnth.jsp.dto.PersonDto;
import jakarta.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 요청처리
        int id= Integer.parseInt(req.getParameter("id"));
        BookDto bk = new BookDto(1,"JSP", "김공장");
        
        List<PersonDto> list = List.of(
                new PersonDto("홍", 20,"남")
                , new PersonDto("김", 20,"여")
                , new PersonDto("박", 20,"남")
        );

        req.setAttribute("book",bk);

        // servlet level로 에러발생 => session 객체 선언
        HttpSession session = req.getSession();
        session.setAttribute("list", list);

        
        // 응답페이지 제작 => jsp에게 위임 (RequestDispatcher)
//        req.getRequestDispatcher("/section01/tagElement.jsp").forward(req, res);
        RequestDispatcher rd = req.getRequestDispatcher("/section01/tagElement.jsp");
        rd.forward(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
