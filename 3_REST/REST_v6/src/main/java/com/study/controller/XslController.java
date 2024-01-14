package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.study.models.Houses;

import com.study.repos.DebtorRepository;
import com.study.repos.ApartmentRepository;
import com.study.repos.HouseRepository;

import com.study.models.Debtor;
import com.study.models.Apartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;


@Controller
<<<<<<< HEAD
@RequestMapping(
        value = "xsl",
        produces = {"application/xml"}
)
public class XslController {
=======
@RequestMapping("/xsl")
public class XslController {

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    @Autowired
    private DebtorRepository debtorService;

    @Autowired
    private ApartmentRepository apartmentService;

    @Autowired
    private HouseRepository houseService;

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/debtor")
=======
    @GetMapping(path = "/debtor", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    private ModelAndView getDebtor() throws JsonProcessingException {
        Iterable<Debtor> list = debtorService.findAll();
        return getModelAndView(list, "debtorXSL");
    }

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/apartment")
=======
    @GetMapping(path = "/apartment", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    public ModelAndView getApartment() throws JsonProcessingException {
        Iterable<Apartment> list = apartmentService.findAll();
        return getModelAndView(list, "apartmentXSL");
    }

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/house")
=======
    @GetMapping(path = "/house", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    public ModelAndView get() throws JsonProcessingException {
        Iterable<Houses> list = houseService.findAll();
        return getModelAndView(list, "houseXSL");
    }

<<<<<<< HEAD
=======

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("List", src);
        return mod;
    }

}