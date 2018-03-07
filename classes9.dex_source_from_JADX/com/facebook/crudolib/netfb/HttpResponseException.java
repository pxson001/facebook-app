package com.facebook.crudolib.netfb;

import java.io.IOException;

/* compiled from: Time */
class HttpResponseException extends IOException {
    public HttpResponseException(int i, String str) {
        super(i + ": " + str);
    }
}
