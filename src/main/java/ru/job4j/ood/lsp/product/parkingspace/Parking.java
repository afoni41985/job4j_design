package ru.job4j.ood.lsp.product.parkingspace;

import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;

public interface Parking {

    boolean add(Vehicle vehicle);

    Vehicle[] getVehicleList();

}
