package com.facebook;

/* compiled from: event_admin_post_approval_required */
public class FacebookException extends RuntimeException {
    public FacebookException(String str) {
        super(str);
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }

    public String toString() {
        return getMessage();
    }
}
