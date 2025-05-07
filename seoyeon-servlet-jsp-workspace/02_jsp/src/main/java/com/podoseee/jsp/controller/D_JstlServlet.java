package com.podoseee.jsp.controller;

import com.podoseee.jsp.dto.PersonDto;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] colorArr = {"red", "yellow", "green", "pink"};
        List<PersonDto> list1 = List.of(
                new PersonDto("김재중", 26, "남자"),
                new PersonDto("이태용", 31, "남자"),
                new PersonDto("정재현", 29, "남자")
        );
        String device = "컴퓨터,핸드폰,TV.에어컨/냉장고.세탁기";

        req.setAttribute("colors", colorArr);
        req.setAttribute("list", list1);
        req.setAttribute("device", device);


        req.getRequestDispatcher("/section04/jstl.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}