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
import static java.util.stream.Collectors.toList;

@SuppressWarnings("all")
public class Streams {

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
    public void exercise_2_mapping() {
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
        // find the length of the longest strings

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

}
