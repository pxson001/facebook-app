package com.facebook.http.common;

import org.apache.http.client.HttpResponseException;

/* compiled from: incoming_like_message */
public class ProtocolExceptions {
    public static boolean m10891a(Throwable th) {
        HttpResponseException f = m10893f(th);
        return f != null && f.getStatusCode() == 401;
    }

    public static boolean m10892a(Throwable th, Class cls) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (cls.isInstance(th)) {
                return true;
            }
        }
        return false;
    }

    public static HttpResponseException m10893f(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof HttpResponseException) {
                return (HttpResponseException) th2;
            }
        }
        return null;
    }
}
