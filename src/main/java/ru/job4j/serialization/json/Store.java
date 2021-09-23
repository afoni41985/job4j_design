package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private final boolean check;
    private final Address address;
    private final int personal;
    private final String[] range;

    public Store(boolean check, Address address, int personal, String... range) {
        this.check = check;
        this.address = address;
        this.personal = personal;
        this.range = range;
    }

    public boolean isCheck() {
        return check;
    }

    public int getPersonal() {
        return personal;
    }

    @Override
    public String toString() {
        return "Store{"
                + "check=" + check
                + ", address=" + address
                + ", personal=" + personal
                + ", range=" + Arrays.toString(range)
                + '}';
    }

    public static void main(String[] args) {
        Store store = new Store(true, (new Address("ул.Колотушкина")), 10, "games", "balls");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(store));
        final String storeGson = "{\"check\":true,"
                + "\"address\":"
                + "{\"address\":\"ул.Колотушкина\"},"
                + "\"personal\":10,\"range\":[\"games\",\"balls\"]}";
        final Store storeMod = gson.fromJson(storeGson, Store.class);
        System.out.println(storeMod);

        JSONObject jsonAddress = new JSONObject("{\"address\":\"ул.Колотушкина\"}");

        List<String> list = new ArrayList<>();
        list.add("как");
        list.add("все");
        list.add("запомнить");
        JSONArray jsonRange = new JSONArray(list);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("chek", store.isCheck());
        jsonObject.put("personal", store.getPersonal());
        jsonObject.put("address", jsonAddress);
        jsonObject.put("range", jsonRange);
        System.out.println(jsonObject);

        System.out.println(new JSONObject(store));
    }
}
