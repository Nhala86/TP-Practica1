package juego;

public class Superficie {
	private Celula[][] superficie;
	private int filas;
	private int columnas;
	
	public Superficie(int nf, int nc){
		this.filas = nf;
		this.columnas = nc;
		//No se si hay que hacer un bucle y meter null campo a campo
		this.superficie = null;
		/*
		 * for(int i = 0; i < nf; i++){
		 * 	for(int j = 0; j < nc; j++){
		 * 	this.superficie[i][j] = null;
		 *  }
		 * }
		 */
	}
	
}
