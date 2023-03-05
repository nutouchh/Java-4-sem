package pract5;

// Простая реализация, переменная inst должна быть либо final, либо volatile.
public class SingletonThree {
    private SingletonThree() {
    }

    private static class SingletonHolder {
        public static final SingletonThree holderInst = new SingletonThree();
    }

    public static SingletonThree getInstance() {
        return SingletonHolder.holderInst;
    }

}