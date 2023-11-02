// tomado de https://www.geeksforgeeks.org/bubble-sort/


import java.util.Random;
import java.util.stream.IntStream;

public class BubbleSort {

    private static void sort(int[] array, int n) {

        int i;
        int j;
        int temp;
        boolean swapped;

        for(i = 0; i < n - 1; i++) {

            swapped = false;

            for(j = 0; j < n - i - 1; j++) {

                if(array[j] > array[j + 1]) {

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                }
            }

            if(!swapped) { break; }

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

Sorted small in: 91.6166ms
Sorted medium in: 14781.3239ms
Sorted big in: 1189846.5838ms

Sorted small in: 82.527ms
Sorted medium in: 14795.1732ms
Sorted big in: 1478997.955ms

Sorted small in: 81.7335ms
Sorted medium in: 14749.8565ms
Sorted big in: 1480537.1659ms

Sorted small in: 59.2066ms
Sorted medium in: 11832.8153ms
Sorted big in: 1195022.374ms

Sorted small in: 62.9821ms
Sorted medium in: 11856.0931ms
Sorted big in: 1193939.0425ms

Sorted small in: 60.6056ms
Sorted medium in: 11876.0924ms
Sorted big in: 1194759.97ms

Sorted small in: 65.1767ms
Sorted medium in: 11852.3269ms
Sorted big in: 1194245.3493ms

Sorted small in: 62.3362ms
Sorted medium in: 11907.2668ms
Sorted big in: 1192256.4554ms

Sorted small in: 63.6422ms
Sorted medium in: 11840.7294ms
Sorted big in: 1194563.1514ms

Sorted small in: 61.7326ms
Sorted medium in: 11845.7472ms
Sorted big in: 1192976.4675ms

Sorted small in: 63.4981ms
Sorted medium in: 11920.7608ms
Sorted big in: 1194725.8387ms

Sorted small in: 61.7425ms
Sorted medium in: 11904.5494ms
Sorted big in: 1192265.4632ms

Sorted small in: 64.222ms
Sorted medium in: 11929.3445ms
Sorted big in: 1194691.1763ms

Sorted small in: 62.8145ms
Sorted medium in: 11850.7906ms
Sorted big in: 1192342.224ms

Sorted small in: 63.4514ms
Sorted medium in: 11822.8676ms
Sorted big in: 1192658.6757ms

 */