package Restart;

import java.text.DecimalFormat;

public class Snacks {
    private String location;
    private String name;
    private double price;
    private String type;
    private String sound;
    private int inventory;
    DecimalFormat df = new DecimalFormat("0.00");

    public Snacks(String location, String name, double price, String type, String sound,int inventory) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
        this.sound = sound;
        this.inventory=inventory;

            }

    public boolean isAvailableToPurchase() {
        if(this.inventory >= 1) {
            return true;
        }
        return false;
    }

    public void buyItem() {
        inventory -= 1;

    }

    @Override
    public String toString() {
        return  location + " " +
                 name + " " +
                 "$"+ df.format(price) + " ";
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }
}

