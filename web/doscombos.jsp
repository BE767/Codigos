<%-- 
    Document   : doscombos
    Created on : 22 may. 2023, 19:09:21
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@page import="org.rocnic.dao.service.UsuariosService"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>JSP Page</title>
</head>
<body>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownUsuario" data-bs-toggle="dropdown" aria-expanded="false">
            Selecciona un Usuario
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownUsuario">
            <% 
            UsuariosService usuarioService = new UsuariosService();
            List<Usuarios> usuarios = usuarioService.obtenerUsuarios();
            
            for (Usuarios usuario : usuarios) {
                int idUsuario = usuario.getIdUsuario();
                String boleta = usuario.getBoleta();
            %>
            <li><a class="dropdown-item" href="#" onclick="cargarFechas('<%= idUsuario %>')"><%= boleta %></a></li>
            <% } %>
        </ul>
    </div>
    
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownFecha" data-bs-toggle="dropdown" aria-expanded="false">
            Selecciona una Fecha
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownFecha" id="fechaDropdown">
            <!-- Las fechas se cargarán dinámicamente aquí -->
        </ul>
    </div>
    
    <script>
        function cargarFechas(idUsuario) {
            if (idUsuario !== "") {
                fetch('fechas.jsp?idUsuario=' + idUsuario)
                    .then(response => response.text())
                    .then(data => {
                        document.getElementById('fechaDropdown').innerHTML = data;
                    })
                    .catch(error => console.log(error));
            }
        }
    </script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


