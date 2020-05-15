package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.AccessLevel;

@Converter(autoApply = true)
public class AccessLevelConverter implements AttributeConverter<AccessLevel, String> {

	@Override
	public String convertToDatabaseColumn(AccessLevel AccessLevel) {
		if (AccessLevel == null) {
			return null;
		}
		return AccessLevel.getCode();
	}

	@Override
	public AccessLevel convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(AccessLevel.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
