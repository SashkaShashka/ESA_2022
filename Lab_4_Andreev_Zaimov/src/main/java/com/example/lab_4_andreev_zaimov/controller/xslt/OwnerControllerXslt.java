package com.example.lab_4_andreev_zaimov.controller.xslt;

import com.example.lab_4_andreev_zaimov.model.Owner;
import com.example.lab_4_andreev_zaimov.repository.OwnerRepository;
import com.example.lab_4_andreev_zaimov.service.OwnerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/xslt/owners")
public class OwnerControllerXslt {

    @Autowired
    private OwnerService ownerService ;


    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<Owner> animals = ownerService.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(animals);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("owners");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}

