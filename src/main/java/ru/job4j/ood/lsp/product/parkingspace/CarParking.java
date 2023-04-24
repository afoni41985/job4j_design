package ru.job4j.ood.lsp.product.parkingspace;

import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {

    private final List<Vehicle> parking = new ArrayList<>();


    public CarParking(int carPlace, int truckPlace) {
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        return parking;
    }


}
