package finalproject;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class BankAccount {
    private int accountId;
    private int pin;
    private ArrayList<Client> holders;
    private double balance;
    private Date creationDate;
    private Date lastInterestPaymentDate;
    private double interestRate;

    public BankAccount(int accountId, int pin, double initialBalance, double interestRate) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = initialBalance;
        this.creationDate = new Date();
        this.lastInterestPaymentDate = new Date();
        this.interestRate = interestRate;
        this.holders = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public ArrayList<Client> getHolders() {
        return holders;
    }

    public void setHolders(ArrayList<Client> holders) {
        this.holders = holders;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastInterestPaymentDate() {
        return lastInterestPaymentDate;
    }

    public void setLastInterestPaymentDate(Date lastInterestPaymentDate) {
        this.lastInterestPaymentDate = lastInterestPaymentDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
    public void addHolder(Client holder) {
        // Check if the holder is not already present in the holders list
        if (!holders.contains(holder)) {
            // Add the holder to the list of holders
            holders.add(holder);
            System.out.println("Holder added: " + holder.getFirstName() + " " + holder.getLastName());
        } else {
            System.out.println("Holder already exists.");
        }
    }
    public void payInterest() {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime lastInterestDateTime = LocalDateTime.from(lastInterestPaymentDate.toInstant());
        LocalDateTime currentDateTime = currentDate.atStartOfDay();

        Duration duration = Duration.between(lastInterestDateTime, currentDateTime);
        long daysSinceLastInterest = duration.toDays();

        if (daysSinceLastInterest > 0) {
            double dailyInterestRate = interestRate / 365; // Assuming interest is calculated daily
            double interestEarned = balance * dailyInterestRate * daysSinceLastInterest;
            balance += interestEarned;
            lastInterestPaymentDate = new Date();
            System.out.println("Interest paid: " + interestEarned);
        } else {
            System.out.println("No interest earned since last payment.");
        }
    }

}
