package idv.felix.maths;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.<br/>
 * <br/>
 * 
 * Follow up: The overall run time complexity should be
 * <span style="background-color: #f9f2f4"><b>O(log (m+n))</b></span>.<br/>
 * <br/>
 * 
 * <b>Example 2:</b><br/>
 * <table>
 * <tr>
 * <td style="padding-right: 50px">Input:</td>
 * <td>nums1 = [1,2], nums2 = [3,4]</td>
 * </tr>
 * <tr>
 * <td>Output:</td>
 * <td>2.50000</td>
 * </tr>
 * <tr>
 * <td>Explanation:</td>
 * <td>merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.</td>
 * </tr>
 * </table>
 * 
 * @author Felix Wu
 * @since Oct 23, 2020
 */
public interface MedianOfTwoSortedArrays {
	double findMedianSortedArrays(int[] nums1, int[] nums2);
}
