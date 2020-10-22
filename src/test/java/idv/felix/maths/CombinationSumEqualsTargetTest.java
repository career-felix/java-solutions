package idv.felix.maths;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Felix Wu
 * @since Oct 21, 2020
 */
@Slf4j
public class CombinationSumEqualsTargetTest {

	private static CombinationSumEqualsTarget solution;

	@BeforeAll
	public static void beforeAll() {
		solution = new CombinationSumEqualsTargetSolution();
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
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(0));
		List<List<Integer>> list = solution.solution(target, candidates);
		if (list != null) {
			final AtomicInteger index = new AtomicInteger(0);
			list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		}
		checkResult(target, list);
	}

	@Test
	public void _01() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1));
		List<List<Integer>> list = solution.solution(target, candidates);
		list.stream().forEach(combination -> log.info("{}", combination));
		checkResult(target, list);
	}

	@Test
	public void _02() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1, 2));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Test
	public void _03() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(2, 3));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Test
	public void _04() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(2, 3, 4, -5));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}

	@Disabled
	@Test
	public void _08() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
		checkResult(target, list);
	}
}
