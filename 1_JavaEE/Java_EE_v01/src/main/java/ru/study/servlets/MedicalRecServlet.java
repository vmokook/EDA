package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.utils.ObjectMapperFactory;
import ru.study.models.dto.MedicalRecRequest;
import ru.study.services.MedicalRecService;


import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "medicalrecServlet", value = "/medrec")
public class MedicalRecServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();
    @Inject
    private MedicalRecService medicalrecService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(medicalrecService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        MedicalRecRequest medicalrecRequest = new MedicalRecRequest();
        medicalrecRequest.setId_post(Integer.parseInt(req.getParameter("id_post")));
        medicalrecRequest.setId(Integer.parseInt(req.getParameter("id")));
        medicalrecRequest.setId_post(Integer.parseInt(req.getParameter("id_patient")));
        medicalrecRequest.setVisit_date((req.getParameter("visit_date")));
        medicalrecRequest.setDiagnosis((req.getParameter("diagnosis")));
        medicalrecRequest.setPrescription((req.getParameter("prescription")));
        medicalrecService.create(medicalrecRequest);
    }


    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int medrecId = Integer.parseInt(req.getParameter("id"));
        medicalrecService.delete(medrecId);
    }
}