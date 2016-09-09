package uk.co.jpawlak.java8exercises.exercises;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

//@SuppressWarnings("all")
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

    @Test
    public void exercise_1_mapAndCollect() {
        // divide each number by 2 (ignoring the reminder) and collect to set

        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Set<Integer> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(ImmutableSet.of(0, 1, 2)));
    }

    @Test
    public void example_4_distinctAndSorted() {
        List<Integer> numbers = asList(9, 8, 0, 5, 6, 2, 3, 4, 9, 0, 6, 2, 3, 5, 0, 9, 6, 3, 4, 9, 3);

        List<Integer> processed = numbers.stream()
                .distinct()
                .sorted()
                .collect(toList());

        System.out.println(processed);
    }

    @Test
    public void exercise_2_mapping() {
        // using map() and distinct(), remove odd numbers from the list and remove duplicates of even numbers
        // you are not allowed to use any kind of if statement

        List<Integer> numbers = asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(asList(0, 2, 4, 6, 8)));
    }

}
