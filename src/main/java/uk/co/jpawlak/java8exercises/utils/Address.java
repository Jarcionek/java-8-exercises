package uk.co.jpawlak.java8exercises.utils;

import lombok.EqualsAndHashCode;

import java.util.Optional;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@EqualsAndHashCode
public class Address {

    private final Optional<Integer> flatNumber;
    private final int streetNumber;
    private final Optional<String> buildingName;
    private final String streetName;
    private final String postCode;

    Address(Integer flatNumber, int streetNumber, String buildingName, String streetName, String postCode) {
        this.flatNumber = Optional.ofNullable(flatNumber);
        this.streetNumber = streetNumber;
        this.buildingName = Optional.ofNullable(buildingName);
        this.streetName = notNull(streetName);
        this.postCode = notNull(postCode);
    }

    public Optional<Integer> getFlatNumber() {
        return flatNumber;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public Optional<String> getBuildingName() {
        return buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostCode() {
        return postCode;
    }

}
