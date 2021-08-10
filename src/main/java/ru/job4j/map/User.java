package ru.job4j.map;

import java.util.*;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
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
