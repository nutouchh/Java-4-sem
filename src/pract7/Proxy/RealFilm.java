package pract7.Proxy;

public class RealFilm implements Film{

    String file;

    public RealFilm(String file) {
        this.file = file;
        load();
    }

    public void load(){
        System.out.println("Загрузка" + file);
    }

    @Override
    public void display() {
        System.out.println("Просмотр" + file);
    }
}
