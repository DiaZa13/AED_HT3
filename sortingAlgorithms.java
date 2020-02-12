/**
 * 
 * @author 
 *
 */
public class sortingAlgorithms {

	public static void selectionSort(Comparable[] numbers) {
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
	*/
	   public static void mergeSort(Comparable[] array) {
	   //overloading: two methods with same name, but different parameter type and/or count
	   //calls mergeSort method with 3 parameters
	      mergeSort(array, 0, array.length-1);
	   }

	/**
	* merge sort
	*
	* @param array is an array of Comparable objects 	
	* @param start is the first element in the array  	
	* @param end is the last element in the array 
	*/ 	
	   public static void mergeSort(Comparable[] array, int start, int end) {
	   // if start index is less than end index
	      if (start < end) {
	         int half = (start + end) / 2;
	      //show array split  
	         //if(Sorting.display){  
	            //System.out.println("SPLIT: start=" + start + ", half=" + half + ", end=" + end);  
	         //}
	      // sort left and right half of array
	         mergeSort(array, start, half);
	         mergeSort(array, half + 1, end);
	      // merge left and right half of array
	         merge(array, start, half, end);		
	      }
	   }

	/**
	* merge: merges the two arrays back together
	*
	* @param array is an array of Comparable objects 	
	* @param start is the first element in the array  	
	* @param half is the middle element in the array  		
	* @param end is the last element in the array 
	*/ 	
	   private static void merge(Comparable[] array, int start, int half, int end) {
	   //display 2 arrays before merge
	      /**if(Sorting.display){  
	         Sorting.print(array, start, half);
	         Sorting.print(array, half+1, end); 
	      }*/
	   // temporary array
	      Comparable[] temp = new Comparable[array.length];
	   // index for 2 subarrays
	      int start1 = start;
	      int end1 = half;
	      int start2 = half + 1;
	      int end2 = end;
	      int i = start1;
	    //loop and copy to temp array, so that elements are sorted
	      while ((start1 <= end1) && (start2 <= end2)) {
	         if (array[start1].compareTo(array[start2]) < 0) {
	            temp[i] = array[start1];
	            //increment i and start1
	            i = i + 1;
	            start1 = start1 + 1;
	         } 
	         else {
	            temp[i] = array[start2];
	            //increment i and start2
	            i = i + 1;
	            start2 = start2 + 1;
	         }
	      }
	   // loop through either the first or second subarray and copy to temp array
	      while (start1 <= end1) {
	         temp[i] = array[start1];
	      //increment i and start1
	         i = i + 1;
	         start1 = start1 + 1;
	      }
	      while (start2 <= end2) {
	         temp[i] = array[start2];
	      //increment i and start2
	         i = i + 1;
	         start2 = start2 + 1;
	      }
	   // copy back to actual array
	      i = start;
	      while (i <= end) {
	         array[i] = temp[i];
	         i=i+1;
	      }
	  }


	
}
