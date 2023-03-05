package pract8.ChainOfResponsibility;

public class NoteModule100 extends NoteModule{
    @Override
    void takeMoney(Money money) {
        int countNode = money.getAmt()/Note.R100;
        int remind = money.getAmt() % Note.R100;
        if (countNode>0){
            System.out.println("Выдано " + countNode + " купюр достоинством " + Note.R100);
        }
        if (remind > 0 && next!=null){
            next.takeMoney(new Money(remind));
        }
    }
}
