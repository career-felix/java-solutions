package idv.felix.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Felix Wu
 * @since Oct 22, 2020
 */
public class CombinationSumDFS implements CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, final int target) {

		// filter for POSITIVE only
		List<Integer> cList = Arrays.stream(candidates).filter(e -> e > 0).boxed().collect(Collectors.toList());
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, target, new ArrayList<>(), cList, 0, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, final int target, List<Integer> path, List<Integer> candidates,
			int sum, int start) {
		if (sum == target) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < candidates.size(); i++) {
			final int sumNew = sum + candidates.get(i);
			if (sumNew > target) {
				continue;
			}
			path.add(candidates.get(i));
			backtrack(result, target, path, candidates, sumNew, i);
			path.remove(path.size() - 1);
		}
	}
}
