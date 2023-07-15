<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
      width: 75%;
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
    .button-success {
      background-color: #1AA7EC;
    }

    .button:hover {
      background-color: #45a049;
    }

    .button-red:hover {
      background-color: #ff3333;
    }
    .button-success:hover {
      background-color: #1E2F97;
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
      /*position: absolute;*/
      /*top: 20px;*/
      /*right: 20px;*/
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
<nav class="navbar navbar-expand-lg navbar-static-top navbar-dark bg-dark">
  <a class="navbar-brand active" href="${pageContext.request.contextPath}/principal">Filmes</a>
  <a class="navbar-brand" href="#">Gêneros</a>
  <a class="navbar-brand" href="${pageContext.request.contextPath}/sala">Salas</a>
  <a class="logout-button" href="${pageContext.request.contextPath}/logout">Sair</a>
</nav>
<h3>Gêneros</h3>
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
  <th>Nome do Gênero</th>
  <th>Classificação Etária</th>
  <th>Opção</th>
  </thead>
  <tbody>
  <c:forEach items="${listGeneros}" var="f">
    <tr>
      <td>${f.getNome()}</td>
      <td>${f.getClassificacao()}</td>
      <td>
        <a href="${pageContext.request.contextPath}/editarGenero?id=${f.getIdgenero()}" class="button">Editar</a>
        <a href="${pageContext.request.contextPath}/remocaoGenero?id=${f.idgenero}" class="button button-red">Remover</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="center">
  <a href="${pageContext.request.contextPath}/addGenero" class="button">Criar novo Gênero</a>
</div>
</body>
</html>
