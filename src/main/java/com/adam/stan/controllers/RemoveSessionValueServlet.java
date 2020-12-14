package com.adam.stan.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/remove-action")
public class RemoveSessionValueServlet extends HttpServlet {

    private static final long serialVersionUID = 4051038532749895143L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);

        HttpSession session = req.getSession(true);

        String key = req.getParameter("key");
        Object attribute = session.getAttribute(key);
        session.removeAttribute(key);
        resp.getWriter().printf("<div>Attribute [key=%s, value=%s] was deleted</div>\n", key, attribute.toString());
    }

}
