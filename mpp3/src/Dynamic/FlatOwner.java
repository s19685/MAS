package Dynamic;

public class FlatOwner extends Person{

    private String accountNumber;

    public FlatOwner(Person p, String accountNumber) {
        super(p.getFirstName(), p.getLastName());
        this.accountNumber = accountNumber;
        p = null;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getAccountNumber();
    }
}
