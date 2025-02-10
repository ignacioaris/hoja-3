import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingAlgorithmsTest {

    @Test
    public void testInsertionSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.quickSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testRadixSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testBucketSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testHeapSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.heapSort(array);
        assertArrayEquals(expected, array);
    }


    @Test
    public void testEmptyArray() {
        Integer[] array = {};
        Integer[] expected = {};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElementArray() {
        Integer[] array = {42};
        Integer[] expected = {42};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testReverseSortedArray() {
        Integer[] array = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }
}
