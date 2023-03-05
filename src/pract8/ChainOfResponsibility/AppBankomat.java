package pract8.ChainOfResponsibility;

// Паттерн «Цепочка обязанностей» позволяет передавать запросы по специальной цепочке обработчиков

public class AppBankomat {
    public static void main(String[] args) {
        NoteModule5000 noteModule5000 = new NoteModule5000();
        NoteModule1000 noteModule1000 = new NoteModule1000();
        NoteModule500 noteModule500 = new NoteModule500();
        NoteModule100 noteModule100 = new NoteModule100();

        noteModule5000.setNextMoneyModule(noteModule1000);
        noteModule1000.setNextMoneyModule(noteModule500);
        noteModule500.setNextMoneyModule(noteModule100);

        noteModule5000.takeMoney(new Money(146700));


    }
}
