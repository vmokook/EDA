package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.study.models.Houses;
import com.study.models.Apartment;
import com.study.models.Debtor;
import com.study.repos.HouseRepository;
import com.study.repos.ApartmentRepository;
import com.study.repos.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@Controller
@RequestMapping(
        value = "xsl",
        produces = {"application/xml"}
)
public class XslController {
    @Autowired
    private DebtorRepository debtorService;

    @Autowired
    private ApartmentRepository apartmentService;

    @Autowired
    private HouseRepository houseService;

    @ResponseBody
    @GetMapping(path = "/debtor")
    private ModelAndView getDebtor() throws JsonProcessingException {
        Iterable<Debtor> list = debtorService.findAll();
        return getModelAndView(list, "debtorXSL");
    }

    @ResponseBody
    @GetMapping(path = "/apartment")
    public ModelAndView getApartment() throws JsonProcessingException {
        Iterable<Apartment> list = apartmentService.findAll();
        return getModelAndView(list, "apartmentXSL");
    }

    @ResponseBody
    @GetMapping(path = "/house")
    public ModelAndView getHouse() throws JsonProcessingException {
        Iterable<Houses> list = houseService.findAll();
        return getModelAndView(list, "houseXSL");
    }

    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        System.out.println(mod);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("List", src);
        System.out.println(mod.getView());
        return mod;
    }

}