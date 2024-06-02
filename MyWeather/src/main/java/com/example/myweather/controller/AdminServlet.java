package com.example.myweather.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private Map<String, String> admins = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        admins.put("administrator", "pas_182433");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (admins.containsKey(username) && admins.get(username).equals(password)) {
            request.getSession().setAttribute("admin", true);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Invalid login. Please try again.");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }
}