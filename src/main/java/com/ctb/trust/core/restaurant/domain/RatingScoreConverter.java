package com.ctb.trust.core.restaurant.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by izeye on 16. 6. 10..
 */
@Converter(autoApply = true)
public class RatingScoreConverter implements AttributeConverter<RatingScore, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(RatingScore attribute) {
		return attribute.getScore();
	}

	@Override
	public RatingScore convertToEntityAttribute(Integer dbData) {
		if (dbData == null) {
			return null;
		}
		return RatingScore.getValueByScore(dbData);
	}
	
}
