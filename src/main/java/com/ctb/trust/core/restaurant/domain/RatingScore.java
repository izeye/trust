package com.ctb.trust.core.restaurant.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by izeye on 16. 6. 10..
 */
public enum RatingScore {

	BAD(1), SO_SO(2), GOOD(3), VERY_GOOD(4), EXCELLENT(5);
	
	private static final Map<Integer, RatingScore> VALUE_BY_SCORE;
	
	static {
		Map<Integer, RatingScore> valueByScore = new HashMap<>();
		for (RatingScore value : values()) {
			valueByScore.put(value.getScore(), value);
		}
		VALUE_BY_SCORE = Collections.unmodifiableMap(valueByScore);
	}

	private final int score;

	private RatingScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public static RatingScore getValueByScore(int score) {
		return VALUE_BY_SCORE.get(score);
	}

}
