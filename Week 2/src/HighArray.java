public class HighArray
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //-----------------------------------------------------------
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j] )
                break;
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    //-----------------------------------------------------------
    public int getMinIndex(int lowIndex, int highIndex){
        if(lowIndex >= highIndex)
            return -1;
        int min = 1001; //Max number bigger number. We assumed the numbers between 0-1000
        int minIndex = -1;
        for(int i = lowIndex; i < highIndex; i++) {
            if(a[i] < min){
                minIndex = i;
                min = (int)a[i];
            }
        }
        return minIndex;
    }
    //-------------------------------------------------------------
    public void placeMin(int lowIndex, int highIndex){
        int minIndex = getMinIndex(lowIndex, highIndex);
        if(minIndex == -1)
            return;
        long tempValue = a[minIndex];
        for(int i = minIndex; i > lowIndex; i--){
            a[i] = a[i-1];
        }
        a[lowIndex] = tempValue;
    }

    public void sort(){
        for(int i = 0; i < nElems; i++){
            placeMin(i, nElems);
        }
    }
    //-----------------------------------------------------------
    public void removeDuplicates(){

    }
    public void printArray(){
        for(int i = 0; i < nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
