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
	public Mundo(int n){
		this.superficie = new Superficie(NUMEROFILAS, NUMEROCOLUMNAS);
		for (int n = 0; n < NUMEROCELULAS; n++){
			generarCelulaAleatoria();
		}
	}
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
	 * 
	 */
	public boolean crearCelulaSuperficie(){
		
	}
	
	/**
	 * 
	 */
	public boolean eliminarCelulaSuperficie(){
		
	}
	
	/**
	 * Generar la celulas en la superficie de forma random
	 */
	public void generarCelulaAleatoria(){
		
	}
}
