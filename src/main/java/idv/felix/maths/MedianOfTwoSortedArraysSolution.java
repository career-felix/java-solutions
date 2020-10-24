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
		int nShort = nums1.length;
		int nLong = nums2.length;

		int[] temp;
		if (nShort > nLong) {
			temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			nShort = nums1.length;
			nLong = nums2.length;
		}

		return binarySearchMedian(nums1, nums2, 0, nShort);
	}

	private double binarySearchMedian(int[] A, int[] B, int low, int high) {
		int i = (low + high) / 2;
		int k = (A.length + B.length) / 2 - i;

		int aLeft = i == 0 ? Integer.MIN_VALUE : A[i - 1];
		int aRight = i == A.length ? Integer.MAX_VALUE : A[i];

		int bLeft = k == 0 ? Integer.MIN_VALUE : B[k - 1];
		int bRight = k == B.length ? Integer.MAX_VALUE : B[k];

		int totalLength = A.length + B.length;
		if (aLeft <= bRight && bLeft <= aRight) {
			if (totalLength % 2 == 0) {
				return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
			} else {
				return Math.min(aRight, bRight);
			}
		} else if (bRight < aLeft) {
			return binarySearchMedian(A, B, low, i - 1);
		} else /* if (aRight < bLeft) */ {
			return binarySearchMedian(A, B, i + 1, high);
		}
	}
}
