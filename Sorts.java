import java.util.Arrays;
/**
 * @author Diana Zaray Corado #191025
 * @version 11/02/2020
 *
 */
public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] numbers = new Integer[3000];
		String s = "", cadLista = "";
		int n;
		File file = new File();
		sortingAlgorithms sort = new sortingAlgorithms();
		//file.messyNumbers();

		cadLista = file.readFile();
		String[] arreglo = cadLista.split(" ");
		for(int i = 0; i< arreglo.length;i++) {
			int r = Integer.parseInt(arreglo[i]);
			numbers[i] = r;
		}
		sort.insertionSort(numbers);
		sort.quickSort(numbers,0,numbers.length-1);
		sort.mergeSort(numbers,0,numbers.length-1);
		sort.radixSort(numbers);
		sort.selectionSort(numbers);
	}

}
