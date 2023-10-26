// tomado de https://www.geeksforgeeks.org/shellsort/


import java.util.Random;
import java.util.stream.IntStream;

public class ShellSort {

    private static int sort(int[] array) {

        int n = array.length;

        for (int gap = n/2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i += 1) {

                int temp = array[i];
                int j;

                for(j = i; j >= gap && array[j - gap] > temp; j -= gap) { array[j] = array[j - gap]; }

                array[j] = temp;

            }
        }

        return 0;

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
            sort(arrayLil);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted small in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayMid);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted medium in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayBig);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted big in: " + opTime + "ms");

        }
    }
}

/*

works

 */