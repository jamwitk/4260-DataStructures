public class Main {
    public static void main(String[] args) {
//a
        var firstBankAccount = new BankAccount("Jamshid","123455","12345678910",100);
        var secondBankAccount = new BankAccount("Metin","123456","12345678222",500);
//b
        System.out.println(firstBankAccount);
//c
        System.out.println(firstBankAccount.GetIDNumber()+" "+firstBankAccount.GetPhoneNumber()+" "+firstBankAccount.GetAddress());
//d
        firstBankAccount.SetAddress("Davutpaşa Mahallesi");
        firstBankAccount.SetPhoneNumber("+9012342123312");
//e
        firstBankAccount.SetName("Jamshid Abdukarimov");
//f
        System.out.println(firstBankAccount);
//g
        System.out.println(firstBankAccount.GetIDNumber()+" "+firstBankAccount.GetPhoneNumber()+" "+firstBankAccount.GetAddress());
//h
        System.out.println("Account Name: "+secondBankAccount.GetName()+" and Current Balance: "+secondBankAccount.GetBalance());
//i
        firstBankAccount.deposit(-200);
//j
        firstBankAccount.deposit(150);
//k
        System.out.println(firstBankAccount.GetBalance());
        //l
        secondBankAccount.withdraw(-200);
        //m
        secondBankAccount.withdraw(1000);
        //n
        secondBankAccount.withdraw(150);
        //o
        System.out.println(secondBankAccount.GetBalance());
        //p
        firstBankAccount.transfer(secondBankAccount, -200);
        //q
        firstBankAccount.transfer(secondBankAccount, 1000);
        //r
        firstBankAccount.transfer(secondBankAccount, 100);

        System.out.println("First account: "+firstBankAccount.GetBalance());
        System.out.println("Second account: "+secondBankAccount.GetBalance());
    }
}

//çok iyi lan istersen
//aynı anda yazıyoz offf
// coderız abi
//
//zoom gibi ekran veya kameralı konusma da yapabilirsin.
//call'a katılasana
