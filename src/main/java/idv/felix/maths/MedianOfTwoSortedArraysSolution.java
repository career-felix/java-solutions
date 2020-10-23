package idv.felix.maths;

/**
 * @author Felix Wu
 * @since Oct 23, 2020
 */
public class MedianOfTwoSortedArraysSolution implements MedianOfTwoSortedArrays {

	/**
	 * O(log(min(n,m)))
	 */
	@Override
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		int[] temp;
		if (n > m) {
			temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			n = nums1.length;
			m = nums2.length;
		}

		return binarySearchMedian(nums1, nums2, 0, n);
	}

	private double binarySearchMedian(int[] A, int[] B, int low, int high) {
		int i = (low + high) / 2;
		int j = (A.length + B.length) / 2 - i;
		int la = i == 0 ? Integer.MIN_VALUE : A[i - 1];
		int lb = j == 0 ? Integer.MIN_VALUE : B[j - 1];
		int ra = i == A.length ? Integer.MAX_VALUE : A[i];
		int rb = j == B.length ? Integer.MAX_VALUE : B[j];
		int totalLength = A.length + B.length;
		if (la <= rb && lb <= ra) {
			if (totalLength % 2 == 0) {
				return (Math.max(la, lb) + Math.min(ra, rb)) / 2;
			} else {
				return Math.min(ra, rb);
			}
		} else if (la > rb) {
			return binarySearchMedian(A, B, low, i - 1);
		} else {
			return binarySearchMedian(A, B, i + 1, high);
		}
	}
}
