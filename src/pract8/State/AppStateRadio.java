package pract8.State;

public class AppStateRadio {
    public static void main(String[] args) {
        Station radio = new RadioOne();
        ContextRadio conRad  = new ContextRadio();
        conRad.setStation(radio);

        for (int i = 0; i < 10; i++){
            conRad.play();
            conRad.nextStation();
        }
    }
}
