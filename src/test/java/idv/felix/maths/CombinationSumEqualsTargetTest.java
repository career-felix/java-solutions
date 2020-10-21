package idv.felix.maths;

import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

	@Test
	public void _01() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1));
		List<List<Integer>> list = solution.solution(target, candidates);
		list.stream().forEach(combination -> log.info("{}", combination));
	}

	@Test
	public void _02() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1, 2));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
	}

	@Test
	public void _08() {
		int target = 20;
		NavigableSet<Integer> candidates = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		List<List<Integer>> list = solution.solution(target, candidates);
		final AtomicInteger index = new AtomicInteger(0);
		list.stream().forEach(combination -> log.info("{} - {}", index.getAndIncrement(), combination));
	}
}
