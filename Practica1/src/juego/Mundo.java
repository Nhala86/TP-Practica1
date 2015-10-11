package juego;

public class Mundo {
	private Superficie superficie;
	public static final int NUMEROCELULAS = 6;
	
	
	/**
	 * La calse constructor de Mundo, genera una superficie con una longitud
	 * especifica de filas y columnas, y genera NUMEROCELULAS en posiciones
	 * aleatorias para esa superficie.
	 */
	public Mundo(){
		this.superficie = new Superficie(3,4);
		/**
		 * una primera aporximacion de lo que tiene que hacer el constructor seria :
		 * for (int n = 0; n < NUMEROCELUAS; n++)
		 * 		generaCelula();
		 */
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
}
