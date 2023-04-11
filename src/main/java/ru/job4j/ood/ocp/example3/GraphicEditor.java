package ru.job4j.ood.ocp.example3;

/**
 * При доюавлении новой реализации shape будет изменяться
 * класс GraphicEditor, чтобы не нарушать правило, небходимо
 * создать метод draw в каждой реализации.
 */
public class GraphicEditor {
    public GraphicEditor() {
    }

    public void drawCircle(Circle c) {
        System.out.println("Circle");
    }

    public void drawRectangle(Rectangle r) {
        System.out.println("Rectangle");
    }

    public void drawShape(Shape s) {
        if (s.getType() == 1) {
            this.drawRectangle((Rectangle) s);
        } else if (s.getType() == 2) {
            this.drawCircle((Circle) s);
        }
    }
}