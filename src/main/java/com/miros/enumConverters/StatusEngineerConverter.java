package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.StatusEngineer;

@Converter(autoApply = true)
public class StatusEngineerConverter implements AttributeConverter<StatusEngineer, String> {

	@Override
	public String convertToDatabaseColumn(StatusEngineer StatusEngineer) {
		if (StatusEngineer == null) {
			return null;
		}
		return StatusEngineer.getCode();
	}

	@Override
	public StatusEngineer convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(StatusEngineer.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
