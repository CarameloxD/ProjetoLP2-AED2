package JavaFx;


public class CoordenadasVertices {
    private double x;
    private double y;

    private final int R = 6371;  // approximate radius of earth
    int screenHeight = 472;
    int screenWidth = 932;


    public CoordenadasVertices(double x, double y) {
        this.x =(screenWidth/2) + (R * Math.cos(x) * Math.cos(y))/25;
        this.y =(screenHeight/2) - (R * Math.cos(x) * Math.sin(y))/25;
        System.out.println("Coordenadas:" + this.x + ", " + this.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
