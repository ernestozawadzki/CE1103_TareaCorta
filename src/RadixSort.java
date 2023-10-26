// tomado de https://www.geeksforgeeks.org/radix-sort/


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RadixSort {

    private static int getMax(int[] array, int n) {

        int max = array[0];

        for(int i = 1; i < n; i++) {

            if(array[i] > max) { max = array[i]; }

        }

        return max;

    }

    private static void countSort(int[] array, int n, int exp) {

        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(i = 0; i < n; i++) { count[(array[i] / exp) % 10]++; }

        for(i = 1; i < 10; i++) { count[i] += count[i - 1]; }

        for(i = n - 1; i >= 0; i--) {

            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;

        }

        for(i = 0; i < n; i++) { array[i] = output[i]; }

    }

    private static void sort(int[] array, int n) {

        int max = getMax(array, n);

        for(int exp = 1; max / exp > 0; exp *= 10) { countSort(array, n, exp); }

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
            sort(arrayLil, arrayLil.length);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted small in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayMid, arrayMid.length);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted medium in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayBig, arrayBig.length);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted big in: " + opTime + "ms");

        }
    }
}

/*

works

 */