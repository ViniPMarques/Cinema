<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }

        .container {
            width: 300px;
            margin: auto auto;
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
        input[type="password"] {
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
        p {
            text-align: center;
            font-size: small;
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
    <h2>Logar</h2>
    <div>
        <c:if test="${not empty sessionScope.erro}">
            <p>${sessionScope.erro}</p>
            <c:set var="erro" scope="session" value=""></c:set>
        </c:if>

        <form method="POST" action="login">
            <label for="login">Login:</label>
            <input type="text" name="login" placeholder="Login">
            <br>
            <label for="senha">Senha:</label>
            <input type="password" name="senha" placeholder="Senha">
            <br />
            <br />
            <button type="submit">Autenticar</button>
        </form>
        <p>Sem Conta? Registre-se!</p>
        <a href="registro.jsp">Registrar</a>
    </div>
</div>
</body>
</html>

