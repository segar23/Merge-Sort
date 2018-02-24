public class MergeSort {
    private int [] array;
    private int [] tempArray;

    public void sort (int [] array) {
        this.array = array;
        this.tempArray = new int[this.array.length];
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivot = lowIndex + (highIndex - lowIndex) / 2;
            mergeSort(lowIndex, pivot);
            mergeSort(pivot + 1, highIndex);
            mergeArrays(lowIndex, pivot, highIndex);
        }
    }

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
        int [] array = {23, 1, 54, 12, 78, 43, 2, 67, 84, 34};
        MergeSort sort = new MergeSort();
        sort.sort(array);
        for (int i:array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
