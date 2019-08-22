package com.example.lambda;

import java.util.Objects;

public class Vacation {

    private String location;
    private int price;
    private int duration;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Vacation(String location, int price, int duration) {
        this.location = location;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "location='" + location + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return price == vacation.price &&
                duration == vacation.duration &&
                Objects.equals(location, vacation.location);
    }
}
