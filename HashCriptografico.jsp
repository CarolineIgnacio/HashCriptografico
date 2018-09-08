<%-- 
    Document   : HashCriptografico
    Created on : 07/09/2018, 22:13:09
    Author     : Caroline Ignácio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Hash</title>
    </head>
    <body>
        <h1>Resultado da codificação</h1>
        <input type="text" size="100" value="<%= request.getAttribute("senhahex")%>"><br>
        <input type="button" value="Return" onclick="history.back()">
    </body>
</html>
