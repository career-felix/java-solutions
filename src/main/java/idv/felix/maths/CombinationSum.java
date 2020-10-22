package idv.felix.maths;

import java.util.List;

/**
 * Given an array of <b>distinct</b> integers <b>candidates</b> and a target
 * integer target, return a list of all <b>unique combinations</b> of candidates
 * where the chosen numbers sum to <b>target</b>. You may return the
 * combinations in any order.<br/>
 * <br/>
 * 
 * The <b>same</b> number may be chosen from candidates an <b>unlimited number
 * of times</b>. Two combinations are unique if the frequency of at least one of
 * the chosen numbers is different.<br/>
 * <br/>
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.<br/>
 * <br/>
 * 
 * Constraints:
 * <ul style="background-color: #f9f2f4">
 * <li>1 <= candidates.length <= 30
 * <li>1 <= candidates[i] <= 200
 * <li>All elements of candidates are distinct.
 * <li>1 <= target <= 500
 * </ul>
 * 
 * @author Felix Wu
 * @since Oct 22, 2020
 */
public interface CombinationSum {
	List<List<Integer>> combinationSum(int[] candidates, int target);
}
