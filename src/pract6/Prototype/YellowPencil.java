package pract6.Prototype;

public class YellowPencil extends Pencil{

    public YellowPencil() {
        this.colorName="yellow";
    }

    @Override
    void addColor() {
        System.out.println("Drawing yellow");
    }
}