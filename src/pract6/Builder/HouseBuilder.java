package pract6.Builder;

public class HouseBuilder implements Builder{

    private String bathroom;
    private String kitchen;

    @Override
    public void buildBathroom() {
        bathroom = "eee, Im built and Im bathroom";
    }

    @Override
    public void buildKitchen() {
        kitchen = "eee, Im built and Im kitchen";
    }

    public String getBathroom() {
        return bathroom;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getResult() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Итого построено: \n" +
                "bathroom='" + bathroom + '\'' +
                ",\nkitchen='" + kitchen + '\'';
    }
}
