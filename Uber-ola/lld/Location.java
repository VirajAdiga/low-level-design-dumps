package lld;

public class Location {
    public double latitude;
    public double longitude;

    public Location(double pLatitude, double pLongitude) {
        this.latitude = pLatitude;
        this.longitude = pLongitude;
    }

    public String getLatitude() {
        return String.valueOf(latitude);
    }

    public String getLongitude() {
        return String.valueOf(longitude);
    }
}
