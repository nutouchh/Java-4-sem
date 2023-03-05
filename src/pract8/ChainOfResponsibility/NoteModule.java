package pract8.ChainOfResponsibility;

public abstract class NoteModule{
    protected NoteModule next;
    abstract void takeMoney(Money money);
    void setNextMoneyModule(NoteModule module){
        next = module;
    }

}
