package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

import java.util.function.Predicate;

public class ReportXML implements Report {
    private final Store store;
    private final Marshaller marshaller;


    public ReportXML(Store store) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        this.marshaller = context.createMarshaller();
        this.store = store;
    }



    @Override
    public String generate(Predicate<Employee> filter) {
        String stringXML = "";
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        }

        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : store.findBy(filter)) {
                marshaller.marshal(employee, writer);
                stringXML = writer.getBuffer().toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringXML;
    }
}

