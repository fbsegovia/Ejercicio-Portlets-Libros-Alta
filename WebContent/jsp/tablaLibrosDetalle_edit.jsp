<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects/>   
    <%
    	String mostrarAutor = renderRequest.getPreferences().getValue("mostrarAutor", "");
   		String mostrarResumen = renderRequest.getPreferences().getValue("mostrarResumen", "");
    %>
      
<h2>Seleccione los atributos a mostrar en la tabla</h2>
<form action="<portlet:actionURL/>" method="post">
	Autor:<input type="checkbox" name="autor" <%=mostrarAutor%>/><br/>
	Resumen:<input type="checkbox" name="resumen" <%=mostrarResumen%>/><br/>
	<input type="submit" name="accion" value="Guardar">
</form>