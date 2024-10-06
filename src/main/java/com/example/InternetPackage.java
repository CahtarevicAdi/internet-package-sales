package com.example;

public class InternetPackage {
    private int speed;
    private String data;
    private int contractDuration;
    private String userName;
    private String userAddress;


    public InternetPackage(int speed, String data, int contractDuration, String userName, String userAddress) {
        this.speed = speed;
        this.data = data;
        this.contractDuration = contractDuration;
        this.userName = userName;
        this.userAddress = userAddress;
    }


    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public int getContractDuration() { return contractDuration; }
    public void setContractDuration(int contractDuration) { this.contractDuration = contractDuration; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserAddress() { return userAddress; }
    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    @Override
    public String toString() {
        return String.format("Speed: %d Mbit/s, Data: %s, Contract: %d years, User: %s, Address: %s",
                speed, data, contractDuration, userName, userAddress);
    }
}
