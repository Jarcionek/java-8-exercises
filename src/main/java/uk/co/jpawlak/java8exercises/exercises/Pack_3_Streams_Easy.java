package uk.co.jpawlak.java8exercises.exercises;

import com.google.common.collect.ImmutableSet;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.instanceOf;
import static uk.co.jpawlak.java8exercises.utils.Utils.nestedClass;

@SuppressWarnings("all")
public class Pack_3_Streams_Easy {

    @Test
    public void example_1_forEach() {
        List<String> names = asList("John", "Jack", "Jacob");

        names.stream().forEach(name -> System.out.println("Hello " + name + "!"));
    }

    @Test
    public void example_2_map() {
        List<String> names = asList("John", "Jack", "Jacob");

        names.stream()
                .map(name -> "Hello " + name + "!")
                .forEach(System.out::println);
    }

    @Test
    public void example_3_collect() {
        List<String> names = asList("John", "Jack", "Jacob");

        List<String> captains = names.stream()
                .map(name -> "Captain " + name)
                .collect(toList());

        System.out.println(captains);
    }

    @Ignore
    @Test
    public void exercise_1_map_collect() {
        // divide each number by 2 (ignoring the reminder) and collect to set

        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Set<Integer> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(ImmutableSet.of(0, 1, 2)));
    }

    @Test
    public void example_4_distinct_sorted() {
        List<Integer> numbers = asList(9, 8, 0, 5, 6, 2, 3, 4, 9, 0, 6, 2, 3, 5, 0, 9, 6, 3, 4, 9, 3);

        List<Integer> processed = numbers.stream()
                .distinct()
                .sorted()
                .collect(toList());

        System.out.println(processed);
    }

    @Ignore
    @Test
    public void exercise_2_map() {
        // find all distinct reminders of division by 13 and collect them sorted

        List<String> strings = asList("9", "4", "5", "6", "2", "3", "9", "4", "3", "4", "5");
        List<Integer> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(asList(2, 3, 4, 5, 6, 9)));
    }

    @Test
    public void example_5_reduce() {
        Stream.of(1, 2, 3, 4).reduce((a, b) -> a + b).ifPresent(System.out::println);

        Stream<Integer> emptyStream = Stream.empty();
        Optional<Integer> optionalResult = emptyStream.reduce((a, b) -> a + b);
        System.out.println(optionalResult);
    }

    @Ignore
    @Test
    public void exercise_3_reduce() {
        // find the length of the longest string

        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.");
        int result = 0;

        //TODO write your code here

        assertThat(result, sameBeanAs(11));
    }

    @Test
    public void example_6_intStream() {
        // int stream contains extra useful methods such as sum, min or max
        int sum = IntStream.of(1, 2, 3, 4).sum();
        System.out.println(sum);

        List<Integer> list = asList(-1, -2, -3, -4);

//        sum = list.stream().sum(); // doesn't compile, not an int stream
        sum = list.stream().mapToInt(x -> x).sum();
        System.out.println(sum);
    }

    @Ignore
    @Test
    public void exercise_4_filter_limit() {
        // find first 5 numbers divisible by 17 generate by an infinite stream

        IntStream numbers = new Random(0).ints().map(Math::abs);
        List<Integer> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(asList(938301587, 100082026, 356750287, 798819494, 1412716779)));
    }

    @Ignore
    @Test
    public void exercise_5_collectingAndThen() {
        // collect to unmodifiable set using Collections.unmodifiableSet
        // you are not allowed to call unmodifiableSet directly, you can only refer to it using method reference
        // Arrays.stream will be useful as well

        Integer[] numbers = {4, 2, 3, 8, 5, 6, 3, 4, 5};
        Set<Integer> result = null;

        //TODO write your code here

        assertThat(result, both(instanceOf(nestedClass("UnmodifiableSet")))
                .and(sameBeanAs(ImmutableSet.of(2, 3, 4, 5, 6, 8))));
    }

    @Test
    public void example_7_flatMap_collectJoining() {
        Stream<Stream<Integer>> streamOfStream = Stream.of(
                Stream.of(1, 2, 3, 4),
                Stream.of(5, 6),
                Stream.of(7, 8, 9)
        );

        Stream<Integer> flattenedStream = streamOfStream.flatMap(stream -> stream);

        String concatenated = flattenedStream
                .map(String::valueOf)
                .collect(joining(", "));

        System.out.println(concatenated);
    }

    @Test
    public void example_8_peek() {
        // you can use peek function to for example see the element at any point in the stream

        Stream.of(1, 2, 3)
                .peek(n -> System.out.println("A: " + n))
                .map(n -> n + 5)
                .peek(n -> System.out.println("B: " + n))
                .sorted() // this intermediate stateful operation will cause all of above to execute
                .map(n -> n + 5)
                .peek(n -> System.out.println("C: " + n))
                .collect(toList());
    }

    @Ignore
    @Test
    public void exercise_6_toArray() {
        // collect a stream of boxed Integers to an array Integer[]
        // hint: toArray method creates Object[], unless you pass to it a function int -> array (provided int will be the size of the stream)

        Stream<Integer> stream = Stream.of(1, 2, 3);
        Integer[] result = null;

        //TODO write your code here

        assertThat(result, both(instanceOf(Integer[].class))
                .and(sameBeanAs(new Integer[] {1, 2, 3})));
    }

}
