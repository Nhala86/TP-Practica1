package juego;

import java.util.Scanner;

public class Main {
	
	//NO SE PROBARLO PARA VER SI FUNCIONA EL TABLERO Y LO DEMAS
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Mundo mundo = new Mundo();
		Controlador controlador = new Controlador(mundo, in);
		controlador.realizaSimulacion();
	}

}
