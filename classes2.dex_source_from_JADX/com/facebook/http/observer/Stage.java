package com.facebook.http.observer;

/* compiled from: notifChangeSetting */
public enum Stage {
    HTTP_CLIENT_EXECUTE("http_client_execute"),
    READ_RESPONSE_BODY("read_response_body");
    
    private final String mName;

    private Stage(String str) {
        this.mName = str;
    }

    public final String toString() {
        return this.mName;
    }
}
