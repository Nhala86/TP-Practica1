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
     * @return Una cadena con los dos parametros numericos de la celula, separados por un guion
     */
    public String toString(){
       return this.pasosSinMover + "-" + this.pasosReproduccion;
    }
    /**
     * 
     * @return
     */
    public int decrementarRep(){
    	return this.pasosReproduccion--;
    }
    /**
     * 
     * @return
     */
	public int decrementarSinMover() {
		return this.pasosSinMover--;
	}
	/**
	 * 
	 * @return
	 */
	public int getReproducir() {
		return this.pasosReproduccion;
	}
	/**
	 * 
	 * @return
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
