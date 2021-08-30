package com.example.lesson_30_08_21.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebFilter("/*")*/
public class AuthFilter {

    /*private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter is execute");
        // Мы не можем вызвать response.sendRedirect("login.jsp") так как нам нужен httpResponse, а не ServletResponse.
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("/login");
        //chain.doFilter(request, response);  // вызываем следующий фильтр. В этом примере нам это не понадобится.
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }*/
}
