package uk.co.jpawlak.java8exercises.utils;

import java.util.Collections;

import static java.util.Arrays.stream;

public class Utils {

    public static <T> T notNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static Class<?> nestedClass(String unmodifiableSet) {
        return stream(Collections.class.getDeclaredClasses())
                .filter(clazz -> clazz.getSimpleName().equals(unmodifiableSet))
                .findFirst()
                .get();
    }

}
