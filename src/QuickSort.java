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

Sorted small in: 10.4491ms
Sorted medium in: 167.5825ms
Sorted big in: 1411830.9342ms

Sorted small in: 2.0336ms
Sorted medium in: 178.3201ms
Sorted big in: 1282767.4686ms

Sorted small in: 2.0331ms
Sorted medium in: 173.5721ms
Sorted big in: 1233061.004ms

Sorted small in: 2.0765ms
Sorted medium in: 178.5343ms
Sorted big in: 1242325.5865ms

Sorted small in: 2.0285ms
Sorted medium in: 165.9432ms
Sorted big in: 1239381.8039ms

Sorted small in: 2.0195ms
Sorted medium in: 157.2091ms
Sorted big in: 1231533.2896ms

Sorted small in: 2.0564ms
Sorted medium in: 186.8981ms
Sorted big in: 1238670.618ms

Sorted small in: 2.0336ms
Sorted medium in: 171.8315ms
Sorted big in: 1224892.2166ms

Sorted small in: 2.0361ms
Sorted medium in: 183.1212ms
Sorted big in: 1230425.1392ms

Sorted small in: 2.2863ms
Sorted medium in: 178.0636ms
Sorted big in: 1230465.5067ms

Sorted small in: 2.0655ms
Sorted medium in: 184.2561ms
Sorted big in: 1250710.3291ms

Sorted small in: 2.0313ms
Sorted medium in: 177.3783ms
Sorted big in: 1232449.6156ms

Sorted small in: 2.0601ms
Sorted medium in: 171.0459ms
Sorted big in: 1231576.6771ms

Sorted small in: 2.0378ms
Sorted medium in: 175.7474ms
Sorted big in: 1226769.7826ms

Sorted small in: 2.0383ms
Sorted medium in: 174.5976ms
Sorted big in: 1217669.5231ms

 */