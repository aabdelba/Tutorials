import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSortMain {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,5,6,4,8,7,5,3,8,5,9};
        quickSort(arr,0,arr.length);
        System.out.println(arr);
    }

    private static int[] quickSort(int[] arr, int start, int end) {

        arrangeFirstMiddleAndLast(arr);
        int pivoit = arr[Math.round(end/2)];//middle
        arr[Math.round(end/2)] = arr[end-1];//make middle = last
        arr[end-1] = pivoit;//make last = pivoit

        int largerFromLeftIndex=0;
        int smallerFromRightIndex=end;
        while(largerFromLeftIndex<=smallerFromRightIndex){

            for(int i = 0 ; i<end ; i++) {
                if (pivoit < arr[i]) {
                    largerFromLeftIndex = i;
                    break;
                }
            }

            for(int i = end-1 ; i>=0 ; i--) {
                if (pivoit > arr[i]) {
                    smallerFromRightIndex = i;
                    break;
                }
            }

            if(largerFromLeftIndex<=smallerFromRightIndex)
                swap(arr,largerFromLeftIndex,smallerFromRightIndex);
        }
        swap(arr,largerFromLeftIndex,end-1);

        if(largerFromLeftIndex>=2) quickSort(arr,0,largerFromLeftIndex);
        if(end-1-largerFromLeftIndex>=2) quickSort(arr,largerFromLeftIndex,end-1);

        return arr;



    }

    private static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

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
