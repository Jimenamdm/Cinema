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

public class Sesion {
	private String hora;
	private int [][] estadoAsientos;
	private int asientosDisponibles;
	private int sigIdCompra;
	
	public Sesion (String hora,int filas, int columnas){
		this.hora=hora;
		this.estadoAsientos=new int [filas][columnas];
		this.sigIdCompra=1;
		this.asientosDisponibles=filas*columnas;
	}// de constructor
	public String getHora(){
		return hora;
	}
	public boolean equals (Object objeto){
		boolean resultado=false;
		if((objeto!=null) && (objeto instanceof Sesion)){//if 1
			Sesion sesion=(Sesion) objeto;
			if(sesion.hora.equals(hora))
				resultado=true;
		}//de if 1
		return resultado;
	}// de equals
	public void comprarEntrada(int fila,int columna){
		if((asientosDisponibles>0)&&(estadoAsientos[fila-1][columna-1]==0)){//if 1
		estadoAsientos[fila-1][columna-1]=sigIdCompra;
		sigIdCompra++;
		asientosDisponibles--;
		}//de if 1
	}//de comprarEntrada
	public int getIdEntrada(int fila, int columna){
		return estadoAsientos[fila-1][columna-1];
	}
	public char [][] getEstadoSesion(){
		char [][] resultado=new char [estadoAsientos.length][estadoAsientos[1].length];
		for(int i=0; i<estadoAsientos.length;i++){//for 1
			for(int j=0;j<estadoAsientos[1].length;j++){//for 2
				if(estadoAsientos[i][j]!=0){//if 1
					resultado[i][j]='#';
				}else{
					resultado[i][j]='O';
				}//de else
					
			}// de for 2
			}// de for 1
		return resultado;
		}// de getEstadoSesion
	
	public int getButacasDisponiblesSesion(){
		return asientosDisponibles;
	}	
	public String recogerEntradas(int id){
		String resultado=null;
		for(int i=0; i<estadoAsientos.length;i++){//for 1
			for(int j=0;j<estadoAsientos[1].length;j++){//for 2
				if(estadoAsientos[i][j]==id){//if 1
					if(resultado==null){//if 2
					resultado=hora+"+"+(i+1)+","+(j+1)+"+";
					}else{
						resultado=resultado+(i+1)+","+(j+1)+"+";
						}//de else
					}//de if 1
				}//de for 2
			}// de for 1
		return resultado;
		}// de recogerEntradas
	public ButacasContiguas recomendarButacasContiguas(int noButacas){
		int butacas=0;
		ButacasContiguas asientos=null;
		boolean existe=false;
		int i=((estadoAsientos.length+1)/2);//(2+1)-1
		int j;
		while((!existe)&&(i<estadoAsientos.length)){//while 1
			j=estadoAsientos[1].length;
			butacas=0;
		   while((!existe)&&(j>0)){//while 2
			   j--;
		    if(estadoAsientos[i][j]==0){//if 1
		    	 butacas++;
		    	 if(butacas==noButacas){//if 2
			    		existe=true;
			    		asientos=new ButacasContiguas(i+1,j+1,noButacas);
							      }// de if 2
		    	 }else{
		    	butacas=0;
		      }//de else
		    }//de while 2
		   i++;
		  }//de while 1
		  if(!existe){//de if 1
		  int a=((estadoAsientos.length+1)/2)-1;
		  int b;
		  while((!existe)&&(a>=0)){// de while 1
			  b=estadoAsientos[1].length;
			  butacas=0;
		   while ((!existe)&&(b>0)){//de while 2
			   b--;
		    if(estadoAsientos[a][b]==0){// de if 2
		      butacas++;
		      if (butacas==noButacas){// de if 3
			       existe=true;
			       asientos=new ButacasContiguas(a+1,b+1,noButacas);
			       }//de if 2
		    }else{
		    	butacas=0;
		    }//de else
		   }//de while 2
		      
		   a--;
		  }//de while 1
		  }// de if 1
	
		  return asientos;
		 }// de recomedarButacasContiguas


	public void comprarEntradasRecomendadas(ButacasContiguas butacas){
		for(int i=butacas.getColumna()-1;i<(butacas.getColumna()-1+butacas.getNoButacas());i++){
			estadoAsientos[butacas.getFila()-1][i]=sigIdCompra;
			asientosDisponibles--;
		}// de for
		sigIdCompra++;
		}
}// de Sesion

