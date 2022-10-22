package rentasad.tools.airportsDatabase.helper;

public class DistanceCalculationHelper {
    static final double _eQuatorialEarthRadius = 6378.1370D;
    static final double _d2r = (Math.PI / 180D);

    public static int HaversineInM(double lat1, double long1, double lat2, double long2) {
        return (int) (1000D * HaversineInKM(lat1, long1, lat2, long2));
    }

    public static double HaversineInKM(double lat1, double long1, double lat2, double long2) {
        double dlong = (long2 - long1) * _d2r;
        double dlat = (lat2 - lat1) * _d2r;
        double a = Math.pow(Math.sin(dlat / 2D), 2D) + Math.cos(lat1 * _d2r) * Math.cos(lat2 * _d2r)
                * Math.pow(Math.sin(dlong / 2D), 2D);
        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
        double d = _eQuatorialEarthRadius * c;

        return d;
    }

    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double distanceInKmBetweenEarthCoordinates(Location location1, Location location2) {
        double earthRadiusKm = 6371;

        double dLat = degreesToRadians(location2.getLatitude()-location1.getLatitude());
        double dLon = degreesToRadians(location2.getLongitude()-location1.getLongitude());

        double lat1 = degreesToRadians(location1.getLatitude());
        double lat2 = degreesToRadians(location2.getLatitude());

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return earthRadiusKm * c;
    }
}
