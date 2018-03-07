package com.facebook;

/* compiled from: eventNameEditTextSuperState */
public class FacebookServiceException extends FacebookException {
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.error = facebookRequestError;
    }

    public final FacebookRequestError m14055a() {
        return this.error;
    }

    public final String toString() {
        return "{FacebookServiceException: " + "httpResponseCode: " + this.error.f13749c + ", facebookErrorCode: " + this.error.f13750d + ", facebookErrorType: " + this.error.f13752f + ", message: " + this.error.m14041d() + "}";
    }
}
