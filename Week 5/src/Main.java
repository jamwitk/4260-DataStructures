public class Main {
    public static void main(String[] args) {
        //1-) REGION
        System.out.println("1-) REGION");
        LinkList newLinkList = new LinkList();
        newLinkList.insertFirst(1,30);
        newLinkList.insertFirst(7,31);
        newLinkList.insertFirst(2,32);
        newLinkList.insertFirst(3,33);

        newLinkList.displayList();
        newLinkList.delete(1);

        newLinkList.displayList();
        newLinkList.delete(3);

        newLinkList.displayList();
        newLinkList.delete(1);

        newLinkList.displayList();
        newLinkList.delete(7);

        newLinkList.displayList();
        //2-) REGION
        System.out.println("2-) REGION");
        FirstLastList newFirstLastList = new FirstLastList();
        newFirstLastList.insertFirst(1);
        newFirstLastList.insertFirst(2);
        newFirstLastList.insertFirst(3);
        newFirstLastList.insertFirst(4);
        newFirstLastList.insertFirst(5);
        newFirstLastList.displayList();
        newFirstLastList.deleteLasts();
        newFirstLastList.displayList();
        //3-) REGION
        System.out.println("3-) REGION");
        System.out.println("Last Integer using Doubly Linked List:");
        System.out.println(lastInteger(10,6));
        //4-) REGION
        System.out.println("4-) REGION");
        System.out.println("Last Integer using Array:");
        System.out.println(lastInteger2(10,6));
    }
    public static int lastInteger(int n, int k) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for (int i = 1; i <= n; i++) { //Insert the numbers from 1 to n
            doublyLinkedList.insertLast(i);
        }

        boolean moveForward = true;
        int counter = 0;
        dLink current = doublyLinkedList.first;
        dLink next = null;

        while(!doublyLinkedList.isEmpty()){ //While the list is not empty
            if(moveForward){
                next = current.next;
                if (next == null) { //If the next is null, then the current is the last element
                    next = current.previous;
                    moveForward = false;
                }
            }
            else{
                next = current.previous;
                if (next == null) {
                    next = current.next;
                    moveForward = true;
                }
            }
            counter++;
            if(counter == k){
                doublyLinkedList.deleteKey(current.dData);
                counter = 0;
            }
            current = next;
            if(next == null) //If the next is null, then there is the last element
                break;
        }
        return (int) doublyLinkedList.deleteFirst().dData; // there is only one element left, so return it
    }
    public static int lastInteger2(int n, int k) {
        int[] array = new int[n]; //Create an array of size n
        for (int i = 0; i < n; i++) { //Fill the array with numbers from 1 to n
            array[i] = i + 1;
        }
        boolean forward = true;
        int counter = 0;
        int index = 0;
        int next = 0;
        int zeroCounter = 0;
        int lastNonZero = 0;
        while(zeroCounter < n-1){
            if(forward){
                next = (index + 1);
                if (next == n) {
                    forward = false;
                    next = index - 1;
                }
            }
            else{
                next = (index - 1);
                if (next == -1) {
                    forward = true;
                    next = index + 1;
                }
            }

            if(array[index] != 0)
            {
                //If we don't check the last nonzero,then in the case of 0,0,3,4,5,0,0: It counts 3 twice. 5,4,3,0,0,0,3,4.
                if(lastNonZero != array[index])
                    counter++;
                lastNonZero = array[index];

                if(counter == k){
                    array[index] = 0;
                    counter = 0;
                    zeroCounter++;
                }
            }
            index = next;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0)
                return array[i]; //There is only one element left, so return it
        }
        return -1;
    }

}


