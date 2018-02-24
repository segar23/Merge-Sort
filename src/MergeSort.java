import java.util.Scanner;

public class MergeSort {
    private int [] array;
    private int [] tempArray;

    //Public method. This will call the recursive sorting
    public void sort (int [] array) {
        this.array = array;
        this.tempArray = new int[this.array.length];
        mergeSort(0, array.length - 1);
    }

    /**
     * Merge Sort method. This will split the array in sub arrays by halves,
     * until it gets to only two items to sort. Then, it will put everything together
     */
    private void mergeSort(int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivot = lowIndex + (highIndex - lowIndex) / 2;
            mergeSort(lowIndex, pivot);
            mergeSort(pivot + 1, highIndex);
            mergeArrays(lowIndex, pivot, highIndex);
        }
    }

    /**
     * This is the Merge function that will make sure that the all the subarrays are in order
     */
    private void mergeArrays(int lowIndex, int pivot, int highIndex) {
        for (int i = 0; i <= highIndex; i++) {
            tempArray[i] = array[i];
        }

        int i = lowIndex;
        int j = pivot + 1;
        int k = lowIndex;
        while (i <= pivot && j <= highIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= pivot) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers are you typing? :");
        int length = scanner.nextInt();
        int [] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Enter number " + i);
            array[i] = scanner.nextInt();
        }

        MergeSort sort = new MergeSort();
        sort.sort(array);
        for (int i:array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
