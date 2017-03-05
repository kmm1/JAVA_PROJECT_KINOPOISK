/**
 * Created by icons on 3.3.17.
 */
public class MainTest {
    public static void main(String[] args) {
        Point pointA = new Point (1,1);
        Point pointB = new Point(1, 3);
        Point pointC = new Point(3, 1);
        Point pointD = new Point(10, 5);
        pointA.distance(pointA, pointB);

        Circle circle1 = new Circle(15, 10, 10);
        circle1.getPerimetr();
        circle1.getArea();
        circle1.getDiametr();

        Triangle triangle1 = new Triangle(pointA, pointB, pointC);
        triangle1.getPerimetr();
        triangle1.getArea();

        Square square1 = new Square(pointA, pointB);
        square1.getPerimetr();
        square1.getArea();

    }
}
