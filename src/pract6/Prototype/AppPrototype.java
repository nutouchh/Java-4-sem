package pract6.Prototype;

//Прототип – это порождающий паттерн проектирования,
// который позволяет копировать объекты, не вдаваясь в подробности их реализации.

public class AppPrototype {
    public static void main(String[] args) {
        PencilStore.getPencil("blue").addColor();
        PencilStore.getPencil("yellow").addColor();
        PencilStore.getPencil("blue").addColor();
        PencilStore.getPencil("yellow").addColor();
    }
}
