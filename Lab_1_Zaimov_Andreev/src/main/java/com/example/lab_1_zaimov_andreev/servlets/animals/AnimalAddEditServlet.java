package com.example.lab_1_zaimov_andreev.servlets.animals;

import com.example.lab_1_zaimov_andreev.bean.AnimalOwnerInformationBean;
import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import com.example.lab_1_zaimov_andreev.classes.Pair;
import com.example.lab_1_zaimov_andreev.entity.AnimalOwnerInformation;
import com.example.lab_1_zaimov_andreev.entity.SummaryOfTheAnimal;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AnimalAddEditServlet", value = "/AnimalEdit")
public class AnimalAddEditServlet extends HttpServlet {

    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;

    @EJB
    private AnimalOwnerInformationBean animalOwnerInformationBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<AnimalOwnerInformation> allInfo = animalOwnerInformationBean.getAll();
        List<Pair> owners = new ArrayList<>();
        for (AnimalOwnerInformation owner : allInfo) {
            String FIO = owner.getFirstName() + " " + owner.getSurname() + " " + owner.getPatronymic();
            owners.add(new Pair(owner.getAnimalOwnerId(), FIO));
        }

        request.setAttribute("owners", owners);

        if(request.getParameter("chipId") != null){
            request.setAttribute("namePage", "Редактирование");
            Long chipId = Long.valueOf(request.getParameter("chipId"));
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
        Long id_owner;
        if (request.getParameter("idOwner").equals("null") || request.getParameter("idOwner") == null)
           id_owner = null;
        else
            id_owner = Long.parseLong(request.getParameter("idOwner"));
        if (!request.getParameter("chipId").equals("")){

            long animalId = Long.valueOf(request.getParameter("chipId"));
            SummaryOfTheAnimal summaryOfTheAnimal = summaryOfTheAnimalBean.get(animalId);
            summaryOfTheAnimal.setName(name);
            summaryOfTheAnimal.setSex(sex);
            summaryOfTheAnimal.setColor(color);
            summaryOfTheAnimal.setBreed(breed);
            summaryOfTheAnimal.setId_owner(id_owner);

            summaryOfTheAnimalBean.update(summaryOfTheAnimal);
        }else{
            summaryOfTheAnimalBean.add(new SummaryOfTheAnimal(name,sex,color,breed, id_owner));
        }
        ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
