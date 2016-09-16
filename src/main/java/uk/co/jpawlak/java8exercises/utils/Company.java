package uk.co.jpawlak.java8exercises.utils;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

public class Company {

    private final String name;

    public Company(String name) {
        this.name = notNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Company company = (Company) o;

        return name.equals(company.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
