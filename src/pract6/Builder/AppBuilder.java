package pract6.Builder;

// Паттерн «Строитель» – разделяет создание объекта на отдельные
//        шаги, а также позволяет использовать один и тот же код создания для
//        получения различных представлений (Н* современный дом и старый дом)

public class AppBuilder {
    public static void main(String[] args) {
        Director director = new Director();
        HouseBuilder hb = new HouseBuilder();

        director.constructorRooms(hb);

        System.out.println(hb.getResult());
    }
}

