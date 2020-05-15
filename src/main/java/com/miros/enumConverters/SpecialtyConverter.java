package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.Specialty;

@Converter(autoApply = true)
public class SpecialtyConverter implements AttributeConverter<Specialty, String> {

	@Override
	public String convertToDatabaseColumn(Specialty Specialty) {
		if (Specialty == null) {
			return null;
		}
		return Specialty.getCode();
	}

	@Override
	public Specialty convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(Specialty.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
