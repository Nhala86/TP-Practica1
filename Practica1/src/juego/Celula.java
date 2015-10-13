package juego;

public class Celula {
	private int noMovimiento;
	private int movimiento;
	
// Crea una celula con movimiento = 0 y con numero de movimientos antes de morir = 0
	public Celula(){
		/**
		* no se especifica este atributo en el enunciado para la clase Celula.
		* this.reproducirse = 2;
		*/
		this.noMovimiento = 1;
		this.movimiento = 0;
	}
	
	public Celula(int noMovimiento, int movimiento){
		this.noMovimiento = noMovimiento;
		this.movimiento = movimiento;
	}

}
