// tomado de https://www.geeksforgeeks.org/merge-sort/


import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort {

    private static void merge(int[] array, int left, int m, int right) {
        
        int n1 = m - left + 1;
        int n2 = right - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; ++i) { L[i] = array[left + i]; }
        
        for(int j = 0; j < n2; ++j) { R[j] = array[m + 1 + j]; }

        int i = 0, j = 0;
        int k = left;
        
        while(i < n1 && j < n2) {
            
            if(L[i] <= R[j]) {
                
                array[k] = L[i];
                i++;
                
            }
            
            else {
                
                array[k] = R[j];
                j++;
                
            }
            
            k++;
            
        }

        while(i < n1) {
            
            array[k] = L[i];
            i++;
            k++;
            
        }

        while(j < n2) {
            
            array[k] = R[j];
            j++;
            k++;
            
        }
    }

    private static void sort(int[] array, int left, int right) {
        
        if (left < right) {

            int m = left + (right - left) / 2;
            sort(array, left, m);
            sort(array, m + 1, right);
            merge(array, left, m, right);
            
        }
    }

    public static void main(String[] args) {

        double startTime;
        double endTime;
        double opTime;

        for(int i = 1; i <= 15; i++) {

            int[] arrayLil = IntStream.generate(() -> new Random().nextInt(10)).limit(10000).toArray();
            int[] arrayMid = IntStream.generate(() -> new Random().nextInt(10)).limit(100000).toArray();
            int[] arrayBig = IntStream.generate(() -> new Random().nextInt(10)).limit(1000000).toArray();

            startTime = System.nanoTime();
            sort(arrayLil, 0, arrayLil.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted small in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayMid, 0, arrayMid.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted medium in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayBig, 0, arrayBig.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted big in: " + opTime + "ms");

        }
    }
}

/*

works

 */