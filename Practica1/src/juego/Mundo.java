package juego;

public class Mundo{
	
	private Superficie superficie;
		
	/**
	 * La clase constructor de Mundo, genera una superficie con una longitud
	 * especifica de filas y columnas, y genera NUMEROCELULAS en posiciones
	 * aleatorias para esa superficie.
	 */
	public Mundo(){
		this.superficie = new Superficie(Constantes.NUMEROFILAS, Constantes.NUMEROCOLUMNAS);
		this.generarCelulas();
	}
	
	public void generarCelulas(){
	 int contCelulas = 0;
	 while (contCelulas < Constantes.NUMEROCELULAS){
		 int f = (int) (Math.random()* Constantes.NUMEROFILAS);
		 int c = (int) (Math.random()* Constantes.NUMEROCOLUMNAS);
		 if (this.superficie.casillaVacia(f, c)) {
			 this.superficie.llenarCasilla(f, c, new Celula());
			 contCelulas++;
		 }
	 }
	}
	
	public String toString(){
		return superficie.toString();
	}
	
	/**
	 * Metodo que evoluciona segun las reglas de la vida.
	 * Si la celula se puede mover a otra casilla aleatoria colindante a ella, entonces deja una nueva celula
	 * Si no puede moverse, tiene un maximo de paso para poder hacerlo, si no muere
	 */
	public void evoluciona(){		
		int f = 0, c = 0;
		boolean [][] ocupado = new boolean [this.getFilas()][this.getColumnas()];
		morir(f, c);
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			ocupado[i][j] = false;
		    }
		}
		
		
	}
	/**
	 * Recorre la matriz y elimina todas las celulas que deben morir, dejando su casilla libre
	 * @param f
	 * @param c
	 */
	private void morir(int f, int c){
		while(f < this.getFilas()&& c < this.getColumnas()){
			if (superficie.getSinMover(f, c) < 0){
				superficie.vaciarCasilla(f, c);
			}
		}
	}
	// Como deberia ser buscar los vecinos, hay que crear el array de casilla y su contador
	public int buscarVecinos(int f, int c){ 
		for(int i = 0; i < incrFila.length; i++){
			int nf = f + incrFila[1];
			int nc = c + incrColumna[1];
			if(indicesCorrectos(nf, nc) && this.superficie.casillaVacia(nf, nc)){
				vectorCasillas[cout] = new Casilla(nf, nc);
				cont ++;
			}
		}
		return vectorCasillas[aleatorio]; // hay que crear un metodo que cree un aleatorio de f y c
	}
	/**
	 * Mueve la celula creandola en la nueva posicion con los atributos SinMover y Reproducir que tenia y la elimina 
	 * de la antigua posicion en la que estaba
	 * @param f Entero que contiene la fila de la nueva posicion de la celula
	 * @param c Entero que contiene la columna de la nueva posicion de la celula
	 * @param i Entero que contiene la fila de la antigua posicion de la celula
	 * @param j Entero que contiene la columna de la antigua posicion de la celula
	 * @param celula Contructora con argumentos que sera la nueva celula
	 */
	private void moverCelula(int f, int c, int i, int j, Celula celula) {
		superficie.llenarCasilla(f, c, celula);
		superficie.vaciarCasilla(i, j);
	}

	/**
	 * Metodo que vacia el tablero de celulas
	 */
	public void vaciar(){
		superficie.reset();
	}
	/**
	 * Crea una celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE se ha hecho el proceso de crear la celula
	 */
	public boolean crearCelulaSuperficie(int f, int c){ 
		return superficie.llenarCasilla(f, c, new Celula());  
	}
	
	/**
	 * Elimina la celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE si se ha hecho el proceso de eliminar la celula
	 */
	public boolean eliminarCelulaSuperficie(int f, int c){
		return superficie.vaciarCasilla(f,c);
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las filas de la superficie
	 * @return valor entero positivo de las filas de la Superficie en el Mundo
	 */
	public int getFilas(){
		return this.superficie.getFilas();
	}
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la superficie
	 * @return valor entero positivo de las columnas de la Superficie en el Mundo
	 */
	public int getColumnas(){
		return this.superficie.getColumnas();
	}
	
}

