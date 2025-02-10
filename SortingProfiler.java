public class SortingProfiler {

    // Método para medir el tiempo de ejecución de un algoritmo
    public static <T extends Comparable<T>> long measureSortTime(SortingAlgorithm<T> algorithm, T[] array) {
        long startTime = System.nanoTime();
        algorithm.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Interfaz para los algoritmos de ordenamiento
    interface SortingAlgorithm<T extends Comparable<T>> {
        void sort(T[] array);
    }
}
