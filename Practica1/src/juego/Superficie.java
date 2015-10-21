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
		//String matriz = " "; inicializar a campo vacio
		String matriz = "";
		for(int i = 0; i < this.filas; i++){
    		for(int j = 0; j < this.columnas; j++){
    			if(!casillaVacia(i, j))	//No se puede llamar al metedo toString sin un objeto
    			//matriz = superficie[i][j].toString() + matriz ; concatenacion inversa
    				matriz += superficie[i][j].toString();
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
	* Metodo que genera una celula nueva si la casilla esta vacia
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
	
	/**
	 * Metodo que indica donde se encuentra la celula 
	 * @param f valor entero positivo acotado en un rango valido del numero de filas
	 * @param c valor entero positivo acotado en un rango valido del numero de columnas
	 * @return entero de la posicion donde se encuentra la celula
	 */	
	private int posicionCelula(int f, int c){
		int posicion;
		if(f == 0 && c == 0)
			posicion = 1; // esquina superior izquierda
		else if(f == 0 && (c > 0 && c < this.columnas -1))
			posicion = 2; // lado superior
		else if(f == 0 && c == this.columnas -1)
			posicion = 3; // esquina superior derecha
		else if((f > 0 && f < this.filas -1)&& c == 0)
			posicion = 4; // lado izquierdo
		else if ((f > 0 && f < this.filas -1) && c == this.columnas -1)
			posicion = 6; // lado derecho
		else if(f == this.filas -1 && c == 0)
			posicion = 7; // esquina inferior izquierda
		else if(f == this.filas -1 && (c > 0 && c < this.columnas -1))
			posicion = 8; // lado inferior
		else if (f == this.filas -1 && c == this.columnas -1)
			posicion = 9; // esquina inferior derecha		 
		else posicion = 5; // posiciones centrales		
		return posicion;
	} 
	/**
	 * Metodo que mueve la celula segun la posicion donde se encuentra
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
	public int filasSuperficie(){
		return this.filas;
	}
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la Superficie
	 * @return valor entero positivo de las columnas 
	 */
	public int columnasSupeficie(){
		return this.columnas;
	}
	
}

