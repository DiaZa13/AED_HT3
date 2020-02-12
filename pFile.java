import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.*;


/**
 * 
 * @author Diana Zaray Corado #191025
 * @version 11/02/2020
 *
 */
public class pFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] numbers = new Integer[3000];
		String linea, cadLista = " ",s = "";
		int n;
		File file = new File();
		sortingAlgorithms sort = new sortingAlgorithms();
		file.orderNumbers();
		//file.messyNumbers();



		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			//archivo = new File ("Numeros.txt");
			fr = new FileReader ("Numeros.txt");
			br = new BufferedReader(fr);

			// Lectura del fichero
			System.out.println("Leyendo el contendio del archivo.txt");

			while((linea = br.readLine())!=null)
				cadLista= linea;

				//System.out.println(linea);
				//cadLista = linea.split(" ");
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}

		String[] arreglo = cadLista.split(" ");
		for(int i = 0; i< arreglo.length;i++) {
			int r = Integer.parseInt(arreglo[i]);
			numbers[i] = r;
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(sort.mergeSort(numbers,0,numbers.length-1)));


	}

}
