import java.util.HashMap;
import java.util.Map;

/**
 * Created by icons on 7.3.17.
 */
public class Garage {
    public static void main(String[] args) {

        Car sedan = new Sedan("Volvo", "C70", 2013, "Black");
        Car hatchback = new Hatchback("Honda", "civic", 2016, "Red");
        Car minivan = new Minivan("BMW", "Tourer", 2015, "Gray");
        Car pickup = new Pickup("BMW", "E80", 20114, "Black");

        Map<Car, Integer> garage = new HashMap<>();
        garage.put(sedan, 2);
        garage.put(hatchback, 3);
        garage.put(minivan, 1);
        garage.put(pickup, 1);
        System.out.println(garage.entrySet());

        int out = garage.get(sedan);  //выезд авто
        garage.put(sedan, out - 1);
        System.out.println("Выехала машина: " + sedan);
        System.out.println(garage.entrySet());


        int in = garage.get(hatchback);  //парковка авто
        garage.put(hatchback, in + 1);
        System.out.println("Запарковалась машина: " + hatchback);
        System.out.println(garage.entrySet());

        System.out.println("Кол-во данного вида автомобиля " + garage.get(sedan)); //Кол-во данного вида автомобиля

    }
}

