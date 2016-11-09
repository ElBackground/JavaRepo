package com.elbackground.servletexplore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Fourth", urlPatterns = {"/Fourth"})
public class Fourth extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        
        try (PrintWriter out = response.getWriter()) {
            out.println(
                Util.defaultWrap("Fourth Servlet", requestBody)
            );
        }
    }
}