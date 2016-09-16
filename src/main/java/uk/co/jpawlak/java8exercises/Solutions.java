package uk.co.jpawlak.java8exercises;

import uk.co.jpawlak.java8exercises.utils.Formatter;
import uk.co.jpawlak.java8exercises.utils.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Solutions {

    public static void lambdas_exercise_1(List<Node> list) {
        Collections.sort(list, (a, b) -> a.name().compareTo(b.name()));
    }

    public static String lambdas_exercise_2(Formatter formatter) {
        return formatter.format((Integer amount) -> amount, 30000);
    }

    public static Set<Integer> streams_exercise_1(List<Integer> numbers) {
        return numbers.stream().map(n -> n / 2).collect(toSet());
    }

    public static List<Integer> streams_exercise_2(List<String> strings) {
        return strings.stream()
                .map(Integer::valueOf)
                .map(n -> n % 13)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static int streams_exercise_3(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .reduce(Math::max)
                .orElse(-1);
    }

    public static List<Integer> streams_exercise_4(IntStream numbers) {
        return numbers
                .filter(n -> n % 17 == 0)
                .limit(5)
                .mapToObj(n -> n)
                .collect(toList());
    }

    public static Set<Integer> streams_exercise_5(Integer[] numbers) {
        Set<Integer> result;
        result = Arrays.stream(numbers).collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
        return result;
    }

}
