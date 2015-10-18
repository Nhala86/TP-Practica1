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
		for (int i = 0; i < Constantes.NUMEROCELULAS; i++){
			generarCelulaAleatoria();
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
	public boolean crearCelulaSuperficie(int f, int c){ // estaba bien antes, si haces esto no devuelve true ni false
		return superficie.llenarCasilla(f, c);  //Si que devuelve true o false, mira la funcion en superficie, pasa lo mismo en vaciar casilla
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
	 * Genera un numero aleatorio entre 0 y n - 1.
	 * @param n Valor entero positivo que limita el rango del numero aleatorio
	 * @return Un entero entre 0 y n - 1
	 */
	private static int generaPosicion(int n){
		return (int)((Math.random() * n));
	}
	
	/**
	 * Genera una celula en la superficie de forma aleatoria
	 */
	public void generarCelulaAleatoria(){
		int n;
		n = generaPosicion(Constantes.NUMEROFILAS * Constantes.NUMEROCOLUMNAS);
		this.superficie.llenarCasilla(n / Constantes.NUMEROFILAS, n % Constantes.NUMEROCOLUMNAS);
	}

}

