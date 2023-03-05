package pract6.Builder;

public class Director {

    public void constructorRooms(HouseBuilder houseBuilder){
        houseBuilder.buildBathroom();
        houseBuilder.buildKitchen();
    }
}
