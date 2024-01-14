<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.study.models.MedicalRecEntity" %>
<%@ page import="ru.study.models.PatientEntity" %>
<%@ page import="ru.study.models.PostsEntity" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Architecture of corporate systems</title>
</head>
<body>
<% List<PatientEntity> ps = (List<PatientEntity>) request.getAttribute("table_patients");%>
<table>
    <thead>
    <tr>
        <th>id_patient</th>
        <th>id_post</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>birth_date</th>
        <th>gender</th>
    </tr>
    </thead>
    <tbody>
    <% for (PatientEntity p : ps) { %>
    <tr>
        <td><%=  p.getId_dorm() %>
        <td><%= p.getId_patient() %>
        <td><%= p.getId_post() %>
        <td><%= p.getFirst_name() %>
        <td><%= p.getLast_name() %>
        <td><%= p.getBirth_date()  %>
        <td><%= p.getGender() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<MedicalRecEntity> medics = (List<MedicalRecEntity>) request.getAttribute("table_medical_records");%>
<table>
    <thead>
    <tr>
        <th>id_post</th>
        <th>id</th>
        <th>id_patient</th>
        <th>visit_date</th>
        <th>diagnosis</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
    <% for (MedicalRecEntity m : medics) { %>
    <tr>
        <td><%= m.getId_post() %>
        <td><%= m.getId() %>
        <td><%= m.getId_patient() %>
        <td><%= m.getVisit_date() %>
        <td><%= m.getDiagnosis() %>
        <td><%= m.getPrescription() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<PostsEntity> ps = (List<PostsEntity>) request.getAttribute("table_posts");%>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>medrec</th>
    </tr>
    </thead>
    <tbody>
    <% for (PostsEntity p: ps) { %>
    <tr>
        <td><%= p.getId_post() %>
        <td><%= p.getMedrec() %>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>

