package idv.felix.maths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Felix Wu
 * @since Oct 24, 2020
 */
@Slf4j
public class MedianOfTwoSortedArraysTest {

	private MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArraysSolution();

	@AfterEach
	public void afterEach() {
		log.info("------------");
	}

	@Test
	public void _00() {
		int[] nums1 = new int[] {1, 2, 3, 4};
		int[] nums2 = new int[] {3, 4, 5, 6, 7};
		double actual = solution.findMedianSortedArrays(nums1, nums2);
		Assertions.assertEquals(4, actual);
	}
}
