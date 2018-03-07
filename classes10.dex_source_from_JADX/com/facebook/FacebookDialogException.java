package com.facebook;

/* compiled from: event_action_bar_overflow_button_click */
public class FacebookDialogException extends FacebookException {
    public int errorCode;
    public String failingUrl;

    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    public final String toString() {
        return "{FacebookDialogException: " + "errorCode: " + this.errorCode + ", message: " + getMessage() + ", url: " + this.failingUrl + "}";
    }
}
