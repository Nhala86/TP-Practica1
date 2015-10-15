package juego;

public class Mundo {
	private Superficie superficie;
	
	
	private static final int NUMEROCELULAS = 6;
	private static final int NUMEROFILAS = 3;
	private static final int NUMEROCOLUMNAS = 4;
	 	
		
	/**
	 * La clase constructor de Mundo, genera una superficie con una longitud
	 * especifica de filas y columnas, y genera NUMEROCELULAS en posiciones
	 * aleatorias para esa superficie.
	 */
	public Mundo(int f, int c, int n){
		this.superficie = new Superficie(f, c);
		for (int i = 0; i < n; i++){
			generarCelulaAleatoria();
		}
	}
	//Lo dejo de para pregunta cual de los 2 es mejor
	/*
	public Mundo(int n){
		this.superficie = new Superficie(NUMEROFILAS, NUMEROCOLUMNAS);
		for (int n = 0; n < NUMEROCELULAS; n++){
		generarCelulaAleatoria();

	
/**
 * 
 * @param nf valor entero positivo que indica el numero de filas de la superficie
 * @param nc valor entero positivo que indica el numero de columnas de la superficie
 * @param n numero entero positivo de celulas que se generan en la superficie
 */
	/**
	 * para cada célula de la superficie ejecuta un paso de acuerdo a las
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
	 * Crea una celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return Si se ha hecho el proceso de crear la celula
	 */
	public boolean crearCelulaSuperficie(int f, int c){
		boolean ok = false;
		if (f < NUMEROFILAS && c < NUMEROCOLUMNAS && f >= 0 && c >= 0){
			superficie.crear(f, c);
			ok = true;
		}
		return ok;
	}
	
	/**
	 * Elimina la celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return Si se ha hecho el proceso de eliminar la celula
	 */
	public boolean eliminarCelulaSuperficie(int f, int c){
		boolean ok = false;
		if (f < NUMEROFILAS && c < NUMEROCOLUMNAS && f >= 0 && c >= 0){
			superficie.borrar(f, c);
			ok = true;
		}
		return ok;
	}
	
	/**
	 * Mirar como funciona la funcion
	 * @param n valor entero positivo
	 * @return un valor entero positivo a modulo de n
	 */
		private static int generaPosicion(int n){
			return (int)(Math.floor(Math.random()*101) % n);
		}

	
	
	/**
	 * Genera una celula en la superficie de forma random
	 */
	public void generarCelulaAleatoria(){
		int f, c;
		//Añadir el metodo aleatorio
		superficie.crear(f, c);
		
	}

}

