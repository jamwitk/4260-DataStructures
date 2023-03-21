public class Main {
    public static void main(String[] args) {
        int insertionComparisonAvg=0;
        int selectionComparisonAvg=0;
        int oddEvenComparisonAvg=0;
        int bubbleComparisonAvg=0;

        int insertionCopyAvg=0;
        int selectionCopyAvg=0;
        int oddEvenCopyAvg=0;
        int bubbleCopyAvg=0;
        System.out.println("Bubble Sort-----------------------");
        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArraySort arraySorter = new ArraySort(25);
            for (int i = 0; i < 25; i++) {
                arraySorter.insert((int) (Math.random() * 100));
            }
            arraySorter.display();
            var response = arraySorter.bubbleSort();
            bubbleComparisonAvg+=response[0];
            bubbleCopyAvg+=response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }
        System.out.println("Selection Sort------------------------");
        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArraySort arraySorter = new ArraySort(25);
            for (int i = 0; i < 25; i++) {
                arraySorter.insert((int) (Math.random() * 100));
            }
            arraySorter.display();
            var response = arraySorter.selectionSort();
            selectionComparisonAvg+=response[0];
            selectionCopyAvg+=response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }
        System.out.println("Insertion Sort------------------------");
        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArraySort arraySorter = new ArraySort(25);
            for (int i = 0; i < 25; i++) {
                arraySorter.insert((int) (Math.random() * 100));
            }
            arraySorter.display();
            var response = arraySorter.insertionSort();
            insertionComparisonAvg+=response[0];
            insertionCopyAvg+=response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }
        System.out.println("oddEven Sort------------------------");
        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArraySort arraySorter = new ArraySort(25);
            for (int i = 0; i < 25; i++) {
                arraySorter.insert((int) (Math.random() * 100));
            }
            arraySorter.display();
            var response = arraySorter.oddEvenSort();
            oddEvenComparisonAvg+=response[0];
            oddEvenCopyAvg+=response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }

        System.out.println("AVERAGES: ");
        System.out.println("Bubble Sort Comparison average: "+ bubbleComparisonAvg/25);
        System.out.println("Bubble Sort Copy average: "+ bubbleCopyAvg/25);

        System.out.println("Selection Sort Comparison average: "+ selectionComparisonAvg/25);
        System.out.println("Selection Sort Copy average: "+ selectionCopyAvg/25);

        System.out.println("Insertion Sort Comparison average: "+ insertionComparisonAvg/25);
        System.out.println("Insertion Sort Copy average: "+ insertionCopyAvg/25);

        System.out.println("Odd Even Comparison Sort Comparison average: "+ oddEvenComparisonAvg/25);
        System.out.println("Odd Even Comparison Copy average: "+ insertionCopyAvg/25);
    }
}
// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArraySort
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArraySort(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------

    public int[] bubbleSort()
    {
        int out, in;
        int comparisonCounter = 0, swapCounter = 0;
        for(out=nElems-1; out>=1; out--){
            for(in=0; in<out; in++){
                comparisonCounter++;
                if( a[in] > a[in+1] )   {
                    long temp = a[in];
                    a[in] = a[in+1];
                    a[in+1] = temp;
                    swapCounter+=3;

                }
            }
        }
        display();
        return new int[]{comparisonCounter, swapCounter};
    }  // end bubbleSort()
    //--------------------------------------------------------------
    public int[] insertionSort()
    {
        int in, out;
        int comparisonCounter = 0, swapCounter = 0;
        for(out=1; out < nElems ; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            comparisonCounter+=2;          // increment by 2 because there is two statement in while loop
            swapCounter++;                 // removed marked item

            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
                --in;                       // go left one position
                comparisonCounter+=2;       //increment by 2 because there is two statement in while loop
                swapCounter++;              //shifted to right
            }
            a[in] = temp;                  // insert marked item
            swapCounter++;                 // inserted marked item
        }  // end for
        return new int[]{comparisonCounter, swapCounter};
    }  // end insertionSort()
    //--------------------------------------------------------------
    public int[] selectionSort()
    {
        int out, in, min;
        int comparisonCounter = 0, swapCounter = 0;
        for(out=0; out<nElems-1; out++)         // outer loop
        {
            min = out;                          // minimum

            for(in=out+1; in<nElems; in++){     // inner loop
                comparisonCounter++;
                if(a[in] < a[min] ){
                    // if min greater,
                    min = in;                   // we have a new min
                }
            }
            long temp = a[out];
            a[out] = a[min];
            a[min] = temp;
            swapCounter+=3;
        }  // end for(out)
        return new int[]{comparisonCounter, swapCounter};
    }
    public int[] oddEvenSort(){
        int comparisonCounter = 0, swapCounter = 0;
        for(int j = 0; j < nElems/2 ; j++){
            for(int i = 0; i < nElems - 1; i+=2){
                comparisonCounter++;
                if(a[i] > a[i+1]){
                    long temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapCounter+=3;
                }
            }
            for(int i = 1; i < nElems - 1; i+=2)
            {
                comparisonCounter++;
                if (a[i] > a[i+1])
                {
                    long temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapCounter+=3;
                }
            }
        }
        return new int[]{comparisonCounter, swapCounter};
    }
}  // end class ArrayBub