package idv.felix.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;

/**
 * @author Felix Wu
 * @since Oct 21, 2020
 */
public class CombinationSumEqualsTargetSolution implements CombinationSumEqualsTarget {

	@Override
	public List<List<Integer>> solution(int target, NavigableSet<Integer> candidates) {

		// check NULL
		if (candidates == null || candidates.size() == 0) {
			return null;
		}

		// remove ZERO
		candidates.removeIf(ele -> ele == 0);

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
