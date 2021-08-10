package ru.job4j.hash;
/*
Из книги "effective java".

Сначала, необходимо исключить избыточные поля, которые не участвуют в equals.

Далее необходимо выбрать базу: число, которое будет основой вычисления hash-кода.

По историческим причинам обычно за базу берут число 31.

 Кто-то говорит, что это взято из-за близости к числу 32, т.е степени двойки 2^5 - 1.

 Кто-то утверждает, что был проведен эксперимент и наиболее лучшей базой получились числа 31 и 33,

 а 31 понравилось больше.

В целом, вы можете выбрать за базу, что хотите, но принято выбирать 31.

Многие IDE генерят hashCode именно с такой базой.

Правила вычисления hashCode:

Присваиваем переменной result ненулевое значение - базу.

Далее для каждого значимого поля в объекте вычисляем hashCode, по следующим правилам:

1. Если поле boolean - (f ? 1 : 0)

2.Если поле byte, char, short или int - (int)f

3.Если поле long - (int)(f ^ (f >>> 32))

4.Если поле float, то Float.floatToIntBits(f);

5. Если поле double, то Double.doubleToLongBits(f), а затем как с long.

6. Если поле это ссылка на другой объект, то рекурсивно вызовите hashCode()

7. Если поле null - то возвращаем 0.

8. Если поле это массив - то обрабатываем так, как будто каждый элемент массива - это поле объекта.

После каждого обработанного поля объединяем его hashCode с текущим значением:
result = 31 * result + c; //c - это hashCode обработанного поля.

Ниже приведен пример.
 */

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