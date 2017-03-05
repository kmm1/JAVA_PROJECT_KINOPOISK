/**
 * Created by icons on 4.3.17.
 */
public class ShapeUtils extends Triangle {


    public ShapeUtils(Point a, Point b, Point c) {
        super(a, b, c);
    }

    public static void isTriangle (){
        if ((distanceAB < distanceBC + distanceCA)&(distanceBC < distanceAB + distanceCA) &(distanceCA < distanceAB + distanceBC)){
        System.out.println("Треугольник существует");
    } else {
        System.out.println("Треугольник не существует");
    }
    }
}


