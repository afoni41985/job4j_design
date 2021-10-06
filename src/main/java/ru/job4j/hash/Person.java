package ru.job4j.hash;

import java.util.Objects;

public class Person {
    private int age;
    private int number;
    private double salary;
    private String name;

    public Person(int age, int number, String name, double salary) {
        this.age = age;
        this.number = number;
        this.name = name;
        this.salary = salary;

    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + age;
        result = result * 17 + number;

        long lnum = Double.doubleToLongBits(number);
        result = result * 17 + (int) (lnum ^ (lnum >>> 32));

        result = result * 17 + name.hashCode();


        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age
                && number == person.number
                && Double.compare(person.salary, salary) == 0
                && Objects.equals(name, person.name);
    }
}