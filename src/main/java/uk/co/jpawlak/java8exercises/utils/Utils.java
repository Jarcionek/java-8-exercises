package uk.co.jpawlak.java8exercises.utils;

public class Utils {

    public static <T> T notNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

}
