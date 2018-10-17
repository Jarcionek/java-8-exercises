package uk.co.jpawlak.java8exercises.solutions;

import uk.co.jpawlak.java8exercises.utils.Employee;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.LongStream.concat;

@SuppressWarnings("all")
public class Solutions_Pack_4 {

    public static String exercise_1_solution_1(List<Employee> employees) {
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

    public static String exercise_1_solution_2(List<Employee> employees) {
        // those employee.get will have terrible performance in case of LinkedList
        return IntStream.range(0, employees.size())
                .filter(i -> IntStream.range(i + 1, employees.size()).anyMatch(j -> haveSameName(employees.get(i), employees.get(j))))
                .mapToObj(employees::get)
                .findFirst()
                .map(employee -> employee.getFirstName() + " " + employee.getSurname())
                .orElse(null);
    }

    private static boolean haveSameName(Employee e1, Employee e2) {
        return e1.getFirstName().equals(e2.getFirstName()) && e1.getSurname().equals(e2.getSurname());
    }

    public static String exercise_1_solution_3(List<Employee> employees) {
        List<String> names = employees.stream().map(e -> e.getFirstName() + " " + e.getSurname()).collect(toList());

        return names.stream()
                .filter(name -> Collections.frequency(names, name) > 1)
                .findFirst()
                .orElse(null);
    }

    public static String exercise_1_solution_4(List<Employee> employees) {
        // O(n) time complexity, but we need all entries in the memory
        return employees.stream()
                .collect(groupingBy(
                        employee -> employee.getFirstName() + " " + employee.getSurname(),
                        LinkedHashMap::new,
                        counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .map(Entry::getKey)
                .orElse(null);
    }

    public static long exercise_2(List<Employee> employees) {
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

    public static long exercise_3(List<Employee> employees) {
        return employees.stream()
                .flatMap(employee -> Stream.of(employee.getHomeAddress(), employee.getCorrespondenceAddress().orElse(null)))
                .filter(address -> address != null)
                .distinct()
                .count();
    }

    public static List<String> exercise_4(DecimalFormat decimalFormat, List<Employee> employees) {
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

    public static List<String> exercise_5_solution_1(String string) {
        return Pattern.compile("\n").splitAsStream(string)
                .collect(groupingBy(identity()))
                .entrySet()
                .stream()
                .sorted(comparing(Entry::getKey))
                .map(entry -> format("%s - %s", entry.getKey(), entry.getValue().size()))
                .collect(toList());
    }

    public static List<String> exercise_5_solution_2(String string) {
        return Pattern.compile("\n").splitAsStream(string)
                .collect(toMap(identity(), element -> 1, (a, b) -> a + b, TreeMap::new))
                .entrySet()
                .stream()
                .map(entry -> format("%s - %s", entry.getKey(), entry.getValue()))
                .collect(toList());
    }

    public static long exercise_6(int[] rows, int[] columns) {
        return stream(rows)
                .asLongStream()
                .flatMap(rowValue -> stream(columns).mapToLong(columnValue -> rowValue * columnValue))
                .sum();
    }

    public static int[] exercise_7(LongStream longs, IntStream ints) {
        return concat(longs, ints.mapToLong(n -> n))
                .map(Math::abs)
                .sorted()
                .skip(5)
                .limit(10)
                .map(n -> n % 1000)
                .mapToInt(n -> (int) n)
                .toArray();
    }

}
