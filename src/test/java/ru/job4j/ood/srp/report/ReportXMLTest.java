package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportXMLTest {

    @Test
    void whenXMLGenerate() throws JAXBException {

        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportXML reportJSON = new ReportXML(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "\n"
                + "<employee name=\"Ivan\" salary=\"100.0\"/>"
                + "\n";
        assertThat(reportJSON.generate(em -> true)).isEqualTo(expect);
    }
}
