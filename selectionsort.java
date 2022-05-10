// package Sorting;
// class Selection{
//     public void SelectSort(int[] data){
//         int i,j,lb, temp;
//         for(i=0; i<data.length; i++) {
// 			for(j=i+1, lb = i; j<data.length; j++) {
// 				if(data[j]<data[lb]) {
// 					lb = j;
// 				}
// 			}
        
//             if(i!=lb){
//                 temp = data[lb];
// 				data[lb]=data[i];
// 				data[i]=temp;
// 			}
//         }
//     }
            
//             public void Display(int[] data){
//                 for(int i=0; i<data.length; i++) {
//                     System.out.print(data[i]+" ");
//                 } 
//             }
//     }
// public class selectionsort {
//     public static void main(String[] args) {
//         Selection s=new Selection();
//         int a[] = {3,2,5,1,15,20,16};
// 		System.out.println("Before sorting");
// 		s.Display(a);
// 		s.SelectSort(a);
// 		System.out.println("\nAfter Sorting");
// 		s.Display(a);
//     }
// }



class selection{
    public void selectionSort(int array[]){
        int size=array.length;

        for(int step=0; step<size-1; step++){
            int min_idx=step;
        
        for (int i=step+1;i<size;i++){
            if(array[i]<array[min_idx]){
                min_idx=i;
            }
        }
        int temp=array[step];
        array[step]=array[min_idx];
        array[min_idx]=temp;
    }
}
}
public class selectionsort{
    public static void main(String[] args) {
        selection s=new selection();
        int array[]={1,3,11,8,300, 9,15,350};
        System.out.println("Before sorting array:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        s.selectionSort(array);
        System.out.println("After sorting array:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+"\t");
        }

    }
}