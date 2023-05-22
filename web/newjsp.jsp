<%-- 
    Document   : newjsp
    Created on : 21 may. 2023, 22:54:49
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.service.Conexion"%>
<%@page import="org.rocnic.dao.Periferico"%>
<%@page import="java.util.List"%>
<%@page import="org.rocnic.dao.service.PerifericoService"%>
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
                    <td>IDp</td>
                    <td><input type="number" name="idp" id="idp" /></td>
                </tr>

                <tr>
                    <td>Nombre</td>
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
    <%
    String accion = request.getParameter("accion");
    if ("enviar".equals(accion)) {
        PerifericoService periServ = new PerifericoService();
        Periferico periferico = new Periferico();
        periferico.setNombrePeriferico(request.getParameter("nombre"));
        
        if (periServ.validarNombreExistente(periferico.getNombrePeriferico())) {
            %>
            <script>
                alert("El nombre de periférico ya existe. Por favor, elija otro nombre.");
            </script>
            <%
        } else {
            if (periServ.addPeriferico(periferico)) {
                %>
                <script>
                    alert("Se ha guardado correctamente.");
                </script>
                <%
            } else {
                %>
                <script>
                    alert("Error al guardar el periférico.");
                </script>
                <%
            }
        }
    }
%>
        <!-- coment -->
        <%      if ("traer".equals(accion)) {
                PerifericoService periServ = new PerifericoService();
                Periferico periferico = periServ.getPerifericosByPerifericos(request.getParameter("idp"));
                if (periferico != null) {
        %>
        <table border="1">
            <tr>
                <td>idU</td>
                <td>Nombre</td>
            </tr>
            <tr>
                <td><%= periferico.getIdPeriferico()%></td>
                <td><%= periferico.getNombrePeriferico()%></td>
            </tr>
        </table>   
        <script>
            alert("Si lo traje");
        </script>
        <%
        } else {
        %>
        <script>
            alert("No lo traje");
        </script>
        <%
                }

            }

        %>
        <!-- comment -->

        <%            PerifericoService periServ = new PerifericoService();
            Periferico periferico = new Periferico();
            if ("cambiar".equals(accion)) {
                periferico.setNombrePeriferico(request.getParameter("nombre"));
                periferico.setIdPeriferico(Integer.parseInt(request.getParameter("idp")));
                if (periServ.updateUsuarios(periferico)) {
        %>    
        <script>
            alert("Realizaste un cambio");
        </script>
        <% } else { %>
        <script>
            alert("No se pudo realizar el cambio");
        </script>
        <% }
            }
        %>
        <!-- comment -->

        <!-- comment -->

        <%
            Periferico perifericos = new Periferico();
            if ("borrar".equals(accion)) {
                perifericos.setNombrePeriferico(request.getParameter("nombre"));
                perifericos.setIdPeriferico(Integer.parseInt(request.getParameter("idp")));
                if (periServ.deletePeriferico(perifericos)) {
        %>    
        <script>
            alert("Borraste Algo");
        </script>
        <% } else { %>
        <script>
            alert("No se borró nada");
        </script>
        <% }
            }
        %>
        <!-- comment -->

        <h1>Hello World!</h1>

        <table border="1">
            <tr>

                <td>idU</td>
                <td>Nombre</td>
            </tr>
            <% PerifericoService estatu = new PerifericoService();
                List<Periferico> list = estatu.getPerifericoList();
                if (list != null && list.size() > 0) {
                    for (Periferico rol : list) {
            %>
            <tr>
                <td><%=rol.getIdPeriferico()%></td>
                <td><%=rol.getNombrePeriferico()%></td>
            </tr>
            <%}
                }
            %>

        </table>   
    </body>
</html>
