package com.example.lesson_30_08_21.servlet;

import com.example.lesson_30_08_21.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/list-users")
public class ListUserServlet extends HttpServlet {

    private final UserService userService=UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session==null){
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("users",userService.findAll());
            req.getRequestDispatcher("/WEB-INF/jsp/list-users.jsp")
                    .forward(req,resp);
        }
    }
}
