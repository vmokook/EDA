package ru.study.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.services.MedicalRecService;
import ru.study.services.PostsService;
import ru.study.services.PatientService;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Inject
    private PatientService patientService;
    @Inject
    private MedicalRecService medicalrecService;
    @Inject
    private PostsService postsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");
        try {
            request.setAttribute("table_patients", patientService.getAll());
            request.setAttribute("table_medical_records", medicalrecService.getAll());
            request.setAttribute("table_posts", postsService.getAll());
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch (Exception ignored) {

        }
    }
}
