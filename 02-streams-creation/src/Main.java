import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 1. Creating a stream from a collection.
        List<String> names = Arrays.asList("Alice", "Bob", "Hj", "wasim");
        Stream<String> nameStream = names.stream(); // List Stream

        Map<String, Integer> count = new HashMap<>();
        count.put("Alice", 0);
        count.put("Bob", 0);
        count.put("Hj", 0);
        count.put("wasim", 0);
        Stream<Map.Entry<String, Integer>> s = count.entrySet().stream(); // Map Stream

        // 2. Creating a stream from arrays.
        String[] places = new String[]{"chennai", "mannargudi", "thiruvarur", "trichy"};
        Stream<String> placeStream = Arrays.stream(places); // Stream from an Array

        // 3. Primitive Streams for int, double, long;
        // Java only provides support for Int, Double and Long for Primitive streams.
        int[] numbers = new int[]{1, 2, 3, 4};
        IntStream numberStream = Arrays.stream(numbers);

        double[] doubles = new double[]{1.0, 2.0, 3.0, 4.0};
        DoubleStream doubleStream = Arrays.stream(doubles);

        long[] longs = new long[]{1, 2, 3, 4};
        LongStream longStream = Arrays.stream(longs);

        /* why IntStream instead of Stream<Integer> ?
            - because IntStream is designed to process primitive int values to avoid
         unnecessary boxing computes
            - Also It supports numeric operations
         */

        double avg = numberStream.average().orElse(0.0);
        // numberStream.max()
        // numberStream.min() etc;

        // 4. Stream.of() and Stream.empty()

        // Stream.of() creates a stream directly from a supplied values
        Stream<String> directStream = Stream.of("Spring", "Boot", "Java");

        // Stream.empty() creates a empty streams containing no elements.
        Stream<String> emptyStream = Stream.empty();

        // when the value is null, empty stream should be created.
        String value = null;
        Stream<String> safeStream = value != null ? Stream.of(value) : Stream.empty();
        // From Java 9+
        Stream<String> safeStreamModern = Stream.ofNullable(value);
        // OfNullable creates a single valued stream when the value is not NULL, otherwise an empty stream.

        // 5. Stream.generate() - Infinite Streams
        // generated takes supplier fn - repeatedly calls the supplied function to generate values.
        Stream<Double> infStream = Stream.generate(Math::random);
        // we can restrict the limit also
        infStream.limit(5);

        // 6. Stream.iterate() - For generating sequence
        // Unlike generate() which produces values independently,
        // iterate() generates a new value using the previous generated value.
        Stream<Integer> integerStream = Stream.iterate(1, i -> i + 1); // inifinite but needs limit()
        Stream<Integer> integerStream2 = Stream.iterate(1, n -> n < 100, i -> i * 2); // stop until the conditions fails
        integerStream2.forEach(System.out::println);


    }
}