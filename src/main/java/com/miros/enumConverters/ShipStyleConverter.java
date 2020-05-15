package com.miros.enumConverters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.miros.web.enums.ShipStyle;

@Converter(autoApply = true)
public class ShipStyleConverter implements AttributeConverter<ShipStyle, String> {

	@Override
	public String convertToDatabaseColumn(ShipStyle ShipStyle) {
		if (ShipStyle == null) {
			return null;
		}
		return ShipStyle.getCode();
	}

	@Override
	public ShipStyle convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(ShipStyle.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
