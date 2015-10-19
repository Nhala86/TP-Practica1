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
     * Recorre casilla a casilla la matriz de celulas y las junta en una cadena para mostrar por consola
     * @return La matriz como un string
     */
	public String toString(){
		String matriz = " ";
		for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			matriz = superficie[i][j].toString() + matriz ;
		    }
    		matriz = matriz + System.getProperty("line.separator");
		}
		return matriz;
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
	 * Mira si la casilla pasada por parametro esta vacia
	 * @param f valor entero positivo que indica el numero de filas
	 * @param c valor entero positivo que indica el numero de columnas
	 * @return TRUE si la casilla esta vacia. FALSE para el caso contrario
	 */
	public boolean casillaVacia(int f, int c){
		return (this.superficie[f][c] == null);
	}

	/**
	 * Vacia la casilla pasada por parametro si no esta vacia ya y existe
	 * @param f valor entero positivo acotado en un rango valido del numero de filas
	 * @param c valor entero positivo acotado en un rango valido del numero de columnas
	 * @return TRUE si vacio la casilla. FALSE para el caso contrario
	 */
	public boolean vaciarCasilla(int f, int c){
		boolean ok = false;
		//De esta forma funciona 100%, solo con casilla vacia podria darse fallo si pasas por parametro un numero que no
		// este en el rango de las casillas, y que no funcione el programa
		// NO SE DEBE pasar un parametro incorrecto, esto ya debe comprobarlo el controlador cuando le pide al usuario el numero
		// if(!casillaVacia(f, c) && f >= 0 && c >= 0 && f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS){
		if(!casillaVacia(f, c)){
			this.superficie[f][c] = null;
			ok = true;
		}
		return ok;
	}

	/**
	* 
	* @param f valor entero positivo acotado en un rango valido del numero de filas
	* @param c valor entero positivo acotado en un rango valido del numero de columnas
	* @return TRUE si lleno la casilla. FALSE para el caso contrario
	*/
	public boolean llenarCasilla(int f, int c){
		boolean ok = false;
		//if(casillaVacia(f, c) && f >= 0 && c >= 0 && f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS){
		if(casillaVacia(f, c)){
			this.superficie[f][c] = new Celula();
			ok = true;
		}
		return ok;
	}
	
}

