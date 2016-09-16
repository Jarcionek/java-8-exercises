package uk.co.jpawlak.java8exercises.utils;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@EqualsAndHashCode
public class Employee {

    private final String firstName;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Company company;
    private final BigDecimal salary;
    private final Address homeAddress;
    private final Optional<Address> correspondenceAddress;

    Employee(String firstName, String surname, LocalDate dateOfBirth, Company company, BigDecimal salary, Address homeAddress, Address correspondenceAddress) {
        this.firstName = notNull(firstName);
        this.surname = notNull(surname);
        this.dateOfBirth = notNull(dateOfBirth);
        this.company = notNull(company);
        this.salary = notNull(salary);
        this.homeAddress = notNull(homeAddress);
        this.correspondenceAddress = Optional.ofNullable(correspondenceAddress);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Company getCompany() {
        return company;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Optional<Address> getCorrespondenceAddress() {
        return correspondenceAddress;
    }

}
