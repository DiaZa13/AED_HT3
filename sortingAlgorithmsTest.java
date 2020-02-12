import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sortingAlgorithmsTest {
    sortingAlgorithms sort = new sortingAlgorithms();

    @Test
    void selectionSort() {
        Integer[] numbers = {10,5,9,3,7};
        Integer[] ordernumbers = {3,5,7,9,10};
        sort.selectionSort(numbers);
        for(int i = 0; i<numbers.length;i++)
             assertEquals(ordernumbers[i],numbers[i]);
    }

    @Test
    void insertionSort() {
        Integer[] numbers = {10,5,9,3,7};
        Integer[] ordernumbers = {3,5,7,9,10};
        sort.insertionSort(numbers);
        for(int i = 0; i<numbers.length;i++)
            assertEquals(ordernumbers[i],numbers[i]);
    }

    @Test
    void mergeSort() {
        Integer[] numbers = {10,5,9,3,7};
        Integer[] ordernumbers = {3,5,7,9,10};
        sort.mergeSort(numbers,0,numbers.length-1);
        for(int i = 0; i<numbers.length;i++)
            assertEquals(ordernumbers[i],numbers[i]);
    }

    @Test
    void quickSort() {
        Integer[] numbers = {10,5,9,3,7};
        Integer[] ordernumbers = {3,5,7,9,10};
        sort.mergeSort(numbers,0,numbers.length-1);
        for(int i = 0; i<numbers.length;i++)
            assertEquals(ordernumbers[i],numbers[i]);
    }
}