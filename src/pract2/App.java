package pract2;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Comparator;

public class App {

    public static Stream<Human> HumanStream() {
        List<Human> input = new ArrayList<>();
        input.add(new Human(19, "Ann", "Lalallaa", LocalDate.of(2030, 01, 01), 10));
        input.add(new Human(20, "Vlad", "Dasdg", LocalDate.of(2003, 04, 10), 45));
        input.add(new Human(65, "Qwer", "Asfghh", LocalDate.of(1992, 11, 06), 40));
        input.add(new Human(35, "Ale", "Kjhgf", LocalDate.of(1980, 05, 03), 62));
        input.add(new Human(30, "Vlkf", "Njfdlds", LocalDate.of(1994, 02, 01), 550));
        Stream<Human> stream = input.stream();
        return stream;
    }

    public void printHuman(Stream<Human> temp) {
        temp.forEach(System.out::println);
    }

    //сортировка по возрасту
    public void sortByAge(Stream<Human> stream) {
        stream.sorted((human1,human2)-> (Integer.compare((Integer) human1.getAge(), (Integer) human2.getAge()))
        ).forEach(System.out::println);
    }

    //Фильтр < 20
    public void filterByAge(Stream<Human> stream){
        stream.filter(human -> human.getAge() < 20)
                .sorted(Comparator.comparingInt(Human::getAge))
                .forEach(System.out::println);
    }

    // Фильтр "в имени есть буква "е""
    public void filterByName(Stream<Human> stream){
        stream.filter(human -> human.getFirstName().contains("e"))
                .forEach(System.out::println);
    }

    public void concName(Stream<Human> stream){
        StringBuilder output = new StringBuilder();
        stream.forEach(human -> {output.append(human.getFirstName().charAt(0));});
        System.out.println(output);
    }


}
