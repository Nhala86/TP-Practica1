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
	 * para cada celula de la superficie ejecuta un paso de acuerdo a las
		reglas que se describieron en la Sección 2. El método evoluciona recorre la superficie
		y dependiendo de las reglas de la vida, va pidiéndola a ésta que realice los pasos
		pertinentes. Ten en cuenta que este método es el que determina cómo se mueven las
		células, las coloca, comprueba si mueren o se reproducen, etc.. Para ello tendrá que
		dar las órdenes pertienentes a la superficie para poder consultar la información sobre
		las células. Por otro lado cuando el mundo evoluciona, hay que controlar que una
		célula no se mueva dos veces en el mismo paso de evolución.
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
	public boolean crearCelulaSuperficie(int f, int c){
		/*
		boolean ok = false;
		  f y c tienen que llegar ya verificadas como valores validos en la clase controlador
		if (f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS && f >= 0 && c >= 0 && superficie.validarCasilla(f,c)){
			superficie.crear(f, c);
			*/
		return this.superficie.llenarCasilla(f, c);
	}
	
	/**
	 * Elimina la celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE si se ha hecho el proceso de eliminar la celula
	 */
	public boolean eliminarCelulaSuperficie(int f, int c){
		/*
		boolean ok = false;
		if (f < Constantes.NUMEROFILAS && c < Constantes.NUMEROCOLUMNAS && f >= 0 && c >= 0 && !superficie.validarCasilla(f,c)){
			superficie.borrar(f, c);
			ok = true;
		}
		return ok;
		*/
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

