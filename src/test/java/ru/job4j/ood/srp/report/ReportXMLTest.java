package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportXMLTest {

    @Test
    void whenXMLGenerate() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Divan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report reportXML = new ReportXML(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<Employees>\n"
                + "    <employees>\n"
                + "        <employee>\n"
                + "            <fired>" + format.format(worker1.getHired().getTime()) + "</fired>\n"
                + "            <hired>" + format.format(worker1.getFired().getTime()) + "</hired>\n"
                + "            <name>" + worker1.getName() + "</name>\n"
                + "            <salary>" + worker1.getSalary() + "</salary>\n"
                + "        </employee>\n"
                + "        <employee>\n"
                + "            <fired>" + format.format(worker2.getHired().getTime()) + "</fired>\n"
                + "            <hired>" + format.format(worker2.getFired().getTime()) + "</hired>\n"
                + "            <name>" + worker2.getName() + "</name>\n"
                + "            <salary>" + worker2.getSalary() + "</salary>\n"
                + "        </employee>\n"
                + "    </employees>\n"
                + "</Employees>\n";
        assertThat(reportXML.generate(employee -> true)).isEqualTo(expect);
    }
}
