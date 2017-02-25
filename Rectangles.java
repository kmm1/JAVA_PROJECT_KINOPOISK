/**
 * Created by icons on 26.2.17.
 */
class Rectangle {
    private double x1, x2, y1, y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    void diagonalLength () {
        double temp = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        double diagonal = Math.sqrt(temp);
        System.out.println("Длина лиаганали: " + diagonal);
    }
    void rectangleArea() {                                           //дл стороны AD
        double x3 = x1;
        double y3 = y2;
        double AD = Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2);
        double lengthAB = Math.sqrt(AD);
        double temp2 = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2); // Диагональ AC
        double diagonalABCD = Math.sqrt(temp2);
        double temp3 = Math.pow(diagonalABCD, 2) - Math.pow(lengthAB, 2);  ////дл стороны AD
        double lengBC = Math.sqrt(temp3);
        double areaABCD = lengBC * lengthAB;
        System.out.println("Площадь прямоугольгика: " + areaABCD);
    }
    public void setX1(double x1) {this.x1 = x1;}
    public double getX1() {return x1;}
    public void setY1(double y1) {this.y1 = y1;}
    public double getY1() {return y1;}
    public void setX2(double x2) {this.x2 = x2;}
    public double getX2() {return x2;}
    public void setY2(double y2) {this.y2 = y2;}
    public double get2() {return y2;}
}


