package com.example.lab_1_zaimov_andreev.servlets;

import com.example.lab_1_zaimov_andreev.bean.AnimalOwnerInformationBean;
import com.example.lab_1_zaimov_andreev.bean.SummaryOfTheAnimalBean;
import com.example.lab_1_zaimov_andreev.classes.Pair;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AnimalOwnerInformationServlet", value = "/index")
public class MainServlet extends HttpServlet {
    @EJB
    private AnimalOwnerInformationBean animalOwnerInformationBean;
    @EJB
    private SummaryOfTheAnimalBean summaryOfTheAnimalBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<AnimalOwnerInformation> allInfo = animalOwnerInformationBean.getAll();
        List<Pair> formattedOwners = new ArrayList<>();
        for (AnimalOwnerInformation owner: allInfo) {
            formattedOwners.add(new Pair(owner.getAnimalOwnerId(),
                    owner.getFirstName() + "\t" +
                        owner.getSurname() + "\t" +
                        owner.getPatronymic() + "\t" +
                        owner.getPhoneNumber() + "\t" +
                        owner.getAddress()));
        }

        List<SummaryOfTheAnimal> allSummary = summaryOfTheAnimalBean.getAll();

        List<Pair> formattedAnimals = new ArrayList<>();
        for (SummaryOfTheAnimal animal: allSummary) {
            formattedAnimals.add(new Pair(animal.getChipId(),
                    animal.getName() + "\t" +
                    animal.getSex() + "\t" +
                    animal.getColor() + "\t" +
                    animal.getBreed() + "\t" +
                    animalOwnerInformationBean.getOwner(animal.getId_owner())
            ));
        }

        request.setAttribute("owner", formattedOwners);
        request.setAttribute("animal", formattedAnimals);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
