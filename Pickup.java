/**
 * Created by icons on 8.3.17.
 */
public class Pickup extends Car {
    public Pickup(String brand, String model, int year, String color) {
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

