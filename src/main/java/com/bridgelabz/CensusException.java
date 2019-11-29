package com.bridgelabz;

public class CensusException extends Exception {

    enum ExceptionType {
        FILE_NOT_FOUND
    }
    ExceptionType type;
    public CensusException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
