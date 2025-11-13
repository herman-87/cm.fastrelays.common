package cm.fastrelay.common.domain;

import cm.fastrelay.common.exception.InvalidEmailAddressException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@EqualsAndHashCode
@Getter
@Setter
public class EmailAddress {
  private String value;
  private final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

  public EmailAddress(String email) {
    if (email != null) {
      if (!Pattern.matches(EMAIL_REGEX, email)) {
        throw new InvalidEmailAddressException("Email address is invalid");
      }
      this.value = email;
    }
  }
}
