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

**(6)** Add statements into the main() method of your Main class for testing all the methods above.
You should test as many different cases as possible.

---
## Week 3 Homework Assignment

**(Programming Assignment)**

**(1)** Write a class called ArraySort whose fields and constructor are the same as those of the ArrayBub, ArraySel and ArrayIns classes. Then copy the insert(), display(), bubbleSort(), selectionSort()
and insertionSort() methods from those three classes and paste into the ArraySort class. Do not copy
the swap() method. The swapping operation should be done inside the bubbleSort() and selectionSort()
methods. This class will be essentially the same as those three classes except that it will contain all
three sorting methods.


**(2)** To the ArraySort class, add another sorting method called oddEvenSort() which repeatedly
makes two passes through the array. On the first pass you look at all the pairs of items, a[j] and a[j + 1]
where j is even (j = 0, 2, 4, . . .). If their key values are out of order, you swap them. On the second pass
you do the same for all the odd values (j = 1, 3, 5, . . .). You do these two passes repeatedly until the
array is sorted. You need to figure out how many times to do the two passes.

**(3)** Into each one of the methods bubbleSort(), selectionSort(), insertionSort() and oddEvenSort(),
add statements so that they count the number of comparisons and the number of copies made during
the whole sorting process. Here, checking whether a value is greater than (less than, or equal to) another
value or not counts as one comparison, and writing a value into an array position or into a variable
counts as one copy. Note that the swapping operation requires 3 copies.
These methods will no longer be void methods. They should return an int array of length 2, which
contains the number of comparisons in position 0 and the number of copies in position 1.

**(4)** In the main method of your Main class create an ArraySort object of length 25. Then using
the methods of the Random class, fill every cell of this array with a random integer between 1 and 99,
inclusive, and print the array using its display() method. Then sort this array with the bubbleSort()
method, print the array again and also print the number of comparisons and the number of copies returned
by the sorting method. This process of generating an ArraySort object containing 25 random integers
between 1 and 99, printing it, sorting it with the bubbleSort() method and printing the array again
together with the number of comparisons and the number of copies made during the sorting process should
then be repeat 20 times in a for loop. Finally, compute and print the average number of comparisons
and the average number of copies made by these 20 bubble sort operations.


**(5)** Repeat part (4) for the selectionSort(), insertionSort() and oddEvenSort() methods and compare
the results you obtained. You should write an analysis report for the results you obtained.

---

## Week 4 Homework Assignment

**(Programming Assignment)**

**(1)** In your Main class, write a method called matchIfElse() that takes a String array as a parameter and matches each cell that contain the string “else” with the cell that contain the last unmatched
“if”. The cells in the array that contain a string other than “if” or “else” will be ignored. The method
should print the indices of each “if” without an “else” and each “if-else” pair in the order of the “if” s
appearing in the array. For example, the method should print the following message for the input array
{if, if, while, if, else, for, if, for, else, if, if, else, for, else, while, else, if }:

    if at index 0 has no else clause
    if at index 3 mathches with else at index 4
    if at index 6 mathches with else at index 8
    if at index 9 mathches with else at index 13
    if at index 1 mathches with else at index 15
    if at index 10 mathches with else at index 11
    if at index 16 has no else clause

If the input array contains an “else” which cannot be matched with any “if”, then the method should
print an error message indicating the position of the “else” that caused an error. For example, for the
input array {if, for, else, while, else, if, else}, the method should print “Error: else at index 4 cannot
be matched with any if.”
You should make use of the StackX class in your method. Add statements into your main method
for testing this method.

**(2)** To the Queue class, add a method called itemAtOrder() that takes a positive integer k as a
parameter and returns the k
th item in the queue. (Here, the item in the front is the 1st item). If k ≤ 0
or there are less than k items in the queue, the method should print an error message and return -1. For
example, if the keys of the items in a queue from the front to the rear are 70 30 80 10 80 50, then calling
itemAtOrder(0), itemAtOrder(2), itemAtOrder(6), and itemAtOrder(7) for this queue should return -1,
30, 50, and -1, respectively. Add statements into your main method for testing this method.

**(3)** To the Queue class, add another method called orderOfItem() that takes an integer N of data
type long as a parameter and returns the order of the first item in the queue with key N. If the queue
does not contain an item with key N, the method should print an error message and return -1. For
example, if the keys of the items in a queue from the front to the rear are 70 30 80 10 80 50, then
calling orderOfItem(40) and orderOfItem(80) for this queue should return -1 and 3, respectively. Add
statements into your main method for testing this method.

