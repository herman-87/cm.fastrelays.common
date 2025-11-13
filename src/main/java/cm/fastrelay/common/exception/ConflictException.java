package cm.fastrelay.common.exception;

public class ConflictException extends RuntimeException {
  public ConflictException(String errorMessage) {
    super(errorMessage);
  }
}
