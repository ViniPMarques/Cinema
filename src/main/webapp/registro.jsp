<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
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
    <h2>Registrar Usuário</h2>
    <div>
        <form method="POST" action="registro">
            <label for="login">Login:</label>
            <input type="text" name="login">
            <br>
            <label for="senha">Senha:</label>
            <input type="password" name="senha">
            <br>
            <br>
            <button type="submit">Registrar</button>
        </form>
        <a href="index.jsp">Voltar</a>
    </div>
</div>
</body>
</html>

