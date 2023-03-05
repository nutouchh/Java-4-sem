package pract8.State;

public class ContextRadio {
    Station station;
    void setStation(Station st){
        station = st;
    }

    void nextStation(){
        if (station instanceof RadioOne){
            setStation(new RadioTwo());
        }
        else if (station instanceof RadioTwo){
            setStation(new RadioThree());
        }
        else if (station instanceof RadioThree){
            setStation(new RadioOne());
        }
    }

    void play(){
        station.play();
    }

}
