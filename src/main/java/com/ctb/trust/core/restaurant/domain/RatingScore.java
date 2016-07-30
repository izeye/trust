/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctb.trust.core.restaurant.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Rating scored by a user.
 *
 * @author Johnny Lim
 */
public enum RatingScore {

	/**
	 * Bad.
	 */
	BAD(1),

	/**
	 * So so.
	 */
	SO_SO(2),

	/**
	 * Good.
	 */
	GOOD(3),

	/**
	 * Very good.
	 */
	VERY_GOOD(4),

	/**
	 * Excellent.
	 */
	EXCELLENT(5);

	private static final Map<Integer, RatingScore> VALUE_BY_SCORE;

	static {
		Map<Integer, RatingScore> valueByScore = new HashMap<>();
		for (RatingScore value : values()) {
			valueByScore.put(value.getScore(), value);
		}
		VALUE_BY_SCORE = Collections.unmodifiableMap(valueByScore);
	}

	private final int score;

	RatingScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public static RatingScore getValueByScore(int score) {
		return VALUE_BY_SCORE.get(score);
	}

}
