import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingAlgorithmTest {
    private Sort<Integer> sort;

    SortTest() {
    }

    @BeforeEach
    void setUp() {
        IComparator<Integer> comparator = Integer::compare;
        this.sort = new Sort(comparator);
    }

    @Test
    void testInsertionSort() {
        Integer[] array = new Integer[]{5, 3, 8, 4, 2};
        Integer[] expected = new Integer[]{2, 3, 4, 5, 8};
        this.sort.insertionSort(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSort() {
        Integer[] array = new Integer[]{9, 7, 5, 3, 1};
        Integer[] expected = new Integer[]{1, 3, 5, 7, 9};
        this.sort.mergeSort(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testQuickSort() {
        Integer[] array = new Integer[]{10, 15, 5, 3, 7};
        Integer[] expected = new Integer[]{3, 5, 7, 10, 15};
        this.sort.quickSort(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testRadixSort() {
        int[] array = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = new int[]{2, 24, 45, 66, 75, 90, 170, 802};
        this.sort.radixSort(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testBucketSort() {
        float[] array = new float[]{0.42F, 0.32F, 0.23F, 0.52F, 0.25F, 0.47F, 0.51F};
        float[] expected = new float[]{0.23F, 0.25F, 0.32F, 0.42F, 0.47F, 0.51F, 0.52F};
        this.sort.bucketSort(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    void testShellSort() {
        Integer[] array = new Integer[]{19, 8, 7, 3, 5};
        Integer[] expected = new Integer[]{3, 5, 7, 8, 19};
        this.sort.shellSort(array);
        Assertions.assertArrayEquals(expected, array);
    }
}
