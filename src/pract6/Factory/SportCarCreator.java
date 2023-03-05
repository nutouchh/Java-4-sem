package pract6.Factory;

public class SportCarCreator extends FactoryCreator{
    @Override
    protected CarProduct createCar() {
        return new SportCar();
    }
}
