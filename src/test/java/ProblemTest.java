import May2022.day05.BestTimeStock;
import May2022.day05.SearchInRotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/18 9:12
 */
public class ProblemTest {

    @Test
    public void SearchInRotatedSortedArrayTest() {

        int search1 = SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        int search2 = SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        int search3 = SearchInRotatedSortedArray.search(new int[]{1}, 0);
        Assert.assertEquals(4, search1);
        Assert.assertEquals(-1, search2);
        Assert.assertEquals(-1, search3);
    }

    @Test
    public void BestTimeStock() {
        int result1 = BestTimeStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        int profit2 = BestTimeStock.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(5, result1);
        Assert.assertEquals(0, profit2);
    }
}
