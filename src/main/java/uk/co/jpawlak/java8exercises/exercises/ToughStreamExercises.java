package uk.co.jpawlak.java8exercises.exercises;

import javafx.util.Pair;
import org.junit.Test;
import uk.co.jpawlak.java8exercises.utils.Employee;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static uk.co.jpawlak.java8exercises.utils.Employees.allEmployees;

public class ToughStreamExercises {

    private static final List<Employee> EMPLOYEES = allEmployees();

    @Test
    public void exercise__groupingBy() {
        // find the total number of groups of at least 5 employees living close to each other
        // consider all employees with the same 2 first characters of the home address post code a single group

        long result = 0;

        //TODO write your code here
        result = EMPLOYEES.stream()
                .collect(groupingBy(employee -> employee.getHomeAddress().getPostCode().substring(0, 2)))
                .entrySet()
                .stream()
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue().size()))
                .filter(pair -> pair.getValue() >= 5)
                .sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                .count();

        assertThat(result, sameBeanAs(110L));
    }

    @Test
    public void exercise__flatMap() {
        // find the total number of all different home and correspondence addresses

        long result = 0;

        //TODO write your code here
        result = EMPLOYEES.stream()
                .flatMap(employee -> Stream.of(employee.getHomeAddress(), employee.getCorrespondenceAddress().orElse(null)))
                .filter(address -> address != null)
                .distinct()
                .count();

        assertThat(result, sameBeanAs(1820));
    }

    @Test
    public void exercise__groupingBy_map() {
        // find how much in total each company pays (annually) to their employees, order result by amount

        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        List<String> result = null;

        //TODO write your code here
        result = EMPLOYEES.stream()
                .collect(groupingBy(employee -> employee.getCompany().getName()))
                .entrySet()
                .stream()
                .map(entry -> new Pair<>(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(Employee::getSalary)
                                .reduce(BigDecimal::add)
                                .get()
                ))
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(pair -> pair.getKey() + " - " + decimalFormat.format(pair.getValue()))
                .collect(Collectors.toList());

        assertThat(result, sameBeanAs(asList(
                "Anglo American - £12,119,153.00",
                "HSBC - £11,469,144.00",
                "Royal Bank of Scotland Group - £11,127,807.00",
                "BP - £10,925,088.00",
                "AstraZeneca - £10,507,305.00",
                "HBOS - £10,428,819.00",
                "Royal Dutch Shell - £10,100,098.00",
                "Barclays plc - £10,071,534.00",
                "Vodafone Group - £10,029,401.00",
                "GlaxoSmithKline - £9,499,235.00"
        )));
    }

    //TODO Jarek: add project lombok and remove toString/equals methods from Employee etc

}
