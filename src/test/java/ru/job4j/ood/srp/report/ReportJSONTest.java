package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportJSONTest {

    @Test
    void whenJSONGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportJSON reportJSON = new ReportJSON(store);
        String expect = "[{"
                + "\"name\":\""
                + worker.getName()
                + "\",\"hired\":"
                + "{\"year\":"
                + worker.getHired().get(Calendar.YEAR)
                + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "}"
                + ",\"fired\":"
                + "{\"year\":"
                + worker.getHired().get(Calendar.YEAR)
                + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "}"
                + ",\"salary\":"
                + worker.getSalary()
                + "}]";
        assertThat(reportJSON.generate(em -> true)).isEqualTo(expect);
    }
}