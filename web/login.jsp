<%-- 
    Document   : index.jsp
    Created on : 20 may. 2023, 13:06:56
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.Helpers.Helpers"%>
<%@page import="org.rocnic.dao.Usuarios"%>
<%@page import="org.rocnic.dao.service.UsuariosService"%>
<%@page import="org.rocnic.dao.EstatusReporte"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Rellena el formulario!</h1>
        <form id="form1">
            <table border="1">

                <tr>
                    <td>IDP</td>
                    <td><input type="number" name="idp" id="idp"/> </td>
                </tr>
                <tr>
                    <td>IDU</td>
                    <td><input type="number" name="idu" id="idu"/> </td>
                </tr>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario" id="usuario"/> </td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="text" name="contraseña" id="contraseña" /> </td>
                </tr>  
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" id="nombre"/> </td>
                </tr>
                <tr>
                    <td>Boleta</td>
                    <td><input type="text" name="boleta" id="boleta"/> </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="accion" id="accion" value="enviar" ></td>
                </tr>  

                <tr>
                    <td colspan="2"><input type="submit" name="accion" id="accion" value="cambiar" ></td>
                </tr>  

            </table>
          
        </form>

    </body>
</html>
