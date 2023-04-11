package ru.job4j.ood.ocp.example1;


public class ExcelReport implements Reportable {
    Object[][] data;

    public ExcelReport(Object[][] data) {
        this.data = data;
    }
}

