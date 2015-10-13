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

        public reset(){
		  for(int i = 0; i < nf; i++){
		 	for(int j = 0; j < nc; j++){
		 	     this.superficie[i][j] = null;
		       I}
		  }
		 
	}
	
}
