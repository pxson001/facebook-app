package com.facebook.analytics2.logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* compiled from: text_background_color */
public class PoolFriendlyInputStreamReader extends Reader {
    private InputStream f2033a;
    private boolean f2034b;
    private CharsetDecoder f2035c;
    private final ByteBuffer f2036d;

    public PoolFriendlyInputStreamReader(InputStream inputStream, ByteBuffer byteBuffer) {
        this(inputStream, Charset.defaultCharset(), byteBuffer);
    }

    private PoolFriendlyInputStreamReader(InputStream inputStream, Charset charset, ByteBuffer byteBuffer) {
        super(inputStream);
        this.f2034b = false;
        this.f2036d = byteBuffer;
        this.f2033a = inputStream;
        this.f2035c = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.f2036d.limit(0);
    }

    public void close() {
        synchronized (this.lock) {
            if (this.f2035c != null) {
                this.f2035c.reset();
            }
            this.f2035c = null;
            if (this.f2033a != null) {
                this.f2033a.close();
                this.f2033a = null;
            }
        }
    }

    public int read() {
        int i = -1;
        synchronized (this.lock) {
            if (m2739a()) {
                char[] cArr = new char[1];
                if (read(cArr, 0, 1) != -1) {
                    i = cArr[0];
                }
            } else {
                throw new IOException("InputStreamReader is closed");
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(char[] r11, int r12, int r13) {
        /*
        r10 = this;
        r2 = -1;
        r1 = 1;
        r0 = 0;
        r4 = r10.lock;
        monitor-enter(r4);
        r3 = r10.m2739a();	 Catch:{ all -> 0x0014 }
        if (r3 != 0) goto L_0x0017;
    L_0x000c:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x0014 }
        r1 = "InputStreamReader is closed";
        r0.<init>(r1);	 Catch:{ all -> 0x0014 }
        throw r0;	 Catch:{ all -> 0x0014 }
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r3 = r11.length;	 Catch:{  }
        com.facebook.analytics2.logger.LibcoreUtils.a(r3, r12, r13);	 Catch:{  }
        if (r13 != 0) goto L_0x001f;
    L_0x001d:
        monitor-exit(r4);	 Catch:{  }
    L_0x001e:
        return r0;
    L_0x001f:
        r5 = java.nio.CharBuffer.wrap(r11, r12, r13);	 Catch:{  }
        r3 = java.nio.charset.CoderResult.UNDERFLOW;	 Catch:{  }
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.hasRemaining();	 Catch:{  }
        if (r6 != 0) goto L_0x002e;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        r9 = r0;
        r0 = r3;
        r3 = r9;
    L_0x0031:
        r6 = r5.hasRemaining();	 Catch:{  }
        if (r6 == 0) goto L_0x0047;
    L_0x0037:
        if (r3 == 0) goto L_0x00bb;
    L_0x0039:
        r3 = r10.f2033a;	 Catch:{ IOException -> 0x0080 }
        r3 = r3.available();	 Catch:{ IOException -> 0x0080 }
        if (r3 != 0) goto L_0x0081;
    L_0x0041:
        r3 = r5.position();	 Catch:{ IOException -> 0x0080 }
        if (r3 <= r12) goto L_0x0081;
    L_0x0047:
        r1 = java.nio.charset.CoderResult.UNDERFLOW;	 Catch:{  }
        if (r0 != r1) goto L_0x0067;
    L_0x004b:
        r1 = r10.f2034b;	 Catch:{  }
        if (r1 == 0) goto L_0x0067;
    L_0x004f:
        r0 = r10.f2035c;	 Catch:{  }
        r1 = r10.f2036d;	 Catch:{  }
        r3 = 1;
        r0 = r0.decode(r1, r5, r3);	 Catch:{  }
        r1 = java.nio.charset.CoderResult.UNDERFLOW;	 Catch:{  }
        if (r0 != r1) goto L_0x0062;
    L_0x005c:
        r0 = r10.f2035c;	 Catch:{  }
        r0 = r0.flush(r5);	 Catch:{  }
    L_0x0062:
        r1 = r10.f2035c;	 Catch:{  }
        r1.reset();	 Catch:{  }
    L_0x0067:
        r1 = r0.isMalformed();	 Catch:{  }
        if (r1 != 0) goto L_0x0073;
    L_0x006d:
        r1 = r0.isUnmappable();	 Catch:{  }
        if (r1 == 0) goto L_0x0076;
    L_0x0073:
        r0.throwException();	 Catch:{  }
    L_0x0076:
        r0 = r5.position();	 Catch:{  }
        r0 = r0 - r12;
        if (r0 != 0) goto L_0x00f1;
    L_0x007d:
        r0 = r2;
    L_0x007e:
        monitor-exit(r4);	 Catch:{  }
        goto L_0x001e;
    L_0x0080:
        r3 = move-exception;
    L_0x0081:
        r3 = r10.f2036d;	 Catch:{  }
        r3 = r3.capacity();	 Catch:{  }
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.limit();	 Catch:{  }
        r3 = r3 - r6;
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.arrayOffset();	 Catch:{  }
        r7 = r10.f2036d;	 Catch:{  }
        r7 = r7.limit();	 Catch:{  }
        r6 = r6 + r7;
        r7 = r10.f2033a;	 Catch:{  }
        r8 = r10.f2036d;	 Catch:{  }
        r8 = r8.array();	 Catch:{  }
        r3 = r7.read(r8, r6, r3);	 Catch:{  }
        if (r3 != r2) goto L_0x00ad;
    L_0x00a9:
        r1 = 1;
        r10.f2034b = r1;	 Catch:{  }
        goto L_0x0047;
    L_0x00ad:
        if (r3 == 0) goto L_0x0047;
    L_0x00af:
        r0 = r10.f2036d;	 Catch:{  }
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.limit();	 Catch:{  }
        r3 = r3 + r6;
        r0.limit(r3);	 Catch:{  }
    L_0x00bb:
        r0 = r10.f2035c;	 Catch:{  }
        r3 = r10.f2036d;	 Catch:{  }
        r6 = 0;
        r0 = r0.decode(r3, r5, r6);	 Catch:{  }
        r3 = r0.isUnderflow();	 Catch:{  }
        if (r3 == 0) goto L_0x0047;
    L_0x00ca:
        r3 = r10.f2036d;	 Catch:{  }
        r3 = r3.limit();	 Catch:{  }
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.capacity();	 Catch:{  }
        if (r3 != r6) goto L_0x00ee;
    L_0x00d8:
        r3 = r10.f2036d;	 Catch:{  }
        r3.compact();	 Catch:{  }
        r3 = r10.f2036d;	 Catch:{  }
        r6 = r10.f2036d;	 Catch:{  }
        r6 = r6.position();	 Catch:{  }
        r3.limit(r6);	 Catch:{  }
        r3 = r10.f2036d;	 Catch:{  }
        r6 = 0;
        r3.position(r6);	 Catch:{  }
    L_0x00ee:
        r3 = r1;
        goto L_0x0031;
    L_0x00f1:
        r0 = r5.position();	 Catch:{  }
        r0 = r0 - r12;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.logger.PoolFriendlyInputStreamReader.read(char[], int, int):int");
    }

    private boolean m2739a() {
        return this.f2033a != null;
    }

    public boolean ready() {
        boolean z = false;
        synchronized (this.lock) {
            if (this.f2033a == null) {
                throw new IOException("InputStreamReader is closed");
            }
            try {
                if (this.f2036d.hasRemaining() || this.f2033a.available() > 0) {
                    z = true;
                }
            } catch (IOException e) {
            }
        }
        return z;
    }
}
