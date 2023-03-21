public class BankAccount {
    private String name;
    private final String accountNumber;
    private final String idNumber;
    private String phoneNumber;
    private String address;
    private double balance;

    public BankAccount(String accName, String accNumber, String accIdNumber, double openingBalance) // constructor
    {
        name = accName;
        accountNumber = accNumber;
        idNumber = accIdNumber;
        balance = openingBalance;
        phoneNumber = "0";
        address = "";
    }
    public BankAccount(String accName, String accNumber, long accIdNumber, double openingBalance) // constructor overload if accIdNumber is long type value
    {
        name = accName;
        accountNumber = accNumber;
        idNumber = String.valueOf(accIdNumber);
        balance = openingBalance;
        phoneNumber = "0";
        address = "";
    }
    //Getters
    public double GetBalance() {
        return balance;
    }

    public String GetName() {
        return name;
    }

    public String GetAccountNumber() {
        return accountNumber;
    }

    public String GetIDNumber() {
        return idNumber;
    }

    public String GetPhoneNumber() {
        return phoneNumber;
    }
    public String GetAddress() {
        return address;
    }
    //Setters

    public void SetName(String newName) {
        name = newName;
    }

    public void SetPhoneNumber(String newPhoneNumber) {
        if(CheckIfOnlyNumber(newPhoneNumber))
            phoneNumber = newPhoneNumber;
        else{
            System.out.println("Error: Phone number must contain only digits.");
        }
    }

    public void SetAddress(String newAddress) {
        address = newAddress;
    }

    public void deposit(double amount)        // makes deposit
    {
        if (amount > 0) {
            balance = balance + amount;
            return;
        }
        System.out.println("Error : The amount is not positive or is greater than the current balance.");
    }

    public void withdraw(double amount)       // makes withdrawal
    {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
            } else {
                System.out.println("Error : The amount is not positive or is greater than the current balance.");
            }
            return;
        }
        System.out.println("Error : The amount is not positive or is greater than the current balance.");
    }

    public String toString()                     // displays balance
    {
        return "Account name : " + name + " and Current balance: " + balance+"TL";
    }

    public void transfer(BankAccount accountToSend, double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Error : The amount is not positive or is greater than the current balance.");
            return;
        }
        withdraw(amount);
        accountToSend.deposit(amount);
    }
    private boolean CheckIfOnlyNumber(String phoneNumberToCheck){

        for (int i = 0; i < phoneNumberToCheck.length(); i++) {
            if (!Character.isDigit(phoneNumberToCheck.charAt(i)))
            {
                if(phoneNumberToCheck.charAt(i) != '+')
                    return false;
            }
        }
        return true;
    }
}
