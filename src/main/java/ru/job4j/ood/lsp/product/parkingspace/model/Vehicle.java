package ru.job4j.ood.lsp.product.parkingspace.model;

import java.util.Objects;

public class Vehicle {
    protected int size;

    public Vehicle(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return size == vehicle.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
