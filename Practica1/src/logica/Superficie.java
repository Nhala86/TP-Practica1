package logica;


public class Superficie{
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
	public StringBuffer toStringBuffer() {
		StringBuffer matriz = new StringBuffer("");
		for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			matriz.append(" "); 
    			if(!casillaVacia(i, j)){    				
    				matriz.append(superficie[i][j].toStringBuffer());    				
    			}
    			else
    				matriz.append(" - ");
		    }
    		matriz.append(System.getProperty("line.separator"));
		}
		return matriz;
	}
	/*
	public String toString(){
		String matriz = "";
		for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			matriz += ' '; 
    			if(!casillaVacia(i, j)){    				
    				matriz += superficie[i][j].toString();    				
    			}
    			else
    				matriz += " - ";
		    }
    		matriz = matriz + System.getProperty("line.separator");
		}
		return matriz;
	}
	*/
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
		return this.superficie[f][c] == null;
	}

	/**
	 * Vacia la casilla pasada por parametro si no esta vacia ya y existe
	 * @param f valor entero positivo acotado en un rango valido del numero de filas
	 * @param c valor entero positivo acotado en un rango valido del numero de columnas
	 * @return TRUE si vacio la casilla. FALSE para el caso contrario
	 */
	public boolean vaciarCasilla(int f, int c){
		boolean ok = false;
		if(!casillaVacia(f, c)){
			this.superficie[f][c] = null;
			ok = true;
		}
		return ok;
	}

	/**
	* Metodo que genera una celula nueva si la casilla esta vacia
	* @param f valor entero positivo acotado en un rango valido del numero de filas
	* @param c valor entero positivo acotado en un rango valido del numero de columnas
	* @return TRUE si lleno la casilla. FALSE para el caso contrario
	*/
	public boolean llenarCasilla(int f, int c, Celula celula){
		boolean ok = false;
		if(casillaVacia(f, c)){
			this.superficie[f][c] = celula;
			ok = true;
		}
		return ok;
	}	
	
	
	/**
	 * Metodo que devuelve el valor entero positivo de las filas de la Superficie
	 * @return valor entero positivo de las filas 
	 */
	public int getFilas(){
		return this.filas;
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la Superficie
	 * @return valor entero positivo de las columnas 
	 */
	public int getColumnas(){
		return this.columnas;
	}
	
	/**
	 * Metodo que llama a la clase Superficie con unos parametros especificos de fila y columna para decrementar los pasos de reproducción
	 * @param f entero positivo que hace referencia a la fila 
	 * @param c entero positivo que hace referencia a la columna
	 * @return el valor decrementado de pasos de reproducción
	 */
	public int decrementarRep(int f, int c){
		return superficie[f][c].decrementarRep();
	}
	
	/**
	 * Metodo que llama a la clase Superficie con unos parametros especificos de fila y columna para decrementar los pasos sin mover
	 * @param f entero positivo que hace referencia a la fila 
	 * @param c entero positivo que hace referencia a la columna
	 * @return el valor decrementado de pasos sin mover
	 */
	public int decrementarSinMover(int f, int c) {
		return superficie[f][c].decrementarSinMover();		
	}
	
	/**
	 * Metodo que llama a la clase Superficie con unos parametros especificos de fila 
	 * y columna para indicar los pasos de reproduccion de la celula
	 * @param f entero positivo que hace referencia a la fila 
	 * @param c entero positivo que hace referencia a la columna
	 * @return el valor actual de pasos de reproducción
	 */
	public int getReproducir(int f, int c) {
		return superficie[f][c].getReproducir();
	}
	/**
	 * Metodo que llama a la clase Superficie con unos parametros especificos de fila y columna para decrementar los pasos sin mover
	 * @param f entero positivo que hace referencia a la fila 
	 * @param c entero positivo que hace referencia a la columna
	 * @return el valor actual de pasos sin mover
	 */
	public int getSinMover(int f, int c) {
		return superficie[f][c].getSinMover();
	}
	
	/**
	 * Metodo que llama a la clase Superficie e iguala la posicion actual
	 * a la nueva en la que se encuentra la celula. Y la antigua la vacia
	 * @param f entero positivo que hace referencia a la fila nueva 
	 * @param c entero positivo que hace referencia a la columna nueva
	 * @param i entero positivo que hace referencia a la fila antigua
	 * @param j entero positivo que hace referencia a la columna antigua
	 */
	public void moverCelula(int f, int c, int i, int j){
		this.superficie[f][c] = this.superficie[i][j];
		this.superficie[i][j] = null;
		
	}
	
	/**
	 * Reinicia el valor de reproducir a la constante
	 * @param f valor entero positivo que indica la fila de la celula
	 * @param c valor entero positivo que indica la columna de la celula
	 */
	public void reiniciarReproducir(int f, int c){
		this.superficie[f][c].reiniciarReproducir(); 
	}

}

