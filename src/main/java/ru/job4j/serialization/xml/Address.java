package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {

    @XmlAttribute
    private String street;

    public Address() {

    }

    public Address(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{"
                + "address='" + street + '\''
                + '}';
    }
}
