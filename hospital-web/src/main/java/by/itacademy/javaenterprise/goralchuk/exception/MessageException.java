package by.itacademy.javaenterprise.goralchuk.exception;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageException {
    private Timestamp timestamp;
    private int code;
    private String message;
    private String exception;
    private String response;
}
