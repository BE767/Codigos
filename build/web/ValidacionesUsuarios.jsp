<%-- 
    Document   : ValidacionesUsuarios
    Created on : 21 may. 2023, 23:12:51
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.service.UsuariosService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="org.rocnic.dao.Usuarios"%>
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
                    <td>IDU</td>
                    <td><input type="number" name="idu" id="idu"/> </td>
                </tr>

                <tr>
                    <td>IDP</td>
                    <td><input type="number" name="idp" id="idp"/> </td>
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

                <tr>
                    <td colspan="3"><input type="submit" name="accion" id="accion" value="traer" ></td>
                </tr> 


                <tr>
                    <td colspan="3"><input type="submit" name="accion" id="accion" value="borrar" ></td>
                </tr> 

            </table>
        </form>
        <%
            String accion = request.getParameter("accion");
            if ("enviar".equals(accion)) {
                UsuariosService ususervice = new UsuariosService();
                Usuarios usuario = new Usuarios();
                usuario.setIdPerfil(Integer.parseInt(request.getParameter("idp")));
                usuario.setUsuario(request.getParameter("usuario"));
                usuario.setContraseña(request.getParameter("contraseña"));
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setBoleta(request.getParameter("boleta"));

                // Validar si la boleta, usuario y contraseña existen
                if (ususervice.validarUsuarioContraseñaBoletaExistente(usuario.getUsuario(), usuario.getContraseña(), usuario.getBoleta())) {
        %>
        <script>
            alert("El usuario, contraseña o boleta ya existen. Por favor, ingresa valores diferentes.");
        </script>
        <%
        } else {
            if (ususervice.addUsuarios(usuario)) {
        %>
        <script>
            alert("Ya lo guardé");
        </script>
        <%
        } else {
        %>
        <script>
            alert("No lo guardé");
        </script>
        <%
                    }
                }
            }
        %>
        <!-- coment -->
        <%      if ("traer".equals(accion)) {
                UsuariosService ususervice = new UsuariosService();
                Usuarios usuario = ususervice.getUsuariosByUsuarios(request.getParameter("idu"));
                if (usuario != null) {
        %>
        <table border="1">
            <tr>
                <td>idU</td>
                <td>idP</td>
                <td>Usuario</td>
                <td>Contrasena</td>
                <td>Nombre</td>
                <td>Boleta</td>
            </tr>
            <tr>
                <td><%= usuario.getIdUsuario()%></td>
                <td><%= usuario.getIdPerfil()%></td>
                <td><%= usuario.getUsuario()%></td>
                <td><%= usuario.getContraseña()%></td>
                <td><%= usuario.getNombre()%></td>
                <td><%= usuario.getBoleta()%></td>
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

        <%            UsuariosService ususervice = new UsuariosService();
            Usuarios usuario = new Usuarios();
            if ("cambiar".equals(accion)) {
                usuario.setIdPerfil(Integer.parseInt(request.getParameter("idp")));
                usuario.setUsuario(request.getParameter("usuario"));
                usuario.setContraseña(request.getParameter("contraseña"));
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setBoleta(request.getParameter("boleta"));
                usuario.setIdUsuario(Integer.parseInt(request.getParameter("idu")));
                if (ususervice.updateUsuarios(usuario)) {
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
            Usuarios usuarios = new Usuarios();
            if ("borrar".equals(accion)) {
                usuarios.setIdPerfil(Integer.parseInt(request.getParameter("idp")));
                usuarios.setUsuario(request.getParameter("usuario"));
                usuarios.setContraseña(request.getParameter("contraseña"));
                usuarios.setNombre(request.getParameter("nombre"));
                usuarios.setBoleta(request.getParameter("boleta"));
                usuarios.setIdUsuario(Integer.parseInt(request.getParameter("idu")));
                if (ususervice.deleteUsuario(usuarios)) {
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
                <td>idP</td>
                <td>Usuario</td>
                <td>Contrasena</td>
                <td>Nombre</td>
                <td>Boleta</td>
            </tr>
            <% UsuariosService estatu = new UsuariosService();
                List<Usuarios> list = estatu.getUsuarioList();
                if (list != null && list.size() > 0) {
                    for (Usuarios rol : list) {
            %>
            <tr>
                <td><%=rol.getIdUsuario()%></td>
                <td><%=rol.getIdPerfil()%></td>
                <td><%=rol.getUsuario()%></td>
                <td><%=rol.getContraseña()%></td>
                <td><%=rol.getNombre()%></td>
                <td><%=rol.getBoleta()%></td>
            </tr>
            <%}
                }
            %>

        </table>   
    </body>
</html>
