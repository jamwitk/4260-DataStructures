public class Main {
    public static void main(String[] args) {
        //STARTING THE A
        System.out.println("A-)Regular case.");
        matchIfElse(new String[]{"if","for","else","while","else","if","else"});

        System.out.println("A-)The case which there is no if else");
        matchIfElse(new String[]{"for","else","while","else","else"});

        System.out.println("A-)The case which there is only if.");
        matchIfElse(new String[]{"if","if","for"});

        System.out.println("A-)The case which there is only else.");
        matchIfElse(new String[]{"else","while","else"});

        //ENDING THE A

        //STARTING THE B ----------------------

        Queue arrQue = new Queue(6);
        arrQue.insert(70);
        arrQue.insert(30);
        arrQue.insert(10);
        arrQue.insert(10);
        arrQue.insert(80);
        arrQue.insert(50);
        System.out.println("B-) Regular tests.");
        System.out.println(arrQue.itemAtOrder(0)); //Should print "Error: -1"
        System.out.println(arrQue.itemAtOrder(2)); //Should print 30
        System.out.println(arrQue.itemAtOrder(6)); //Should print 50
        System.out.println(arrQue.itemAtOrder(7)); //Should print "Error: -1"
        System.out.println("B-) No items test");
        System.out.println(new Queue(4).itemAtOrder(2)); // should print "Error: -1"

        //ENDING THE B ----------------------

        //STARTING THE C -----------------
        System.out.println("C-)Regular tests.");
        System.out.println(arrQue.orderOfItem(40)); //Should print "Error: -1"
        System.out.println(arrQue.orderOfItem(80)); //Should print 5

        System.out.println("C-)Empty array test. Must Return Error: -1");
        System.out.println(new Queue(5).orderOfItem(40));

        System.out.println("C-)Duplicate elements in array. Must return the first one's order.");
        System.out.println(arrQue.orderOfItem(10));
        //ENDING THE C -------------------
        //STARTING THE D -------------------
        /* In this class, insertion method has O(1) time we insert elements for the last rear.
        [0,1,2,'Insertion place',null,null]
        and
        for the remove method, we're looking for the minimum item from the array. And it takes time.
        Consequently, it works much slower than insertion. It has O(N) time which N is array size.
        * */
        PriorityQ highQueue = new PriorityQ(5);
        highQueue.insert(90);
        highQueue.insert(35);
        highQueue.insert(3);
        System.out.println("Is queue full? "+highQueue.isFull()); //Should print false
        highQueue.insert(10);
        highQueue.insert(20);
        System.out.println("Is queue full? "+highQueue.isFull()); //Should print false

        PriorityQ queue = new PriorityQ(5);
        queue.insert(40);
        queue.insert(10);
        queue.insert(50);
        queue.insert(20);
        queue.insert(30);

        System.out.println(queue.remove()); // should print 10
        System.out.println(queue.remove()); // should print 20
        System.out.println(queue.remove()); // should print 30
        System.out.println(queue.remove()); // should print 40
        System.out.println(queue.remove()); // should print 50
        //ENDING THE D---------------------

    }
    public static void matchIfElse(String[] arr){

        StackX stack = new StackX(arr.length);
        //To show messages in order the if's appearance, we store all messages in String array.
        String[] messages = new String[arr.length];

        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals("if")) // We push if's index to stack.
            {
                stack.push(i);
            }
            else if(arr[i].equals("else") && !stack.isEmpty())// Here we check if any "if" has been pushed before the "else"
            {
                //if yes, we pop "if" from the Stack.
                int index = (int)stack.pop();
                //and we get the index of "if" and push the message to the index.
                messages[index] = "if at index "+index+" matches with else at index "+i;
            }
            else if(arr[i].equals("else") && stack.isEmpty())// Here we check if any "if" has not been pushed before the "else"
            {
                //if yes (there is no "if" in stack), we store the message in index of "else" index.
                messages[i] = "Error: else at index "+i+" cannot be matched with any if";
            }
        }
        //If stack is empty then there is 'if's such that no else clause.
        while (!stack.isEmpty()){
            int index = (int)stack.pop();
            messages[index] = "if at index "+index+" has no else clause";
        }
        //Printing the messages.
        /*

        Ex: ["if at index 6 has no else clause",null,"Error: else at index i cannot be matched with any if",null]
        We skip nulls which means there is no messages.

        */
        for (int i = 0; i < messages.length; i++)
        {
            if(messages[i] == null) //Skipping the null
                continue;
            System.out.println(messages[i]);
        }
    }

}
class PriorityQ
{
    // array in sorted order, from max at 0 to min at size-1
    private final int maxSize;
    public long[] queArray;
    public int nItems;
    //-------------------------------------------------------------
    public PriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        if(!isFull())
            queArray[nItems++] = item;
    }
    //-------------------------------------------------------------
    public long remove()             // remove minimum item
    {
        long min = queArray[0];
        long minIndex = 0;
        //Finding the index of minimum item from the array
        for (int i = 0; i < nItems; i++) {
            if(queArray[i] < min){
                min = queArray[i];
                minIndex = i;
            }
        }

        //Removing the element at minIndex
        for(int k = (int)minIndex; k < nItems-1; k++){

            queArray[k] = queArray[k+1];
            // move higher ones down
        }
        nItems--;                   // decrement size
        return min;
        //return queArray[--nItems];
    }
    //-------------------------------------------------------------
    public long peekMin()            // peek at minimum item
    {
        long min = queArray[0];
        //Finding the index of minimum item from the array
        for (int i = 0; i < nItems; i++) {
            if(queArray[i] < min){
                min = queArray[i];
            }
        }
        return min;
    }
    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    {
        return (nItems==0);
    }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    {
        return (nItems == maxSize);
    }
//-------------------------------------------------------------
}
class Queue
{
    private final int maxSize;
    private final long[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    public Queue(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    public void insert(long j)   // put item at rear of queue
    {
        if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
    //--------------------------------------------------------------
    public long remove()         // take item from front of queue
    {
        long temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }
    //--------------------------------------------------------------
    public long peekFront()      // peek at front of queue
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if queue is empty
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if queue is full
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size()           // number of items in queue
    {
        return nItems;
    }
    public long itemAtOrder(int k){
        if(k <= 0 || nItems < k){
            System.out.print("Error: ");
            return -1;
        }
        return queArray[--k];
    }
    public long orderOfItem(long N){
        long order = 1;
        for(int i = 0; i < nItems; i++){
            if(maxSize < i){
                return -1;
            }
            if(queArray[i] == N){
                return order;
            }
            order++;
        }
        System.out.print("Error: ");
        return -1;
    }
//--------------------------------------------------------------
}
class StackX
{
    private final int maxSize;        // size of stack array
    private final long[] stackArray;
    private int top;            // top of stack
    //--------------------------------------------------------------
    public StackX(int s)         // constructor
    {
        maxSize = s;             // set array size
        stackArray = new long[maxSize];  // create array
        top = -1;                // no items yet
    }
    //--------------------------------------------------------------
    public void push(long j)    // put item on top of stack
    {
        stackArray[++top] = j;     // increment top, insert item
    }
    //--------------------------------------------------------------
    public long pop()           // take item from top of stack
    {
        return stackArray[top--];  // access item, decrement top
    }
    //--------------------------------------------------------------
    public long peek()          // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize-1);
    }
//--------------------------------------------------------------
}