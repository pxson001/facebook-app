package com.facebook.ads.internal.thirdparty.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class C1959f {
    private final C1964g f14269a;

    public C1959f() {
        this(new C1964g());
    }

    private C1959f(C1964g c1964g) {
        this.f14269a = c1964g;
    }

    public final OutputStream m14397a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public final HttpURLConnection m14398a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public final void m14399a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public final boolean m14400a(C1970m c1970m) {
        C1971n c1971n = c1970m.f14293a;
        C1964g c1964g = this.f14269a;
        if (null != null) {
            this.f14269a.m14423a("BasicRequestHandler.onError got");
            c1970m.printStackTrace();
        }
        return c1971n != null && c1971n.f14294a > 0;
    }

    public final byte[] m14401a(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public final InputStream m14402b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
