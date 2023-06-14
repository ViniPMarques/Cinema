<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        h3 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<h3>FILMES</h3>
<c:if test="${not empty sessionScope.sucesso}">
    <p>${sessionScope.sucesso}</p>
    <c:set var="sucesso" scope="session" value=""></c:set>
</c:if>
<table>
    <thead>
        <th>Título</th>
        <th>Diretor</th>
        <th>Gênero</th>
        <th>Opção</th>
    </thead>
    <tbody>
    <c:forEach items="${listFilmes}" var="f">
        <tr>
            <td>${f.getTitulo()}</td>
            <td>${f.getDiretor()}</td>
            <td>${f.getGenero()}</td>
            <td><a href="${pageContext.request.contextPath}/edicao">Editar</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/addFilme">Criar novo Filme</a>

</body>
</html>

