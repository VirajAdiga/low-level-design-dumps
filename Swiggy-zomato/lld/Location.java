package lld;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double pLat, double pLong) {
        latitude = pLat;
        longitude = pLong;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

