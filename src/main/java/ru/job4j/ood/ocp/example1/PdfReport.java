package ru.job4j.ood.ocp.example1;

public class PdfReport implements Reportable {
    Object[][] data;

    public PdfReport(Object[][] data) {
        this.data = data;
    }
}
