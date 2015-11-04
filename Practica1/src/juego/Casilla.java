package juego;

public class Casilla {
	private int nf;
	private int nc;
	
	/**
	 * Metodo constructor de la clase Casilla definido para las casillas del juego
	 * @param nf valor entero positivo que representa la fila en la que se encuentra la casilla
	 * @param nc valor entero positivo que representa la columna en la que se encuentra la casilla
	 */
	public Casilla(int nf,int nc){
		this.nf = nf;
		this.nc = nc;
	}
	
	/**
	 * Metodo que devuelve el numero de la fila donde se encuentra la casilla
	 * @return valor entero positivo de la posición de la casilla en la fila
	 */
	public int getFila(){
		return this.nf;
	}
	
	/**
	 * Metodo que devuelve el numero de la columna donde se encuentra la casilla
	 * @return valor entero positivo de la posición de la casilla en la columna
	 */
	public int getColumna(){
		return this.nc;
	}
}