**(4)** The PriorityQ class features fast removal of the high-priority item but slow insertion of new
items. Modify the PriorityQ class so that it has O(1) insertion time but slower removal of the high priority item.

---

## Week 5 Homework Assignment

**(Programming Assignment)**

**(1)** The delete() method in the LinkList class makes use of references to two Link objects, namely
previous and current. Modify this method so that only one reference to a Link object is used.

**(2)** To the FirstLastList class, add a method called deleteLast() that deletes the last link in the
list.

**(3)** Let n and k be positive integers and consider the list of integers 1, 2, 3, . . . , n. Starting form 1,
you traverse this list of integers forward and backward and delete every k
th integer. When you reach the last integer in the list while moving forward, you turn backward; and when you reach the first integer
in the list while moving backward, you turn forward again.

For example, if n = 10 and k = 6, you first start with the list 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, move forward
and delete 6. Then you traverse 7, 8, 9, 10, 9, 8 and delete 8. Then you traverse 7, 5, 4, 3, 2, 1 and delete 1. Then you traverse 2, 3, 4, 5, 7, 9 and delete 9. Then you traverse 10, 7, 5, 4, 3, 2 and delete 2. Then you
traverse 3, 4, 5, 7, 10, 7 and delete 7. Then you traverse 5, 4, 3, 4, 5, 10 and delete 10. Then you traverse
5, 4, 3, 4, 5, 4 and delete 4. Then you traverse 3, 5, 3, 5, 3, 5 and delete 5. Finally, 3 will be last integer
deleted form the list.

In your Main class, write a method called lastInteger() that takes two positive integers n and k as
parameters, finds and returns the last integer that will be deleted from the list of integers 1, 2, 3, . . . , n
as described above. For example, lastInteger(10,6) should return 3 as explained above. In your method,
you should use a doubly linked list. What will be returned by lastInteger(1000,600)?

**(4)** In your Main class, write a method called lastInteger2() that does exactly the same job as the
lastInteger() method, but uses an array instead of a doubly linked list.

---

## Week 6 Homework Assignment

**(Programming Assignment)**

**(1)** Let a, n and p be positive integers. Write a recursive method for finding a^n (mod p), i.e. the remainder when a^n is divided by p. For example if a = 2, n = 9 and p = 11 the method should return 6. Make sure that the running time of your algorithm is O(log n) and you are able to compute 11^12345 (mod 24683).

**(2)** Let n and k be positive integers. Write a recursive method for listing all k-element subsets of
the set {1, 2, . . . , n}. For example if n = 5 and k = 3 the method should print the sets {1, 2, 3}, {1, 2, 4},
{1, 2, 5}, {1, 3, 4}, {1, 3, 5}, {1, 4, 5}, {2, 3, 4}, {2, 3, 5}, {2, 4, 5}, and {3, 4, 5} in some order.

**(3)** Let n and k be positive integers. Write a recursive method for listing all ways of distributing n
identical balls into k distinct boxes numbered from 1 to k. For example if n = 4 and k = 3 the method
should print the ordered triples (4, 0, 0), (3, 1, 0), (3, 0, 1), (2, 2, 0), (2, 1, 1), (2, 0, 2), (1, 3, 0), (1, 2, 1),
(1, 1, 2), (1, 0, 3), (0, 4, 0), (0, 3, 1), (0, 2, 2), (0, 1, 3), and (0, 0, 4) in some order.

**(4)** Let n be a positive integer. Write a recursive method for listing all ways of writing n as the
sum of a non-increasing sequence of positive integers. For example if n = 5 the method should print the
equations 5 = 5, 5 = 4+ 1, 5 = 3+ 2, 5 = 3+ 1+ 1, 5 = 2+ 2+ 1, 5 = 2+1+ 1+ 1, and 5 = 1+ 1+ 1+1+ 1
in some order.

---

## Week 7 Homework Assignment

**(Programming Assignment)**

**(1)** Let k be a positive integer. Write a recursive method for finding the k-th smallest element in an
integer array by using the partitionIt() method which uses the rightmost element in the array as pivot.

**(2)** As in Homework Assignment 3, for each of the methods shellSort (that uses h = 3 ∗ h + 1
interval sequence) and quickSort1 (that uses the rightmost element as the pivot), add statements so that
they count the number of comparisons and the number of copies made during the whole sorting process

**(3)** Repeat question (4) in Homework assignment 3 for shellSort and quickSort1. Use arrays of
length 100 instead of arrays of length 25 and fill the arrays with random integers between 1 and 999, and
repeat this process 20 times for each sorting method. Do not print the arrays, only print the number of
comparisons and the number of copies made during the sorting processes, and the average values. Write
an analysis report for comparing the results you obtained.