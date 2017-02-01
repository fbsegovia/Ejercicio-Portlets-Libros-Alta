package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Libros;

public class GestorLibros {
	
	public static List<Libros> listaLibros;
	
	static{
		listaLibros = new ArrayList<>();
		
		Libros libro = new Libros();
		libro.setTitulo("Cronicas del druida de hierro 1: Acosado");
		libro.setIsbn("9788448038717");
		libro.setAutor("Kevin Hearne");
		libro.setResumen("Atticus O'Sullivan es uno de los últimos druidas que quedan sobre la tierra. Vive tranquilamente en Arizona donde regenta una librería especializada en ocultismo. Los vecinos y sus clientes creen que este apuesto joven irlandés tiene unos veintiún años, cuando en realidad tiene veintiún siglos. Sus poderes los obtiene de la tierra, posee un acusado ingenio y es el propietario de Fragarach, la que responde, una espada mágica. Pero un enfurecido dios celta perturba la paz que ha hallado. Durante siglos ha intentado hallar a Atticus para hacerse con su espada y ahora, por fin, lo ha hecho. El druida necesitará todos sus poderes y más para enfrentarse a lo que se le viene encima. Un poco de aquella «suerte irlandesa» -ya algo pasada de modano le vendrá mal, así como la ayuda de una seductora diosa de la muerte, una vampira y un hombre lobo.");
		listaLibros.add(libro);
		
		libro = new Libros();
		libro.setTitulo("El color de la magia");
		libro.setIsbn("9788497596794");
		libro.setAutor("Terry Pratchett");
		libro.setResumen("En un mundo plano sostenido por cuatro elefantes impasibles -que se apoyan en la espalda de una tortuga gigante- habitan los estrafalarios personajes de esta novela: un hechicero avaro y torpe, un turista ingenuo cuyo fiero equipaje le sigue a todas partes sostenido por cientos de patitas, dragones que existen si se cree en ellos, gremios de ladrones y asesinos, espadas mágicas, la Muerte y, por supuesto, un extenso catálogo de magos y demonios... En esta serie de novelas se dan cita todos los temas y situaciones del género fantástico, visto a través del personalismo y corrosivo sentido dela comicidad de un autor inglés que se ha convertido en uno de los escritores de humor de mayor éxito y fama en el mundo. ");
		listaLibros.add(libro);
		
		libro = new Libros();
		libro.setTitulo("Harry Dresden 1: Tormenta");
		libro.setIsbn("9788498005288");
		libro.setAutor("Jim Butcher");
		libro.setResumen("Harry Dresden se ha convertido en una ayuda insustituible para la policía de Chicago, porque es el único a quien pueden acudir cuando una investigación entra de lleno en lo paranormal. Es el caso de un doble asesinato con tintes de magia negra. Y detrás de la magia negra siempre hay un mago oscuro. Así es como Harry se encuentra de frente con el lado siniestro de la hechicería. Y lo que parecía un trabajo rutinario se convierte en una pesadilla. Ahora van a por él. Jim Butcher se estrenó como escritor en 2000 con Tormenta, primera novela de La saga de Dresden. La serie se ha convertido en un fenómeno de masas en Estados Unidos, donde ya cuenta con toda una legión de seguidores, y empieza a conquistar lectores en todo el mundo.");
		listaLibros.add(libro);
	}
	
	public List<Libros> getListaLibros() {
		return listaLibros;
	}
	
	public Libros buscarPorISBN (String isbn) {
		for (Libros l : listaLibros) {
			if (l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}
	
	//Otra forma de buscar libros por ISBN -> Se necesita sobreescribir el método equals.
	public Libros buscarLibro(String isbn){
		Libros libroAux = new Libros();
		libroAux.setIsbn(isbn);
		int indice = listaLibros.indexOf(libroAux);
		libroAux = listaLibros.get(indice);
		return libroAux;		
	}
	
	//Al sobrescribir el metodo equals podemos añadir como condicion
	//que el libro no exista en la lista previamente.
	public void altaLibro(Libros libro) {
		if(!listaLibros.contains(libro))
		listaLibros.add(libro);
	}
	
	
}
