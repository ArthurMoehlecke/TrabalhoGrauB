package unisinos.br;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    	int[] tamanho = {128, 256, 512, 1024, 2048, 4096, 65536}; 
        testSortingAlgorithms(tamanho);
    }
    
    public static void testSortingAlgorithms(int[] tamanho) {
        for (int size : tamanho) {
            int[] crescente = generateSortedArray(size, true);
            int[] decrescente = generateSortedArray(size, false);
            int[] semValoresRepitidos = aleatorioArray(size, false);
            int[] comValoresRepitidos = aleatorioArray(size, true);
            
            testAlgorithm("Bubble Sort", crescente.clone());
            testAlgorithm("Bubble Sort", decrescente.clone());
            testAlgorithm("Bubble Sort", semValoresRepitidos.clone());
            testAlgorithm("Bubble Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Insertion Sort", crescente.clone());
            testAlgorithm("Insertion Sort", decrescente.clone());
            testAlgorithm("Insertion Sort", semValoresRepitidos.clone());
            testAlgorithm("Insertion Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Selection Sort", crescente.clone());
            testAlgorithm("Selection Sort", decrescente.clone());
            testAlgorithm("Selection Sort", semValoresRepitidos.clone());
            testAlgorithm("Selection Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Heap Sort", crescente.clone());
            testAlgorithm("Heap Sort", decrescente.clone());
            testAlgorithm("Heap Sort", semValoresRepitidos.clone());
            testAlgorithm("Heap Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Shell Sort", crescente.clone());
            testAlgorithm("Shell Sort", decrescente.clone());
            testAlgorithm("Shell Sort", semValoresRepitidos.clone());
            testAlgorithm("Shell Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Merge Sort", crescente.clone());
            testAlgorithm("Merge Sort", decrescente.clone());
            testAlgorithm("Merge Sort", semValoresRepitidos.clone());
            testAlgorithm("Merge Sort", comValoresRepitidos.clone());
            
            testAlgorithm("Quick Sort", crescente.clone());
            testAlgorithm("Quick Sort", decrescente.clone());
            testAlgorithm("Quick Sort", semValoresRepitidos.clone());
            testAlgorithm("Quick Sort", comValoresRepitidos.clone());
        }
    }
    
    public static void testAlgorithm(String algoritimo, int[] array) {
        long startTime = System.nanoTime();
        switch (algoritimo) {
            case "Bubble Sort":
                BubbleSort.bubbleSort(array);
                break;
            case "Insertion Sort":
                InsertionSort.insertionSort(array);
                break;
            case "Selection Sort":
                SelectionSort.selectionSort(array);
                break;
            case "Heap Sort":
                HeapSort.heapSort(array);
                break;
            case "Shell Sort":
                ShellSort.shellSort(array);
                break;
            case "Merge Sort":
                MergeSort.mergeSort(array);
                break;
            case "Quick Sort":
                QuickSort.quickSort(array, 0, 0);
                break;
        }
        
        long endTime = System.nanoTime();
        long nanossegundos = endTime - startTime;
        
        System.out.println(algoritimo + " - Tamanho do Array: " + array.length + " - Tempo de Execução (nanossegundos): " + nanossegundos);
    }
    
    public static int[] generateSortedArray(int tamanho, boolean ascendente) {
        int[] array = new int[tamanho];
        if (ascendente) {
            for (int i = 0; i < tamanho; i++) {
                array[i] = i;
            }
        } else {
            for (int i = 0; i < tamanho; i++) {
                array[i] = tamanho - i - 1;
            }
        }
        return array;
    }
    
    public static int[] aleatorioArray(int tamanho, boolean comDuplicidade) {
        int[] array = new int[tamanho];
        Random random = new Random();
        
        if (comDuplicidade) {
            for (int i = 0; i < tamanho; i++) {
                array[i] = random.nextInt(tamanho);
            }
        } else {
            for (int i = 0; i < tamanho; i++) {
                array[i] = i;
            }
            matriz(array);
        }
        
        return array;
    }
    
    public static void matriz(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}