package com.fasterxml.jackson.core.json;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: graphsearch/query?q=%s&display_style=%s&title=%s */
public final class ByteSourceJsonBootstrapper {
    protected final IOContext f21858a;
    protected final InputStream f21859b;
    protected final byte[] f21860c;
    protected int f21861d;
    protected boolean f21862e = true;
    protected int f21863f = 0;
    private int f21864g;
    private int f21865h;
    private final boolean f21866i;

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this.f21858a = iOContext;
        this.f21859b = inputStream;
        this.f21860c = iOContext.m11847e();
        this.f21864g = 0;
        this.f21865h = 0;
        this.f21861d = 0;
        this.f21866i = true;
    }

    public ByteSourceJsonBootstrapper(IOContext iOContext, byte[] bArr, int i, int i2) {
        this.f21858a = iOContext;
        this.f21859b = null;
        this.f21860c = bArr;
        this.f21864g = i;
        this.f21865h = i + i2;
        this.f21861d = -i;
        this.f21866i = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.core.JsonEncoding m29638a() {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = 4;
        r2 = r5.m29644d(r2);
        if (r2 == 0) goto L_0x0055;
    L_0x0009:
        r2 = r5.f21860c;
        r3 = r5.f21864g;
        r2 = r2[r3];
        r2 = r2 << 24;
        r3 = r5.f21860c;
        r4 = r5.f21864g;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 16;
        r2 = r2 | r3;
        r3 = r5.f21860c;
        r4 = r5.f21864g;
        r4 = r4 + 2;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r2 = r2 | r3;
        r3 = r5.f21860c;
        r4 = r5.f21864g;
        r4 = r4 + 3;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r3 = r5.m29640a(r2);
        if (r3 == 0) goto L_0x0045;
    L_0x003c:
        if (r0 != 0) goto L_0x0078;
    L_0x003e:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8;
    L_0x0040:
        r1 = r5.f21858a;
        r1.f7310b = r0;
        return r0;
    L_0x0045:
        r3 = r5.m29642b(r2);
        if (r3 != 0) goto L_0x003c;
    L_0x004b:
        r2 = r2 >>> 16;
        r2 = r5.m29643c(r2);
        if (r2 != 0) goto L_0x003c;
    L_0x0053:
        r0 = r1;
        goto L_0x003c;
    L_0x0055:
        r2 = 2;
        r2 = r5.m29644d(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x005c:
        r2 = r5.f21860c;
        r3 = r5.f21864g;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r3 = r5.f21860c;
        r4 = r5.f21864g;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r2 = r5.m29643c(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0077:
        goto L_0x003c;
    L_0x0078:
        r0 = r5.f21863f;
        switch(r0) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0088;
            case 3: goto L_0x007d;
            case 4: goto L_0x0092;
            default: goto L_0x007d;
        };
    L_0x007d:
        r0 = new java.lang.RuntimeException;
        r1 = "Internal error";
        r0.<init>(r1);
        throw r0;
    L_0x0085:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8;
        goto L_0x0040;
    L_0x0088:
        r0 = r5.f21862e;
        if (r0 == 0) goto L_0x008f;
    L_0x008c:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE;
        goto L_0x0040;
    L_0x008f:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE;
        goto L_0x0040;
    L_0x0092:
        r0 = r5.f21862e;
        if (r0 == 0) goto L_0x0099;
    L_0x0096:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE;
        goto L_0x0040;
    L_0x0099:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper.a():com.fasterxml.jackson.core.JsonEncoding");
    }

    private Reader m29641b() {
        JsonEncoding jsonEncoding = this.f21858a.f7310b;
        switch (1.a[jsonEncoding.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new UTF32Reader(this.f21858a, this.f21859b, this.f21860c, this.f21864g, this.f21865h, this.f21858a.f7310b.isBigEndian());
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                InputStream inputStream = this.f21859b;
                InputStream byteArrayInputStream = inputStream == null ? new ByteArrayInputStream(this.f21860c, this.f21864g, this.f21865h) : this.f21864g < this.f21865h ? new MergedStream(this.f21858a, inputStream, this.f21860c, this.f21864g, this.f21865h) : inputStream;
                return new InputStreamReader(byteArrayInputStream, jsonEncoding.getJavaName());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    public final JsonParser m29645a(int i, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2) {
        if (m29638a() == JsonEncoding.UTF8 && z) {
            return new UTF8StreamJsonParser(this.f21858a, i, this.f21859b, objectCodec, bytesToNameCanonicalizer.m7216a(z2), this.f21860c, this.f21864g, this.f21865h, this.f21866i);
        }
        return new ReaderBasedJsonParser(this.f21858a, i, m29641b(), objectCodec, charsToNameCanonicalizer.m7188a(z, z2));
    }

    private boolean m29640a(int i) {
        switch (i) {
            case -16842752:
                break;
            case -131072:
                this.f21864g += 4;
                this.f21863f = 4;
                this.f21862e = false;
                return true;
            case 65279:
                this.f21862e = true;
                this.f21864g += 4;
                this.f21863f = 4;
                return true;
            case 65534:
                m29639a("2143");
                break;
        }
        m29639a("3412");
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.f21864g += 2;
            this.f21863f = 2;
            this.f21862e = true;
            return true;
        } else if (i2 == 65534) {
            this.f21864g += 2;
            this.f21863f = 2;
            this.f21862e = false;
            return true;
        } else if ((i >>> 8) != 15711167) {
            return false;
        } else {
            this.f21864g += 3;
            this.f21863f = 1;
            this.f21862e = true;
            return true;
        }
    }

    private boolean m29642b(int i) {
        if ((i >> 8) == 0) {
            this.f21862e = true;
        } else if ((16777215 & i) == 0) {
            this.f21862e = false;
        } else if ((-16711681 & i) == 0) {
            m29639a("3412");
        } else if ((-65281 & i) != 0) {
            return false;
        } else {
            m29639a("2143");
        }
        this.f21863f = 4;
        return true;
    }

    private boolean m29643c(int i) {
        if ((65280 & i) == 0) {
            this.f21862e = true;
        } else if ((i & 255) != 0) {
            return false;
        } else {
            this.f21862e = false;
        }
        this.f21863f = 2;
        return true;
    }

    private static void m29639a(String str) {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private boolean m29644d(int i) {
        int i2 = this.f21865h - this.f21864g;
        while (i2 < i) {
            int i3;
            if (this.f21859b == null) {
                i3 = -1;
            } else {
                i3 = this.f21859b.read(this.f21860c, this.f21865h, this.f21860c.length - this.f21865h);
            }
            if (i3 <= 0) {
                return false;
            }
            this.f21865h += i3;
            i2 = i3 + i2;
        }
        return true;
    }
}
