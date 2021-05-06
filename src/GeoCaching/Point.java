package GeoCaching;

public abstract class Point {

    public Float Latitude;

    public Float Longitude;

    public String Regiao;

    //Constructor
    public Point(Float latitude, Float longitude, String regiao) {
        Latitude = latitude;
        Longitude = longitude;
        Regiao = regiao;
    }

    //Getter e Setter
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

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String regiao) {
        Regiao = regiao;
    }
}