package pract6.Factory;

public class UniversalCarCreator extends FactoryCreator{
    @Override
    protected CarProduct createCar() {
        return new UniversalCar();
    }
}
