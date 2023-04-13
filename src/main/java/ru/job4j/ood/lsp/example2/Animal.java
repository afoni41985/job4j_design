package ru.job4j.ood.lsp.example2;

/**
 * чтобы обратиться к методу accept класса CatShelter,
 * вызывающий код должен знать, что он работает с CatShelter и Cat,
 * а не с AnimalShelter и Animal (в противном случае будет вызываться
 * метод accept класса Animal), а это прямое нарушение принципа
 * подстановки Барбары Лисков
 */
class Animal {
}

class Cat extends Animal {
}

class AnimalShelter {
    void accept(Animal animal) {

    }
}

class CatShelter extends AnimalShelter {
    void accept(Cat cat) {

    }

}