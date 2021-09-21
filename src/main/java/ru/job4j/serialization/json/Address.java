package ru.job4j.serialization.json;

public class Address {
    String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{"
                + "address='" + address + '\''
                + '}';
    }
}
