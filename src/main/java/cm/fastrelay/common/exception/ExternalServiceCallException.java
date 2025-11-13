package cm.fastrelay.common.exception;

public class ExternalServiceCallException extends RuntimeException {
  public ExternalServiceCallException(String errorMessage) {
    super(errorMessage);
  }
}
