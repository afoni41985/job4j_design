package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ReportHRTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 1200);
        Employee worker2 = new Employee("Taran", now, now, 18000);
        Employee worker3 = new Employee("Divan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportHR hr = new ReportHR(store, parser);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker2.getName()
                + " "
                + worker2.getSalary()
                + System.lineSeparator()
                + worker1.getName()
                + " "
                + worker1.getSalary()
                + System.lineSeparator()
                + worker3.getName()
                + " "
                + worker3.getSalary()
                + System.lineSeparator();
        assertThat(hr.generate(em -> true)).isEqualTo(expect);

    }
}