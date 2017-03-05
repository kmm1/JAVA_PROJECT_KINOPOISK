import Figure.Figure;

/**
 * Created by icons on 4.3.17.
 */
public class Rectangle implements Figure {
    private Point leftUp;
    private Point rightDown;

    public Rectangle (Point leftUp, Point rightDown){
        this.leftUp=leftUp;
        this.rightDown=rightDown;
    }

    @Override
    public void getPerimetr() {
        double dx = this.rightDown.getX()-this.leftUp.getX();
        double dy = this.rightDown.getY()-this.leftUp.getY();
        double perimetr = Math.pow(dx,2)+Math.pow(dy,2);
        System.out.println("Периметр прямоугольгика " + perimetr);
    }

    @Override
    public void getArea() {
       double dx = this.rightDown.getX()-this.leftUp.getX();
       double dy = this.rightDown.getY()-this.leftUp.getY();
       double area = dx*dy;
        System.out.println("Площадь прямоугольгика " + area);
    }

    public void getDiagonal (Point leftUp, Point rightDown) {
        double diagonal = Math.sqrt(Math.pow(this.leftUp.x - this.rightDown.x, 2) + Math.pow(this.leftUp.y - this.rightDown.y, 2));
        System.out.println("Диаганаль прямоугольника " + diagonal);
    }
}

