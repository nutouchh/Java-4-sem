package pract8.ChainOfResponsibility;

public class Money {
    private int amt;
    public Money(int amt){
        setAmt(amt);
    }
    public int getAmt(){
        return amt;
    }

    public void setAmt(int amt) {
        if (amt > 0 && amt <= 200000 && amt % Note.R100 == 0) {
            this.amt = amt;
        }
        else {
            throw new RuntimeException("Сумма денег должна быть не больше 100 000 и кратна 100");
        }
    }
}
