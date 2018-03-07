package com.facebook.analytics2.logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* compiled from: t_rtc */
class PoolFriendlyOutputStreamWriter extends Writer {
    private final OutputStream f3505a;
    private CharsetEncoder f3506b;
    private ByteBuffer f3507c;

    public PoolFriendlyOutputStreamWriter(OutputStream outputStream, ByteBuffer byteBuffer) {
        this(outputStream, Charset.defaultCharset(), byteBuffer);
    }

    private PoolFriendlyOutputStreamWriter(OutputStream outputStream, Charset charset, ByteBuffer byteBuffer) {
        super(outputStream);
        this.f3505a = outputStream;
        this.f3507c = byteBuffer;
        this.f3506b = charset.newEncoder();
        this.f3506b.onMalformedInput(CodingErrorAction.REPLACE);
        this.f3506b.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public void close() {
        synchronized (this.lock) {
            if (this.f3506b != null) {
                m5717a();
                m5719a(false);
                this.f3505a.close();
                this.f3506b = null;
                this.f3507c = null;
            }
        }
    }

    public void flush() {
        m5719a(true);
    }

    private void m5719a(boolean z) {
        synchronized (this.lock) {
            m5720b();
            int position = this.f3507c.position();
            if (position > 0) {
                this.f3507c.flip();
                this.f3505a.write(this.f3507c.array(), this.f3507c.arrayOffset(), position);
                this.f3507c.clear();
            }
            if (z) {
                this.f3505a.flush();
            }
        }
    }

    private void m5718a(CharBuffer charBuffer) {
        while (true) {
            CoderResult encode = this.f3506b.encode(charBuffer, this.f3507c, false);
            if (!encode.isOverflow()) {
                break;
            }
            m5719a(false);
        }
        if (encode.isError()) {
            encode.throwException();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5717a() {
        /*
        r5 = this;
        r4 = 0;
        r0 = java.nio.CharBuffer.allocate(r4);
    L_0x0005:
        r1 = r5.f3506b;
        r2 = r5.f3507c;
        r3 = 1;
        r1 = r1.encode(r0, r2, r3);
        r2 = r1.isError();
        if (r2 == 0) goto L_0x002f;
    L_0x0014:
        r1.throwException();
    L_0x0017:
        r0 = r5.f3506b;
        r1 = r5.f3507c;
        r0 = r0.flush(r1);
    L_0x001f:
        r1 = r0.isUnderflow();
        if (r1 != 0) goto L_0x003d;
    L_0x0025:
        r1 = r0.isOverflow();
        if (r1 == 0) goto L_0x0039;
    L_0x002b:
        r5.m5719a(r4);
        goto L_0x0017;
    L_0x002f:
        r1 = r1.isOverflow();
        if (r1 == 0) goto L_0x0017;
    L_0x0035:
        r5.m5719a(r4);
        goto L_0x0005;
    L_0x0039:
        r0.throwException();
        goto L_0x001f;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.logger.PoolFriendlyOutputStreamWriter.a():void");
    }

    private void m5720b() {
        if (this.f3506b == null) {
            throw new IOException("OutputStreamWriter is closed");
        }
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            m5720b();
            LibcoreUtils.m5733a(cArr.length, i, i2);
            m5718a(CharBuffer.wrap(cArr, i, i2));
        }
    }

    public void write(int i) {
        synchronized (this.lock) {
            m5720b();
            m5718a(CharBuffer.wrap(new char[]{(char) i}));
        }
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            if (i2 < 0) {
                throw LibcoreUtils.m5732a(str, i, i2);
            } else if (str == null) {
                throw new NullPointerException("str == null");
            } else if ((i | i2) < 0 || i > str.length() - i2) {
                throw LibcoreUtils.m5732a(str, i, i2);
            } else {
                m5720b();
                m5718a(CharBuffer.wrap(str, i, i2 + i));
            }
        }
    }
}
