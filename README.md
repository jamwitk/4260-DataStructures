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
error message indicating that the amount deposited should be positive and hence the deposit operation
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

---
## Week 2 Homework Assignment

**(Programming Assignment)**

**(1)** To the HighArray class, add a method called getMinIndex() that takes two parameters, lowIndex
and highIndex, and returns the index of the item with the smallest key in the array among all the items
whose indices are between lowIndex and highIndex inclusive. You may assume that all the keys in the
array are positive integers less than 1000. For example, if an array holds items with the keys 6 7 1 5 9
3 2 8 4 then getMinIndex(3,7) should return 6 because among the keys 5 9 3 2 8 the smallest one is 2
and the index of the item with this key is 6. If lowIndex is greater than highIndex, or there are no items
between these two indices inclusive, then the method should return -1.

**(2)** To the HighArray class, add a method called placeMin() that takes two parameters, lowIndex
and highIndex, and by using the getMinIndex() method, rearranges the items whose indices are between
lowIndex and highIndex inclusive so that the item with the smallest key in this range is placed at index
lowIndex. For example, if an array holds items with the keys 6 7 1 5 9 3 2 8 4 then placeMin(3,7) should
place the item with key 2 in index position 3 and place the items with keys 5 9 3 8 in index positions
4, 5, 6 and 7 in some order. If lowIndex is greater than highIndex, or there are no items between these
two indices inclusive, the method should perform nothing.


**(3)** To the HighArray class, add a method called sort() that sorts the items in the array according
to their key values by repeatedly using the placeMin() method in a loop.

**(4)** To the HighArray class, add a method called removeDuplicates() that removes all duplicates
from the array. As k starts from index 0 and goes through all items in the array, the method should
compare the item at index k with all the items from index k + 1 to the end, and keys of the items which
have the same key as the item at index k should be changed to -1. If the key of the item at index k itself
has already been changed to -1 then this item will be skipped without making any comparisons. The
method should finally run through all items again and remove the ones with key -1.


**(5)** To the OrdArray class, add a method called removeDuplicates() that removes all duplicates
from the array. The running time of your method should be O(N), where N is the number of items in
the array.

**(6)** Add statements into the main() method of your Main class for testing all of the methods above.
You should test as many different cases as possible.

