package pract6.Factory;

// Паттерн «Фабричный метод» – определяет интерфейс создания
//        объектов, позволяя подклассам менять тип создаваемых объектов

public class AppFactory {
    public static void main(String[] args) {
        FactoryCreator sport = new SportCarCreator();
        sport.doCar();

        FactoryCreator uni = new UniversalCarCreator();
        uni.doCar();
    }
}
