<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Pagina Principal</title>
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

        .button {
            display: inline-block;
            padding: 8px 16px;
            font-size: 14px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .button-red {
            background-color: #ff0000;
        }

        .button:hover {
            background-color: #45a049;
        }

        .button-red:hover {
            background-color: #ff3333;
        }

        .success-message {
            margin: 20px auto;
            width: 50%;
            padding: 10px;
            background-color: #dff0d8;
            color: #3c763d;
            border-radius: 4px;
            text-align: center;
        }

        .error-message {
            margin: 20px auto;
            width: 50%;
            padding: 10px;
            background-color: #e6bebe;
            color: #7d3636;
            border-radius: 4px;
            text-align: center;
        }

        .center {
            text-align: center;
        }

        .logout-button {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 8px 16px;
            font-size: 14px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            background-color: #ff0000;
            color: #fff;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .logout-button:hover {
            background-color: #ff3333;
        }
    </style>
</head>
<body>
<h3>FILMES</h3>
<c:if test="${not empty sessionScope.sucesso}">
    <div class="success-message center">
        <p>${sessionScope.sucesso}</p>
        <c:set var="sucesso" scope="session" value=""></c:set>
    </div>
</c:if>
<c:if test="${not empty sessionScope.retirado}">
    <div class="error-message center">
        <p>${sessionScope.retirado}</p>
        <c:set var="retirado" scope="session" value=""></c:set>
    </div>
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
            <td>
                <a href="${pageContext.request.contextPath}/editarFilme?id=${f.getIdfilme()}" class="button">Editar</a>
                <a href="${pageContext.request.contextPath}/remocao?id=${f.idfilme}" class="button button-red">Remover</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="center">
    <a href="${pageContext.request.contextPath}/addFilme" class="button">Criar novo Filme</a>
</div>
<a href="${pageContext.request.contextPath}/logout" class="logout-button">Sair</a>
</body>
</html>
