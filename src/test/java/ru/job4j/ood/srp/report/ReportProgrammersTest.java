package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReportProgrammersTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        ReportProgrammers engine = new ReportProgrammers(store, parser);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName()
                + ";"
                + parser.parse(worker.getHired())
                + ";"
                + parser.parse(worker.getFired())
                + ";"
                + worker.getSalary()
                + System.lineSeparator();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}