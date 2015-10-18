package juego;

public class Celula {
	private int noMovimiento;
	private int movimiento;
	
	// Crea una celula con movimiento = 0 y con numero de movimientos antes de morir = 0
	public Celula(){
		this.noMovimiento = 1;
		this.movimiento = 0;
	}
	
	public Celula(int noMovimiento, int movimiento){
		this.noMovimiento = noMovimiento;
		this.movimiento = movimiento;
	}
	
	/**
     * Coge los valores numericos de noMovimiento y movimiento y los convierte en una cadena para mostrar
     * @return Una cadena con los dos parametros numericos de la celula, separados por un guion
     */
    public String toString(){
       return this.noMovimiento + "-" + this.movimiento;
    }

}
