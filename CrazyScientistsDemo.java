import javafx.scene.layout.Priority;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;


/**
 * Created by icons on 26.3.17.
 */
public class CrazyScientistsDemo {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final CountDownLatch countDownLatch2 = new CountDownLatch(3);
        int cycle = 99;
        final CountDownLatch countDownLatch3 = new CountDownLatch(cycle);
        CrazyScientists scientists = new CrazyScientists();


        Thread putFactory1 = new Thread(() -> {
            try {
                scientists.putFirst();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            countDownLatch2.countDown();
        });

        Thread redTake1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                scientists.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch2.countDown();
        });

        Thread blueTake1 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                scientists.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch2.countDown();
        });


        redTake1.setName("Прислужник Рэда");
        blueTake1.setName("Прислужник Блу");
        putFactory1.setPriority(Thread.MAX_PRIORITY);
        redTake1.setPriority(Thread.MIN_PRIORITY);
        blueTake1.setPriority(Thread.MIN_PRIORITY);
        putFactory1.start();
        redTake1.start();
        blueTake1.start();
        redTake1.join();
        blueTake1.join();
        putFactory1.join();
        for (int k = 0; k < cycle; k++) {
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch3.countDown();
            Thread putFactory2 = new Thread(() -> {
                try {
                    scientists.putOther();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
            Thread redTake2 = new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    scientists.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread blueTake2 = new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    scientists.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            blueTake2.setName("Прислужник Блу");
            redTake2.setName("Прислужник Рэда");
            putFactory2.setPriority(Thread.MAX_PRIORITY);
            redTake2.setPriority(Thread.MIN_PRIORITY);
            blueTake2.setPriority(Thread.MIN_PRIORITY);
            putFactory2.start();
            blueTake2.start();
            redTake2.start();
            redTake2.join();
            blueTake2.join();
            putFactory2.join();
        }
        Thread winnerIs = new Thread(() -> {
            try {
                try {
                    countDownLatch3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scientists.winner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        winnerIs.start();
        winnerIs.join();
    }
}