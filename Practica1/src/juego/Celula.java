package juego;

public class Celula {
	private int pasosSinMover;
	private int pasosReproduccion;
	
	/**
	 * Metodo constructor generico de la clase Celula definido para las celulas basicas del juego
	 */
	public Celula(){
		this.pasosSinMover = Constantes.MAX_PASOS_SIN_MOVER;
		this.pasosReproduccion = Constantes.PASOS_REPRODUCCION;
	}	
	
	/**
     * Coge los valores numericos de pasosSinMover y pasosReproduccion y los convierte en una cadena para mostrar
     * @return una cadena con los dos parametros numericos de la celula, separados por un guion
     */
    public String toString(){
       return this.pasosSinMover + "-" + this.pasosReproduccion;
    }
    
    /**
     * Metodo que decrementa el numero de pasos de reproduccion que tiene la celula
     * @return valor entero entre 0 y 2
     */
    public int decrementarRep(){
    	return this.pasosReproduccion--;
    }
    
    /**
     * Metodo que decrementa el numero de pasos sin mover que tiene la celula
     * @return valor entero entre 0 y 1
     */
	public int decrementarSinMover() {
		return this.pasosSinMover--;
	}
	
	/**
	 * Metodo que devuelve los pasos de reproduccion de la celula
	 * @return valor entero positivo que indica los pasos de reproduccion de la celula
	 */
	public int getReproducir() {
		return this.pasosReproduccion;
	}
	
	/**
	 * Metodo que devuelve los pasos de reproduccion de la celula
	 * @return valor entero positivo que indica los pasos sin mover de la celula
	 */
	public int getSinMover() {
		return this.pasosSinMover;
	}
	
	/**
	 * Reinicia el valor de pasosReproduccion a la constante
	 */
	public void reiniciarReproducir(){
		this.pasosReproduccion = Constantes.PASOS_REPRODUCCION;
	}
}
