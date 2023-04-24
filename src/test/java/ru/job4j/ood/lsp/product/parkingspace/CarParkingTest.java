package ru.job4j.ood.lsp.product.parkingspace;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.parkingspace.model.Car;
import ru.job4j.ood.lsp.product.parkingspace.model.Truck;
import ru.job4j.ood.lsp.product.parkingspace.model.Vehicle;


class CarParkingTest {


    @Ignore
    @Test
    void whenAdd1TruckAnd1CarInCarParking() {
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Parking parking = new CarParking(1, 1);
        Assertions.assertTrue(parking.add(car));
        Assertions.assertTrue(parking.add(truck));
        Assertions.assertEquals(parking.getVehicleList().size(), 2);
    }

    @Ignore
    @Test
    void whenAddOnly2Car() {
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Parking parking = new CarParking(2, 0);
        Assertions.assertTrue(parking.add(car1));
        Assertions.assertTrue(parking.add(car2));
        Assertions.assertEquals(parking.getVehicleList().size(), 2);
    }

    @Ignore
    @Test
    void whenAddOnly2Truck() {
        Vehicle truck = new Truck();
        Vehicle truck1 = new Truck();
        Parking parking = new CarParking(2, 0);
        Assertions.assertTrue(parking.add(truck));
        Assertions.assertTrue(parking.add(truck1));
        Assertions.assertEquals(parking.getVehicleList().size(), 2);
    }

    @Ignore
    @Test
    void whenAdd1TruckInCarPlace() {
        Vehicle truck = new Truck();
        Vehicle truck1 = new Truck();
        Parking parking = new CarParking(1, 1);
        Assertions.assertTrue(parking.add(truck));
        Assertions.assertTrue(parking.add(truck1));
        Assertions.assertEquals(parking.getVehicleList().size(), 2);
    }

    @Ignore
    @Test
    void whenAdd1CarInTruckPlace() {
        Vehicle car = new Car();
        Vehicle car1 = new Car();
        Parking parking = new CarParking(1, 1);
        Assertions.assertTrue(parking.add(car));
        Assertions.assertFalse(parking.add(car1));
        Assertions.assertEquals(parking.getVehicleList().size(), 1);
    }

    @Ignore
    @Test
    void whenThereAreNoSeats() {
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        Parking parking = new CarParking(0, 0);
        Assertions.assertFalse(parking.add(car));
        Assertions.assertFalse(parking.add(truck));
        Assertions.assertEquals(parking.getVehicleList().size(), 0);
    }
}
