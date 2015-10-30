package juego;

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
	public boolean llenarCasilla(int f, int c){
		boolean ok = false;
		if(casillaVacia(f, c)){
			this.superficie[f][c] = new Celula();
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
	 * 
	 * @param f
	 * @param c
	 * @return
	 */
	public int decrementarRep(int f, int c){
		return superficie[f][c].decrementarRep();
	}
	/**
	 * 
	 * @param f
	 * @param c
	 * @return
	 */
	public int decrementarSinMover(int f, int c) {
		return superficie[f][c].decrementarSinMover();		
	}
	/**
	 * 
	 * @param f
	 * @param c
	 * @return
	 */
	public int getReproducir(int f, int c) {
		return superficie[f][c].getReproducir();
	}
	/**
	 * 
	 * @param f
	 * @param c
	 * @return
	 */
	public int getSinMover(int f, int c) {
		return superficie[f][c].getSinMover();
	}

	public void moverCelula(int f, int c, int i, int j) {
		this.superficie[i][j]=this.superficie[f][c];
		this.superficie[f][c]=null;
		
	}
	
}

