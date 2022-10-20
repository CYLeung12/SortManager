import com.sparta.cyl.sorter.BubbleSorter;
import com.sparta.cyl.sorter.MergeSorter;
import com.sparta.cyl.sorter.Sorter;
import com.sparta.cyl.sorter.TreeSorter;
import org.junit.jupiter.api.*;

import java.util.*;

public class SorterTest {
    private int[] unsortedArray;
    private List<Sorter> sorterList;




    @BeforeEach
    public void start(){
        sorterList = new ArrayList<Sorter>();
        sorterList.add(new BubbleSorter());
        sorterList.add(new MergeSorter());
        sorterList.add(new TreeSorter());
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        sorterList.clear();
    }


    @Test
    @DisplayName("Test odd size array")
    public void testOddArray(){

        int[] unsortedArray = {21, 2, 56, 166, 43};
        int[] sortedArray = {2, 21, 43, 56, 166};

        for (Sorter sorter: sorterList){
            int[] sortedArrayBySorted =  sorter.runSorter(unsortedArray);
            Assertions.assertEquals(unsortedArray.length, sortedArrayBySorted.length);
            Assertions.assertArrayEquals(sortedArray, sortedArrayBySorted);
            for (int i = 0; i < unsortedArray.length; i ++){
                Assertions.assertEquals(sortedArray[i], sortedArrayBySorted[i]);
            }
            for (int i = 0; i < unsortedArray.length - 1; i++){
                Assertions.assertTrue(sortedArrayBySorted[i] <= sortedArrayBySorted[i+1]);
            }
        }
    }


    @Test
    @DisplayName("Test even size array")
    public void testEvenArray(){
        int[] unsortedArray = {18, 439, 510, 888, 973, 13};
        int[] sortedArray = {13, 18, 439, 510, 888, 973};

        for (Sorter sorter: sorterList){
            int[] sortedArrayBySorted =  sorter.runSorter(unsortedArray);
            Assertions.assertEquals(unsortedArray.length, sortedArrayBySorted.length);
            Assertions.assertArrayEquals(sortedArray, sortedArrayBySorted);
            for (int i = 0; i < unsortedArray.length; i ++){
                Assertions.assertEquals(sortedArray[i], sortedArrayBySorted[i]);
            }
            for (int i = 0; i < unsortedArray.length - 1; i++){
                Assertions.assertTrue(sortedArrayBySorted[i] <= sortedArrayBySorted[i+1]);
            }
        }
}
        @Test
        @DisplayName("Test one length array")
        public void testOneLenArray(){

            int[] unsortedArray = {3};
            int[] sortedArray = {3};

            for (Sorter sorter: sorterList){

                int[] sortedArrayBySorted =  sorter.runSorter(unsortedArray);
                Assertions.assertEquals(unsortedArray.length, sortedArrayBySorted.length);
                Assertions.assertArrayEquals(sortedArray, sortedArrayBySorted);
                for (int i = 0; i < unsortedArray.length; i ++){
                    Assertions.assertEquals(sortedArray[i], sortedArrayBySorted[i]);
                }
                for (int i = 0; i < unsortedArray.length - 1; i++){
                    Assertions.assertTrue(sortedArrayBySorted[i] <= sortedArrayBySorted[i+1]);
                }
            }
    }

    @Test
    @DisplayName("Test array with duplicated value")
    public void testDuplicatedValueArray(){

        int[] unsortedArray = {3, 3, 0, 0, 13, 13, 11};
        int[] sortedArray = {0, 0, 3, 3, 11, 13, 13};

        for (Sorter sorter: sorterList){

            int[] sortedArrayBySorted =  sorter.runSorter(unsortedArray);
            Assertions.assertEquals(unsortedArray.length, sortedArrayBySorted.length);
            Assertions.assertArrayEquals(sortedArray, sortedArrayBySorted);
            for (int i = 0; i < unsortedArray.length; i ++){
                Assertions.assertEquals(sortedArray[i], sortedArrayBySorted[i]);
            }
            for (int i = 0; i < unsortedArray.length - 1; i++){
                Assertions.assertTrue(sortedArrayBySorted[i] <= sortedArrayBySorted[i+1]);
            }
        }
    }

    @Test
    @DisplayName("Test already sorted array")
    public void testSortedArray(){

        int[] unsortedArray = {13, 27, 67, 101, 252, 787, 881};
        int[] sortedArray = {13, 27, 67, 101, 252, 787, 881};

        for (Sorter sorter: sorterList){

            int[] sortedArrayBySorted =  sorter.runSorter(unsortedArray);
            Assertions.assertEquals(unsortedArray.length, sortedArrayBySorted.length);
            Assertions.assertArrayEquals(sortedArray, sortedArrayBySorted);
            for (int i = 0; i < unsortedArray.length; i ++){
                Assertions.assertEquals(sortedArray[i], sortedArrayBySorted[i]);
            }
            for (int i = 0; i < unsortedArray.length - 1; i++){
                Assertions.assertTrue(sortedArrayBySorted[i] <= sortedArrayBySorted[i+1]);
            }
        }
    }


}
