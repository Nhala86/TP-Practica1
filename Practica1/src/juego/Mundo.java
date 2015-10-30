package juego;


import java.util.Arrays;

public class Mundo{
	
	private Superficie superficie;

		
	/**
	 * La clase constructor de Mundo, genera una superficie con una longitud
	 * especifica de filas y columnas, y genera NUMEROCELULAS en posiciones
	 * aleatorias para esa superficie.
	 */
	public Mundo(){
		this.superficie = new Superficie(Constantes.NUMEROFILAS, Constantes.NUMEROCOLUMNAS);
		this.generarCelulas();
	}
	
	public void generarCelulas(){
	 int contCelulas = 0;
	 while (contCelulas < Constantes.NUMEROCELULAS){
		 int f = (int) (Math.random()* Constantes.NUMEROFILAS);
		 int c = (int) (Math.random()* Constantes.NUMEROCOLUMNAS);
		 if (this.superficie.casillaVacia(f, c)) {
			 this.superficie.llenarCasilla(f, c, new Celula());
			 contCelulas++;
		 }
	 }
	}
	
	public String toString(){
		return superficie.toString();
	}
	
	/**
	 * Metodo que evoluciona segun las reglas de la vida.
	 * Si la celula se puede mover a otra casilla aleatoria colindante a ella, entonces deja una nueva celula
	 * Si no puede moverse, tiene un maximo de paso para poder hacerlo, si no muere
	 */
	public void evoluciona(){		
		boolean [][] movido = new boolean [this.getFilas()][this.getColumnas()];
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			movido[i][j] = false;
		    }
		}
		for(int i = 0; i < this.getFilas(); i++){
    		for(int j = 0; j < this.getColumnas(); j++){
    			if (!superficie.casillaVacia(i, j) && !morir(i, j) && !movido[i][j]){
    				//Obtener la nueva posicion (f,c)
    				int posiciones[] = posicionesVacias(i,j);
    				//Se puede mover (TIENE SITIO LIBRE)
					if (posiciones[0] != -1){
						int x = (int) (Math.random() * posiciones.length);
						int f, c;
						if (x % 2 == 0){
							f = posiciones[x];
							c = posiciones[x + 1];
						}
						else {
							f = posiciones[x - 1];
							c = posiciones[x];
						}
    					superficie.decrementarRep(i, j);
    					if (superficie.getReproducir(i,j) < 0){// reproducirse
    						System.out.println("Movimiento de (" + i + "," + j + ") a (" + f + "," + c + ")");
	    					moverCelula (f, c, i, j, new Celula(superficie.getSinMover(i, j) , Constantes.PASOS_REPRODUCCION));
	    					superficie.llenarCasilla(i, j, new Celula());
	    					System.out.println("Nace nueva celula en (" + i + "," + j + ")" + " cuyo padre ha sido (" + f + "," + c + ")");
    					}
    					else {
    						System.out.println("Movimiento de (" + i + "," + j + ") a (" + f + "," + c + ")");
	    					moverCelula (f, c, i, j, new Celula(superficie.getSinMover(i, j) , superficie.getReproducir(i, j)));
    					}
    					//Nueva posicion a la que se mueve la celula
    					movido[f][c]= true;
    				}
    				else {
	    				//Si no se puede mover y esta por reproducirse, la celula muere
	    				if (superficie.getReproducir(i,j) < 0){ //muere
	    					superficie.vaciarCasilla(i, j);
	    					System.out.println("Muere la celula de la casilla (" + i + "," + j + ") por no poder reproducirse");
	    				}
    					else {
    						superficie.decrementarSinMover(i, j);
    					}
    				}			
    			}
			}
		}
	}
	
	/**
	 * Elimina la celula si cumple la condicion de que SinMovimientos sea menor que 0, dejando su casilla libre
	 * @param f Entero que contiene la fila de la celula
	 * @param c Entero que contiene la columna de la celula
	 * @return TRUE Si se han cumplido las condiciones y se elimina la celula, FALSE si no se cumplen
	 */
	private boolean morir(int f, int c){
		boolean hecho = false;
		if (superficie.getSinMover(f, c) == 0){
			superficie.vaciarCasilla(f, c);
			System.out.println("Muere la celula de la casilla (" + f + "," + c + ") por inactividad");
			hecho = true;
		}
		return hecho;
	}
	
	/**
	 * Busco las posiciones vacias que hay alrededor de la celula que se pasa por parametro
	 * @param f Entero que representa la fila
	 * @param c Entero que representa la columna
	 * @return Un array de enteros de longitud (casillas vacias * 2) con las posiciones vacias (estan agrupadas de 2 en 2 
	 * dentro del array), si no posiciones vacias lo indico con el -1 como numero de control
	 */
	private int[] posicionesVacias(int f, int c){ 
		int cont=0;
		//16 = 8 * 2, guardo las nuevas posiciones en 2 casillas consecutivas, y 8 son las posibles posiciones vacias
		//Es la unica forma facil que se me ocurre de guardar las 2 posiciones
		int [] casillas = new int[16];
		int [] fila = {-1, 0, 1};
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int nf = f + fila[i];
				int nc = c + fila[j];
				if (nf < 0){
					nf = superficie.getFilas() - 1;
				}
				if (nf >= superficie.getFilas()){
					nf = 0;
				}
				if (nc < 0){
					nc = superficie.getColumnas() - 1;
				}
				if (nc >= superficie.getColumnas()){
					nc = 0;
				}
				if(superficie.casillaVacia(nf,nc)){
					casillas[cont] = nf;
					cont++;
					casillas[cont] = nc;
					cont++;
				}
			}
		}
		int casilla[];
		if (cont==0){
			casilla = new int[1];
			casilla[0] = -1;
		}
		else {
			casilla=Arrays.copyOf(casillas, cont);
		}
		return casilla;
	}
	/**
	 * Mueve la celula creandola en la nueva posicion con los atributos SinMover y Reproducir que tenia y la elimina 
	 * de la antigua posicion en la que estaba
	 * @param f Entero que contiene la fila de la nueva posicion de la celula
	 * @param c Entero que contiene la columna de la nueva posicion de la celula
	 * @param i Entero que contiene la fila de la antigua posicion de la celula
	 * @param j Entero que contiene la columna de la antigua posicion de la celula
	 * @param celula Contructora con argumentos que sera la nueva celula
	 */
	private void moverCelula(int f, int c, int i, int j, Celula celula) {
		superficie.llenarCasilla(f, c, celula);
		superficie.vaciarCasilla(i, j);
	}

	/**
	 * Metodo que vacia el tablero de celulas
	 */
	public void vaciar(){
		superficie.reset();
	}
	/**
	 * Crea una celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE se ha hecho el proceso de crear la celula
	 */
	public boolean crearCelulaSuperficie(int f, int c){ 
		return superficie.llenarCasilla(f, c, new Celula());  
	}
	
	/**
	 * Elimina la celula en la posicion (f,c) de la superficie
	 * @param f Valor entero positivo fila de la matriz
	 * @param c Valor entero positivo columna de la matriz
	 * @return TRUE si se ha hecho el proceso de eliminar la celula
	 */
	public boolean eliminarCelulaSuperficie(int f, int c){
		return superficie.vaciarCasilla(f,c);
	}
	
	/**
	 * Metodo que devuelve el valor entero positivo de las filas de la superficie
	 * @return valor entero positivo de las filas de la Superficie en el Mundo
	 */
	public int getFilas(){
		return this.superficie.getFilas();
	}
	/**
	 * Metodo que devuelve el valor entero positivo de las columnas de la superficie
	 * @return valor entero positivo de las columnas de la Superficie en el Mundo
	 */
	public int getColumnas(){
		return this.superficie.getColumnas();
	}
	
}

