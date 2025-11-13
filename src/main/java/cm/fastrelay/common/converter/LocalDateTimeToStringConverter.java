package cm.fastrelay.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class LocalDateTimeToStringConverter implements AttributeConverter<LocalDateTime, String> {
  @Override
  public String convertToDatabaseColumn(LocalDateTime localDateTime) {
    if (localDateTime == null) {
      return null;
    }
    return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
  }

  @Override
  public LocalDateTime convertToEntityAttribute(String s) {
    if (s == null) {
      return null;
    }
    return LocalDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME);
  }
}
