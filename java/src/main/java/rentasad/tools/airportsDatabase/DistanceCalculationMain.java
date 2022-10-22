package rentasad.tools.airportsDatabase;


import rentasad.tools.airportsDatabase.helper.DistanceCalculationHelper;
import rentasad.tools.airportsDatabase.helper.Location;

public class DistanceCalculationMain
{
    public static void main(String[] args) {
        double latitudeEddp = 51.423889;
        double longitudeEddp = 12.236389;
        Location locationEddp = new Location(longitudeEddp, latitudeEddp);
        double latitudeLOWI = 47.260201;
        double longitudeLOWI = 11.344;
        Location locationLowi = new Location(longitudeLOWI, latitudeLOWI);
        double distance = DistanceCalculationHelper.distanceInKmBetweenEarthCoordinates(locationEddp, locationLowi);
        System.out.println(distance);
    }
}
