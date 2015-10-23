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
	 * Metodo constructor especifico de la calse Celula definido para celulas con atributos especificos
	 * @param pasosSinMover
	 * @param pasosReproduccion
	 */
	public Celula(int pasosSinMover, int pasosReproduccion){
		this.pasosSinMover = pasosSinMover;
		this.pasosReproduccion = pasosReproduccion;
	}
	
	/**
     * Coge los valores numericos de noMovimiento y movimiento y los convierte en una cadena para mostrar
     * @return Una cadena con los dos parametros numericos de la celula, separados por un guion
     */
    public String toString(){
       return this.pasosSinMover + "-" + this.pasosReproduccion;
    }
    public int decrementarRep(){
    	return this.pasosReproduccion--;
    }

	public int decrementarSinMover() {
		return this.pasosSinMover--;
	}

	public int getReproducir() {
		return this.pasosReproduccion;
	}

	public int getSinMover() {
		return this.pasosSinMover;
	}
}
