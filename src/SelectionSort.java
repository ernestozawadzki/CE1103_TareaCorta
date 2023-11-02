// GeeksforGeeks. (2023, mayo 26). Selection Sort Data Structure and Algorithm Tutorials. https://www.geeksforgeeks.org/selection-sort/


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

Sorted small in: 39.2546ms
Sorted medium in: 3632.3527ms
Sorted big in: 220764.4013ms

Sorted small in: 36.6318ms
Sorted medium in: 3617.1504ms
Sorted big in: 360975.1422ms

Sorted small in: 36.3083ms
Sorted medium in: 3651.4321ms
Sorted big in: 360882.2271ms

Sorted small in: 22.2785ms
Sorted medium in: 2212.3661ms
Sorted big in: 220724.0812ms

Sorted small in: 22.2696ms
Sorted medium in: 2202.9012ms
Sorted big in: 220681.1259ms

Sorted small in: 22.2619ms
Sorted medium in: 2210.83ms
Sorted big in: 220862.7826ms

Sorted small in: 22.2915ms
Sorted medium in: 2208.1919ms
Sorted big in: 220719.8014ms

Sorted small in: 22.3477ms
Sorted medium in: 2206.006ms
Sorted big in: 220685.3285ms

Sorted small in: 22.256ms
Sorted medium in: 2202.3322ms
Sorted big in: 220732.9619ms

Sorted small in: 22.2832ms
Sorted medium in: 2205.4149ms
Sorted big in: 220700.2013ms

Sorted small in: 22.272ms
Sorted medium in: 2203.1356ms
Sorted big in: 220703.6150ms

Sorted small in: 22.243ms
Sorted medium in: 2204.1623ms
Sorted big in: 220684.5312ms

Sorted small in: 22.4161ms
Sorted medium in: 2214.3481ms
Sorted big in: 220805.2173ms

Sorted small in: 22.2566ms
Sorted medium in: 2203.65ms
Sorted big in: 220732.1099ms

Sorted small in: 22.2803ms
Sorted medium in: 2202.5548ms
Sorted big in: 220684.3965ms

 */
