package pract7.Composite;

// Паттерн «Компоновщик» позволяет сгруппировать множество
//        объектов в древовидную структуру

public class AppComposite {
    public static void main(String[] args) {
        Shape c1 = new Circle();
        Shape c2 = new Circle();
        Shape c3 = new Circle();

        Shape s1 = new Square();

        Shape t1 = new Triangle();
        Shape t2 = new Triangle();

        Composite com = new Composite();
        Composite com1 = new Composite();
        Composite com2 = new Composite();

        com1.addComponent(c1);
        com1.addComponent(c2);
        com1.addComponent(c3);

        com2.addComponent(s1);
        com2.addComponent(t1);
        com2.addComponent(t2);

        com.addComponent(com2);
        com.addComponent(com1);

        com.draw();

    }
}
