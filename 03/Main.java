class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;
    

    //constructor
    BankAccount(int accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    //getter
    int getAccountNumber(){
        return accountNumber;
    }
    String getAccountHolder(){
        return accountHolder;
    }
    double getBalance(){
        return balance;
    }

    //setter
    void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }
    void setBalance(double balance){
        this.balance=balance;
    }

    //withdraw money
    void withdraw(double amount){
        if(amount>balance){
            throw new IllegalArgumentException( "Insufficient balance");
        }
        balance -=amount; 
    }
}

class Bank{
    private BankAccount[] accounts;
    private int accountCount;

    Bank(){
        accounts=new BankAccount[5];
        accountCount=0;
    }

    //Add new bank account
    void addAccount(BankAccount account){
        if(accountCount<accounts.length){
            accounts[accountCount]=account;
            accountCount++;
        }
        else{
            System.out.println("Cannot add more accounts. Bank is full.");
        }
    }

    //withdraw money using account number
    void withdrawFromAccount(int accountNumber, double amount){
        for(int i=0;i<accountCount;i++){
            if (accounts[i].getAccountNumber() == accountNumber){
                try{
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawn " + amount + " from account " + accountNumber);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account number " + accountNumber + " not found.");
    }


    //display details
    void displayAllAccounts(){
        if(accountCount==0){
            System.out.println("No accounts to display.");
        }
        else{
            System.out.println("Account Number\tHolder\tBalance");
            for (int i = 0; i < accountCount; i++){
                System.out.println(accounts[i].getAccountNumber()+"\t\t"+accounts[i].getAccountHolder()+"\t"+accounts[i].getBalance());
            }
        }
    }
}


 class Main{
    public static void main(String[] args){
      

        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        // Withdraw unvalid amount
        bank.withdrawFromAccount(1001, 6000.0);

        // Withdraw valid amount
        bank.withdrawFromAccount(1002, 1000.0);

        // Display all accounts
        System.out.println("\nAll Bank Accounts:");
        bank.displayAllAccounts();

    }
}