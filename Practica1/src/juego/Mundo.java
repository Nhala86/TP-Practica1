package juego;

public class Mundo {
	
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
		 int f = (int) (Math.random()*Constantes.NUMEROFILAS);
		 int c = (int) (Math.random()*Constantes.NUMEROCOLUMNAS);
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
		boolean [][] movido = new boolean [this.getFilas()][this.getColumnas()];
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			movido[i][j] = false;
		    }
		}		
		for(int i = 0; i < this.getFilas(); i++){ 
			for(int j = 0; j < this.getColumnas(); j++){
				if (superficie.getSinMover(i,j) < 0){// morir
					superficie.vaciarCasilla(i, j);
				}
				else if(!movido[i][j]){
					//se puede mover (TIENE SITIO LIBRE)
					if (){
						superficie.decrementarRep(i, j);
						if (superficie.getReproducir(i,j) < 0){// reproducirse
							System.out.println("Movimiento de (i,j) a (f,c)");
							//Mover celula (contador f,c : no i,j)
							superficie.llenarCasilla(i, j, new Celula());
							
						}
						else {
							//Mover celula
						}
						//Nueva posicion a la que se mueve la celula
						movido[][]= true;
					}
					else {
						//Si no se puede mover y esta por reproducirse, la celula muere
						if (superficie.getReproducir(i,j) < 0){ //muere
							superficie.vaciarCasilla(i, j);
						}
						else {
							superficie.decrementarSinMover(i, j);
						}
					}
					
				}
				
			}
		}	
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
	 * Metodo que devuelve el alor entero positivo de las filas de la superficie
	 * @return valor entero positivo de las filas de la Superficie en el Mundo
	 */
	public int getFilas(){
		return this.superficie.getFilas();
	}
	/**
	 * Metodo que devuelve el alor entero positivo de las columnas de la superficie
	 * @return valor entero positivo de las columnas de la Superficie en el Mundo
	 */
	public int getColumnas(){
		return this.superficie.getColumnas();
	}
	
}

