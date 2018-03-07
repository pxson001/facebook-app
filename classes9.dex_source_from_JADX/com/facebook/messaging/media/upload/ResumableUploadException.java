package com.facebook.messaging.media.upload;

import org.apache.http.client.HttpResponseException;

/* compiled from: lifetimeOverallStats */
public final class ResumableUploadException extends Exception {
    private static final Integer f12021a = Integer.valueOf(400);

    private ResumableUploadException(String str) {
        super(str);
    }

    public static void m12560a(HttpResponseException httpResponseException) {
        if (httpResponseException.getStatusCode() == f12021a.intValue()) {
            throw new ResumableUploadException("Server returned fatal http error code");
        }
    }
}