class Link
{
    public int iData;              // data item (key)
    public double dData;           // data item
    public Link next;              // next link in list
    // -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;
        dData = dd;
    }
    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first;            // ref to first link on list

    // -------------------------------------------------------------
    public LinkList()              // constructor
    {
        first = null;               // no links on list yet
    }
    // -------------------------------------------------------------
    public void insertFirst(int id, double dd)
    {                           // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }
    // -------------------------------------------------------------
    public Link find(int key)      // find link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // start at 'first'
        while(current.iData != key)        // while no match,
        {
            if(current.next == null)        // if end of list,
                return null;                 // didn't find it
            else                            // not end of list,
                current = current.next;      // go to next link
        }
        return current;                    // found it
    }
    // -------------------------------------------------------------
    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        //Link current = first;              // search for link
        Link previous = first;
        if(first.iData == key)
        {
            first = first.next;
            return previous;
        }
        while(previous.next.iData != key)
        {
            if(previous.next.next == null)
                return null;                 // didn't find it
            else
            {
                previous = previous.next;          // go to next link
            }
        }
        if(previous.next == first)              // found it; first link?
            first = first.next;            // first --> old next
        else                               // not first link
            previous.next = previous.next.next;  // bypass it
        return previous.next;


    }
    // -------------------------------------------------------------
    public void displayList()      // display the list
    {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class LinkList

class fLink
{
    public long dData;                 // data item
    public fLink next;                  // next link in list
    // -------------------------------------------------------------
    public fLink(long d)                // constructor
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()          // display this link
    {
        System.out.print(dData + " ");
    }
// -------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////
class FirstLastList
{
    private fLink first;               // ref to first link
    private fLink last;                // ref to last link
    // -------------------------------------------------------------
    public FirstLastList()            // constructor
    {
        first = null;                  // no links on list yet
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    { return first==null; }
    // -------------------------------------------------------------
    public void insertFirst(long dd)  // insert at front of list
    {
        fLink newLink = new fLink(dd);   // make new link

        if( isEmpty() )                // if empty list,
            last = newLink;             // newLink <-- last
        newLink.next = first;          // newLink --> old first
        first = newLink;               // first --> newLink
    }
    // -------------------------------------------------------------
    public void insertLast(long dd)   // insert at end of list
    {
        fLink newLink = new fLink(dd);   // make new link
        if( isEmpty() )                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
    }
    // -------------------------------------------------------------
    public long deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        long temp = first.dData;
        if(first.next == null)         // if only one item
            last = null;                // null <-- last
        first = first.next;            // first --> old next
        return temp;
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        fLink current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println();
    }
    public void deleteLasts(){
        fLink current = first;
        while(current.next != last){
            current = current.next;
        }
        last = current;
        last.next = null;
    }
// -------------------------------------------------------------
}

class dLink
{
    public long dData;                 // data item
    public dLink next;                  // next link in list
    public dLink previous;              // previous link in list
    // -------------------------------------------------------------
    public dLink(long d)                // constructor
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()          // display this link
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}  // end class Link
////////////////////////////////////////////////////////////////
class DoublyLinkedList
{
    public  dLink first;               // ref to first item
    public dLink last;                // ref to last item
    // -------------------------------------------------------------
    public DoublyLinkedList()         // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    { return first==null; }
    // -------------------------------------------------------------
    public void insertFirst(long dd)  // insert at front of list
    {
        dLink newLink = new dLink(dd);   // make new link

        if( isEmpty() )                // if empty list,
            last = newLink;             // newLink <-- last
        else
            first.previous = newLink;   // newLink <-- old first
        newLink.next = first;          // newLink --> old first
        first = newLink;               // first --> newLink
    }
    // -------------------------------------------------------------
    public void insertLast(long dd)   // insert at end of list
    {
        dLink newLink = new dLink(dd);   // make new link
        if( isEmpty() )                // if empty list,
            first = newLink;            // first --> newLink
        else
        {
            last.next = newLink;        // old last --> newLink
            newLink.previous = last;    // old last <-- newLink
        }
        last = newLink;                // newLink <-- last
    }
    // -------------------------------------------------------------
    public dLink deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        dLink temp = first;
        if(first.next == null)         // if only one item
            last = null;                // null <-- last
        else
            first.next.previous = null; // null <-- old next
        first = first.next;            // first --> old next
        return temp;
    }
    // -------------------------------------------------------------
    public dLink deleteLast()          // delete last link
    {                              // (assumes non-empty list)
        dLink temp = last;
        if(first.next == null)         // if only one item
            first = null;               // first --> null
        else
            last.previous.next = null;  // old previous --> null
        last = last.previous;          // old previous <-- last
        return temp;
    }
    // -------------------------------------------------------------
    // insert dd just after key
    public boolean insertAfter(long key, long dd)
    {                              // (assumes non-empty list)
        dLink current = first;          // start at beginning
        while(current.dData != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if(current == null)
                return false;            // didn't find it
        }
        dLink newLink = new dLink(dd);   // make new link

        if(current==last)              // if last link,
        {
            newLink.next = null;        // newLink --> null
            last = newLink;             // newLink <-- last
        }
        else                           // not last link,
        {
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current;    // old current <-- newLink
        current.next = newLink;        // old current --> newLink
        return true;                   // found it, did insertion
    }
    // -------------------------------------------------------------
    public dLink deleteKey(long key)   // delete item w/ given key
    {                              // (assumes non-empty list)
        dLink current = first;          // start at beginning
        while(current.dData != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if(current == null)
                return null;             // didn't find it
        }
        if(current==first)             // found it; first item?
            first = current.next;       // first --> old next
        else                           // not first
            // old previous --> old next
            current.previous.next = current.next;

        if(current==last)              // last item?
            last = current.previous;    // old previous <-- last
        else                           // not last
            // old previous <-- old next
            current.next.previous = current.previous;
        return current;                // return value
    }
    // -------------------------------------------------------------
    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        dLink current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            current.displayLink();      // display data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        dLink current = last;           // start at end
        while(current != null)         // until start of list,
        {
            current.displayLink();      // display data
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }

// -------------------------------------------------------------
}