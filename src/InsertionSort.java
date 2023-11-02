// GeeksforGeeks. (2023, mayo 31). Insertion Sort Data Structure and Algorithm Tutorials. https://www.geeksforgeeks.org/insertion-sort/


import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSort {

    private static void sort(int[] array) {

        int n = array.length;

        for(int i = 1; i < n; ++i) {

            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {

                array[j + 1] = array[j];
                j = j - 1;

            }

            array[j + 1] = key;

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

Sorted small in: 11.5149ms
Sorted medium in: 719.0453ms
Sorted big in: 60021.8269ms

Sorted small in: 5.8876ms
Sorted medium in: 599.5687ms
Sorted big in: 59770.826ms

Sorted small in: 5.8465ms
Sorted medium in: 638.391ms
Sorted big in: 59904.7832ms

Sorted small in: 5.8529ms
Sorted medium in: 597.9607ms
Sorted big in: 59909.1482ms

Sorted small in: 5.9233ms
Sorted medium in: 597.3488ms
Sorted big in: 59940.7844ms

Sorted small in: 5.8536ms
Sorted medium in: 597.5095ms
Sorted big in: 60026.906ms

Sorted small in: 5.8055ms
Sorted medium in: 606.7705ms
Sorted big in: 60011.3667ms

Sorted small in: 5.827ms
Sorted medium in: 598.8021ms
Sorted big in: 59844.8482ms

Sorted small in: 5.8743ms
Sorted medium in: 592.8727ms
Sorted big in: 59901.4339ms

Sorted small in: 5.8442ms
Sorted medium in: 596.4824ms
Sorted big in: 59877.8674ms

Sorted small in: 5.8348ms
Sorted medium in: 597.9287ms
Sorted big in: 59938.2969ms

Sorted small in: 5.8829ms
Sorted medium in: 593.6821ms
Sorted big in: 59860.6106ms

Sorted small in: 5.8447ms
Sorted medium in: 595.4377ms
Sorted big in: 59881.0139ms

Sorted small in: 5.8408ms
Sorted medium in: 595.7701ms
Sorted big in: 59896.8339ms

Sorted small in: 6.9995ms
Sorted medium in: 622.503ms
Sorted big in: 59867.7206ms

 */
