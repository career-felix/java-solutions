package idv.felix.maths;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Felix Wu
 * @since Oct 22, 2020
 */
@Slf4j
public class CombinationSumTest {

	private static CombinationSum solution;

	@BeforeAll
	public static void beforeAll() {
		solution = new CombinationSumDFS();
	}

	@AfterEach
	public void afterEach() {
		log.info("------------");
	}

	private void checkResult(int target, List<List<Integer>> result) {
		if (result == null) {
			return;
		}
		for (int i = 0; i < result.size(); i++) {
			List<Integer> combination = result.get(i);
			Assertions.assertEquals(target, combination.stream().collect(Collectors.summingInt(ele -> ele)));
			for (int k = i + 1; k < result.size(); k++) {
				Assertions.assertNotEquals(combination, result.get(k));
			}
		}
	}

	@Test
	public void _00() {
		int target = 20;
		int[] candidates = new int[] { 0 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		if (list != null) {
			final AtomicInteger index = new AtomicInteger(0);
			list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		}
		checkResult(target, list);
	}

	@Test
	public void _01() {
		int target = 20;
		int[] candidates = new int[] { 1 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		list.stream().forEach(combination -> log.info("{}", combination));
		checkResult(target, list);
	}

	@Test
	public void _02() {
		int target = 20;
		int[] candidates = new int[] { 1, 2 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Test
	public void _03() {
		int target = 20;
		int[] candidates = new int[] { 2, 3 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Test
	public void _04() {
		int target = 20;
		int[] candidates = new int[] { 2, 3, 4, -5 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Test
	public void _08() {
		int target = 20;
		int[] candidates = new int[] { 2, 3, 4, 5, 6, 7, 8 };
		List<List<Integer>> list = solution.combinationSum(candidates, target);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}
}
