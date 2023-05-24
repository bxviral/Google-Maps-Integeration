package com.example.googlemaps;

public class AddressData {
    String fullAdd;
    double latitude;
    double longitude;

    public AddressData(String fullAdd, double latitude, double longitude) {
        this.fullAdd = fullAdd;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getFullAdd() {
        return fullAdd;
    }

    public void setFullAdd(String fullAdd) {
        this.fullAdd = fullAdd;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
