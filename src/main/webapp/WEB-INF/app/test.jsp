<%-- 
    Document   : test
    Created on : 03/11/2013, 12:30:53 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>${mensaje}</p> <!-- Estoy imprimiendo un mensaje q m enviaron de algun lugar -->

        <hr/>


        <form action="guardarDos" method="post">
            <label>Nombres</label>
            <input type="text" name="nombres"/>
            
            <label>Apellidos</label>
            <input type="text" name="apellidos"/>
            
            <input type="submit"/>
        </form>


    </body>
</html>
