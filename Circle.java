import Figure.Figure;

/**
 * Created by icons on 4.3.17.
 */
class Circle extends Point implements Figure {

    private double radius;

    public Circle ( double x, double y, double radius){
        super(x,y);
        this.radius=radius;
    }
    public double getRadius() {return radius;}

@Override
   public void getPerimetr(){
    double perimetr= Math.PI * Math.pow(radius, 2);
       System.out.println("Периметр круга "+ perimetr);
}
@Override
    public void getArea(){
        double area= 2 * Math.PI * radius;
        System.out.println("Площадь круга "+ area);
    }

    public void getDiametr(){
        double diametr= Math.pow(radius, 2);
        System.out.println("Диаметр круга "+ diametr);
    }

}
