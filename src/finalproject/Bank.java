package finalproject;

import java.util.Vector;

public class Bank {
    private Vector<BankAccount> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void createAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccountBySSN(String ssn) {
        for (BankAccount account : accounts) {
            for (Client holder : account.getHolders()) {
                if (holder.getSsn().equals(ssn)) {
                    return account;
                }
            }
        }
        return null;
    }

    public BankAccount getAccountByName(String name) {
        for (BankAccount account : accounts) {
            for (Client holder : account.getHolders()) {
                String holderName = holder.getFirstName() + " " + holder.getLastName();
                if (holderName.equalsIgnoreCase(name)) {
                    return account;
                }
            }
        }
        return null;
    }

    public BankAccount getAccountByAccountNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountId() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void updateAccount(BankAccount account, double depositAmount, double withdrawAmount, Client newPrimaryHolder) {
        // Update balance by depositing and withdrawing amounts
        if (depositAmount > 0) {
            account.deposit(depositAmount);
            System.out.println("Deposited: " + depositAmount);
        }
        if (withdrawAmount > 0) {
            account.withdraw(withdrawAmount);
            System.out.println("Withdrawn: " + withdrawAmount);
        }

        // Change the primary holder
        if (newPrimaryHolder != null && account.getHolders().contains(newPrimaryHolder)) {
            // Swap the new primary holder with the current primary holder
            Client currentPrimaryHolder = account.getHolders().get(0);
            int index = account.getHolders().indexOf(newPrimaryHolder);
            account.getHolders().set(0, newPrimaryHolder);
            account.getHolders().set(index, currentPrimaryHolder);
            System.out.println("Primary holder changed to: " + newPrimaryHolder.getFirstName() + " " + newPrimaryHolder.getLastName());
        }

        // Other update operations such as changing account holder's name, address, phone number, etc.
        // Implement as needed
    }


    public void deleteAccount(BankAccount account) {
        accounts.remove(account);
    }

    public void listAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}

