package com.elbackground.servletexplore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Fourth", urlPatterns = {"/Fourth"})
public class Fourth extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String[]> collection = request.getParameterMap().values();
        String requestBody = "";
        for (String[] s : collection) {
            requestBody += "value: " + s[0] + "<br />";
        }
        try (PrintWriter out = response.getWriter()) {
            out.println(
                Util.defaultWrap("Fourth Servlet", requestBody)
            );
        }
    }
}