package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.models.dto.PatientRequest;
import ru.study.services.PatientService;
import ru.study.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "patientServlet", value = "/patients")
public class PatientServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private PatientService patientService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(patientService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PatientRequest patientRequest = new PatientRequest();
        patientRequest.setId_patient(Integer.parseInt(req.getParameter("id_patient")));
        patientRequest.setId_post(Integer.parseInt(req.getParameter("id_post")));
        patientRequest.setFirst_name((req.getParameter("first_name")));
        patientRequest.setLast_name((req.getParameter("last_name")));
        patientRequest.setBirth_date((req.getParameter(" birth_date")));
        patientRequest.setGender((req.getParameter("gender")));
        patientService.create(patientRequest);
    }


    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id_post = Integer.parseInt(req.getParameter("id_post"));
        int id_patient = Integer.parseInt(req.getParameter("id_patient"));
        patientService.delete(id_post, id_patient);
    }
}