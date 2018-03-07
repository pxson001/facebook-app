package com.facebook.phonenumbers;

/* compiled from: dbl_change_nonce */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    /* compiled from: dbl_change_nonce */
    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType, String str) {
        super(str);
        this.message = str;
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
