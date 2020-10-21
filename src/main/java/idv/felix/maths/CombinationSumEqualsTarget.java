package idv.felix.maths;

import java.util.List;
import java.util.NavigableSet;

/**
 * @author Felix Wu
 * @since Oct 21, 2020
 */
public interface CombinationSumEqualsTarget {

	List<List<Integer>> solution(int target, NavigableSet<Integer> candidates);
}
