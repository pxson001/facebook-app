package com.facebook.zero.connectiontest;

import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: evt */
public class HttpResponseCodeVerifier implements HttpResponseProcessor {
    private final int f13058a;

    public HttpResponseCodeVerifier(int i) {
        this.f13058a = i;
    }

    public final void mo561a(int i, HttpURLConnection httpURLConnection) {
        if (i != this.f13058a) {
            throw new IOException("Expected response code " + this.f13058a + ", got " + i);
        }
    }

    public final void mo560a(int i, String str) {
        if (i != this.f13058a) {
            throw new IOException("Expected response code " + this.f13058a + ", got " + i);
        }
    }
}
