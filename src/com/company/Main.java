package com.company;

class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(String message)
    {
        super(message);
    }
}

class Account{
    String owner;
    int balance;
    int accountNumber;

    public Account(String owner, int balance, int accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void wykonaniePrzelewu(int transfer) throws NotEnoughMoneyException{
        if (balance >= transfer){
            balance = balance - transfer;
        }else{
            System.out.println("Za mało środków na koncie, nie udało się wykonać przelewu");
            throw new NotEnoughMoneyException("Za mało środków na koncie");
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account account1 = new Account("Kowalski Bartosz", 1000, 12435);

        try{
            account1.wykonaniePrzelewu(1100);
        }catch (NotEnoughMoneyException e){
            System.out.println(e);
            e.printStackTrace();
        }finally {
            System.out.println("Środki na koncie: " + account1.getBalance());
        }
    }
}
