package com.aor.refactoring.example6;

public class Location {
    private String latitude;
    private String longitude;
    private String name;

    public Location(String locationLatitude, String locationLongitude, String locationName) {
        this.latitude = locationLatitude;
        this.longitude = locationLongitude;
        this.name = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return latitude + "," + longitude + " (" + name + ")";
    }
}
