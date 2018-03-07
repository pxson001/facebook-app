package com.facebook.zero.connectiontest;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.iolite.Closeables;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: events_summary_view_order_ride */
public class HttpResponseContentVerifier implements HttpResponseProcessor {
    private final String f13059a;

    public HttpResponseContentVerifier(String str) {
        this.f13059a = str;
    }

    public final void mo561a(int i, HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            if (new String(ByteStreams.a(inputStream), "UTF-8").indexOf(this.f13059a) < 0) {
                throw new IOException("Expected string " + this.f13059a + " not found from response, headers: " + ConnectionTestUtil.m13109a(httpURLConnection));
            }
        } finally {
            Closeables.a(inputStream);
        }
    }

    public final void mo560a(int i, String str) {
        if (!str.contains(this.f13059a)) {
            throw new IOException("Expected string " + this.f13059a + " not found from response");
        }
    }
}
