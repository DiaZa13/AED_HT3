/**
 * 
 * @author Adaptado por Diana Zaray Corado #191025
 * @author Lewis/Loftus (selectionSort e insertionSort)
 * @autor
 *
 */
public class sortingAlgorithms {

	public static Comparable[] selectionSort(Comparable[] numbers) {
		 int min;
	      Comparable temp;

	      for (int index = 0; index < numbers.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < numbers.length; scan++)
	            if (numbers[scan].compareTo(numbers[min]) < 0)
	               min = scan;

	         // Swap the values
	         temp = numbers[min];
	         numbers[min] = numbers[index];
	         numbers[index] = temp;
	      }
	      return numbers;
	}
	
	public static void insertionSort(Comparable[] numbers) {
		
		 for (int index = 1; index < numbers.length; index++)
	      {
	         Comparable key = numbers[index];
	         int position = index;

	         //  Shift larger values to the right
	         while (position > 0 && key.compareTo(numbers[position-1]) < 0)
	         {
	            numbers[position] = numbers[position-1];
	            position--;
	         }
	            
	         numbers[position] = key;
	      }
	}
	
	/**
	* merge sort
	*
	* @param array is an array of Comparable objects

	   public static void mergeSort(Comparable[] array) {
	   //overloading: two methods with same name, but different parameter type and/or count
	   //calls mergeSort method with 3 parameters
	      mergeSort(array, 0, array.length-1);
	   }
	*/

	/**
	* merge sort
	*
	* @param numbers is an array of Comparable objects
	* @param start is the first element in the array  	
	* @param end is the last element in the array 
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
	* merge: merges the two arrays back together
	*
	* @param numbers is an array of Comparable objects
	* @param start is the first element in the array  	
	* @param half is the middle element in the array  		
	* @param end is the last element in the array 
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
	         } 
	         else {
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
	         i=i+1;
	      }
	  }




	
}
