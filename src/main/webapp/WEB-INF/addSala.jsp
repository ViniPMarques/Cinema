<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Gênero</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            background-image: url('https://e0.pxfuel.com/wallpapers/463/120/desktop-wallpaper-movie-theatre.jpg');
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
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
            color: white;
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
        input[type="number"],
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
    <h2>Adicionar Sala</h2>
    <div>
        <form method="POST" action="registroSala">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" placeholder="Nome da Sala">
            <br>
            <label for="cadeiras">Cadeiras:</label>
            <input type="number" name="cadeiras" placeholder="Quantiade de Cadeiras">
            <br>
            <br>
            <button type="submit">Registrar Sala</button>
        </form>
        <a href="${pageContext.request.contextPath}/genero">Voltar</a>
    </div>
</div>
</body>
</html>

