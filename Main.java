import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "numbers.txt";
        ArrayList<Integer> sizes = new ArrayList<>();
// Tamaños pequeños para Bogo Sort
        sizes.add(10);
        sizes.add(100);
        sizes.add(500);
        sizes.add(1000);
        sizes.add(2000);
        sizes.add(3000);

        List<String[]> results = new ArrayList<>();
        results.add(new String[]{"Size", "Insertion Sort", "Merge Sort", "Quick Sort", "Radix Sort", "Bucket Sort", "Heap Sort", "Bogo Sort"});

        for (int i : sizes) {
            generateRandomNumbers(filename, i);
            Integer[] numbers = readNumbersFromFile(filename, i);

            // Algoritmos de ordenamiento
            SortingProfiler.SortingAlgorithm<Integer> insertionSort = SortingAlgorithms::insertionSort;
            SortingProfiler.SortingAlgorithm<Integer> mergeSort = SortingAlgorithms::mergeSort;
            SortingProfiler.SortingAlgorithm<Integer> quickSort = SortingAlgorithms::quickSort;
            SortingProfiler.SortingAlgorithm<Integer> radixSort = SortingAlgorithms::radixSort;
            SortingProfiler.SortingAlgorithm<Integer> bucketSort = SortingAlgorithms::bucketSort;
            SortingProfiler.SortingAlgorithm<Integer> heapSort = SortingAlgorithms::heapSort;
            //SortingProfiler.SortingAlgorithm<Integer> bogoSort = SortingAlgorithms::bogoSort;

            // Medir tiempos de ejecución
            long insertionTime = SortingProfiler.measureSortTime(insertionSort, Arrays.copyOf(numbers, numbers.length));
            long mergeTime = SortingProfiler.measureSortTime(mergeSort, Arrays.copyOf(numbers, numbers.length));
            long quickTime = SortingProfiler.measureSortTime(quickSort, Arrays.copyOf(numbers, numbers.length));
            long radixTime = SortingProfiler.measureSortTime(radixSort, Arrays.copyOf(numbers, numbers.length));
            long bucketTime = SortingProfiler.measureSortTime(bucketSort, Arrays.copyOf(numbers, numbers.length));
            long heapTime = SortingProfiler.measureSortTime(heapSort, Arrays.copyOf(numbers, numbers.length));
            //long bogoTime = SortingProfiler.measureSortTime(bogoSort, Arrays.copyOf(numbers, numbers.length));  // Medir Bogo Sort

            // Guardar resultados
            results.add(new String[]{
                    String.valueOf(i),
                    String.valueOf(insertionTime),
                    String.valueOf(mergeTime),
                    String.valueOf(quickTime),
                    String.valueOf(radixTime),
                    String.valueOf(bucketTime),
                    String.valueOf(heapTime),
                   // String.valueOf(bogoTime)
            });

            // Mostrar resultados en consola
            System.out.println("Tamaño de la lista: " + i);
            System.out.println("Insertion Sort Time: " + insertionTime + " ns");
            System.out.println("Merge Sort Time: " + mergeTime + " ns");
            System.out.println("Quick Sort Time: " + quickTime + " ns");
            System.out.println("Radix Sort Time: " + radixTime + " ns");
            System.out.println("Bucket Sort Time: " + bucketTime + " ns");
            System.out.println("Heap Sort Time: " + heapTime + " ns");
            //System.out.println("Bogo Sort Time: " + bogoTime + " ns");
        }

        // Guardar resultados en un archivo CSV
        saveResultsToCSV("sorting_times.csv", results);
    }

    // Generar números aleatorios y guardar en archivo
    public static void generateRandomNumbers(String filename, int count) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                writer.write(random.nextInt(10000) + "\n");
            }
        }
    }

    // Leer números del archivo
    public static Integer[] readNumbersFromFile(String filename, int count) throws IOException {
        Integer[] numbers = new Integer[count];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }
        }
        return numbers;
    }

    // Guardar resultados en un archivo CSV
    public static void saveResultsToCSV(String filename, List<String[]> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }
    }
}
