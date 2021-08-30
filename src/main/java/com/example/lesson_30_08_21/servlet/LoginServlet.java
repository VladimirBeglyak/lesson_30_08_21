package com.example.lesson_30_08_21.servlet;

import com.example.lesson_30_08_21.dto.UserDto;
import com.example.lesson_30_08_21.entity.User;
import com.example.lesson_30_08_21.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User login = userService.login(req.getParameter("email"), req.getParameter("password"));

        if (login != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            if (login.getRole() == 1) {
                resp.sendRedirect("/list-users");
            }else{
                resp.sendRedirect("/user");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}
