package juego;

public class Celula {
	private int reproducirse;
	private int noMovimiento;
	private int movimiento;
	
	public Celula(){
		this.reproducirse = 2;
		this.noMovimiento = 1;
		this.movimiento = 0;
	}
	
	public Celula(int reproducirse, int noMovimiento, int movimiento){
		this.reproducirse = reproducirse;
		this.noMovimiento = noMovimiento;
		this.movimiento = movimiento;
	}

}
