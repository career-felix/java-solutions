package idv.felix.maths;

/**
 * Given an array of integers <b>nums</b> and an integer <b>k</b>, return the
 * number of <b>unique</b> k-diff pairs in the array.<br/>
 * 
 * A <b style="color: #fe1234">k-diff</b> pair is an integer pair (nums[i],
 * nums[j]), where the following are true:
 * 
 * <ul style="background-color: #f9f2f4">
 * <li>0 <= i, j < nums.length
 * <li>i != j
 * <li>|nums[i] - nums[j]| == k
 * </ul>
 * Notice that <b>|val|</b> denotes the absolute value of <b>val</b>.
 * 
 * @author Felix Wu
 * @since Oct 22, 2020
 */
public interface KDiffPairsInArray {
	int findPairs(int[] nums, int k);
}
