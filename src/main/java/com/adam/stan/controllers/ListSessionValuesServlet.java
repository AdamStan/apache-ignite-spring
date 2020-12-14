package com.adam.stan.controllers;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions")
public class ListSessionValuesServlet extends HttpServlet {

    private static final long serialVersionUID = 6463631127236648928L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);

            HttpSession session = request.getSession(true);

            int total = 0;

            for (Object key : Collections.list(session.getAttributeNames())) {
                Object value = session.getAttribute((String)key);
                String attr = String.format("Attribute[key=%s, value=%s]", key, value);
                response.getWriter().println("<div>" + attr + "</div>");
                total++;
            }
            response.getWriter().println("<div>Total attributes: " + total + "</div>");
        }
}
