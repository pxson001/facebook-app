package com.facebook.zero.connectiontest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: events_suggestions_cut_type */
public class ServerHeaderVerifier implements HttpResponseProcessor {
    private final String f13060a;

    public ServerHeaderVerifier(String str) {
        this.f13060a = str;
    }

    public final void mo561a(int i, HttpURLConnection httpURLConnection) {
        Map headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            String str2;
            if ("server".equalsIgnoreCase(str2)) {
                List list = (List) headerFields.get(str2);
                str2 = list.isEmpty() ? null : (String) list.get(0);
                if (!str2.toLowerCase(Locale.US).contains(this.f13060a)) {
                    throw new IOException("Invalid server header: " + str2 + " expected: " + this.f13060a + " debug: " + ConnectionTestUtil.m13109a(httpURLConnection));
                }
                return;
            }
        }
        throw new IOException("Missing server header, debug: " + ConnectionTestUtil.m13109a(httpURLConnection));
    }

    public final void mo560a(int i, String str) {
        if (!str.contains(this.f13060a)) {
            throw new IOException("Expected string " + this.f13060a + " not found from response");
        }
    }
}
