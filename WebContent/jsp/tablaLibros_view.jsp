<%@page import="modelo.entidades.Libros"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<%
	List<Libros> listaLibros = (List<Libros>) request.getAttribute("listaLibros");
%>

<table border=1>
  <tr>
    <th>Título</th>
    <th>ISBN</th>
    <th>Detalle</th>
  </tr>
  <% for(Libros l : listaLibros){ %>
  <tr>
    <td><%=l.getTitulo()%></td>
    <td><%=l.getIsbn() %></td>
    <td><a href="<portlet:actionURL/>?isbn=<%=l.getIsbn()%>&accion=Detalle">Detalles</a></td>
  </tr>
  <% } %>
</table>

<h4>¿Desea añadir algun libro a la base de datos?</h4>
<form action="<portlet:actionURL/>" method="post">
	Título:<input type="text" name="titulo"/><br/>
	ISBN:<input type="text" name="isbn"/><br/>
	Autor:<input type="text" name="autor"/><br/>
	<p>Resumen:</p>
	<textarea name="resumen" rows="5" cols="70">Introduzca su resumen aquí...</textarea><br/>
	<br/>
	<input type="submit" name="accion" value="Alta">
</form>


   