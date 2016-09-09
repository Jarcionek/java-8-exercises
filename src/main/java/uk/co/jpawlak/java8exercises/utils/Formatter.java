package uk.co.jpawlak.java8exercises.utils;

import java.text.DecimalFormat;
import java.util.function.Function;

@SuppressWarnings("unused")
public class Formatter {

    private static final DecimalFormat PATTERN = new DecimalFormat("£#,###.00");

    /**
     * Applies transformer function on input value and then formats the number as string.
     */
    public String format(Function<Integer, Integer> transformer, int inputValue) {
        return PATTERN.format(transformer.apply(inputValue));
    }

    /**
     * Applies transformer function on input value and then formats the number as string.
     */
    public String format(Function<Double, Double> transformer, double inputValue) {
        return PATTERN.format(transformer.apply(inputValue));
    }

}
