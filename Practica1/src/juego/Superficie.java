package juego;

public class Superficie {
	private Celula[][] superficie;
	private int filas;
	private int columnas;
	
/**
 * Constructor de la clase superficie
 * @param nf valor entero positivo que indica el numero de filas de la superficie
 * @param nc valor entero positivo que indica el numero de columnas de la superficie
 */
	public Superficie(int nf, int nc){
		this.filas = nf;
		this.columnas = nc;
		this.superficie = new Celula[this.filas][this.columnas];
        this.reset();
    }
    	/**
    	 * Mostrar el tablero por pantalla
    	 */
	public String toString(){
		superficie[i][j].toString()
		return 
	}
/**
 * Procedimiento que pone a NULL todas las casillas de la superficie
 */
    public void reset(){
    	for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			this.superficie[i][j] = null;
		    }
		}		 
	}  
    
/**
 * 
 * @param f valor entero positivo que indica el numero de filas
 * @param c valor entero positivo que indica el numero de columnas
 * @return TRUE si la casilla esta vacia. FALSE para el caso contrario
 */
	public boolean casillaVacia(int f, int c){
		return (this.superficie[f][c] == null);
	}

/**
 * 
 * @param f valor entero positivo que indica el numero de filas
 * @param c valor entero positivo que indica el numero de columnas
 * @return TRUE si vacio la casilla. FALSE para el caso contrario
 */
	public boolean vaciarCasilla(int f, int c){
		boolean ok = false;
		if(!casillaVacia(f, c) && f >= 0 && c >= 0 && f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS){
			this.superficie[f][c] = null;
			ok = true;
		}
		return ok;
	}

/**
* 
* @param f valor entero positivo que indica el numero de filas
* @param c valor entero positivo que indica el numero de columnas
* @return TRUE si lleno la casilla. FALSE para el caso contrario
*/
	public boolean llenarCasilla(int f, int c){
		boolean ok = false;
		if(casillaVacia(f, c) && f >= 0 && c >= 0 && f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS){
			this.superficie[f][c] = new Celula();
			ok = true;
		}
		return ok;
	}
	
}

