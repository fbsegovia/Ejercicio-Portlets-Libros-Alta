package portlets;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import modelo.entidades.Libros;
import modelo.negocio.GestorLibros;

public class DetalleLibroPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		GestorLibros gl = new GestorLibros();
		
		String siguientePagina = request.getParameter("siguientePagina"); 
		
		if(siguientePagina == null){
			List<Libros> listaLibros = gl.getListaLibros();
			request.setAttribute("listaLibros", listaLibros);
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/tablaLibros_view.jsp");
			prd.include(request, response);
			System.out.println("página inicial");
		}else if(siguientePagina.equals("1")){
			List<Libros> listaLibros = gl.getListaLibros();
			request.setAttribute("listaLibros", listaLibros);
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/tablaLibros_view.jsp");
			prd.include(request, response);
			System.out.println("página inicial con añadidos");
		}else if(siguientePagina.equals("2")){
			System.out.println("Recojo el isbn");
			String isbn = request.getParameter("isbn");
			Libros l = gl.buscarPorISBN(isbn);
			request.setAttribute("libro", l);
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/tablaLibrosDetalle_view.jsp");
			prd.include(request, response);	
			System.out.println("página detalle");
		}
	}
	
	@Override
	protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/tablaLibrosDetalle_edit.jsp");
		prd.include(request, response);	
	}
	
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		String accion =request.getParameter("accion");
		String siguientePagina = null;
		if(accion.equals("Detalle")){
			String isbn =request.getParameter("isbn");
			if(isbn !=null){
			response.setRenderParameter("isbn", isbn);
			siguientePagina = "2";
			System.out.println("mandando en ISBN");
			}
		}else if(accion.equals("Volver")){
			siguientePagina = "1";
		}else if(accion.equals("Alta")){
			String titulo = request.getParameter("titulo");
			String isbn = request.getParameter("isbn");
			String autor = request.getParameter("autor");
			String resumen = request.getParameter("resumen");
			Libros libro = new Libros();
			libro.setTitulo(titulo);
			libro.setIsbn(isbn);
			libro.setAutor(autor);
			libro.setResumen(resumen);
			GestorLibros gl = new GestorLibros();
			gl.altaLibro(libro);
			siguientePagina = "1";
			System.out.println("mandando el libro");
		}else if(accion.equals("Guardar")){
			siguientePagina = "1";
			System.out.println("se envia la pagina");
			PortletPreferences preferencias = request.getPreferences();
			preferencias.setValue("mostrarAutor", "");
			preferencias.setValue("mostrarResumen", "");
			System.out.println("Se preparan las preferencias");
			if(request.getParameter("autor") != null){
				preferencias.setValue("mostrarAutor", "checked");
			}
			if(request.getParameter("resumen") != null){
				preferencias.setValue("mostrarResumen", "checked");
			}
			preferencias.store();
			response.setPortletMode(PortletMode.VIEW);
		}
		response.setRenderParameter("siguientePagina", siguientePagina);
	}
	
	
}
