package juego;

public class Casilla {
	private int nf;
	private int nc;
	
	public Casilla(int nf,int nc){
		this.nf = nf;
		this.nc = nc;
	}

	public int getFila(){
		return this.nf;
	}
	public int getColumna(){
		return this.nc;
	}
}
