package com.example.lesson_30_08_21.servlet;

import com.example.lesson_30_08_21.entity.User;
import com.example.lesson_30_08_21.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService=UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user=(User) req.getSession().getAttribute("user");
        User byId = userService.findById(user.getId());
        req.setAttribute("user",byId);
        req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req,resp);
    }
}
