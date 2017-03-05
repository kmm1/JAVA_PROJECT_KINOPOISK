/**
 * Created by icons on 3.3.17.
 */
 public class Point {
    double x;
    double y;



    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }
    public double getX() {return x;}
    public double getY() {return y;}

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public  void distance (Point A, Point B) {
        double distanse = Math.sqrt(Math.pow(A.x-B.x,2)+Math.pow(A.y-B.y,2));
        System.out.println("Расстояние между двумя точками "+distanse);
    }

}
