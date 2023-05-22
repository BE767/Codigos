<%-- 
    Document   : index.jsp
    Created on : 20 may. 2023, 13:06:56
    Author     : Evelyn
--%>

<%@page import="org.rocnic.dao.EstatusReporte"%>
<%@page import="java.util.List"%>
<%@page import="org.rocnic.dao.service.EstatusReporteService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
      <table border="1">
    <tr>
        <td>Rol</td>
        <td>Descripción</td>
    </tr>
    <%
        EstatusReporteService estatu = new EstatusReporteService();
        List<EstatusReporte>list = estatu.getEstatusReporteList();
        if( list != null && list.size() > 0)
        {
        for(EstatusReporte rol : list)
        {

    %>
    <tr>
        <td><%=rol.getIdEstatusReporte()%></td>
        <td><%=rol.getNombreEstatus( )%></td>
    </tr>
    <%}
       }
     %>
</table>

     
    </body>
</html>
