<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edição de Sala</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-top: 20px;
    }

    .container {
      width: 50%;
      margin: 20px auto;
      background-color: #fff;
      padding: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 10px;
    }

    input[type="text"], select {
      width: 94%;
      padding: 8px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    input[type="number"] {
      width: 94%;
      padding: 8px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button[type="submit"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      border: none;
      background-color: #4CAF50;
      color: #fff;
      border-radius: 4px;
      cursor: pointer;
    }

    button[type="submit"]:hover {
      background-color: #45a049;
    }

    .error-message {
      color: red;
      margin-bottom: 10px;
    }

    .back-link {
      display: block;
      margin-top: 10px;
      text-align: center;
      color: #333;
    }
  </style>
</head>
<body>
<h2>Edição de Sala</h2>
<div class="container">
  <c:if test="${not empty sessionScope.erro}">
    <p class="error-message">${sessionScope.erro}</p>
    <c:set var="erro" scope="session" value=""></c:set>
  </c:if>

  <form method="POST" action="atualizarSala">
    <label for="nome">Nome da Sala:</label>
    <input type="text" name="nome" value="${sala.getNome()}">
    <br>
    <label for="cadeiras">Quantidade de Cadeiras:</label>
    <input type="number" name="cadeiras" value="${sala.getCadeiras()}">
    <br>
    <input type="hidden" name="idsala" value="${sala.getIdsala()}">
    <br>
    <button type="submit">Atualizar Sala</button>
  </form>
  <a href="${pageContext.request.contextPath}/sala" class="back-link">Voltar</a>
</div>
</body>
</html>