package com.example.lab_1_zaimov_andreev.servlets.animals;

import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AnimalRemoveServlet", value = "/AnimalRemove")
public class AnimalRemoveServlet extends HttpServlet {

    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");



        if(request.getParameter("chipId") != null){
            request.setAttribute("namePage", "Удаление");
            long chipId = Long.valueOf(request.getParameter("chipId"));
            summaryOfTheAnimalBean.delete(chipId);
        }
        else
            request.setAttribute("namePage", "Error 404");
        ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
