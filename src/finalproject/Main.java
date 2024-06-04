package finalproject;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a Bank
        Bank bank = new Bank();

        // Create Clients
        Client client1 = new Client("111-22-3333", "Alice", "Johnson");
        Client client2 = new Client("444-55-6666", "Bob", "Smith");

        // Create BankAccounts for the Clients
        BankAccount account1 = new BankAccount(1, 1234, 1000.0, 0.05);
        BankAccount account2 = new BankAccount(2, 5678, 2000.0, 0.03);

        // Add Clients to the BankAccounts
        account1.addHolder(client1);
        account2.addHolder(client2);

        // Add BankAccounts to the Bank
        bank.createAccount(account1);
        bank.createAccount(account2);

        // Test methods in Bank class
        System.out.println("Testing Bank methods:");
        System.out.println("Retrieve account by SSN: " + bank.getAccountBySSN("111-22-3333"));
        System.out.println("Retrieve account by name: " + bank.getAccountByName("Alice Johnson"));
        System.out.println("Retrieve account by account number: " + bank.getAccountByAccountNumber(1));
        bank.listAllAccounts();

        // Test methods in BankAccount class
        System.out.println("\nTesting BankAccount methods:");
        System.out.println("Balance before deposit: " + account1.getBalance());
        account1.deposit(500.0);
        System.out.println("Balance after deposit: " + account1.getBalance());
        System.out.println("Balance before withdrawal: " + account1.getBalance());
        account1.withdraw(200.0);
        System.out.println("Balance after withdrawal: " + account1.getBalance());

        // Test methods in Client class
        System.out.println("\nTesting Client methods:");
        System.out.println("SSN: " + client1.getSsn());
        System.out.println("First Name: " + client1.getFirstName());
        System.out.println("Last Name: " + client1.getLastName());

        // Test methods in Person class
        System.out.println("\nTesting Person methods:");
        Person person = new Person("111-22-3333", "Alice", "Johnson", LocalDate.of(1990, 5, 15), "123 Main St");
        System.out.println("SSN: " + person.getSsn());
        System.out.println("First Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Date of Birth: " + person.getDob());
        System.out.println("Address: " + person.getAddress());
    }
}
