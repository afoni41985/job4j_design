package ru.job4j.ood.lsp.product.parkingspace;

import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;

import java.util.List;

public interface Parking {

    boolean add(Vehicle vehicle);

    List<Vehicle> getVehicleList();

}
