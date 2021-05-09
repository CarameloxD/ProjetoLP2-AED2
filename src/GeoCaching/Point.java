package GeoCaching;

public class Point {

    private Float Latitude;

    private Float Longitude;

    //Constructor

    public Point() {}

    public Point(Float latitude, Float longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- GETTERs & SETTERs --
     */

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }
}