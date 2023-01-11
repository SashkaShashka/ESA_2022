package com.example.lab_3_zaimov_andreev.controller.xslt;

import com.example.lab_3_zaimov_andreev.model.Animal;
import com.example.lab_3_zaimov_andreev.repository.AnimalRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/xslt/animals")
public class AnimalControllerXslt {

    final AnimalRepository animalRepository ;

    public AnimalControllerXslt(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<Animal> animals = animalRepository.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(animals);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("animals");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}

