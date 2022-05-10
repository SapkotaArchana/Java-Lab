
package Lab;

class MergeDemo {

    public void Merge(int L[], int R[], int A[]) {
        int nL = L.length;
        int nR = R.length;
        int i, j, k;
        i = j = k = 0;

        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                k++;
                i++;
            } else {
                A[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < nL) {
            A[k] = L[i];
            k++;
            i++;
        }
        while (j < nR) {
            A[k] = R[j];
            k++;
            j++;
        }

    }

    public void MergeSort(int A[]) {
        int n = A.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int left[] = new int[mid];
        int right[] = new int[n - mid];
        for (int i = 0; i <= mid - 1; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i <= n - 1; i++) {
            right[i - mid] = A[i];
        }
        MergeSort(left);
        MergeSort(right);
        Merge(left, right, A);
    }
}

public class mergesort {

    public static void main(String[] args) {
        MergeDemo m = new MergeDemo();
        int arr[] = {5, 2, 7, 8, 95, 100};
        System.out.println("Before sorting array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        m.MergeSort(arr);
        System.out.println("After sorting array:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}

// package Sorting;
// class Merge{
//     public void MergeSort(int L[],int R[],int A[]) {
//         int nL=L.length;
//         int nR=R.length;;
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<nL && j<nR){
//             if(L[i]<=R[j]){
//                 A[k]=L[i];
//                 k++;
//                 i++;
//             }
//             else{
//                 A[k]=R[j];
//                 k++;
//                 j++;
//             }
//         }
    
//         while(i<nL){
//             A[k]=L[i];
//             k++;
//             i++;
//         }
//         while(j<nR){
//             A[k]=R[j];
//             k++;
//             j++;
//         }
//         }
//         public void Display(int A[]){
//             int n=A.length;
//             if(n<2){
//                 return;
//             }
//             int mid=n/2;
//             int left[]=Arr[mid];
//             int right[]=A[(n-mid)];
//             for(int i=0;i<mid-1;i++){
//                 left[i]=A[i];
//             }
//             for(int i=mid; i<n-1; i++){
//                 right[i-mid]=A[i];
//             }
            
//     }
// }
// public class mergesort {	
// 	public static void main(String[] args) {
// 		int a[] = {15,5,24,8, 1,3, 16 ,10,20};
// 		Merge aaa = new Merge();
// 		System.out.println("Before sorting");
// 		aaa.Display(15);
// 		System.out.println("\nAfter sorting");
// 		aaa.Merge(a, 0, a.length-1);
// 		Display(a);
// 	}
// }
	
// }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */