package ru.job4j.ood.lsp.product.parkingspace;

import ru.job4j.ood.lsp.product.parkingspace.model.Car;
import ru.job4j.ood.lsp.product.parkingspace.model.Truck;
import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {

    private final List<Vehicle> vehicleList;
    private int carPlace;
    private int truckPlace;


    public CarParking(int carPlace, int truckPlace) {
        vehicleList = new ArrayList<>(carPlace + truckPlace);
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        boolean rsl = false;
        if (truckPlace == 0 && carPlace == 0) {
            System.out.println("Нет мест");
            rsl = false;
        } else if (vehicle.getSize() == 1 && carPlace > 0) {
            vehicleList.add(new Car());
            carPlace--;
            rsl = true;
        } else if (vehicle.getSize() == 2 && truckPlace > 0) {
            vehicleList.add(new Truck());
            truckPlace--;
            rsl = true;
        } else if (truckPlace <= carPlace) {
            carPlace -= truckPlace;
            vehicleList.add(new Truck());
            rsl = true;
        }

        return rsl;
    }



    @Override
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }


}
