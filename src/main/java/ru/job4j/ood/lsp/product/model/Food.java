package ru.job4j.ood.lsp.product.model;

import java.time.LocalDate;
import java.time.Period;

public class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expiryDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate createDate,
                LocalDate expiryDate, double price, int discount) {
        if (createDate.isAfter(LocalDate.now())) {
            System.out.println("Проверьте дату, еще раз");
        }
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='"
                + name
                + '\''
                + ", expiryDate="
                + expiryDate
                + ", createDate="
                + createDate
                + ", price="
                + price
                + ", discount="
                + discount
                + '}';
    }

    public int getExpirePercent() {
        double period1 = Period.between(this.getCreateDate(), LocalDate.now()).getDays();
        double period2 = Period.between(this.getCreateDate(), this.getExpiryDate()).getDays();
        return (int) Math.ceil((period1 / period2) * 100);
    }

    public double getPriceWithDiscount() {
        if (this.getPrice() >= 100 && this.getPrice() < 0) {
            System.out.println("Скидка, не может быть 100 и более");

        }
        return this.getPrice() * (100 - this.getDiscount()) / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
