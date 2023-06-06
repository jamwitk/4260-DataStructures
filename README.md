# 2022 - 2023 Spring MAT4260 Data Structures
 
### Course Objective

To learn data structures such as arrays, stacks, queues, linked lists, binary trees, red-black trees, and some sorting methods.

## Week 1 Homework Assignment

**(Programming Assignment) [100 points]**

**(1)** Modify the BankAccount class given in the textbook as follows:

**(a)** Add the name, account number, Republic of Turkey ID number, and phone number and address of the client as fields to the class.

**(b)** Modify the constructor of the class by adding the name, account number and Republic of Turkey ID number of the client as parameters. The constructor should set the phone number to 0 and address to the empty string.

**(c)** Add methods getBalance(), getName(), getAccountNumber(), getIDnumber(), getPhoneNumber() and getAddress() that return these values.

**(d)** Add methods setName(), setPhoneNumber() and setAddress() that change these values.

**(e)** Modify the method deposit() so that if the parameter amount is negative or 0, it prints an
error message[README.md](README.md) indicating that the amount deposited should be positive and hence the deposit operation
is not performed.

**(f)** Modify the method withdraw() so that if the parameter amount is negative or 0, it prints an
error message like the deposit() method. Also, if the amount to be withdrawn is larger that the current
balance, the method should not perform the withdrawal operation but print an error message indicating
that the current balance is not sufficient.

**(g)** Modify the display() method so that it is called toString() instead, and it returns the name
and account number as well as the current balance.

**(h)** Add a method called transfer() that gets two parameters, one BankAccount object and
one amount, and transfers the amount from the BankAccount object the method is called with to the
BankAccount object in the parameters. As in the withdraw() method, the transfer operation should not
be performed and error messages should be printed if the amount is not positive or is greater than the
current balance.

**(2)**  Write a class called Main so that it performs the following operations in its main method in
the order given:


**(a)** Create two bankAccount objects, first with opening balance 100 TL, and the second with
opening balance 500 TL. You should determine the names, account numbers, and Republic of Turkey
ID numbers of the owners of these accounts yourself.

**(b)** Print the first account (name, account number and balance should be automatically printed
by the toString() method).

**(c)** Print the Republic of Turkey ID number, phone number (which should be 0), and address
(which should be an empty string) of the first account by calling the corresponding getX() methods.

**(d)** Add the address and phone number information to the first account by calling the setPhoneNumber() and setAddress() methods.

**(e)** Change the name of the first account by calling its setName() method.

**(f)** Print the first account again.


**(g)** Print the Republic of Turkey ID number, phone number and address of the first account
again.

**(h)** Print the name and balance of the second account by calling the corresponding getX() methods.

**(i)** Call the deposit() method for depositing -200 TLs to the first account (which should print an
error message).

**(j)** Deposit 150 TLs to the first account.

**(k)** Print the balance of the first account.


**(l)** Call the withdraw() method for withdrawing -200 TLs from the second account (which should
print an error message).

**(m)** Call the withdraw() method for withdrawing 1000 TLs from the second account (which should
also print an error message).

**(n)** Withdraw 150 TLs from the second account.

**(o)** Print the balance of the second account.


**(p)** Call the transfer() method for transferring -200 TLs from the first account to the second
account (which should print an error message).

**(q)** Call the transfer() method for transferring 1000 TLs from the first account to the second
account (which should also print an error message).

**(r)** Transfer 100 TLs from the first account to the second account.

**(s)** Print the balance of both accounts.