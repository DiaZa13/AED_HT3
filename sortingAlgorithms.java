import java.util.Arrays;

/**
 * @author Diana Zaray Corado #191025
 * @author Lewis/Loftus (selectionSort e insertionSort), ejemplo visto en clase
 * @autor Wiliam McDaniel Albritton (mergeSort y quickSort)
 * @see //www2.hawaii.edu/~walbritt/ics211/examples/Sorting.j
 * @author Adaptado de GeeksforGeeks (radixSort)
 * @see //www.geeksforgeeks.org/radix-sort/
 * @version 12/2/2020
 */
public class sortingAlgorithms {

//----------------------------------------------------SELECTION SORT-----------------------------------------------------

	/**
	 * pre: hay una array de enteros con datos desordenados
	 * post: se genera un array de datos ordenados
	 * selectionSort
	 *
	 * @param numbers array con numeros ordenados/desordenados a ordenar
	 */
	public static void selectionSort(Comparable[] numbers) {
		int min;
		Comparable temp;

		for (int index = 0; index < numbers.length - 1; index++) {
			min = index;
			for (int scan = index + 1; scan < numbers.length; scan++)
				if (numbers[scan].compareTo(numbers[min]) < 0)
					min = scan;

			// Swap the values
			temp = numbers[min];
			numbers[min] = numbers[index];
			numbers[index] = temp;
		}
	}
//------------------------------------------------------------INSERTION SORT---------------------------------------------------------

	/**
	 * pre: entra un array con datos ordenados/desordenados
	 * post: sale una array con datos ordenados
	 * insertionSort
	 *
	 * @param numbers array de enteros con datos ordenados/desordenados
	 */
	public void insertionSort(Comparable[] numbers) {

		for (int index = 1; index < numbers.length; index++) {
			Comparable key = numbers[index];
			int position = index;

			while (position > 0 && key.compareTo(numbers[position - 1]) < 0) {
				numbers[position] = numbers[position - 1];
				position--;
			}

			numbers[position] = key;
		}
	}
//--------------------------------------------------------MERGE SORT---------------------------------------------------------

	/**
	 * pre: array con datos ordenados/desordenados
	 * post: sale un array con datos ordenados
	 * mergeSort
	 *
	 * @param numbers array de enteros ordenados/desordenados
	 * @param start   es el primer elemento del array
	 * @param end     es el ultimo elemento del array
	 */
	public Comparable[] mergeSort(Comparable[] numbers, int start, int end) {
		if (start < end) {
			int half = (start + end) / 2;
			mergeSort(numbers, start, half);
			mergeSort(numbers, half + 1, end);
			merge(numbers, start, half, end);
		}
		return numbers;
	}

	/**
	 * pre: hay dos array con datos ordenados/desordenados
	 * post: unifica los dos array en un solo array
	 * merge
	 *
	 * @param numbers es un array de enteros ordenados/desordenados
	 * @param start   es el primer elemento del array
	 * @param half    elemento central del arreglo
	 * @param end     ultimo elemento del array
	 */
	private void merge(Comparable[] numbers, int start, int half, int end) {

		Comparable[] temp = new Comparable[numbers.length];

		int start1 = start;
		int end1 = half;
		int start2 = half + 1;
		int end2 = end;
		int i = start1;

		while ((start1 <= end1) && (start2 <= end2)) {
			if (numbers[start1].compareTo(numbers[start2]) < 0) {
				temp[i] = numbers[start1];
				i = i + 1;
				start1 = start1 + 1;
			} else {
				temp[i] = numbers[start2];
				i = i + 1;
				start2 = start2 + 1;
			}
		}
		while (start1 <= end1) {
			temp[i] = numbers[start1];
			i = i + 1;
			start1 = start1 + 1;
		}
		while (start2 <= end2) {
			temp[i] = numbers[start2];
			i = i + 1;
			start2 = start2 + 1;
		}
		i = start;
		while (i <= end) {
			numbers[i] = temp[i];
			i = i + 1;
		}
	}

//----------------------------------------------------------------QUICK SORT------------------------------------------------------------

	/**
	 * pre: array con enteros desordenados/ordenados
	 * post: ordena el array de enteros que entro como parametro
	 * quick sort
	 *
	 * @param numbers es un array de enteros
	 * @param start   es el primer elemento en el array
	 * @param end     es el ultimo elemento en el array
	 */
	public void quickSort(Comparable[] numbers, int start, int end) {
		if (start < end) {
			// split the table into two parts
			int pivot = partition(numbers, start, end);
			// sort the two parts
			quickSort(numbers, start, pivot - 1);
			quickSort(numbers, pivot + 1, end);
		}
	}

	/**
	 * pre: hay un solo array de datos desordenados/ordenados
	 * post: hay dos array de datos
	 * partitions: divide el array en dos partes, ya sea una mas grande que
	 * otra o ambas iguales.
	 *
	 * @param numbers es un array de enteros
	 * @param start   es el primer elemento en el array
	 * @param end     es el ultimo elemento en el array
	 * @return index del elemento dividido
	 */
	private static int partition(Comparable[] numbers, int start, int end) {
		Comparable pivot = numbers[start];
		int split = start;
		for (int i = start + 1; i <= end; i++) {
			if (pivot.compareTo(numbers[i]) > 0) {
				split = split + 1;
				Comparable temp = numbers[i];
				numbers[i] = numbers[split];
				numbers[split] = temp;
			}
		}
		numbers[start] = numbers[split];
		numbers[split] = pivot;
		return split;
	}
//--------------------------------------------------RADIX SORT----------------------------------------------------------------

	/**
	 * pre: array con datos desordenados/ordenados
	 * post: los datos del array son ordenados
	 * radixSort
	 * @param numbers
	 */
	public void radixSort(Integer[] numbers)
	{
		int m = getMax(numbers);
		for (int exp = 1; m/exp > 0; exp *= 10)
			countSort(numbers, numbers.length, exp);
	}

	/**
	 * pre:
	 * post: calcula el mayor elemento dentro del array
	 * @param numbers array de numeros ordenados/desordenados
	 * @return mayor elemento dentro del array
	 */
		static int getMax(Integer numbers[]){
		int mx = numbers[0];
		for (int i = 1; i < numbers.length; i++)
			if (numbers[i] > mx)
		mx = numbers[i];
		return mx;
		}


	/**
	 * pre:
	 * post: los datos son ordenados en cada vuelta
	 * countingSort
	 * @param numbers array de numeros
	 * @param position ultima position del array
	 * @param exp cantidad de veces que hace countingSort
	 */
	static void countSort(Integer numbers[], int position, int exp)
	{
		int output[] = new int[position]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count,0);
		for (i = 0; i < position; i++)
			count[ (numbers[i]/exp)%10 ]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = position - 1; i >= 0; i--)
		{
			output[count[ (numbers[i]/exp)%10 ] - 1] = numbers[i];
			count[ (numbers[i]/exp)%10 ]--;
		}

		for (i = 0; i < position; i++)
			numbers[i] = output[i];
	}


}
