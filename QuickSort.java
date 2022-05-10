package Lab;
class QuickSO{
    public int partition(int array[], int low, int high) {
        // choose the rightmost element as pivot
      int pivot = array[high];
      
      // pointer for greater element
      int i = (low - 1);
      for (int j = low; j < high; j++) {
        if (array[j] <= pivot) {
          i++;
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
  
      }
      int temp = array[i + 1];
      array[i + 1] = array[high];
      array[high] = temp;
  
      // return the position from where partition is done
      return (i + 1);
    }
  
    public void quickSort(int array[], int low, int high) {
      if (low < high) {
  
        // find pivot element such that
        // elements smaller than pivot are on the left
        // elements greater than pivot are on the right
        int pi = partition(array, low, high);
        
        // recursive call on the left of pivot
        quickSort(array, low, pi - 1);
  
        // recursive call on the right of pivot
        quickSort(array, pi + 1, high);
      }
    }
  }
public class QuickSort {
    public static void main(String[] args) {
        QuickSO q=new QuickSO();
        int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        int size=arr.length;
        q.quickSort(arr, 0, size-1);
        System.out.println("After sorting array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
		
    }
}

 

    