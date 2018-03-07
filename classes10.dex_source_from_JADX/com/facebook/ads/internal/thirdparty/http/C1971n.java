package com.facebook.ads.internal.thirdparty.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class C1971n {
    public int f14294a;
    public String f14295b;
    public Map<String, List<String>> f14296c;
    private byte[] f14297d;

    public C1971n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f14294a = httpURLConnection.getResponseCode();
            this.f14295b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f14296c = httpURLConnection.getHeaderFields();
        this.f14297d = bArr;
    }

    public final int m14435a() {
        return this.f14294a;
    }

    public final byte[] m14436d() {
        return this.f14297d;
    }

    public final String m14437e() {
        return this.f14297d != null ? new String(this.f14297d) : null;
    }
}
