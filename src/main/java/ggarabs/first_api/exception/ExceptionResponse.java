package ggarabs.first_api.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
