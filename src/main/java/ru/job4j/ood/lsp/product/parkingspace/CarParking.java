package ru.job4j.ood.lsp.product.parkingspace;

import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;

public class CarParking implements Parking {

    private final Vehicle[] parking;

    public CarParking(int carPlace, int truckPlace) {
        this.parking = new Vehicle[carPlace + truckPlace];
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle[] getVehicleList() {
        return parking;
    }


}
