package pract6.Factory;

public abstract class FactoryCreator {
    public CarProduct doCar(){
        CarProduct car = createCar();
        car.speed();
        return  car;
    }
    protected abstract CarProduct createCar();
}
