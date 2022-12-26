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
        String test = "test test test";
        request.setAttribute("test", test);
        List<AnimalOwnerInformation> allInfo = animalOwnerInformationBean.getAll();
        request.setAttribute("count", allInfo.stream().count());
        request.setAttribute("qweqweqwe", "qweqewqwe");
        List<SummaryOfTheAnimal> allSummary = summaryOfTheAnimalBean.getAll();
        PrintWriter out = response.getWriter();
        out.println("count");
        out.println(allInfo.stream().count());
        String h = helloBean.HelloWorld();
        request.setAttribute("test", h);

        System.out.println(h);

        request.setAttribute("owner", allInfo);
        request.setAttribute("animal", allSummary);

        //request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
