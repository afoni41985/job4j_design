package ru.job4j.ood.ocp.example1;

/**
 *Если мы хотим добавить возможность создания отчетов в формате HTML.
 * Невозможно модифицировать этот код без изменения существующего кода
 * модуля в классе ReportGenerator и if-условия в нем.
 * Каждый отчетный экземпляр должен иметь свою собственную логику
 * генерации отчета и не должен зависеть от кода модуля для этого
 */
public class ReportGenerator {
    public void generate(Reportable report) {
        if (report instanceof ExcelReport) {
            System.out.println("create excel report");
        } else if (report instanceof PdfReport) {
            System.out.println("create pdf report");
        }
    }

    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        generator.generate(new PdfReport(new Object[1][1]));
        generator.generate(new ExcelReport(new Object[1][1]));
    }
}
