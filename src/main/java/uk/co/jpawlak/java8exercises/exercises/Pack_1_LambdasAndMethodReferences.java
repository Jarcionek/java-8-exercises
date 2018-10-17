package uk.co.jpawlak.java8exercises.exercises;

import org.junit.Ignore;
import org.junit.Test;
import uk.co.jpawlak.java8exercises.utils.Formatter;
import uk.co.jpawlak.java8exercises.utils.Node;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;

@SuppressWarnings("all")
public class Pack_1_LambdasAndMethodReferences {

    @Test
    public void example_1_oneInputOneOutput() {
        // think of function as old fashioned mapper/converter which converts a single value into another value
        // it has a single method (with two generic parameters R and T):   R apply(T t)

        Function<Integer, String> oldFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };

        Function<Integer, String> newFunction_lambda = integer -> integer.toString();

        Function<Integer, String> newFunction_lambda_withOptionalBrackets = (integer) -> integer.toString();

        Function<Integer, String> newFunction_methodReference = Object::toString;
    }


    @Test
    public void example_2_functionalInterface() {
        // lambdas can be used only for interface with one method
        // those are annotated with @FunctionalInterface:

        FunctionalInterface functionalInterface;

        // see for example:

        Runnable runnable;

        // interfaces with more than one method cannot be implemented using lambdas
        // those do not have this annotation, see for example:

        List<?> list;
    }


    @Test
    public void example_3_noInputNoOutput() {
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        // for no-arg methods the brackets are mandatory
        Runnable newRunnable_lambda = () -> System.out.println("hello world");
    }


    @Test
    public void example_4_twoInputsOneOutput() {
        Comparator<Integer> oldComparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> newComparator_lambda = (o1, o2) -> o1.compareTo(o2);

        // method Comparator.compare takes two explicit parameters
        // method Integer.compareTo also takes two parameters: one implicit (this) and one explicit
        // hence we can use method reference
        Comparator<Integer> newComparator_methodReference = Integer::compareTo;
    }


    @Test
    public void example_5_methodReferences() {
        // let's consider example 1 again, but with slightly different implementation:

        Function<Integer, String> oldFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return Integer.toString(integer); // in example 1 it was:   integer.toString()
            }
        };

        // we can use lambda

        Function<Integer, String> newFunction_lambda = integer -> Integer.toString(integer);

        // but we cannot use method reference
//        Function<Integer, String> function = Integer::toString;
        // won't compile
        // this is because toString is ambiguous, we have inherited Object.toString() and static Integer.toString(int)
        // if we were using static String.valueOf, it would be fine:

        Function<Integer, String> newFunction_explicitParameter = String::valueOf;
        Function<Integer, String> newFunction_implicitParameter = Object::toString;

        // String::valueOf is static and takes one argument
        // Object::toString is non static (which means that it has one implicit parameter) and takes no arguments
        // when using method reference it doesn't matter whether arguments are implicit or explicit
        // only the total number of arguments need to be the same as the function we are implementing
        // in this example apply(T) takes a single argument, so do the other two methods
    }


    @Test
    public void example_6_typesOfParametersInLambdas() {
        // when using lambdas, the types of parameters are "guessed" depending on the context:

        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);

        // here o1 and o2 will be Integers because this is what are the types of arguments in Comparator.compareTo
        // however you can be explicit about it:

        Comparator<Integer> comparator_withExplicitTypes = (Integer hello, Integer world) -> hello.compareTo(world);
        Function<String, Integer> function_withExplicitTypes = (String string) -> null;

        // brackets are mandatory when specifying the type of single argument, this won't compile:

//        Function<String, Integer> brokenFunction = String string -> null;

        // also note that the names are arbitrary, it's like the new method declaration - you define the parameters names
    }


    @Test
    public void example_7_lambdasWithBody() {
        Function<Object, String> multiLineLambda = x -> {
            System.out.println("hello");
            return "someString";
        };

        Function<Object, String> singleLineLambdaWithBody = x -> { return "someString"; };

        Function<Object, String> singleLineLambdaWithoutBody = x -> "someString";
    }


    @Test
    public void example_8_usefulClasses() {
        // there is a bunch of useful Java 8 classes in package java.util.function, these are the most commonly used ones:

                                                                                       // ARGUMENTS     RETURN VALUE TYPE
        Function<Object, String> function                = object -> "string";         //     1              generic
        Consumer<String> consumer                        = object -> {};               //     1              N/A
        Supplier<Integer> supplier                       = ()     -> 7;                //     0              generic
        Predicate<String> predicate                      = text   -> text.equals("x"); //     1              boolean
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;            //     2              generic

        // and don't forget about existing classes:

        Runnable runnable                                = ()     -> {};               //     0              N/A
        Callable<String> callable                        = ()     -> "blah";           //     0              generic
    }


    // EXERCISES


    @Ignore
    @Test
    public void exercise_1_sort() {
        // sort a list using Collections.sort
        // implement a comparator using lambda or method reference to sort the nodes lexicographically by name
        // the implementation should be single line, not exceed 120 characters margin
        // and still having meaningful variables' names

        List<Node> list = asList(new Node("c"), new Node("b"), new Node("d"), new Node("a"));

        //TODO write your code here

        assertThat(list, sameBeanAs(asList(new Node("a"), new Node("b"), new Node("c"), new Node("d"))));
    }


    @Ignore
    @Test
    public void exercise_2_numberFormatter() {
        // call the formatter to format int 30000 as currency
        // as in previous exercise, the solution should be one-liner
        // the formatter takes transformation and initial amount, first applies transformer function on the amount
        // and then formats to string - this is internal class, feel free to look at it
        // the purpouse of this exercise is to call the formatter with 30000 and define such function
        // that the ambigous method call error is resolved

        Formatter formatter = new Formatter();
        String result = null;

        //TODO write your code here

        assertThat(result, sameBeanAs("£30,000.00"));
    }

}
