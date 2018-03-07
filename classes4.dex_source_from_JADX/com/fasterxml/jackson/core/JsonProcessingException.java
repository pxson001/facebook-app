package com.fasterxml.jackson.core;

import java.io.IOException;

/* compiled from: fetchMultipleContactsParams */
public class JsonProcessingException extends IOException {
    static final long serialVersionUID = 123;
    public JsonLocation _location;

    protected JsonProcessingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this._location = jsonLocation;
    }

    protected JsonProcessingException(String str) {
        super(str);
    }

    protected JsonProcessingException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, null);
    }

    protected JsonProcessingException(String str, Throwable th) {
        this(str, null, th);
    }

    private JsonLocation m12297b() {
        return this._location;
    }

    protected String m12298a() {
        return null;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation jsonLocation = this._location;
        String a = m12298a();
        if (jsonLocation == null && a == null) {
            return message;
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(message);
        if (a != null) {
            stringBuilder.append(a);
        }
        if (jsonLocation != null) {
            stringBuilder.append('\n');
            stringBuilder.append(" at ");
            stringBuilder.append(jsonLocation.toString());
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
