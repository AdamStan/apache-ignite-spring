package com.adam.stan.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/add")
public class AddSessionValueServlet extends HttpServlet {

    private static final long serialVersionUID = -8794621516320549629L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        HttpSession session = request.getSession(true);

        String key = request.getParameter("key");
        String value = request.getParameter("value");
        session.setAttribute(key, value);
        response.getWriter().printf("<div>Added attribute [key=%s, value=%s]</div>\n", key, value);
    }
}
