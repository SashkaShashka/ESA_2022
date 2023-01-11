package com.example.lab_3_zaimov_andreev.controller.xslt;

import com.example.lab_3_zaimov_andreev.model.Owner;
import com.example.lab_3_zaimov_andreev.repository.OwnerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

    final OwnerRepository ownerRepository ;

    public OwnerControllerXslt(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public ModelAndView get() throws JsonProcessingException {
        List<Owner> animals = ownerRepository.findAll();

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(animals);

        Source source = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        ModelAndView modelAndView = new ModelAndView("owners");
        modelAndView.addObject("xmlSource", source);

        return modelAndView;
    }
}

