package by.itacademy.javaenterprise.goralchuk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionControl {

    @ExceptionHandler
    public ResponseEntity<MessageException> notFoundException(NoFoundException exception, WebRequest request){
        MessageException message = new MessageException();
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        message.setCode(404);
        message.setMessage(exception.getMessage());
        message.setException(exception.getLocalizedMessage());
        message.setResponse(request.getDescription(true));
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    };

    @ExceptionHandler
    public ResponseEntity<MessageException> serverException(Exception exception, WebRequest request){
        MessageException message = new MessageException();
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        message.setCode(500);
        message.setMessage(exception.getMessage());
        message.setException(exception.getLocalizedMessage());
        message.setResponse(request.getDescription(true));
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    };

    @ExceptionHandler
    public ResponseEntity<MessageException> securityException(AuthoriseException exception, WebRequest request){
        MessageException message = new MessageException();
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        message.setCode(401);
        message.setMessage(exception.getMessage());
        message.setException(exception.getLocalizedMessage());
        message.setResponse(request.getDescription(true));
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    };

}
