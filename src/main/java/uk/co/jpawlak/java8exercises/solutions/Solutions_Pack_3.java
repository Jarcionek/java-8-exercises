package uk.co.jpawlak.java8exercises.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@SuppressWarnings("all")
public class Solutions_Pack_3 {

    public static Set<Integer> exercise_1(List<Integer> numbers) {
        return numbers.stream().map(n -> n / 2).collect(toSet());
    }

    public static List<Integer> exercise_2(List<String> strings) {
        return strings.stream()
                .map(Integer::valueOf)
                .map(n -> n % 13)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static int exercise_3(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .reduce(Math::max)
                .orElse(-1);
    }

    public static List<Integer> exercise_4(IntStream numbers) {
        return numbers
                .filter(n -> n % 17 == 0)
                .limit(5)
                .mapToObj(n -> n)
                .collect(toList());
    }

    public static Set<Integer> exercise_5(Integer[] numbers) {
        Set<Integer> result;
        result = Arrays.stream(numbers).collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
        return result;
    }

    public static Integer[] exercise_6(Stream<Integer> stream) {
        return stream.toArray(Integer[]::new);
    }

}
