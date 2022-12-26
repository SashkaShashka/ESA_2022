package com.example.lab_1_zaimov_andreev.servlets.animals;

import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import com.example.lab_1_zaimov_andreev.entity.AnimalOwnerInformation;
import com.example.lab_1_zaimov_andreev.entity.SummaryOfTheAnimal;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AnimalAddEditServlet", value = "/AnimalEdit")
public class AnimalAddEditServlet extends HttpServlet {

    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");



        if(request.getParameter("chipId") != null){
            request.setAttribute("namePage", "Редактирование");
            long chipId = Long.valueOf(request.getParameter("chipId"));
            SummaryOfTheAnimal summaryOfTheAnimal = summaryOfTheAnimalBean.get(chipId);

            request.setAttribute("animal", summaryOfTheAnimal);
        }
        else
            request.setAttribute("namePage", "Добавление");
        request.getRequestDispatcher("/animalEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String color = request.getParameter("color");
        String breed = request.getParameter("breed");

        if (!request.getParameter("chipId").equals("")){

            long animalId = Long.valueOf(request.getParameter("chipId"));
            SummaryOfTheAnimal summaryOfTheAnimal = summaryOfTheAnimalBean.get(animalId);
            summaryOfTheAnimal.setName(name);
            summaryOfTheAnimal.setSex(sex);
            summaryOfTheAnimal.setColor(color);
            summaryOfTheAnimal.setBreed(breed);

            summaryOfTheAnimalBean.update(summaryOfTheAnimal);
        }else{
            summaryOfTheAnimalBean.add(new SummaryOfTheAnimal(name,sex,color,breed));
        }
        ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
