package uk.co.jpawlak.java8exercises.exercises;

import org.junit.Test;

import java.util.Optional;

@SuppressWarnings("all")
public class Pack_2_Optionals {

    @Test
    public void example_1_creatingOptionals() {
        Optional<String> optional_1 = Optional.empty();
        Optional<String> optional_2 = Optional.of("non-null value");
        Optional<String> optional_3 = Optional.ofNullable("any value");
        Optional<String> optional_4 = Optional.ofNullable(null);
    }

    @Test
    public void example_2_basicUsage() {
        Optional<String> optional = Optional.of("John");
//        Optional<String> optional = Optional.empty();

        if (optional.isPresent()) {
            System.out.println(optional.get()); // get() will throw exception for empty optional
        }

        optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("Jack"));
    }

    @Test
    public void example_3_map_filter() {
        Optional<String> optional = Optional.of("John");
//        Optional<String> optional = Optional.of("Jack");
//        Optional<String> optional = Optional.empty();

        optional.map(value -> "Hello " + value + "!").ifPresent(System.out::println);

        optional.filter(value -> value.equals("Jack")).ifPresent(System.out::println);
    }

    @Test
    public void example_4_flatMap() {
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Jack"));
//        Optional<Optional<String>> nestedOptional = Optional.of(Optional.empty());
//        Optional<Optional<String>> nestedOptional = Optional.empty();

        Optional<String> flattenedOptional = nestedOptional.flatMap(optional -> optional);

        System.out.println(flattenedOptional.get());
    }

}
