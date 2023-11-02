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

Sorted small in: 1.7012ms
Sorted medium in: 11.148ms
Sorted big in: 102.8374ms

Sorted small in: 1.0023ms
Sorted medium in: 10.934ms
Sorted big in: 89.8195ms

Sorted small in: 0.6826ms
Sorted medium in: 7.2347ms
Sorted big in: 80.0732ms

Sorted small in: 0.677ms
Sorted medium in: 7.2189ms
Sorted big in: 80.8904ms

Sorted small in: 0.7088ms
Sorted medium in: 7.2737ms
Sorted big in: 79.8783ms

Sorted small in: 0.6798ms
Sorted medium in: 7.161ms
Sorted big in: 79.7433ms

Sorted small in: 0.6777ms
Sorted medium in: 7.1298ms
Sorted big in: 79.5237ms

Sorted small in: 0.6731ms
Sorted medium in: 7.2057ms
Sorted big in: 80.2331ms

Sorted small in: 0.6791ms
Sorted medium in: 7.1572ms
Sorted big in: 81.159ms

Sorted small in: 0.6924ms
Sorted medium in: 7.2348ms
Sorted big in: 80.5306ms

Sorted small in: 0.6761ms
Sorted medium in: 7.1565ms
Sorted big in: 79.1029ms

Sorted small in: 0.6917ms
Sorted medium in: 7.1022ms
Sorted big in: 80.1214ms

Sorted small in: 0.6724ms
Sorted medium in: 7.1049ms
Sorted big in: 79.3167ms

Sorted small in: 0.6609ms
Sorted medium in: 7.094ms
Sorted big in: 79.9503ms

Sorted small in: 0.6627ms
Sorted medium in: 7.0157ms
Sorted big in: 79.2958ms

 */