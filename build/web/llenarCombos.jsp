<%-- 
    Document   : llenarCombos
    Created on : 22 may. 2023, 17:50:46
    Author     : Evelyn
--%>
<%@page import="org.rocnic.dao.service.EquiposService"%>
<%@page import="org.rocnic.dao.Laboratorio"%>
<%@page import="org.rocnic.dao.service.LaboratorioService"%>
<%@page import="org.rocnic.dao.Equipos"%>
<%@page import="java.util.List"%>
<%@page import="org.rocnic.dao.service.UsuariosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ComboBox Dependientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <select name="dllLaboratorio" onchange="cargaEquipos(this.value)">
            <%
                
                LaboratorioService labService = new LaboratorioService();
                List<Laboratorio> laboratorioList = labService.getLaboratorioList();
                if (laboratorioList != null && laboratorioList.size() > 0) {
            %>   
            <option value="-1">Seleccione Laboratorio</option>
            <%
                for (Laboratorio laboratorio : laboratorioList) {
            %>
            <option value="<%= laboratorio.getIdLaboratorio()%>"><%= laboratorio.getNombreLaboratorio()%></option>
            <% }
                }
            %>
        </select>

        <select name="dllEquipo" id="dllEquipo">
            <option value="">Seleccionar Equipo</option>
        </select>
        

     <script>


            var IdLab;
            function cargaEquipos(IdLaboratorio) {
                idLab = IdLaboratorio;
                // Limpiar el segundo nivel
                var selectNivel2 = document.getElementById("dllEquipo");
                selectNivel2.innerHTML = '<option value="">Seleccionar Equipo</option>';

                alert(IdLaboratorio);

            <%
                EquiposService numere = new EquiposService();
                List<Equipos> equipoList = numere.getEquiposById(1);
               
            
            %>
            }
        </script>

    </body>
</html>





