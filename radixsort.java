

class Radix{
    public void countingSort(int arr[], int size, int place) {
        int[] output = new int[size + 1];
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int count[] = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(arr[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] =count[i]+ count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            arr[i] = output[i];
    }

    // Function to get the largest element from an array
    int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Main function to implement radix sort
    public void radixSor(int arr[], int size) {
        // Get maximum element
        int max = getMax(arr, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, size, place);
    }
}

public class radixsort {
    public static void main(String args[]) {
        int[] arr = { 14, 61, 54, 23, 1, 45, 28 };
        int size = arr.length;
        Radix rs = new Radix();
        System.out.println("Before sorting array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        rs.radixSor(arr, size);
        System.out.println("After sorting array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    
    }
}
