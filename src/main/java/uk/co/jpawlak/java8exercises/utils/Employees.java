package uk.co.jpawlak.java8exercises.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Employees {

    private static final Random RANDOM = new Random(0);

    private static final List<String> FIRST_NAMES = asList("Oliver", "Jack", "Harry", "Jacob", "Charlie", "Thomas", "George", "Oscar", "James", "William", "Noah", "Alfie", "Joshua", "Muhammad", "Henry", "Leo", "Archie", "Ethan", "Joseph", "Freddie", "Samuel", "Alexander", "Logan", "Daniel", "Isaac", "Max", "Mohammed", "Benjamin", "Mason", "Lucas", "Edward", "Harrison", "Jake", "Dylan", "Riley", "Finley", "Theo", "Sebastian", "Adam", "Zachary", "Arthur", "Toby", "Jayden", "Luke", "Harley", "Lewis", "Tyler", "Harvey", "Matthew", "David", "Amelia", "Olivia", "Isla", "Emily", "Poppy", "Ava", "Isabella", "Jessica", "Lily", "Sophie", "Grace", "Sophia", "Mia", "Evie", "Ruby", "Ella", "Scarlett", "Isabelle", "Chloe", "Sienna", "Freya", "Phoebe", "Charlotte", "Daisy", "Alice", "Florence", "Eva", "Sofia", "Millie", "Lucy", "Evelyn", "Elsie", "Rosie", "Imogen", "Lola", "Matilda", "Elizabeth", "Layla", "Holly", "Lilly", "Molly", "Erin", "Ellie", "Maisie", "Maya", "Abigail", "Eliza", "Georgia", "Jasmine", "Esme");
    private static final List<String> SURNAMES = asList("Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Roberts", "Johnson", "Lewis", "Walker", "Robinson", "Wood", "Thompson", "White", "Watson", "Jackson", "Wright", "Green", "Harris", "Cooper", "King", "Lee", "Martin", "Clarke", "James", "Morgan", "Hughes", "Edwards", "Hill", "Moore", "Clark", "Harrison", "Scott", "Young", "Morris", "Hall", "Ward", "Turner", "Carter", "Phillips", "Mitchell", "Patel", "Adams", "Campbell", "Anderson", "Allen", "Cook", "Bailey", "Parker", "Miller", "Davis", "Murphy", "Price", "Bell", "Baker", "Griffiths", "Kelly", "Simpson", "Marshall", "Collins", "Bennett", "Cox", "Richardson", "Fox", "Gray", "Rose", "Chapman", "Hunt", "Robertson", "Shaw", "Reynolds", "Lloyd", "Ellis", "Richards", "Russell", "Wilkinson", "Khan", "Graham", "Stewart", "Reid", "Murray", "Powell", "Palmer", "Holmes", "Rogers", "Stevens", "Walsh", "Hunter", "Thomson", "Matthews", "Ross", "Owen", "Mason", "Knight", "Kennedy", "Butler", "Saunders");
    private static final List<String> STREET_NAMES = asList("High Street", "Station Road", "Main Street", "Park Road", "Church Road", "Church Street", "London Road", "Victoria Road", "Green Lane", "Manor Road", "Church Lane", "Park Avenue", "The Avenue", "The Crescent", "Queens Road", "New Road", "Grange Road", "Kings Road", "Kingsway", "Windsor Road", "Highfield Road", "Mill Lane", "Alexander Road", "York Road", "St. John’s Road", "Main Road", "Broadway", "King Street", "The Green", "Springfield Road", "George Street", "Park Lane", "Victoria Street", "Albert Road", "Queensway", "New Street", "Queen Street", "West Street", "North Street", "Manchester Road", "The Grove", "Richmond Road", "Grove Road", "South Street", "School Lane", "The Drive", "North Road", "Stanley Road", "Chester Road", "Mill Road");
    private static final List<String> COMPANY_NAMES = asList("Royal Dutch Shell", "BP", "HSBC", "GlaxoSmithKline", "Vodafone Group", "Royal Bank of Scotland Group", "Barclays plc", "HBOS", "AstraZeneca", "Anglo American");

    private static LocalDate randomDateOfBirth() {
        int min = (int) LocalDate.of(1940, 1, 1).toEpochDay();
        int max = (int) LocalDate.of(1999, 12, 31).toEpochDay();
        return LocalDate.ofEpochDay(min + RANDOM.nextInt(max - min));
    }

    private static BigDecimal randomSalary() {
        return BigDecimal.valueOf(20_000 + RANDOM.nextInt(80_000));
    }

    private static Integer randomFlatNumber() {
        return RANDOM.nextInt(10) < 3 ? null : 1 + RANDOM.nextInt(50);
    }

    private static int randomStreetNumber() {
        return 1 + RANDOM.nextInt(200);
    }

    private static String randomBuildingName() {
        return null;
    }

    private static String randomFirstName() {
        return FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size()));
    }

    private static String randomSurname() {
        return SURNAMES.get(RANDOM.nextInt(SURNAMES.size()));
    }

    private static String randomStreetName() {
        return STREET_NAMES.get(RANDOM.nextInt(STREET_NAMES.size()));
    }

    private static String randomCompanyName() {
        return COMPANY_NAMES.get(RANDOM.nextInt(COMPANY_NAMES.size()));
    }

    private static String randomPostCode() {
        Supplier<Character> randomLetter = () -> (char) ('A' + RANDOM.nextInt('Z' - 'A'));
        Supplier<Integer> randomDigit = () -> RANDOM.nextInt(9);
        return "" + randomLetter.get() + randomLetter.get() + randomDigit.get() + randomDigit.get() + " " + randomDigit.get() + randomLetter.get() + randomLetter.get();
    }

    private static Address randomAddress() {
        return new Address(
                randomFlatNumber(),
                randomStreetNumber(),
                randomBuildingName(),
                randomStreetName(),
                randomPostCode()
        );
    }


    private static final List<Employee> ALL_EMPLOYEES = IntStream.generate(() -> 0)
            .limit(1764)
            .mapToObj(ignored -> {
                Address homeAddress = randomAddress();
                return new Employee(
                        randomFirstName(),
                        randomSurname(),
                        randomDateOfBirth(),
                        new Company(randomCompanyName()),
                        randomSalary(),
                        homeAddress,
                        RANDOM.nextInt(100) < 3 ? randomAddress() : homeAddress
                );
            })
            .collect(collectingAndThen(toList(), Collections::unmodifiableList));


    public static List<Employee> allEmployees() {
        return ALL_EMPLOYEES;
    }

}
