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
		String s = "", cadLista = "";
		int n;
		File file = new File();
		sortingAlgorithms sort = new sortingAlgorithms();
		//file.orderNumbers();
		//file.messyNumbers();

		cadLista = file.readFile();
		String[] arreglo = cadLista.split(" ");
		for(int i = 0; i< arreglo.length;i++) {
			int r = Integer.parseInt(arreglo[i]);
			numbers[i] = r;
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(sort.insertionSort(numbers)));


	}

}
