package cine;
import anotacion.Programacion2; 

//Rellenar siempre los datos del Autor 1
//Para entrega individual poner enGrupo = false
//Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
	nombreAutor1 = "Jimena",
	apellidoAutor1 = "Mejía De Miguel",
	emailUPMAutor1 = "j.mdemiguel@alumnos.upm.es"
	)
public class Cine {
	private String nombre;
	private Sala[] salas;
	
	public Cine (String nombre, Sala[] salas){
		this.nombre=nombre;
		this.salas=salas;
	}
	
	public void comprarEntrada(int sala, int sesion, int fila, int columna){
		Sala n=salas[sala-1];
		n.comprarEntrada(sesion, fila, columna);
	}
	public int getIdEntrada(int sala, int sesion, int fila, int columna){
		Sala n=salas[sala-1];
		return n.getIdEntrada(sesion, fila, columna);
	}
	
	public String [] getPeliculas(){
		String [] peliculas=new String[salas.length];
		for(int i=0; i<salas.length;i++){//for 1
			peliculas[i]=salas[i].getPelicula();
		}// de for 1
		return peliculas;
	}// de getPeliculas
	
	public String [] getHorasDeSesionesDeSala(int sala){
		Sala n=salas[sala-1];
		return n.getHorasDeSesionesDeSala();
	}
	
	public char[][] getEstadoSesion(int sala, int sesion){
		Sala n=salas[sala-1];
		return n.getEstadoSesion(sesion);
	}
	
	
	public int getButacasDisponiblesSesion(int sala, int sesion){
		Sala n=salas[sala-1];
		return n.getButacasDisponiblesSesion(sesion);
	}
	
	public String recogerEntradas(int id, int sala, int sesion){
		String resultado=null;
		Sala n=salas[sala-1];
		resultado=n.recogerEntradas(id, sesion);
		if(resultado!=null)
		resultado=nombre+"@"+n.recogerEntradas(id, sesion);
		return resultado;
	}
	public ButacasContiguas recomendarButacasContiguas(int noButacas, int sala, int sesion){
		Sala n=salas[sala-1];
		return n.recomendarButacasContiguas(noButacas, sesion);
	}
	
	public void comprarEntradasRecomendadas(int sala, int sesion, ButacasContiguas butacas){
		Sala n=salas[sala-1];
		n.comprarEntradasRecomendadas(sesion, butacas);
	}
	
	public void incluirSesion(int sala, String horaSesion){
		Sala n=salas[sala-1];
		n.incluirSesion(horaSesion);
		}
	
	public void borrarSesion(int sala,String horaSesion){
		Sala n=salas[sala-1];
		n.borrarSesion(horaSesion);
			}
}// de Cine
