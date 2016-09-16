package uk.co.jpawlak.java8exercises.utils;

import java.util.Optional;

import static uk.co.jpawlak.java8exercises.utils.Utils.notNull;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Address {

    private final Optional<Integer> flatNumber;
    private final int streetNumber;
    private final Optional<String> buildingName;
    private final String streetName;
    private final String postCode;

    public Address(Integer flatNumber, int streetNumber, String buildingName, String streetName, String postCode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        if (streetNumber != address.streetNumber) {
            return false;
        }
        if (!flatNumber.equals(address.flatNumber)) {
            return false;
        }
        if (!buildingName.equals(address.buildingName)) {
            return false;
        }
        if (!streetName.equals(address.streetName)) {
            return false;
        }
        return postCode.equals(address.postCode);

    }

    @Override
    public int hashCode() {
        int result = flatNumber.hashCode();
        result = 31 * result + streetNumber;
        result = 31 * result + buildingName.hashCode();
        result = 31 * result + streetName.hashCode();
        result = 31 * result + postCode.hashCode();
        return result;
    }

}
