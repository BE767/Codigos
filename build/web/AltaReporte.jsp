<%-- 
    Document   : AltaReporte
    Created on : 22 may. 2023, 22:04:48
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.Equipos"%>
<%@page import="java.util.List"%>
<%@page import="org.rocnic.dao.service.EquiposService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Rellena el formulario!</h1>
        <form id="form1" method="post">
            <table border="1">
                <tr>
                    <td>Numero Equipo</td>
                    <td><input type="number" name="numeroEquipo" id="numeroEquipo" /></td>
                </tr>

                <tr>
                    <td>Laboratorio</td>
                    <td><input type="text" name="laboratorio" id="laboratorio" /></td>
                </tr>

                <tr>
                    <td>Perifericos</td>
                    <td><input type="text" name="nombre" id="nombre" /></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" name="accion" value="enviar"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" name="accion" value="cambiar"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" name="accion" value="traer"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" name="accion" value="borrar"></td>
                </tr>
            </table>
        </form>

        <h1>Hello World!</h1>

        <table border="1">
            <tr>
                <td>NumeroEquipo</td>
                <td>Laboratorio</td>
                <td>Perifericos</td>
                <td>NombreEquipo</td>
            </tr>
            <% EquiposService equiposService = new EquiposService();
                List<Equipos> equiposList = equiposService.getEquiposList();
                if (equiposList != null && equiposList.size() > 0) {
                    for (Equipos equipo : equiposList) {
            %>
            <tr>
                <td><%=equipo.getIdEquipo()%></td>
                <td><%=equipo.getIdLaboratorio()%></td>
                <td><%=equipo.getIdPeriferico()%></td>
                <td><%=equipo.getNombreEquipo()%></td>
            </tr>
            <% }
                }
            %>
        </table>
    </body>
</html>
