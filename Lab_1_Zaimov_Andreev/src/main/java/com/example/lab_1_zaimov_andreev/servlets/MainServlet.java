package com.example.lab_1_zaimov_andreev.servlets;

import com.example.lab_1_zaimov_andreev.bean.OwnerBean;
import com.example.lab_1_zaimov_andreev.bean.AnimalBean;
import com.example.lab_1_zaimov_andreev.entity.Owner;
import com.example.lab_1_zaimov_andreev.entity.Animal;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AnimalOwnerServlet", value = "/index")
public class MainServlet extends HttpServlet {
    @EJB
    private OwnerBean ownerBean;
    @EJB
    private AnimalBean animalBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<Owner> owners = ownerBean.getAll();

        List<Animal> animals = animalBean.getAll();

        request.setAttribute("owners", owners);
        request.setAttribute("animals", animals);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
