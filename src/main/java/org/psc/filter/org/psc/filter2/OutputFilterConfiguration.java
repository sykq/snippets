package org.psc.filter.org.psc.filter2;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public enum OutputFilterConfiguration implements FilterConfiguration<String, Integer, Integer> {
	FILTER(e -> e.contains("a"), e -> 2 * e);

	private Predicate<String> filterCondition;
	private Function<Integer, Integer> filterFunction;

	private OutputFilterConfiguration(Predicate<String> filterCondition, Function<Integer, Integer> filterFunction) {
		this.filterCondition = filterCondition;
		this.filterFunction = filterFunction;
	}

	@Override
	public List<FilterConfiguration<String, Integer, Integer>> getConfigurations() {
		return Arrays.asList(OutputFilterConfiguration.values());
	}
}