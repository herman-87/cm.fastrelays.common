package cm.fastrelay.common.converter;

import cm.fastrelay.common.domain.EmailAddress;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmailAddressToStringConverter implements AttributeConverter<EmailAddress, String> {
  @Override
  public String convertToDatabaseColumn(EmailAddress emailAddress) {
    if (emailAddress == null) {
      return null;
    }
    return emailAddress.getValue();
  }

  @Override
  public EmailAddress convertToEntityAttribute(String email) {
    if (email == null) {
      return null;
    }
    return new EmailAddress(email);
  }
}
