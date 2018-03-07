package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler.ByteBufferType;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: first_visible_item_offset */
public final class ByteArrayBuilder extends OutputStream {
    private static final byte[] f11537a = new byte[0];
    private final BufferRecycler f11538b;
    private final LinkedList<byte[]> f11539c;
    private int f11540d;
    public byte[] f11541e;
    public int f11542f;

    public ByteArrayBuilder() {
        this(null);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    public ByteArrayBuilder(int i) {
        this(null, i);
    }

    private ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this.f11539c = new LinkedList();
        this.f11538b = bufferRecycler;
        if (bufferRecycler == null) {
            this.f11541e = new byte[i];
        } else {
            this.f11541e = bufferRecycler.a(ByteBufferType.WRITE_CONCAT_BUFFER);
        }
    }

    public final void m12024a() {
        this.f11540d = 0;
        this.f11542f = 0;
        if (!this.f11539c.isEmpty()) {
            this.f11539c.clear();
        }
    }

    public final void m12026b() {
        m12024a();
        if (this.f11538b != null && this.f11541e != null) {
            this.f11538b.a(ByteBufferType.WRITE_CONCAT_BUFFER, this.f11541e);
            this.f11541e = null;
        }
    }

    public final void m12025a(int i) {
        if (this.f11542f >= this.f11541e.length) {
            m12023h();
        }
        byte[] bArr = this.f11541e;
        int i2 = this.f11542f;
        this.f11542f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final void m12027b(int i) {
        if (this.f11542f + 1 < this.f11541e.length) {
            byte[] bArr = this.f11541e;
            int i2 = this.f11542f;
            this.f11542f = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.f11541e;
            i2 = this.f11542f;
            this.f11542f = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        m12025a(i >> 8);
        m12025a(i);
    }

    public final void m12028c(int i) {
        if (this.f11542f + 2 < this.f11541e.length) {
            byte[] bArr = this.f11541e;
            int i2 = this.f11542f;
            this.f11542f = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            bArr = this.f11541e;
            i2 = this.f11542f;
            this.f11542f = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.f11541e;
            i2 = this.f11542f;
            this.f11542f = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        m12025a(i >> 16);
        m12025a(i >> 8);
        m12025a(i);
    }

    public final byte[] m12029c() {
        int i = this.f11540d + this.f11542f;
        if (i == 0) {
            return f11537a;
        }
        Object obj = new byte[i];
        Iterator it = this.f11539c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            int length = bArr.length;
            System.arraycopy(bArr, 0, obj, i2, length);
            i2 += length;
        }
        System.arraycopy(this.f11541e, 0, obj, i2, this.f11542f);
        int i3 = this.f11542f + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.f11539c.isEmpty()) {
            m12024a();
        }
        return obj;
    }

    public final byte[] m12030d() {
        m12024a();
        return this.f11541e;
    }

    public final byte[] m12033e() {
        m12023h();
        return this.f11541e;
    }

    public final byte[] m12031d(int i) {
        this.f11542f = i;
        return m12029c();
    }

    public final byte[] m12034f() {
        return this.f11541e;
    }

    public final void m12032e(int i) {
        this.f11542f = i;
    }

    public final int m12035g() {
        return this.f11542f;
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.f11541e.length - this.f11542f, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.f11541e, this.f11542f, min);
                i += min;
                this.f11542f += min;
                i2 -= min;
            }
            if (i2 > 0) {
                m12023h();
            } else {
                return;
            }
        }
    }

    public final void write(int i) {
        m12025a(i);
    }

    public final void close() {
    }

    public final void flush() {
    }

    private void m12023h() {
        int i = 262144;
        this.f11540d += this.f11541e.length;
        int max = Math.max(this.f11540d >> 1, 1000);
        if (max <= 262144) {
            i = max;
        }
        this.f11539c.add(this.f11541e);
        this.f11541e = new byte[i];
        this.f11542f = 0;
    }
}
