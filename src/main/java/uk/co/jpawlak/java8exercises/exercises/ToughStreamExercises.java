package uk.co.jpawlak.java8exercises.exercises;

import org.junit.Ignore;
import org.junit.Test;
import uk.co.jpawlak.java8exercises.utils.Employee;

import java.text.DecimalFormat;
import java.util.List;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;
import static uk.co.jpawlak.java8exercises.utils.Employees.allEmployees;

@SuppressWarnings("all")
public class ToughStreamExercises {

    private static final List<Employee> EMPLOYEES = allEmployees();

    @Ignore
    @Test
    public void exercise_1_findFirst() {
        // find whether there are two employees with the same first name and surname and return the name
        // the solution has to be a single statement, complexity O(n^2) is acceptable

        String result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs("Holly Davies"));
    }

    @Ignore
    @Test
    public void exercise_2_groupingBy_counting() {
        // find the total number of groups of at least 5 employees living close to each other
        // consider all employees with the same 2 first characters of the home address post code a single group
        // you can collect to map and then stream over it, however the solution has to be a single statement

        long result = 0;

        //TODO write your code here

        assertThat(result, sameBeanAs(110L));
    }

    @Ignore
    @Test
    public void exercise_3_flatMap() {
        // find the total number of all different home and correspondence addresses

        long result = 0;

        //TODO write your code here

        assertThat(result, sameBeanAs(1820L));
    }

    @Ignore
    @Test
    public void exercise_4_groupingBy_summingInt() {
        // find how much in total each company pays (annually) to their employees, order result by amount
        // you can convert the salaries to ints using BigDecimal#intValue method
        // you can collect to map and then stream over it, however the solution has to be a single statement

        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        List<String> result = null;

        //TODO write your code here

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

    @Ignore
    @Test
    public void exercise_5() {
        // count the instances of words and output a list of formatted strings
        // output the strings sorted lexicographically by name
        // you can use collect twice
        // as always, a single statement solution is expected
        // hint: look at Pattern.compile(regex).splitAsStream(string)

        String string = "dog" + "\n" + "bird" + "\n" + "cat" + "\n" + "cat" + "\n" + "dog" + "\n" + "cat";
        List<String> result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs(asList(
                "bird - 1",
                "cat - 3",
                "dog - 2"
        )));
    }

}
