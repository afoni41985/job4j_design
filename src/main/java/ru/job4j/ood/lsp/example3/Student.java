package ru.job4j.ood.lsp.example3;

/**
 * В наследуемом подклассе в методе canGraduated, меняется условие,
 * которое влияет на результат работы метода
 * и изменяет поведение метода в базовом классе
 * это нарушение принципа
 * * подстановки Барбары Лисков
 **/
class Student {
    String name;
    String faculty;
    int course;

    public Student(String name, String faculty, int course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public boolean canGraduated() {
        return course > 3;
    }
}

class MguStudent extends Student {

    public MguStudent(String name, String faculty, int course) {
        super(name, faculty, course);
    }

    @Override
    public boolean canGraduated() {
        return course > 5;
    }

    public static void main(String[] args) {

    }
}