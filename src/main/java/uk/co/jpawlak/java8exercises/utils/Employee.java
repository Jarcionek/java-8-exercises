package uk.co.jpawlak.java8exercises.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Employee {

    private final String firstName;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Company company;
    private final BigDecimal salary;
    private final Address homeAddress;
    private final Optional<Address> correspondenceAddress;

    public Employee(String firstName, String surname, LocalDate dateOfBirth, Company company, BigDecimal salary, Address homeAddress, Address correspondenceAddress) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) {
            return false;
        }
        if (!surname.equals(employee.surname)) {
            return false;
        }
        if (!dateOfBirth.equals(employee.dateOfBirth)) {
            return false;
        }
        if (!company.equals(employee.company)) {
            return false;
        }
        if (!salary.equals(employee.salary)) {
            return false;
        }
        if (!homeAddress.equals(employee.homeAddress)) {
            return false;
        }
        return correspondenceAddress.equals(employee.correspondenceAddress);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + homeAddress.hashCode();
        result = 31 * result + correspondenceAddress.hashCode();
        return result;
    }

}
