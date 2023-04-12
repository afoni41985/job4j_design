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
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Divan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report reportJSON = new ReportJSON(store);
        String expect = "["
                + "{"
                + "\"name\":\""
                + worker1.getName()
                + "\","
                + "\"hired\":{"
                + "\"year\":"
                + worker1.getHired().get(Calendar.YEAR)
                + ","
                + "\"month\":"
                + worker1.getHired().get(Calendar.MONTH)
                + ","
                + "\"dayOfMonth\":"
                + worker1.getHired().get(Calendar.DAY_OF_MONTH)
                + ","
                + "\"hourOfDay\":"
                + worker1.getHired().get(Calendar.HOUR_OF_DAY)
                + ","
                + "\"minute\":"
                + worker1.getHired().get(Calendar.MINUTE)
                + ","
                + "\"second\":"
                + worker1.getHired().get(Calendar.SECOND)
                + "},"
                + "\"fired\":{"
                + "\"year\":"
                + worker1.getFired().get(Calendar.YEAR)
                + ","
                + "\"month\":"
                + worker1.getFired().get(Calendar.MONTH)
                + ","
                + "\"dayOfMonth\":"
                + worker1.getFired().get(Calendar.DAY_OF_MONTH)
                + ","
                + "\"hourOfDay\":"
                + worker1.getFired().get(Calendar.HOUR_OF_DAY)
                + ","
                + "\"minute\":"
                + worker1.getFired().get(Calendar.MINUTE)
                + ","
                + "\"second\":"
                + worker1.getFired().get(Calendar.SECOND)
                + "},"
                + "\"salary\":"
                + worker1.getSalary()
                + "}"
                + ","
                + "{"
                + "\"name\":\""
                + worker2.getName()
                + "\","
                + "\"hired\":{"
                + "\"year\":"
                + worker2.getHired().get(Calendar.YEAR)
                + ","
                + "\"month\":"
                + worker2.getHired().get(Calendar.MONTH)
                + ","
                + "\"dayOfMonth\":"
                + worker2.getHired().get(Calendar.DAY_OF_MONTH)
                + ","
                + "\"hourOfDay\":"
                + worker2.getHired().get(Calendar.HOUR_OF_DAY)
                + ","
                + "\"minute\":"
                + worker2.getHired().get(Calendar.MINUTE)
                + ","
                + "\"second\":"
                + worker2.getHired().get(Calendar.SECOND)
                + "},"
                + "\"fired\":{"
                + "\"year\":"
                + worker2.getFired().get(Calendar.YEAR)
                + ","
                + "\"month\":"
                + worker2.getFired().get(Calendar.MONTH)
                + ","
                + "\"dayOfMonth\":"
                + worker2.getFired().get(Calendar.DAY_OF_MONTH)
                + ","
                + "\"hourOfDay\":"
                + worker2.getFired().get(Calendar.HOUR_OF_DAY)
                + ","
                + "\"minute\":"
                + worker2.getFired().get(Calendar.MINUTE)
                + ","
                + "\"second\":"
                + worker2.getFired().get(Calendar.SECOND)
                + "},"
                + "\"salary\":"
                + worker2.getSalary() + "}"
                + "]";
        assertThat(reportJSON.generate(employee -> true)).isEqualTo(expect);
    }
}
