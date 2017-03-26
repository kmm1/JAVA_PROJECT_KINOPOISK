import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by icons on 26.3.17.
 */
public class CrazyScientists {
    List list = Collections.synchronizedList(new ArrayList<>());
    String[] BasicArray = {"Голова", "Тело", "Левая рука", "Правая рука", "Левая нога", "Правая нога", "CPU", "RAM", "HDD"};
    Random random = new Random();
    LinkedList<String> listForRed = new LinkedList<>();
    LinkedList<String> listForBlue = new LinkedList<>();
    Map<String, Integer> mapForRed = new HashMap<>();
    Map<String, Integer> mapForBlue = new HashMap<>();


    public void putFirst() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 20; i++) {
                String str = BasicArray[random.nextInt(BasicArray.length)];
                list.add(str);
            }
            System.out.println("Итак спор между учеными Блу и Рэд начался!!!!");
            System.out.println("В первую ночь на свалке оказалось 20 деталей");
        }
    }

    public void putOther() throws InterruptedException {
        synchronized (this) {
            int r = ThreadLocalRandom.current().nextInt(1, 5);// от 1 до 4 случ деталей
            for (int i = 0; i < r; i++) {
                String str = BasicArray[random.nextInt(BasicArray.length)];
                list.add(str);
            }
            System.out.println("Ночью фабрика выбросила " + r + " деталей");
        }
    }


    public void take() throws InterruptedException {
        synchronized (this) { //гарантия этот блок допкскает только один поток
            int r = 0;
            if (list.size() == 0) {
                r = 0;         // 0 деталей
            }
            if (list.size() == 1) {
                r = ThreadLocalRandom.current().nextInt(1, 2);// 1 случ деталей
            } else if (list.size() == 2) {
                r = ThreadLocalRandom.current().nextInt(1, 3);// от 1 до 2 случ деталей
            } else if (list.size() == 3) {
                r = ThreadLocalRandom.current().nextInt(1, 4);// от 1 до 3 случ деталей
            } else if (list.size() > 4) {
                r = ThreadLocalRandom.current().nextInt(1, 5);// от 1 до 4 случ деталей
            }
            for (int i = 0; i < r; i++) {                            // определ сколько деталий удалить
                String str2 = (String) list.get(random.nextInt(list.size()));
                list.remove(str2);
                if (Thread.currentThread().getName().equals("Прислужник Рэда")) {
                    listForRed.add(str2);
                } else if (Thread.currentThread().getName().equals("Прислужник Блу")) {
                    listForBlue.add(str2);
                }
            }
            System.out.println(Thread.currentThread().getName() + " нашел " + r + " деталей");
        }
    }


    public void winner() throws InterruptedException {
        int minValue2 = 0;
        int minValue1 = 0;
        System.out.println("Спор окончен. Идет подсчет результатов:");
        for (String x : listForRed) {
            if (!x.isEmpty()) {
                Integer num = mapForRed.get(x);
                if (num == null) {
                    num = 0;
                }
                mapForRed.put(x, ++num);
            }
        }
        System.out.println("Высокотехнологичные железяки Рэда: " + mapForRed);

        if (mapForRed.size() < BasicArray.length) {
            System.out.println("Рэд собрал 0 роботов");
        } else if (mapForRed.size() == BasicArray.length) {
            List list1 = new ArrayList(mapForRed.values());
            System.out.println(list1);
            Collections.sort(list1);
            minValue1 = (int) list1.get(0);
            System.out.println("Рэд собрал " + minValue1 + " роботов");
        }

        for (String x : listForBlue) {
            if (!x.isEmpty()) {
                Integer num = mapForBlue.get(x);
                if (num == null) {
                    num = 0;
                }
                mapForBlue.put(x, ++num);
            }
        }
        System.out.println("Детали Блу: " + mapForBlue);

        if (mapForBlue.size() < BasicArray.length) {
            System.out.println("Блу собрал 0 роботов");
        } else if (mapForBlue.size() == BasicArray.length) {
            List list1 = new ArrayList(mapForBlue.values());
            System.out.println(list1);
            Collections.sort(list1);
            minValue2 = (int) list1.get(0);
            System.out.println("Блу собрал " + minValue2 + " роботов");
        }
        if (minValue1 > minValue2) {
            System.out.println("Победил Рэд!!! Теперь он может завалит весь город робатами!");
        } else if (minValue1 < minValue2) {
            System.out.println("Победил Блу!!! Какая радость!");
        } else if (minValue1 == minValue2) {
            System.out.println("Победила дружба!!!");
        }
    }
}