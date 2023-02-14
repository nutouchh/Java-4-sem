package pract3;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App  {


//    программа из теоретической части практики
//
//    static volatile int buf;
//    private static final Semaphore semaphore = new Semaphore(1);
//    static void increment() {
//        try {
//            semaphore.acquire();
//            buf++;
//            semaphore.release();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//

//    private static final Lock lock = new ReentrantLock();
//
//    static void increment() {
//        lock.lock();
//        buf++;
//        lock.unlock();
//    }




//    synchronized static void increment() {
//        buf++;
//    }
//
//    public static void main(String[] args) throws Exception {
//        buf = 0;
//        Thread one = new Thread(()->{
//            for (int i = 0; i < 5000; i++) {
//                increment();
//            }
//        });
//        Thread two = new Thread(()->{
//            for (int i = 0; i < 5000; i++) {
//                increment();
//            }
//        });
//        one.start();
//        two.start();
//        Thread.sleep(3000);
//        System.out.println(buf);
//    }

    public static void main(String[] args) throws Exception {

        if (false){

            Set<Integer> setWithout = new HashSet<>();
            SetSemaphore<Integer> setWith = new SetSemaphore<>();

//      Проделаем одинаковые действия с двумя множествами:
//      без потокобезопасности и с ней.

//      БЕЗ ПБ

            Thread one = new Thread(()->{
                for (int i = 0; i < 5000; i++) {
                    setWithout.add(i);
                }
            });
            Thread two = new Thread(()->{
                for (int i = 5000; i < 10000; i++) {
                    setWithout.add(i);
                }
            });
            one.start();
            two.start();
            Thread.sleep(3000); // остановка проги на 3 сек

            System.out.println("Значение размера контейнера без ПБ, правильное = 10000:");
            System.out.println(setWithout.size());

//      на выходе постоянно получаем разное значение размера контейнера, даже с большой остановкой


//      С ПБ

            Thread three = new Thread(()->{
                for (int i = 0; i < 5000; i++) {
                    setWith.add(i);
                }
            });
            Thread four = new Thread(()->{
                for (int i = 5000; i < 10000; i++) {
                    setWith.add(i);
                }
            });
            three.start();
            four.start();
            Thread.sleep(100); // остановка проги на 0.1 сек

            System.out.println("Значение размера контейнера с ПБ, правильное = 10000:");
            System.out.println(setWith.size());

//      на выходе ОДИНАКОВОЕ значение размера контейнера, даже с небольшой остановкой

        }
        else {

            List<Integer> listWithout = new LinkedList<>();
            ListLock<Integer> listLockWith = new ListLock<>();

//      Проделаем одинаковые действия с двумя списками:
//      без потокобезопасности и с ней.

//      БЕЗ ПБ

            Thread one = new Thread(()->{
                for (int i = 0; i < 5000; i++) {
                    listWithout.add(i);
                }
            });
            Thread two = new Thread(()->{
                for (int i = 5000; i < 10000; i++) {
                    listWithout.add(i);
                }
            });
            one.start();
            two.start();
            Thread.sleep(3000); // остановка проги на 3 сек

            System.out.println("Значение размера контейнера без ПБ, правильное = 10000:");
            System.out.println(listWithout.size());

//      на выходе постоянно получаем разное значение размера контейнера, даже с большой остановкой


//      С ПБ

            Thread three = new Thread(()->{
                for (int i = 0; i < 5000; i++) {
                    listLockWith.add(i);
                }
            });
            Thread four = new Thread(()->{
                for (int i = 5000; i < 10000; i++) {
                    listLockWith.add(i);
                }
            });
            three.start();
            four.start();
            Thread.sleep(100); // остановка проги на 0.1 сек

            System.out.println("Значение размера контейнера с ПБ, правильное = 10000:");
            System.out.println(listLockWith.size());

//      на выходе ОДИНАКОВОЕ значение размера контейнера, даже с небольшой остановкой
        }


    }
}
