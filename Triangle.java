import Figure.Figure;

/**
 * Created by icons on 4.3.17.
 */
public class Triangle implements Figure {

    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public Point getA() {return a;}
    public Point getB() {return b;}
    public Point getC() {return c;}

    static double  distanceAB, distanceBC, distanceCA;
    static double perimetr, halfPerimeter, area;



    @Override
    public void getPerimetr() {
        distanceAB =Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
        distanceBC =Math.sqrt(Math.pow(b.x-c.x,2)+Math.pow(b.y-c.y,2));
        distanceCA =Math.sqrt(Math.pow(c.x-a.x,2)+Math.pow(c.y-a.y,2));
        perimetr = distanceAB+distanceBC+distanceCA;
        System.out.println("Периметр треугольника " + perimetr);
    }

   @Override
    public void getArea() {
        distanceAB =Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
        distanceBC =Math.sqrt(Math.pow(b.x-c.x,2)+Math.pow(b.y-c.y,2));
        distanceCA =Math.sqrt(Math.pow(c.x-a.x,2)+Math.pow(c.y-a.y,2));
        halfPerimeter = (distanceAB+distanceBC+distanceCA)/2;
        area = Math.sqrt(halfPerimeter*(halfPerimeter-distanceAB)*(halfPerimeter-distanceBC)*(halfPerimeter-distanceCA));
        System.out.println("Площадь треугольника " + area);
    }

}

