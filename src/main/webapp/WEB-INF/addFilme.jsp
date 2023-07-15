<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Adicionar Filme</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
    }

    .container {
      width: 300px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    input[type="text"],
    select {
      width: 94%;
      padding: 8px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button[type="submit"]:hover {
      background-color: #45a049;
    }

    a {
      display: block;
      text-align: center;
      margin-top: 10px;
      color: #555;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Adicionar Filme</h2>
    <div>
      <form method="POST" action="registroFilme">
        <label for="titulo">Título:</label>
        <input type="text" name="titulo" placeholder="Título">
        <br>
        <label for="diretor">Diretor:</label>
        <input type="text" name="diretor" placeholder="Diretor">
        <br>
        <label for="genero">Escolha 1 genero:</label>
        <select id="genero" name="genero">
          <c:forEach items="${listGeneros}" var="g">
            <option value="${g.idgenero}">
                ${g.nome}
            </option>
          </c:forEach>
        </select>
<%--          <option value="1">Comédia</option>--%>
<%--          <option value="2">Luta</option>--%>
<%--          <option value="3">Aventura</option>--%>
<%--          <option value="4">Drama</option>--%>
<%--        </select>--%>
        <br>
        <label for="sala">Escolha uma sala:</label>
        <select id="sala" name="sala">
          <c:forEach items="${listSalas}" var="s">
            <option value="${s.idsala}">
                ${s.nome}
            </option>
          </c:forEach>
        </select>
<%--          <option value="1">1A</option>--%>
<%--          <option value="2">1B</option>--%>
<%--          <option value="3">1C</option>--%>
<%--          <option value="4">2A</option>--%>
<%--          <option value="5">2B</option>--%>
<%--        </select>--%>
        <br>
        <br>
        <button type="submit">Registrar Filme</button>
      </form>
      <a href="${pageContext.request.contextPath}/principal">Voltar</a>
    </div>
  </div>
</body>
</html>

