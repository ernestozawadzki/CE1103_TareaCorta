// tomado de https://www.geeksforgeeks.org/selection-sort/


import java.util.Random;
import java.util.stream.IntStream;

public class SelectionSort {

    private static void sort(int[] array) {

        int n = array.length;

        for(int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for(int j = i + 1; j < n; j++) {

                if (array[j] < array[minIndex]) { minIndex = j; }

            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }
    }
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
            sort(arrayLil);
            printArr(arrayLil);
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