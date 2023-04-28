public class Main {
    public static void main(String[] args) {
        HighArray arr = new HighArray(100);
        arr.insert(6);
        arr.insert(7);
        arr.insert(1);
        arr.insert(5);
        arr.insert(9);
        arr.insert(3);
        arr.insert(2);
        arr.insert(8);
        arr.insert(4);
        int response = arr.getMinIndex(3,7);
        arr.printArray();
        arr.placeMin(1,5);
        arr.printArray();
        arr.sort();
        arr.printArray();

    }
}