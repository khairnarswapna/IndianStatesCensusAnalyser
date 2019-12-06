package com.bridgelabz;

public class CustomException extends Exception {

    public enum ExceptionType {
        FILE_NOT_FOUND,INCORRECT_TYPE,DELEMETER_NOT_FOUND,INCORRECT_HEADER,BINDING_BROBLEM_AT_RUNTIME,NO_SUCH_FILE
    }
    public ExceptionType type;

   public CustomException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

   public CustomException(ExceptionType type) {
        this.type = type;
    }

    public CustomException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CustomException(String message, Throwable cause, ExceptionType type) {
        super(message, cause);
        this.type = type;
    }

    public CustomException(Throwable cause, ExceptionType type) {
        super(cause);
        this.type = type;
    }
}

