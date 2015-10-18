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

    public String toString(){
       return this.noMovimiento + "-" + this.movimiento;
    }

}
