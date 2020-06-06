package com.company.basics.multithreads;

public class Quote {
    private String site;
    private int price;

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", price=" + price +
                '}';
    }
}
