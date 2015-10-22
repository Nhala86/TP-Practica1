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
	 * Metodo que indica mediante un entero una posicion relativa de la celula en la superficie
	 * para determinar el caso particular de la misma en su tratamiento al moverse. 
	 * 1 -- 2 -- 3
	 * |	|	 |
	 * 4 --	5 -- 6
	 * |	|	 |
	 * 7 -- 8 -- 9
	 * @param f valor entero positivo acotado en un rango valido del numero de filas
	 * @param c valor entero positivo acotado en un rango valido del numero de columnas
	 * @return entero de la posicion donde se encuentra la celula
	 */	
	private int posicionCelula(int f, int c){
		int posicion;
		
		if(f == 0){
			if(c == 0)
				posicion = 1;
			else if(c >0 && c < this.columnas -1)
				posicion = 2;
			else
				posicion = 3;
		}
		else if(f >0 && f < this.filas-1){
			if(c == 0)
				posicion = 4;
			else if(c >0 && c < this.columnas -1)
				posicion = 5;
			else
				posicion = 6;
		}
		else{
			if(c == 0)
				posicion = 7;
			else if(c >0 && c < this.columnas -1)
				posicion = 8;
			else
				posicion = 9;
		}
		return posicion;
		}
	
	/**
	 * Metodo que mueve la celula segun la posicion donde se encuentra
	 * hay que considerar los 9 casos especificos de una superficie cuadrada
	 * y tratar cada uno de manera independiente. Para ello se estudiar previamente
	 * la posicion de la celula a mover seguido de su caracteristico metodo de movimiento.
	 */
	public void moverCelula(int f, int c){
		int x = posicionCelula(f, c);
		switch(x){
			case 1:					
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;			
		}
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

	public int decrementarRep(int f, int c){
		return superficie[f][c].decrementarRep();
	}

	public int decrementarSinMover(int f, int c) {
		return superficie[f][c].decrementarSinMover();
		
	}

	public int getReproducir(int f, int c) {
		
		return superficie[f][c].getReproducir();
	}

	public int getSinMover(int f, int c) {
		
		return superficie[f][c].getSinMover();
	}
	
}

