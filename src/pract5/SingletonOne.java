package pract5;

public class SingletonOne {

//    простой способ без потокобезопасности
    private static SingletonOne inst;

    private SingletonOne() {}

    public static SingletonOne getInstance() {
        if (inst == null) {
            inst = new SingletonOne();
        }
        return inst;
    }
}
