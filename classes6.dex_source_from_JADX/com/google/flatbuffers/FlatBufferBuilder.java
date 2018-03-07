package com.google.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: qrcode_type */
public class FlatBufferBuilder {
    static final Charset f6837c = Charset.forName("UTF-8");
    static final /* synthetic */ boolean f6838m = (!FlatBufferBuilder.class.desiredAssertionStatus());
    public ByteBuffer f6839a;
    public int f6840b;
    int f6841d;
    int[] f6842e;
    int f6843f;
    boolean f6844g;
    int f6845h;
    int[] f6846i;
    int f6847j;
    int f6848k;
    boolean f6849l;

    public FlatBufferBuilder(int i) {
        this.f6841d = 1;
        this.f6842e = null;
        this.f6843f = 0;
        this.f6844g = false;
        this.f6846i = new int[16];
        this.f6847j = 0;
        this.f6848k = 0;
        this.f6849l = false;
        if (i <= 0) {
            i = 1;
        }
        this.f6840b = i;
        this.f6839a = m9948d(i);
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public final FlatBufferBuilder m9956a(ByteBuffer byteBuffer) {
        this.f6839a = byteBuffer;
        this.f6839a.clear();
        this.f6839a.order(ByteOrder.LITTLE_ENDIAN);
        this.f6841d = 1;
        this.f6840b = this.f6839a.capacity();
        this.f6843f = 0;
        this.f6844g = false;
        this.f6845h = 0;
        this.f6847j = 0;
        this.f6848k = 0;
        return this;
    }

    private static ByteBuffer m9948d(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private static ByteBuffer m9945b(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i = capacity << 1;
        byteBuffer.position(0);
        ByteBuffer d = m9948d(i);
        d.position(i - capacity);
        d.put(byteBuffer);
        return d;
    }

    public final int m9954a() {
        return this.f6839a.capacity() - this.f6840b;
    }

    public final void m9962a(int i, int i2) {
        if (i > this.f6841d) {
            this.f6841d = i;
        }
        int capacity = ((((this.f6839a.capacity() - this.f6840b) + i2) ^ -1) + 1) & (i - 1);
        while (this.f6840b < (capacity + i) + i2) {
            int capacity2 = this.f6839a.capacity();
            this.f6839a = m9945b(this.f6839a);
            this.f6840b = (this.f6839a.capacity() - capacity2) + this.f6840b;
        }
        for (int i3 = 0; i3 < capacity; i3++) {
            ByteBuffer byteBuffer = this.f6839a;
            int i4 = this.f6840b - 1;
            this.f6840b = i4;
            byteBuffer.put(i4, (byte) 0);
        }
    }

    private void m9950f(int i) {
        ByteBuffer byteBuffer = this.f6839a;
        int i2 = this.f6840b - 4;
        this.f6840b = i2;
        byteBuffer.putInt(i2, i);
    }

    public final void m9957a(double d) {
        ByteBuffer byteBuffer = this.f6839a;
        int i = this.f6840b - 8;
        this.f6840b = i;
        byteBuffer.putDouble(i, d);
    }

    private void m9946b(byte b) {
        m9962a(1, 0);
        ByteBuffer byteBuffer = this.f6839a;
        int i = this.f6840b - 1;
        this.f6840b = i;
        byteBuffer.put(i, b);
    }

    private void m9947b(short s) {
        m9962a(2, 0);
        ByteBuffer byteBuffer = this.f6839a;
        int i = this.f6840b - 2;
        this.f6840b = i;
        byteBuffer.putShort(i, s);
    }

    private void m9951g(int i) {
        m9962a(4, 0);
        m9950f(i);
    }

    public final void m9958a(int i) {
        m9962a(4, 0);
        if (f6838m || i <= m9954a()) {
            m9950f((m9954a() - i) + 4);
            return;
        }
        throw new AssertionError();
    }

    public final void m9963a(int i, int i2, int i3) {
        m9949f();
        this.f6848k = i2;
        m9962a(4, i * i2);
        m9962a(i3, i * i2);
    }

    public final int m9967b() {
        m9950f(this.f6848k);
        return m9954a();
    }

    public final int m9955a(String str) {
        byte[] bytes = str.getBytes(f6837c);
        m9946b((byte) 0);
        m9963a(1, bytes.length, 1);
        ByteBuffer byteBuffer = this.f6839a;
        int length = this.f6840b - bytes.length;
        this.f6840b = length;
        byteBuffer.position(length);
        this.f6839a.put(bytes, 0, bytes.length);
        return m9967b();
    }

    private void m9949f() {
        if (this.f6844g) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void m9952h(int i) {
        if (i != m9954a()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public final void m9968b(int i) {
        m9949f();
        if (this.f6842e == null || this.f6842e.length < i) {
            this.f6842e = new int[i];
        }
        this.f6843f = i;
        Arrays.fill(this.f6842e, 0, this.f6843f, 0);
        this.f6844g = true;
        this.f6845h = m9954a();
    }

    public final void m9966a(int i, boolean z, boolean z2) {
        if (this.f6849l || z != z2) {
            m9962a(1, 0);
            ByteBuffer byteBuffer = this.f6839a;
            int i2 = this.f6840b - 1;
            this.f6840b = i2;
            byteBuffer.put(i2, (byte) (z ? 1 : 0));
            m9953i(i);
        }
    }

    public final void m9959a(int i, byte b, int i2) {
        if (this.f6849l || b != i2) {
            m9946b(b);
            m9953i(i);
        }
    }

    public final void m9965a(int i, short s, int i2) {
        if (this.f6849l || s != i2) {
            m9947b(s);
            m9953i(i);
        }
    }

    public final void m9969b(int i, int i2, int i3) {
        if (this.f6849l || i2 != i3) {
            m9951g(i2);
            m9953i(i);
        }
    }

    public final void m9964a(int i, long j, long j2) {
        if (this.f6849l || j != j2) {
            m9962a(8, 0);
            ByteBuffer byteBuffer = this.f6839a;
            int i2 = this.f6840b - 8;
            this.f6840b = i2;
            byteBuffer.putLong(i2, j);
            m9953i(i);
        }
    }

    public final void m9961a(int i, float f, double d) {
        if (this.f6849l || ((double) f) != d) {
            m9962a(4, 0);
            ByteBuffer byteBuffer = this.f6839a;
            int i2 = this.f6840b - 4;
            this.f6840b = i2;
            byteBuffer.putFloat(i2, f);
            m9953i(i);
        }
    }

    public final void m9960a(int i, double d, double d2) {
        if (this.f6849l || d != d2) {
            m9962a(8, 0);
            m9957a(d);
            m9953i(i);
        }
    }

    public final void m9972c(int i, int i2, int i3) {
        if (this.f6849l || i2 != i3) {
            m9958a(i2);
            m9953i(i);
        }
    }

    public final void m9974d(int i, int i2, int i3) {
        if (i2 != i3) {
            m9952h(i2);
            m9953i(i);
        }
    }

    private void m9953i(int i) {
        this.f6842e[i] = m9954a();
    }

    public final int m9970c() {
        if (this.f6842e == null || !this.f6844g) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        int i;
        int i2;
        m9951g(0);
        int a = m9954a();
        for (i = this.f6843f - 1; i >= 0; i--) {
            if (this.f6842e[i] != 0) {
                i2 = a - this.f6842e[i];
            } else {
                i2 = 0;
            }
            m9947b((short) i2);
        }
        m9947b((short) (a - this.f6845h));
        m9947b((short) ((this.f6843f + 2) * 2));
        loop1:
        for (i2 = 0; i2 < this.f6847j; i2++) {
            int capacity = this.f6839a.capacity() - this.f6846i[i2];
            int i3 = this.f6840b;
            short s = this.f6839a.getShort(capacity);
            if (s == this.f6839a.getShort(i3)) {
                short s2 = (short) 2;
                while (s2 < s) {
                    if (this.f6839a.getShort(capacity + s2) == this.f6839a.getShort(i3 + s2)) {
                        s2 += 2;
                    }
                }
                i2 = this.f6846i[i2];
                break loop1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            this.f6840b = this.f6839a.capacity() - a;
            this.f6839a.putInt(this.f6840b, i2 - a);
        } else {
            if (this.f6847j == this.f6846i.length) {
                this.f6846i = Arrays.copyOf(this.f6846i, this.f6847j * 2);
            }
            int[] iArr = this.f6846i;
            i = this.f6847j;
            this.f6847j = i + 1;
            iArr[i] = m9954a();
            this.f6839a.putInt(this.f6839a.capacity() - a, m9954a() - a);
        }
        this.f6844g = false;
        return a;
    }

    public final void m9971c(int i) {
        m9962a(this.f6841d, 4);
        m9958a(i);
        this.f6839a.position(this.f6840b);
    }

    public final ByteBuffer m9973d() {
        return this.f6839a;
    }

    public final byte[] m9975e() {
        byte[] bArr = new byte[(this.f6839a.capacity() - this.f6840b)];
        this.f6839a.position(this.f6840b);
        this.f6839a.get(bArr);
        return bArr;
    }
}
