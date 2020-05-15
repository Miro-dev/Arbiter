package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.Materials;

@Converter(autoApply = true)
public class MaterialsConverter implements AttributeConverter<Materials, String> {

	@Override
	public String convertToDatabaseColumn(Materials Materials) {
		if (Materials == null) {
			return null;
		}
		return Materials.getCode();
	}

	@Override
	public Materials convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(Materials.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
