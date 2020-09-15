package test.java;

import main.java.QuickSortMain;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.DoubleStream;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    private static int[] arr;
    private static int[] expectedResult;

    @BeforeClass
    public static void runQuickSort(){
        arr = new int[]{3, 4, 5, 1, 43, 6, 4, 14523, 23, 2345, 1, 4, 5, 2, 3, 5, 245234, 235, 6, 5, 345, 2, 345, 2, 345, 2344, 2345, 23, 2, 4, 6, 234, 7, 8, 9, 9, 76, 96, 865, 5, 8, 44, 3, 8927358, 7, 5, 3, 8, 5, 9};
        arr = QuickSortMain.quickSort(arr);

        System.out.print("\n\nStarting comparison\n");

        expectedResult = Arrays.stream(arr).sorted().toArray();
        System.out.println("ExpectedResult:");
        for (int i:expectedResult) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void testResultSize(){
        assert arr.length==expectedResult.length : "Lengths are not equal";
    }

    @Test
    public void testResultContent(){
        for(int i=0 ; i<expectedResult.length ; i++){
            assert(arr[i]==expectedResult[i]):"At [" +i+"], got "+arr[i]+" expected "+expectedResult[i];
            System.out.println("Value at [" +i+"] is "+expectedResult[i]+" which is equal for both arrays");
            i++;
        }
    }

}
