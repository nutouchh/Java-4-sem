package pract2;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        App testHuman = new App();
        Stream<Human> listHuman =  App.HumanStream();
        testHuman.printHuman(listHuman);
        System.out.println();

        listHuman =  App.HumanStream();
        testHuman.sortByAge(listHuman);
        System.out.println();

        listHuman =  App.HumanStream();
        testHuman.filterByAge(listHuman);
        System.out.println();

        listHuman =  App.HumanStream();
        testHuman.filterByName(listHuman);
        System.out.println();

        listHuman =  App.HumanStream();
        testHuman.concName(listHuman);
    }
}
