package logica;


public class Celula {
	
	private static final int MAX_PASOS_SIN_MOVER = 1;
	private static final int PASOS_REPRODUCCION = 2;
	private int pasosSinMover;
	private int pasosReproduccion;
	
	/**
	 * Metodo constructor generico de la clase Celula definido para las celulas basicas del juego
	 */
	public Celula(){
		this.pasosSinMover = MAX_PASOS_SIN_MOVER;
		this.pasosReproduccion =PASOS_REPRODUCCION;
	}	
	/**
	 * Constructor de una celula con argumentos
	 * @param SinMover Numero de pasos que puede pasar la celula sin moverse
	 * @param Reproduccion Numero de pasos que le quedan a la celula para reproducirse
	 */
	public Celula(int SinMover, int Reproduccion){
		this.pasosSinMover = SinMover;
		this.pasosReproduccion = Reproduccion;
	}
	/**
     * Coge los valores numericos de pasosSinMover y pasosReproduccion y los convierte en una cadena para mostrar
     * @return una cadena con los dos parametros numericos de la celula, separados por un guion
     */
	/*
    public String toString(){
       return this.pasosSinMover + "-" + this.pasosReproduccion;
    }
    */
	
	
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
		this.pasosReproduccion = PASOS_REPRODUCCION;
	}
	/**
     * Coge los valores numericos de pasosSinMover y pasosReproduccion y los convierte en una cadena para mostrar
     * @return una cadena con los dos parametros numericos de la celula, separados por un guion
     */
	public Object toStringBuffer() {
		return this.pasosSinMover + "-" + this.pasosReproduccion;
	}
}
