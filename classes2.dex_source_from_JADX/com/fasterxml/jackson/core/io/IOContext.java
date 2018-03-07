package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.BufferRecycler.ByteBufferType;
import com.fasterxml.jackson.core.util.BufferRecycler.CharBufferType;
import com.fasterxml.jackson.core.util.TextBuffer;

/* compiled from: request_id */
public final class IOContext {
    public final Object f7309a;
    public JsonEncoding f7310b;
    public final boolean f7311c;
    protected final BufferRecycler f7312d;
    protected byte[] f7313e = null;
    protected byte[] f7314f = null;
    protected byte[] f7315g = null;
    protected char[] f7316h = null;
    protected char[] f7317i = null;
    protected char[] f7318j = null;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z) {
        this.f7312d = bufferRecycler;
        this.f7309a = obj;
        this.f7311c = z;
    }

    public final void m11837a(JsonEncoding jsonEncoding) {
        this.f7310b = jsonEncoding;
    }

    public final Object m11836a() {
        return this.f7309a;
    }

    public final JsonEncoding m11841b() {
        return this.f7310b;
    }

    public final boolean m11845c() {
        return this.f7311c;
    }

    public final TextBuffer m11846d() {
        return new TextBuffer(this.f7312d);
    }

    public final byte[] m11847e() {
        m11834a(this.f7313e);
        byte[] a = this.f7312d.m11855a(ByteBufferType.READ_IO_BUFFER);
        this.f7313e = a;
        return a;
    }

    public final byte[] m11848f() {
        m11834a(this.f7314f);
        byte[] a = this.f7312d.m11855a(ByteBufferType.WRITE_ENCODING_BUFFER);
        this.f7314f = a;
        return a;
    }

    public final char[] m11849g() {
        m11834a(this.f7316h);
        char[] a = this.f7312d.m11856a(CharBufferType.TOKEN_BUFFER);
        this.f7316h = a;
        return a;
    }

    public final char[] m11850h() {
        m11834a(this.f7317i);
        char[] a = this.f7312d.m11856a(CharBufferType.CONCAT_BUFFER);
        this.f7317i = a;
        return a;
    }

    public final char[] m11840a(int i) {
        m11834a(this.f7318j);
        char[] a = this.f7312d.m11857a(CharBufferType.NAME_COPY_BUFFER, i);
        this.f7318j = a;
        return a;
    }

    public final void m11838a(byte[] bArr) {
        if (bArr != null) {
            m11835a(bArr, this.f7313e);
            this.f7313e = null;
            this.f7312d.m11853a(ByteBufferType.READ_IO_BUFFER, bArr);
        }
    }

    public final void m11842b(byte[] bArr) {
        if (bArr != null) {
            m11835a(bArr, this.f7314f);
            this.f7314f = null;
            this.f7312d.m11853a(ByteBufferType.WRITE_ENCODING_BUFFER, bArr);
        }
    }

    public final void m11839a(char[] cArr) {
        if (cArr != null) {
            m11835a(cArr, this.f7316h);
            this.f7316h = null;
            this.f7312d.m11854a(CharBufferType.TOKEN_BUFFER, cArr);
        }
    }

    public final void m11843b(char[] cArr) {
        if (cArr != null) {
            m11835a(cArr, this.f7317i);
            this.f7317i = null;
            this.f7312d.m11854a(CharBufferType.CONCAT_BUFFER, cArr);
        }
    }

    public final void m11844c(char[] cArr) {
        if (cArr != null) {
            m11835a(cArr, this.f7318j);
            this.f7318j = null;
            this.f7312d.m11854a(CharBufferType.NAME_COPY_BUFFER, cArr);
        }
    }

    private static void m11834a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    private static void m11835a(Object obj, Object obj2) {
        if (obj != obj2) {
            throw new IllegalArgumentException("Trying to release buffer not owned by the context");
        }
    }
}
