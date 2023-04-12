package ru.job4j.ood.isp.example1;

/**
 * При добавлении нового класса, например EconomicPrinter class в котором принтер
 * не отправляет факс, нам придется имплементировать интерфейс со всеми методами,
 * даже которые мы не будем использовать, класс будет зависеть от метода Fax,
 * необходимо разделить данный интерфейс 3 разных
 */
public class AllInOnePrinter implements SmartDevice {


    @Override
    public void print() {

    }

    @Override
    public void fax() {

    }

    @Override
    public void scan() {

    }
}
