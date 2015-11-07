package controlador;

import java.util.Scanner;

import logica.Mundo;

import java.io.*;
/*
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
*/

public class Controlador {
	private Mundo mundo;
	private Scanner in;
	
	/**
	 * Metodo que inicializa el mundo y el scanner
	 */
	public Controlador(){
		this.mundo = new Mundo();
		this.in = new Scanner(System.in);
	}
	
	/**
	 * Metodo constructor del Controlador que define los parametros mundo e in
	 * @param mundo le pasa el nuevo mundo inicializado
	 * @param in le pasa los controles ya inicializados
	 */
    public Controlador(Mundo mundo, Scanner in){
        this.mundo = mundo;
        this.in = in;
    }
    
    /**
     * Metodo encargado de los controles que el usuario introduce para el funcionamiento del juego
     * y encargado de llamar a las funciones en otras clases para mostrar por pantalla el juego y sus movimientos
     * @throws IOException 
     */
	public void realizaSimulacion() throws IOException{
		boolean fin = false;
		boolean vacio = false;
		System.out.println("Bienvenido al juego de la vida: ");
        System.out.println(mundo.toStringBuffer());
		while (!fin){
			System.out.print("Comando > ");
			String string = in.nextLine();
			String [] palabras = string.split(" ");
			if (palabras[0].equalsIgnoreCase("paso")){
				//Creo que si la superficie esta vacia, no hay evolucion posible
				//Preguntar a puri
				if (!vacio){
					mundo.evoluciona();
				}
				System.out.println(mundo.toStringBuffer());
			}
			else if (palabras[0].equalsIgnoreCase("iniciar")){
				System.out.println("Iniciando de nuevo el juego....");
				//Condicion para no repetir el proceso de vaciar si todo esta vacio
				if (!vacio){
					mundo.vaciar();
				}
				mundo.generarCelulas();
				vacio = false;
                System.out.println(mundo.toStringBuffer());
                
			}
			else if (palabras[0].equalsIgnoreCase("crearcelula")){
				//Hay fallo si no metes los 2 numeros separados (Ej: crearcelula 00)
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if(validarDatos(f, c)){
					if (mundo.crearCelulaSuperficie(f, c)){
						System.out.print("Creamos la celula en: (");
						System.out.print(palabras[1]);  System.out.print(",");
						System.out.print(palabras[2]);   System.out.println(")");
						vacio = false;
					}
					else {
						System.out.println("Error, la posicion indicada esta ocupada");
					}
				}
				else {
					System.out.println("Los parametros pasados son incorrectos, la celula no existe. Vuelva a introducirlos");
				}
                System.out.println(mundo.toStringBuffer());			
             }
			
			else if (palabras[0].equalsIgnoreCase("eliminarcelula")){
				//Hay fallo si no metes los 2 numeros separados (Ej: eliminarcelula 00)
				int f = new Integer (palabras[1]);
				int c = new Integer (palabras[2]);
				if(validarDatos(f, c)){
					if (mundo.eliminarCelulaSuperficie(f, c)){
						System.out.print("Eliminamos la celula en: (");
						System.out.print(palabras[1]);  System.out.print(",");
						System.out.print(palabras[2]);   System.out.println(")");
					}
					else {
						System.out.println("Error, la posicion indicada esta ocupada");
					}
				}
				else {
					System.out.println("Los parametros pasados son incorrectos, la celula no existe. Vuelva a introducirlos");
				}
                System.out.println(mundo.toStringBuffer());
			}
			else if (palabras[0].equalsIgnoreCase("ayuda")){
				System.out.println("POSIBLES COMANDOS:");
				System.out.println("PASO: realiza un paso en la simulacion");
				System.out.println("AYUDA: muestra esta ayuda");
				System.out.println("SALIR: cierra la aplicación");
				System.out.println("INICIAR: inicia una nueva simulación");
				System.out.println("VACIAR: crea un mundo vacio");
				System.out.println("CREARCELULA F C: crea una nueva celula en la posicion (f,c) si es posible");
				System.out.println("ELIMINARCELULA F C: elimina una celula de la posicion (f,c) si es posible");
                System.out.println(mundo.toStringBuffer());
			}
			else if (palabras[0].equalsIgnoreCase ("vaciar")){
				//Condicion para no repetir el proceso de vaciar si todo esta vacio
				if (!vacio){
					mundo.vaciar();
					vacio = true;
				}
				System.out.println("Vaciando la superficie....");
                System.out.println(mundo.toStringBuffer());
			}
			else if (palabras[0].equalsIgnoreCase ("guardar")){
				guardar();
				System.out.println("Juego guardado con exito");
			}
			else if (palabras[0].equalsIgnoreCase ("cargar")){
				mundo = cargar();
				System.out.println("Juego cargado con exito");
				System.out.println(mundo.toStringBuffer());
			}
			else if (palabras[0].equalsIgnoreCase("salir")){
				System.out.println("Fin de la simulacion.....");
				fin = true;
			}
			else {
				System.out.println("Comando no valido, introduzca otro");
                System.out.println(mundo.toStringBuffer());
			}
		}
	}
	/**
	 * Abre el fichero juego.txt, carga las dimensiones del tablero del fichero y las celulas que habia en un nuevo mundo
	 * @return El nuevo mundo que hemos cargado del fichero
	 * @throws IOException
	 */
	private Mundo cargar() throws IOException {
		File archivo=new File("juego.txt");
		Scanner entrada = new Scanner(archivo);
		int fila = entrada.nextInt(), columna = entrada.nextInt();
		Mundo mundo = new Mundo(fila, columna);
		for (int i=0; i < fila; i++){
			for (int j=0; j < columna; j++){
				String cadena = entrada.next();
				if (!cadena.equals("-")){
					//Crear nueva celula
					String [] posicion = cadena.split("-");
					int SinMover = Integer.parseInt(posicion[0]);
					int Reproduccion = Integer.parseInt(posicion[1]);
					mundo.crearCelulaSuperficie(i, j, SinMover, Reproduccion);
				}
			}
		}
		entrada.close();
		return mundo;
	}

	/**
	 * Se encarga de guardar las dimensiones del tablero y luego todo el tablero con el estado actual del juego en juego.txt
	 * @throws IOException
	 */
	private void guardar() throws IOException{
		File archivo=new File("juego.txt");
		FileWriter escribir = new FileWriter(archivo);
		String dim = mundo.getFilas() + " " + mundo.getColumnas() + System.getProperty("line.separator");
		escribir.append(dim);
		escribir.append(mundo.toStringBuffer());
		escribir.close();
	}

	/**
	 * Metodo que valida que los valores de fila y columna que pasa el usuario son validos
	 * @param f valores enteros positivos de fila
	 * @param c valores enteros positivos de columna
	 * @return TRUE si los valores de fila y columna es valido
	 * FALSE si los valores de fila y columna no son correctos, no estan dentro de los parametros definidos
	 */
	private boolean validarDatos(int f, int c){
		boolean valido = false;
		if(f >= 0 && f < this.mundo.getFilas()){
			if(c >= 0 && c < this.mundo.getColumnas()){
				valido = true;
			}
		}
		return valido;
	}
	
}
