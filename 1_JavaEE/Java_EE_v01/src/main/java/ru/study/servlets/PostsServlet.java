package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.models.dto.PostsRequest;
import ru.study.services.PostsService;
import ru.study.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/post")
public class PostsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private PostsService postsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(postsService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PostsRequest postsRequest = new PostsRequest();
        postsRequest.setMedrec(req.getParameter("medical_center"));
        postsRequest.setId_post(Integer.parseInt(req.getParameter("id_post")));
        postsService.create(postsRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String medical_center = req.getParameter("medical_center");
        int id_post = Integer.parseInt(req.getParameter("id_post"));
        postsService.delete(medical_center, id_post);
    }
}