import Figure.Figure;

/**
 * Created by icons on 4.3.17.
 */
public class Square implements Figure{

    private Point a, b;

    public Square(Point a, Point b){
        this.a=a;
        this.b=b;
    }
    public Point getA() {return a;}
    public Point getB() {return b;}

    @Override
    public void getArea() {
        double distanceAB = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        double area = Math.pow(distanceAB, 2);
        System.out.println("Площадь квадрата " + area);
    }

    @Override
    public void getPerimetr() {
        double distanceAB = Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
        double perimetr = 4*distanceAB;
        System.out.println("Периметр квадрата " + perimetr);
    }
}
