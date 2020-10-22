package idv.felix.maths;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Felix Wu
 * @since Oct 22, 2020
 */
public class KDiffPairsInArraySolution implements KDiffPairsInArray {

	@Override
	public int findPairs(int[] nums, int k) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		if (k == 0) {
			Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
			return (int) map.values().stream().filter(e -> e > 1).count();
		} else {
			k = Math.abs(k);
			TreeSet<Integer> set = new TreeSet<>(list);
			int count = 0;
			while (set.size() > 1) {
				int first = set.pollFirst();
				if (set.contains(first + k)) {
					count++;
				}
			}
			return count;
		}
	}
}
