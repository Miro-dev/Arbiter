package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.StatusOrder;

@Converter(autoApply = true)
public class StatusOrderConverter implements AttributeConverter<StatusOrder, String> {

	@Override
	public String convertToDatabaseColumn(StatusOrder StatusOrder) {
		if (StatusOrder == null) {
			return null;
		}
		return StatusOrder.getCode();
	}

	@Override
	public StatusOrder convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(StatusOrder.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
