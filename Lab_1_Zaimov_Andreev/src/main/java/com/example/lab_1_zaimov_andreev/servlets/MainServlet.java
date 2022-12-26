package com.example.lab_1_zaimov_andreev.servlets;

import com.example.lab_1_zaimov_andreev.bean.AnimalOwnerInformationBean;
import com.example.lab_1_zaimov_andreev.bean.HelloBean;
import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import com.example.lab_1_zaimov_andreev.entity.AnimalOwnerInformation;
import com.example.lab_1_zaimov_andreev.entity.SummaryOfTheAnimal;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AnimalOwnerInformationServlet", value = "/index")
public class MainServlet extends HttpServlet {
    @EJB
    private AnimalOwnerInformationBean animalOwnerInformationBean;
    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;
    @EJB
    private HelloBean helloBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<AnimalOwnerInformation> allInfo = animalOwnerInformationBean.getAll();

        List<SummaryOfTheAnimal> allSummary = summaryOfTheAnimalBean.getAll();

        request.setAttribute("owner", allInfo);
        request.setAttribute("animal", allSummary);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
