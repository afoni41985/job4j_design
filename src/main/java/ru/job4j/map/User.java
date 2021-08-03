package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("aleks", 10, new GregorianCalendar(2011, Calendar.JUNE, 25));
        User user = new User("aleks", 10, new GregorianCalendar(2011, Calendar.JUNE, 25));
        var users = new HashMap<User, Object>();
        users.put(user, new Object());
        users.put(user1, new Object());
        users.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
