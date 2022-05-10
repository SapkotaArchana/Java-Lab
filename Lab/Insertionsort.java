package Lab;
class insertion{
    public void insertionSort(int A[],int n){
        for(int i=0;i<n;i++){
            int temp=A[i];
            int j=i;
            while(j>0 && temp<A[j-1]){
                A[j]=A[j-1];
                j=j-1;
            }
            A[j]=temp;
        }
    }
}
public class Insertionsort {
    public static void main(String[] args) {
        int array[]={1,6,4,3,8,10};
        insertion in=new insertion();
        
        System.out.println("Before sorting array:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        in.insertionSort(array, 6);
        System.out.println("After sorting array:");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+"\t");
        }
    }
}
