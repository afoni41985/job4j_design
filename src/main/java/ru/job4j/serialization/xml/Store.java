package ru.job4j.serialization.xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {
    @XmlAttribute
    private boolean check;

    private Address location;
    @XmlAttribute
    private int personal;

    private String[] range;

    public Store() {

    }

    public Store(boolean check, Address location, int personal, String... range) {
        this.check = check;
        this.location = location;
        this.personal = personal;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Store{"
                + "check=" + check
                + ", address=" + location
                + ", personal=" + personal
                + ", range=" + Arrays.toString(range)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        Store store = new Store(true, (new Address("ул.Колотушкина")), 10, "games", "balls");
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(Store.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(store, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            Store result = (Store) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}

