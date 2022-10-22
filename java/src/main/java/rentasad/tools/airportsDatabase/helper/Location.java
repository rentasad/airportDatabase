package rentasad.tools.airportsDatabase.helper;

public class Location {
    private String name;
    private final double longitude;

    /**
     *
     * @param longitude gps coordinates longitude as double
     * @param latitude gps coordinates latitude as double
     */
    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    private final double latitude;



}
