package Lab;
class Bubble{
    public void Bubblesort(int Array[],int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(Array[j]>Array[j+1]){
                    int temp=Array[j];
                    Array[j]=Array[j+1];
                    Array[j+1]=temp;
                }
            }
        }
    }
}
public class bubblesort {
    public static void main(String[] args) {
        Bubble b=new Bubble();
         int Array[]={25,57,48,37,12, 92,86,33};
        System.out.println("Before sorting array:");
        for(int i=0;i<Array.length;i++)
        {
            System.out.print(Array[i]+"\t");
        }
        System.out.println();
        b.Bubblesort(Array, 8);
        System.out.println("After sorting array:");
        for(int i=0;i<Array.length;i++)
        {
            System.out.print(Array[i]+"\t");
        }
    }
}
