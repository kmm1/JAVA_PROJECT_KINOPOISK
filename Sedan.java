/**
 * Created by icons on 7.3.17.
 */
public class Sedan extends Car {

    public Sedan(String brand, String model, int year, String color) {
        super(brand, model, year, color);
    }

    @Override
    public String toString() {
        return (getBrand() + " " + getModel() + " " + getYear() + " " + getColor());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
