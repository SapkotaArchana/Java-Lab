
class heap{
    public void heapify(int arr[], int n, int i){
        int largest = i;                                                                                                                                                          
		int l = 2 * i + 1;         
		int r = 2 * i + 2;                                                                                                                                                          
		if (l < n && arr[l] > arr[largest])                                                                                                                                                          
			largest = l;                                                                                                                                                          
                                                                                                                                                       
		if (r < n && arr[r] > arr[largest])                                                                                                                                                          
			largest = r;                                                                                                                                                          
                                                                                                                                                                   
		if (largest != i) {                                                                                                                                                          
			int swap = arr[i];                                                                                                                                                          
			arr[i] = arr[largest];                                                                                                                                                          
			arr[largest] = swap;
			
			heapify(arr, n, largest);                                                                                                                                                          
		}                                                                                                                                                          
    }
    public void heapsor(int arr[],int n){  
		n=arr.length;                                                                                                                              
		// Build heap (rearrange array)                                                                                                                                                          
		for (int i = n / 2 - 1; i >= 0; i--)  {                                                                                                                                                        
			heapify(arr, n, i);  
		}                                                                                                                                                                 
		for (int i = n - 1; i >=0; i--) {                                                                                                                                                        
			int temp = arr[0];                                                                                                                                                          
			arr[0] = arr[i];                                                                                                                                                          
			arr[i] = temp; 

			heapify(arr, i, 0);                                                                                                                                                          
		}                                                                                                                                                          
	}
    // static void printArray(int arr[])                                                                                                                                                          
	// {                                                                                                                                                          
	// 	int n = arr.length;                                                                                                                                                          
	// 	for (int i = 0; i < n; ++i)                                                                                                                                                          
	// 		System.out.print(arr[i] + " ");                                                                                                                                                          
	// 	System.out.println();                                                                                                                                                          
	// }
    //    public static void swap(int[] arr, int a, int b){
	// 	   int temp=arr[a];
	// 	   arr[a]=arr[b];
	// 	   arr[b]=temp;
	//    }
             
}
public class heapsort {
    public static void main(String[] args) {
        heap h=new heap();
        int arr[] = { 2,8,7,12,10,15,4};  
        System.out.println("Before sorting array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        //h.heapify(arr, 6,6);
		h.heapsor(arr, 4);
        System.out.println("After sorting array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
		
    }
}
