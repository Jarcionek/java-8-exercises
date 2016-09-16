package uk.co.jpawlak.java8exercises.utils;

import lombok.EqualsAndHashCode;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

@EqualsAndHashCode
public class Company {

    private final String name;

    Company(String name) {
        this.name = notNull(name);
    }

    public String getName() {
        return name;
    }

}
