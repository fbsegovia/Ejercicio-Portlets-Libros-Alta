<%@page import="modelo.entidades.Libros"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<portlet:defineObjects/>   

<%
	Libros l = (Libros) request.getAttribute("libro");
	String mostrarAutor = renderRequest.getPreferences().getValue("mostrarAutor", "");
	String mostrarResumen = renderRequest.getPreferences().getValue("mostrarResumen", "");
%>

<table  border=1 style="color:green">
  <tr>
    <th>Título</th>
    <th>ISBN</th>
    <%
  	if(mostrarAutor.equals("checked")){
  	%>
    <th>Autor</th>
    <%
    }
    if(mostrarResumen.equals("checked")){
    %>
    <th>Resumen</th>
    <%
    }
    %>
  </tr>
  <tr>
    <td><%=l.getTitulo() %></td>
    <td><%=l.getIsbn() %></td>
    <%
	 if(mostrarAutor.equals("checked")){
	%>
    <td><%=l.getAutor() %></td>
     <%
    }
    if(mostrarResumen.equals("checked")){
    %>
    <td><%=l.getResumen() %></td>
    <%
    }
    %>
  </tr>
</table>

<a href="<portlet:actionURL/>?accion=Volver"">Volver</a>


