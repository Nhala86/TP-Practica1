package juego;

public class Superficie {
	private Celula[][] superficie;
	private int filas;
	private int columnas;
	

	public Superficie(int nf, int nc){
		this.filas = nf;
		this.columnas = nc;
		this.superficie = new Celula[this.filas] [this.columnas];
        this.reset();
    }

//No se si hay que poner la funcion como static
    public void reset(){
    	for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			this.superficie[i][j] = null;
		    }
		}		 
	}
	
}
