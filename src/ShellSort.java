// GeeksforGeeks. (2023, enero 10). ShellSort. https://www.geeksforgeeks.org/shellsort/


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

Sorted small in: 2.1475ms
Sorted medium in: 6.9727ms
Sorted big in: 47.7791ms

Sorted small in: 0.3769ms
Sorted medium in: 4.1316ms
Sorted big in: 47.4631ms

Sorted small in: 0.3734ms
Sorted medium in: 4.1098ms
Sorted big in: 48.1409ms

Sorted small in: 0.3708ms
Sorted medium in: 4.1238ms
Sorted big in: 47.3534ms

Sorted small in: 0.3646ms
Sorted medium in: 4.6221ms
Sorted big in: 48.6618ms

Sorted small in: 0.3666ms
Sorted medium in: 4.1055ms
Sorted big in: 47.3638ms

Sorted small in: 0.3735ms
Sorted medium in: 4.1231ms
Sorted big in: 47.6288ms

Sorted small in: 0.3688ms
Sorted medium in: 4.1385ms
Sorted big in: 47.6109ms

Sorted small in: 0.4234ms
Sorted medium in: 4.1927ms
Sorted big in: 47.7947ms

Sorted small in: 0.3699ms
Sorted medium in: 4.1793ms
Sorted big in: 47.8482ms

Sorted small in: 0.3725ms
Sorted medium in: 4.128ms
Sorted big in: 47.616ms

Sorted small in: 0.375ms
Sorted medium in: 4.1296ms
Sorted big in: 47.4472ms

Sorted small in: 0.3721ms
Sorted medium in: 4.1087ms
Sorted big in: 47.5564ms

Sorted small in: 0.37560ms
Sorted medium in: 4.1413ms
Sorted big in: 47.6862ms

Sorted small in: 0.3732ms
Sorted medium in: 4.1841ms
Sorted big in: 47.8894ms

 */
