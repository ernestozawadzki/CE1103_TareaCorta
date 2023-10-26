// tomado de https://www.geeksforgeeks.org/quick-sort/


import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {

    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    private static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {

            if(array[j] < pivot) {

                i++;
                swap(array, i, j);

            }
        }

        swap(array, i + 1, high);
        return (i + 1);

    }

    private static void sort(int[] array, int low, int high) {

        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;

        while(top >= 0) {

            high = stack[top--];
            low = stack[top--];
            int pivotIndex = partition(array, low, high);

            if(pivotIndex - 1 > low) {

                stack[++top] = low;
                stack[++top] = pivotIndex - 1;

            }

            if(pivotIndex + 1 < high) {

                stack[++top] = pivotIndex + 1;
                stack[++top] = high;

            }

        }

    }

    public static void main(String[] args) {

        double startTime;
        double endTime;
        double opTime;

        for(int i = 1; i <= 15; i++) {

            int[] arrayLil = IntStream.generate(() -> new Random().nextInt(10)).limit(10000).toArray();
            int[] arrayMid = IntStream.generate(() -> new Random().nextInt(10)).limit(100000).toArray();
            int[] arrayBig = IntStream.generate(() -> new Random().nextInt(10)).limit(10000000).toArray();

            startTime = System.nanoTime();
            sort(arrayLil, 0 , arrayLil.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted small in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayMid, 0 , arrayMid.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted medium in: " + opTime + "ms");

            startTime = System.nanoTime();
            sort(arrayBig, 0 , arrayBig.length - 1);
            endTime = System.nanoTime();
            opTime = ((endTime - startTime) / 1000) / 1000;
            System.out.println("Sorted big in: " + opTime + "ms");

        }
    }
}

/*

works

 */