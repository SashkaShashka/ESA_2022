package com.example.lab_1_zaimov_andreev.servlets;

import com.example.lab_1_zaimov_andreev.bean.AnimalOwnerInformationBean;
import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import com.example.lab_1_zaimov_andreev.entity.AnimalOwnerInformation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddAndEditServlet", value = "/edit")
public class AddAndEditServlet extends HttpServlet {


    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;
    @EJB
    private AnimalOwnerInformationBean animalOwnerInformationBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");


        if(request.getParameter("edit")!=null){
            long animalOwnerId = Long.valueOf(request.getParameter("edit"));
            AnimalOwnerInformation animalOwnerInformation = animalOwnerInformationBean.get(animalOwnerId);

            request.setAttribute("owner", animalOwnerInformation);
        }
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        if (request.getParameter("animalOwnerId") != null){

            long animalOwnerId = Long.valueOf(request.getParameter("animalOwnerId"));
            AnimalOwnerInformation animalOwnerInformation = animalOwnerInformationBean.get(animalOwnerId);
            animalOwnerInformation.setFirstName(firstName);
            animalOwnerInformation.setSurname(surname);
            animalOwnerInformation.setPatronymic(patronymic);
            animalOwnerInformation.setPhoneNumber(phoneNumber);
            animalOwnerInformation.setAddress(address);

            animalOwnerInformationBean.update(animalOwnerInformation);
        }else{
            animalOwnerInformationBean.add(new AnimalOwnerInformation(firstName,surname,patronymic,phoneNumber,address));
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
