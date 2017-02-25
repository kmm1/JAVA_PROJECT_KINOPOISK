/**
 * Created by icons on 26.2.17.
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }
    void distance () {
        double temp = Math.pow(x, 2)+Math.pow(y,2);
        double distanse=Math.sqrt(temp);
        System.out.println("Расстояние до заданной точки "+distanse);
    }
    public void setX(double x) {this.x = x;}
    public double getX() {return x;}
    public void setY(double y) {this.y = y;}
    public double getY() {return y;}
}



