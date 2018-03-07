package com.facebook.http.protocol;

import java.io.OutputStream;

/* compiled from: dialtone_wifi_interstitial_become_invisible */
public class ByteArrayBody extends ContentBody {
    private byte[] f5065b;

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str, (long) bArr.length, str2);
        this.f5065b = bArr;
    }

    public final void mo621b(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        outputStream.write(this.f5065b);
    }
}
