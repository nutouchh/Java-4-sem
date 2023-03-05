package pract7.Proxy;

public class ProxyFilm implements Film{

    String file;

//    хранит ссылку на объект RealFilm
    RealFilm realfilm;

    public ProxyFilm(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realfilm == null){
            realfilm = new RealFilm(file);
        }
        System.out.println("Просмотр" + file);
    }
}
