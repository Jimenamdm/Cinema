package cine;

import list.ArrayList;
import anotacion.Programacion2; 

//Rellenar siempre los datos del Autor 1
//Para entrega individual poner enGrupo = false
//Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
	nombreAutor1 = "Jimena",
	apellidoAutor1 = "Mejía De Miguel",
	emailUPMAutor1 = "j.mdemiguel@alumnos.upm.es"
)

public class Sala {
	private String pelicula;
	private ArrayList<Sesion> sesiones;
	private int filas;
	private int columnas;
	
	public Sala(String pelicula, String[] horaSesiones, int filas, int columnas){
		this.pelicula=pelicula;
		this.sesiones=new ArrayList<Sesion>();
		String aux;
		for(int i=0;i<horaSesiones.length-1;i++){//for 1
			for(int j=i+1;j<horaSesiones.length;j++){//for 2
				if(horaSesiones[i].compareTo(horaSesiones[j])>0){//if 1
					aux=horaSesiones[i];
					horaSesiones[i]=horaSesiones[j];
					horaSesiones[j]=aux;
				}//de if 1
			}//de for 2
		}//de for 1
		Sesion sesionN;
		for(int i=0;i<horaSesiones.length;i++){//for 1
			sesionN = new Sesion (horaSesiones[i],filas,columnas);
			sesiones.add(i, sesionN);
		}//de for 1
		this.filas=filas;
		this.columnas=columnas;
	}//de constructor
	public String getPelicula (){
		return pelicula;
	}
	public void comprarEntrada(int sesion, int fila, int columna){
		Sesion n=sesiones.get(sesion-1);
		n.comprarEntrada(fila, columna);
	}
	public int getIdEntrada (int sesion, int fila, int columna){
		Sesion n=sesiones.get(sesion-1);
		return n.getIdEntrada(fila, columna);
		}
	public String [] getHorasDeSesionesDeSala (){
		String []resultado=new String [sesiones.size()];
		for(int i=0; i<sesiones.size(); i++){//for 1
			resultado[i]=sesiones.get(i).getHora();
		}// de for 1
		return resultado;
	}// de getHorasDeSesionDeSala
	public char [][] getEstadoSesion(int sesion){
		Sesion n=sesiones.get(sesion-1);
		return n.getEstadoSesion();
	}
	public int getButacasDisponiblesSesion(int sesion){
		Sesion n=sesiones.get(sesion-1);
		return n.getButacasDisponiblesSesion();
	}
	public String recogerEntradas (int id, int sesion){
		String resultado=null;
		Sesion n=sesiones.get(sesion-1);
		resultado=n.recogerEntradas(id);
		if(resultado!=null)
		resultado= pelicula+"@"+n.recogerEntradas(id);
		return resultado;
	}
	
	public ButacasContiguas recomendarButacasContiguas(int noButacas,int sesion){
		Sesion n=sesiones.get(sesion-1);
		return n.recomendarButacasContiguas(noButacas);
	}
	public void comprarEntradasRecomendadas (int sesion, ButacasContiguas butacas){
		Sesion n=sesiones.get(sesion-1);
		n.comprarEntradasRecomendadas(butacas);
	}
	public void incluirSesion(String horaSesion){
		Sesion n=new Sesion(horaSesion,filas, columnas);
		boolean existe=false;
		int i=0;
		if(horaSesion!=null){//if 1
			if(sesiones.size()==0){//if 2
				sesiones.add(0,n);
				existe=true;
					}//de if 2
		while((i<sesiones.size())&&(!existe)){//while 1
			if(sesiones.get(i).getHora().compareTo(horaSesion)>0){//if 3
				sesiones.add(i,n);
				existe=true;
			}else if(sesiones.get(sesiones.size()-1).getHora().compareTo(horaSesion)<0){
					sesiones.add(sesiones.size(),n);
					existe=true;
					} //de else if
			i++;
		}//de while 1
		}//de if 1
	}//de incluir sesion
				
			
	public void borrarSesion (String horaSesion){
		Sesion n;
		boolean existe=false;
		int i=0;
		if((horaSesion!=null)){// if 1
		while((i<sesiones.size())&&(!existe)){//while 1
			if(sesiones.get(i).getHora().equals(horaSesion)){//if 2
				existe=true;
				n=sesiones.get(i);
				sesiones.remove(n);
				}//de if 2
			i++;
			}//de while 1
		}//de if 1
		}//de borrar sesion
}// de Sala
	
