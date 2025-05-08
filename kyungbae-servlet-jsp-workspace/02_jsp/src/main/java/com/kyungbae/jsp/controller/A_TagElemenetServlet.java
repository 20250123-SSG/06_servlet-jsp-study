package com.kyungbae.jsp.controller;

import com.kyungbae.jsp.dto.BookDto;
import com.kyungbae.jsp.dto.PersonDto;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@WebServlet("/tag-element")
public class A_TagElemenetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 요청처리 (DB에 쿼리실행)
        int no = Integer.parseInt(req.getParameter("no"));
        BookDto bk = new BookDto(1, "jsp 마스터", "mr.kim"); // 넘어온 도서객체 예시

        List<PersonDto> list = List.of(
                new PersonDto("김첨지", 20, "남자"),
                new PersonDto("최길남", 26, "남자"),
                new PersonDto("박술녀", 21, "여자")
        );

        // request 객체는 이미 Servlet 단에서 선언이 되어있음 => 바로 접근 가능
        req.setAttribute("book", bk);

        // session 객체는 Servlet단에서 선언되어있지 않음 => HttpSession객체 얻기
        HttpSession hs = req.getSession();
        hs.setAttribute("list", list);

        ServletContext sc = req.getServletContext();
        sc.setAttribute("academy", "SSG I&C");

        // 응답페이지 제작 => jsp에게 위임 (RequestDispatcher)
        req.getRequestDispatcher("/section01/tagElement.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
