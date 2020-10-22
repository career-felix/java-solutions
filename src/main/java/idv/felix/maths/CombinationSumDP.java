package idv.felix.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Dynamic Programming
 * 
 * @author Felix Wu
 * @since Oct 22, 2020
 */
public class CombinationSumDP implements CombinationSum {

	@Override
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> list = Arrays.stream(candidates).boxed().collect(Collectors.toList());
		TreeSet<Integer> set = new TreeSet<>(list);
		List<List<Integer>> result = solution(target, set);
		return result == null ? new ArrayList<>() : result;
	}

	private List<List<Integer>> solution(int target, NavigableSet<Integer> candidates) {

		// remove ZERO and NEGATIVE
		candidates.removeIf(ele -> ele <= 0);

		// check NULL
		if (candidates == null || candidates.size() == 0) {
			return null;
		}

		/** START */
		final int first = candidates.first();
		final int times = target / first;

		// boundary condition
		if (candidates.size() == 1) {
			if (times * first == target) {
				List<Integer> combination = new ArrayList<>();
				for (int i = 0; i < times; i++) {
					combination.add(first);
				}
				return Collections.singletonList(combination);
			} else {
				return null;
			}
		}

		// more than 1 candidates
		List<List<Integer>> result = new ArrayList<>();
		NavigableSet<Integer> tailSet = candidates.tailSet(first, false);

		// i: the occurrence of the first number
		for (int i = 0; i <= times; i++) {
			List<Integer> firstList = new ArrayList<>();
			for (int k = 0; k < i; k++) {
				firstList.add(first);
			}

			List<List<Integer>> tailResult = solution(target - i * first, tailSet);
			if (tailResult != null) {
				tailResult.stream().forEach(s -> s.addAll(0, firstList));
				result.addAll(tailResult);
			}
		}

		return result;
	}
}
