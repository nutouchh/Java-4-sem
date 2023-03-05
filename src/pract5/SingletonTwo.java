package pract5;


//пример из методички
public enum SingletonTwo {
    inst;
    public static SingletonTwo getInstance() {
        return inst;
    }
}