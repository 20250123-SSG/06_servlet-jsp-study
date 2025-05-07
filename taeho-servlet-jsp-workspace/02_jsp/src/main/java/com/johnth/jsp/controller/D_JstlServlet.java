package com.johnth.jsp.controller;

import com.johnth.jsp.dto.PersonDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/jstl")
public class D_JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String[] colorArr ={"red", "yellow", "green", "pink", "blue"};
        List<PersonDto> list = List.of(
                new PersonDto("홍길동", 20,"남")
                , new PersonDto("김", 20,"여")
                , new PersonDto("박", 20,"남")
        );
        String device = "컴퓨터, 핸드폰, TV, 에어컨, 냉장고, 세탁기";

        req.setAttribute("colors", colorArr);
        req.setAttribute("list", list);
        req.setAttribute("device", device);

        req.getRequestDispatcher("/section04/jstl.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
