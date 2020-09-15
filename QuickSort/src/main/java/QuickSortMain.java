package main.java;

import java.util.Arrays;
import java.util.List;

public class QuickSortMain {

    public static int[] quickSort(int[] arr) {

        arrangeFirstMiddleAndLast(arr);
        List<Integer> arrList = Arrays.asList(Arrays.stream(arr).boxed().toArray( Integer[]::new ));
        arrList = quickSort(arrList,0,arr.length);

        //DEBUG
        System.out.println("\n---------------------\nFINAL:");
        for (int k:arrList) {
            System.out.print(k+" ");
        }

        return arrList.stream().mapToInt(i->i).toArray();
    }

    public static List<Integer> quickSort(List<Integer> arr, int start, int end) {

        int subArrayLength = end - start;
        if(subArrayLength==2) {
            if (arr.get(start) > arr.get(end-1))
                swap(arr, start, end-1);
        }else if(subArrayLength<=1) {
            return arr;
        }

        //set up pivot
        int pivotIndex = start + Math.round((subArrayLength)/2);
        int pivot = arr.get(pivotIndex);//middle
        swap(arr,pivotIndex,end-1);
        pivotIndex=end-1;

        //DEBUG
        System.out.println("pivotIndex:"+pivotIndex);
        System.out.println("pivot:"+pivot);
        for(int i=start;i<end;i++)
            System.out.print(arr.get(i) + " ");
        System.out.println("\n");




        int largerFromLeftIndex=start;
        int smallerFromRightIndex=end-1;
        while(largerFromLeftIndex<smallerFromRightIndex) {

            for (int i = 0; i < end; i++) {
                if (pivot < arr.get(i)) {
                    largerFromLeftIndex = i;
                    break;
                } else if(i==end-1){
                    largerFromLeftIndex = pivotIndex;
                }
            }

            for (int i = end - 1; i >= 0; i--) {
                if (pivot > arr.get(i)) {
                    smallerFromRightIndex = i;
                    break;
                } else if(i==0){
                    smallerFromRightIndex = -1;
                }
            }

            System.out.println("\t"+largerFromLeftIndex);
            System.out.println("\t"+smallerFromRightIndex);

            if (largerFromLeftIndex < smallerFromRightIndex) {
                swap(arr, largerFromLeftIndex, smallerFromRightIndex);
            } else {
                swap(arr, largerFromLeftIndex, pivotIndex);
                pivotIndex = largerFromLeftIndex;
            }

        }

        //recursion
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex+1, end);

        return arr;

    }

    private static List<Integer>  swap(List<Integer>  arr, int i, int j) throws ArrayIndexOutOfBoundsException{
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);


        //DEBUG
        System.out.print("\t");
        for (int k:arr) {
            System.out.print(k+" ");
        }
        System.out.println("");




        return arr;
    }

    private static int[] arrangeFirstMiddleAndLast(int[] arr) {

        int[] firstLastMiddle = new int[3];

        int n1 = arr[0];
        int n2 = arr[Math.round(arr.length/2)];
        int n3 = arr[arr.length-1];

        int smallest = n1<n2 && n1<n3 ? n1 : n2<n1 && n2<n3 ? n2 : n3;
        int largest = n3>n1 && n3>n2 ? n3 : n2>n1 && n2>n3 ? n2 : n1;
        int middle = n1 != smallest && n1 != largest ? n1 : n2 != smallest && n2 != largest ? n2 : n3;

        arr[0] = smallest;
        arr[Math.round(arr.length/2)] = middle;
        arr[arr.length-1] = largest;

        return arr;
    }


}
