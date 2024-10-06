package com.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty name;
    private final StringProperty address;
    private final StringProperty speed;
    private final StringProperty data;
    private final StringProperty contract;

    public Person(String name, String address, String speed, String data, String contract) {
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.speed = new SimpleStringProperty(speed);
        this.data = new SimpleStringProperty(data);
        this.contract = new SimpleStringProperty(contract);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getSpeed() {
        return speed.get();
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public StringProperty speedProperty() {
        return speed;
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public StringProperty dataProperty() {
        return data;
    }

    public String getContract() {
        return contract.get();
    }

    public void setContract(String contract) {
        this.contract.set(contract);
    }

    public StringProperty contractProperty() {
        return contract;
    }
}
