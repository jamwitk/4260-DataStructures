public class Main {
    public static void main(String[] args) {
        FirstQuestion(10);
        SecondThirdFourthQuestion();
    }
    public static void SecondThirdFourthQuestion(){
        long shellComparisonAvg=0;
        long shellCopyAvg=0;
        long quickComparisonAvg=0;
        long quickCopyAvg=0;
        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArraySh arraySorter = new ArraySh(100);
            for (int i = 0; i < 100; i++) {
                arraySorter.insert((int) (Math.random() * 999) + 1);
            }
            int[] response = arraySorter.shellSort();
            shellComparisonAvg += response[0];
            shellCopyAvg += response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }
        System.out.println("Shell Sort Comparison Average: "+shellComparisonAvg/20);
        System.out.println("Shell Sort Copy Average: "+shellCopyAvg/20);

        for(int k = 0; k < 20; k++){
            System.out.println((k+1)+". iteration");
            ArrayIns arraySorter = new ArrayIns(100);
            for (int i = 0; i < 100; i++) {
                arraySorter.insert((int) (Math.random() * 999)+1);
            }
            int[] response = arraySorter.quickSort();
            quickComparisonAvg+=response[0];
            quickCopyAvg+=response[1];
            System.out.println("Comparison Counter: " + response[0] + " and Copy Counter: " + response[1]);
        }
        System.out.println("Quick Sort Comparison Average: "+quickComparisonAvg/20);
        System.out.println("Quick Sort Copy Average: "+quickCopyAvg/20);
    }
    public static void FirstQuestion(int k){
        ArrayPar arr = new ArrayPar(10);
        for (int i = 0; i < 10; i++) {
            arr.insert(i);
        }
        System.out.println("The "+k+"th smallest element in an array is: "+findKthSmallest(arr,k));
    }
    public static long findKthSmallest(ArrayPar arr, int k){
        return findKthSmallest(arr,0,arr.size()-1,k);
    }
    public static long findKthSmallest(ArrayPar arr, int left, int right, int k){
        int pivot = arr.partitionIt(left,right,arr.theArray[right]);
        if(pivot == k-1){
            return arr.theArray[pivot];
        }
        else if(pivot > k-1){
            return findKthSmallest(arr,left,pivot-1,k);
        }
        else{
            return findKthSmallest(arr,pivot+1,right,k);
        }
    }
    public static class ArrayPar{
        private long[] theArray;
        private int nElems;
        public ArrayPar(int max)          // constructor
        {
            theArray = new long[max];      // create the array
            nElems = 0;                    // no items yet
        }
        //--------------------------------------------------------------
        public void insert(long value)    // put element into array
        {
            theArray[nElems] = value;      // insert it
            nElems++;                      // increment size
        }
        //--------------------------------------------------------------
        public int size()                 // return number of items
        { return nElems; }
        //--------------------------------------------------------------
        public void display()             // displays array contents
        {
            System.out.print("A=");
            for(int j=0; j<nElems; j++)    // for each element,
                System.out.print(theArray[j] + " ");  // display it
            System.out.println("");
        }
        //--------------------------------------------------------------
        public int partitionIt(int left, int right, long pivot)
        {
            int leftPtr = left - 1;           // right of first elem
            int rightPtr = right + 1;         // left of pivot
            while(true)
            {
                while(leftPtr < right &&       // find bigger item
                        theArray[++leftPtr] < pivot) {
                    ;  // (nop)
                }

                while(rightPtr > left &&       // find smaller item
                        theArray[--rightPtr] > pivot)
                    ;  // (nop)
                if(leftPtr >= rightPtr)        // if pointers cross,
                    break;                      //    partition done
                else                           // not crossed, so
                    swap(leftPtr, rightPtr);    //    swap elements
            }  // end while(true)
            return leftPtr;                   // return partition
        }  // end partitionIt()
        public void swap(int dex1, int dex2)  // swap two elements
        {
            long temp;
            temp = theArray[dex1];             // A into temp
            theArray[dex1] = theArray[dex2];   // B into A
            theArray[dex2] = temp;             // temp into B
        }  // end swap()
    }
    public static class ArraySh
    {
        private final long[] theArray;          // ref to array theArray
        private int nElems;               // number of data items
        //--------------------------------------------------------------
        public ArraySh(int max)           // constructor
        {
            theArray = new long[max];      // create the array
            nElems = 0;                    // no items yet
        }
        //--------------------------------------------------------------
        public void insert(long value)    // put element into array
        {
            theArray[nElems] = value;      // insert it
            nElems++;                      // increment size
        }
        //--------------------------------------------------------------
        public void display()             // displays array contents
        {
            System.out.print("A=");
            for(int j=0; j<nElems; j++)    // for each element,
                System.out.print(theArray[j] + " ");  // display it
            System.out.println();
        }
        //--------------------------------------------------------------
        public int[] shellSort()
        {
            int comparisons = 0, swaps = 0;
            int inner, outer;
            long temp;

            int h = 1;
            while(h <= nElems/3){
                comparisons++;
                h = h*3 + 1;
            }

            while(h>0)
            {
                // h-sort the file
                comparisons++;
                for(outer=h; outer<nElems; outer++)
                {
                    comparisons++;
                    temp = theArray[outer];
                    inner = outer;
                    while(inner > h-1 && theArray[inner-h] >=  temp)
                    {
                        theArray[inner] = theArray[inner-h];
                        inner -= h;
                        comparisons++;
                        swaps++;
                    }
                    theArray[inner] = temp;
                    swaps++;
                }
                h = (h-1) / 3;
            }
            return new int[]{comparisons,swaps};
        }  // end shellSort()
//--------------------------------------------------------------
    }  // end class ArraySh
    public static class ArrayIns
    {
        private long[] theArray;          // ref to array theArray
        private int nElems;               // number of data items
        public int comparisons = 0, swaps = 0;

        //--------------------------------------------------------------
        public ArrayIns(int max)          // constructor
        {
            theArray = new long[max];      // create the array
            nElems = 0;                    // no items yet
        }
        //--------------------------------------------------------------
        public void insert(long value)    // put element into array
        {
            theArray[nElems] = value;      // insert it
            nElems++;                      // increment size
        }
        //--------------------------------------------------------------
        public void display()             // displays array contents
        {
            System.out.print("A=");
            for(int j=0; j<nElems; j++)    // for each element,
                System.out.print(theArray[j] + " ");  // display it
            System.out.println();
        }
        //--------------------------------------------------------------
        public int[] quickSort()
        {
            recQuickSort(0, nElems-1);
            return new int[]{comparisons,swaps};
        }
        //--------------------------------------------------------------
        public void recQuickSort(int left, int right)
        {

            if(right-left <= 0)              // if size <= 1,
                return;                      //    already sorted
            else                             // size is 2 or larger
            {
                long pivot = theArray[right];      // rightmost item
                // partition range
                int partition = partitionIt(left, right, pivot);
                recQuickSort(left, partition-1);   // sort left side
                recQuickSort(partition+1, right);  // sort right side
            }
        }  // end recQuickSort()
        //--------------------------------------------------------------
        public int partitionIt(int left, int right, long pivot)
        {
            int leftPtr = left-1;           // left    (after ++)
            int rightPtr = right;           // right-1 (after --)
            while(true)
            {                            // find bigger item
                while( theArray[++leftPtr] < pivot ){
                    comparisons++;
                }
                    ;  // (nop)
                // find smaller item
                while(rightPtr > 0 && theArray[--rightPtr] > pivot){
                    comparisons++;
                }
                    ;  // (nop)

                if(leftPtr >= rightPtr)      // if pointers cross,
                    break;                    //    partition done
                else
                {
                    swap(leftPtr, rightPtr);  //    swap elements
                }
            }  // end while(true)
            swap(leftPtr, right);           // restore pivot
            return leftPtr;                 // return pivot location
        }  // end partitionIt()
        //--------------------------------------------------------------
        public void swap(int dex1, int dex2)  // swap two elements
        {
            long temp = theArray[dex1];        // A into temp
            theArray[dex1] = theArray[dex2];   // B into A
            theArray[dex2] = temp;             // temp into B
            swaps+=3;
        }  // end swap(
//--------------------------------------------------------------
    }  // end class ArrayIns
}