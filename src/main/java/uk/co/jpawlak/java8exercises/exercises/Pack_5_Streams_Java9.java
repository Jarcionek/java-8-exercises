package uk.co.jpawlak.java8exercises.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Pack_5_Streams_Java9 {

    @Test
    public void exercise_1_takeWhile_dropWhile() {
        // get all lines within head element

        List<String> html = asList(
                "<html>",
                "    <head>",
                "        <meta charset=\"UTF-8\">",
                "        <meta name=\"author\" content=\"Jarek Pawlak\">",
                "        <title>My Page</title>",
                "    </head>",
                "    <body>",
                "        <h1>Hello world</h1>",
                "    </body>",
                "</html>"
        );
        List<String> result = null;

        //TODO write your code here
        result = html.stream()
                .map(String::trim)
//                .dropWhile()
                .skip(1)
//                .takeWhile()
                .collect(toList());

        assertThat(result, sameBeanAs(asList(
                "<meta charset=\"UTF-8\">",
                "<meta name=\"author\" content=\"Jarek Pawlak\">",
                "<title>My Page</title>"
        )));
    }

    @Test
    public void blagf() {
        /*
        List<String> filteredList = listOfOptionals.stream()
  .flatMap(Optional::stream)
  .collect(Collectors.toList());
         */
    }

    @Test
    public void asfa() {
        //Stream.ofNullable
    }

}
