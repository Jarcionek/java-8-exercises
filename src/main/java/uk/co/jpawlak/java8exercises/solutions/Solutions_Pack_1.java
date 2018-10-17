package uk.co.jpawlak.java8exercises.solutions;

import uk.co.jpawlak.java8exercises.utils.Formatter;
import uk.co.jpawlak.java8exercises.utils.Node;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class Solutions_Pack_1 {

    public static void exercise_1(List<Node> list) {
        Collections.sort(list, (a, b) -> a.name().compareTo(b.name()));
    }

    public static String exercise_2(Formatter formatter) {
        return formatter.format((Integer amount) -> amount, 30000);
    }

}
