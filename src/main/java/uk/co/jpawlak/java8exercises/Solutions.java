package uk.co.jpawlak.java8exercises;

import uk.co.jpawlak.java8exercises.utils.Employee;
import uk.co.jpawlak.java8exercises.utils.Formatter;
import uk.co.jpawlak.java8exercises.utils.Node;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
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

    public static String toughStreams_exercise_1(List<Employee> employees) {
        return employees.stream()
                .filter(employee1 -> employees.stream()
                        .filter(employee2 -> employee1 != employee2
                                && employee1.getFirstName().equals(employee2.getFirstName())
                                && employee1.getSurname().equals(employee2.getSurname())
                        )
                        .findFirst()
                        .isPresent())
                .findFirst()
                .map(employee -> employee.getFirstName() + " " + employee.getSurname())
                .orElse(null);
    }

    public static long toughStreams_exercise_2(List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(
                        employee -> employee.getHomeAddress().getPostCode().substring(0, 2),
                        counting()
                ))
                .values()
                .stream()
                .filter(size -> size >= 5)
                .count();
    }

    public static long toughStreams_exercise_3(List<Employee> employees) {
        return employees.stream()
                .flatMap(employee -> Stream.of(employee.getHomeAddress(), employee.getCorrespondenceAddress().orElse(null)))
                .filter(address -> address != null)
                .distinct()
                .count();
    }

    public static List<String> toughStreams_exercise_4(DecimalFormat decimalFormat, List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(
                        employee -> employee.getCompany().getName(),
                        summingInt(employee -> employee.getSalary().intValue())
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(pair -> pair.getKey() + " - " + decimalFormat.format(pair.getValue()))
                .collect(toList());
    }

    public static List<String> toughStreams_exercise_5_solution_1(String string) {
        return Pattern.compile("\n").splitAsStream(string)
                .collect(groupingBy(identity()))
                .entrySet()
                .stream()
                .sorted(comparing(Entry::getKey))
                .map(entry -> format("%s - %s", entry.getKey(), entry.getValue().size()))
                .collect(toList());
    }

    public static List<String> toughStreams_exercise_5_solution_2(String string) {
        return Pattern.compile("\n").splitAsStream(string)
                .collect(toMap(identity(), element -> 1, (a, b) -> a + b, TreeMap::new))
                .entrySet()
                .stream()
                .map(entry -> format("%s - %s", entry.getKey(), entry.getValue()))
                .collect(toList());
    }

}
