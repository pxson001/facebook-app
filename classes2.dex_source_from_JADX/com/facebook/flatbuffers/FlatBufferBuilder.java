package com.facebook.flatbuffers;

import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import com.facebook.flatbuffers.util.MapEntrySetToKeyListAdapter;
import com.facebook.flatbuffers.util.MapEntrySetToValueListAdapter;
import com.facebook.infer.annotation.Assertions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: market */
public class FlatBufferBuilder {
    static final Charset f15012c = Charset.forName("UTF-8");
    static final /* synthetic */ boolean f15013i = (!FlatBufferBuilder.class.desiredAssertionStatus());
    public ByteBuffer f15014a;
    public int f15015b;
    int f15016d = 1;
    @Nullable
    int[] f15017e = null;
    int f15018f;
    int[] f15019g = new int[16];
    int f15020h = 0;

    public FlatBufferBuilder(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f15015b = i;
        this.f15014a = m21468e(i);
    }

    private static ByteBuffer m21468e(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private static ByteBuffer m21459b(ByteBuffer byteBuffer, int i) {
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        ByteBuffer e;
        int max = capacity + Math.max(Math.min(capacity, 65536), i - capacity);
        byteBuffer.position(0);
        try {
            e = m21468e(max);
            i = max;
        } catch (OutOfMemoryError e2) {
            e = m21468e(i);
        }
        e.position(i - capacity);
        e.put(byteBuffer);
        return e;
    }

    protected final void m21489a() {
        this.f15019g = new int[16];
        this.f15020h = 0;
    }

    protected final int m21501b() {
        return this.f15014a.capacity() - this.f15015b;
    }

    protected final int m21508c() {
        return this.f15016d;
    }

    public final void m21493a(int i, int i2) {
        if (i > this.f15016d) {
            this.f15016d = i;
        }
        int capacity = ((((this.f15014a.capacity() - this.f15015b) + i2) ^ -1) + 1) & (i - 1);
        int i3 = (capacity + i) + i2;
        int capacity2 = this.f15014a.capacity() - this.f15015b;
        while (this.f15015b < i3) {
            int capacity3 = this.f15014a.capacity();
            this.f15014a = m21459b(this.f15014a, i3 + capacity2);
            this.f15015b = (this.f15014a.capacity() - capacity3) + this.f15015b;
        }
        for (int i4 = 0; i4 < capacity; i4++) {
            ByteBuffer byteBuffer = this.f15014a;
            int i5 = this.f15015b - 1;
            this.f15015b = i5;
            byteBuffer.put(i5, (byte) 0);
        }
    }

    protected final void m21500a(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.f15014a;
        int i3 = this.f15015b - i2;
        this.f15015b = i3;
        byteBuffer.position(i3);
        this.f15014a.put(bArr, i, i2);
    }

    private void m21456a(short s) {
        ByteBuffer byteBuffer = this.f15014a;
        int i = this.f15015b - 2;
        this.f15015b = i;
        byteBuffer.putShort(i, s);
    }

    private void m21472g(int i) {
        ByteBuffer byteBuffer = this.f15014a;
        int i2 = this.f15015b - 4;
        this.f15015b = i2;
        byteBuffer.putInt(i2, i);
    }

    private void m21461b(long j) {
        ByteBuffer byteBuffer = this.f15014a;
        int i = this.f15015b - 8;
        this.f15015b = i;
        byteBuffer.putLong(i, j);
    }

    protected final void m21490a(byte b) {
        m21493a(1, 0);
        ByteBuffer byteBuffer = this.f15014a;
        int i = this.f15015b - 1;
        this.f15015b = i;
        byteBuffer.put(i, b);
    }

    private void m21462b(short s) {
        m21493a(2, 0);
        m21456a(s);
    }

    protected final void m21491a(int i) {
        m21493a(4, 0);
        m21472g(i);
    }

    protected final void m21499a(long j) {
        m21493a(8, 0);
        m21461b(j);
    }

    private void m21470f() {
        m21493a(4, 0);
        m21472g(0);
    }

    protected final void m21506b(int i) {
        m21493a(4, 0);
        if (f15013i || i <= m21501b()) {
            m21472g((m21501b() - i) + 4);
            return;
        }
        throw new AssertionError();
    }

    private void m21460b(int i, int i2, int i3) {
        m21471g();
        m21493a(4, i * i2);
        m21493a(i3, i * i2);
    }

    private int m21473h(int i) {
        m21472g(i);
        return m21501b();
    }

    public final int m21480a(ByteBuffer byteBuffer, int i) {
        m21471g();
        int limit = byteBuffer.limit();
        m21493a(limit, 0);
        ByteBuffer byteBuffer2 = this.f15014a;
        limit = this.f15015b - limit;
        this.f15015b = limit;
        byteBuffer2.position(limit);
        this.f15014a.put(byteBuffer.asReadOnlyBuffer());
        return m21501b() - i;
    }

    public final int m21475a(@Nullable Flattenable flattenable) {
        if (flattenable == null) {
            return 0;
        }
        return flattenable.mo1403a(this);
    }

    public final <T> int m21478a(@Nullable T t, Flattener<T> flattener) {
        if (t == null) {
            return 0;
        }
        return flattener.a(t, this);
    }

    public final int m21476a(Flattenable flattenable, VirtualFlattenableResolver virtualFlattenableResolver) {
        if (flattenable == null) {
            return 0;
        }
        short a = virtualFlattenableResolver.mo2869a(flattenable);
        if (a == (short) -1) {
            throw new RuntimeException("Could not resolve reference type for " + flattenable.getClass().getSimpleName());
        }
        int a2 = flattenable.mo1403a(this);
        m21510c(2);
        m21497a(0, a, 0);
        m21507b(1, a2);
        return m21511d();
    }

    public final int m21487a(int[] iArr, boolean z) {
        if (iArr == null || (iArr.length == 0 && z)) {
            return 0;
        }
        m21460b(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (iArr[length] == 0) {
                m21470f();
            } else {
                m21506b(iArr[length]);
            }
        }
        return m21473h(iArr.length);
    }

    public final <T extends Flattenable> int m21483a(List<T> list, boolean z) {
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && z) {
            return 0;
        }
        int[] iArr = new int[list.size()];
        int i = 0;
        for (T t : list) {
            int a;
            int i2 = i + 1;
            if (t != null) {
                a = t.mo1403a(this);
            } else {
                a = 0;
            }
            iArr[i] = a;
            i = i2;
        }
        return m21487a(iArr, z);
    }

    public final <T> int m21482a(List<T> list, Flattener<T> flattener, boolean z) {
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && z) {
            return 0;
        }
        int[] iArr = new int[list.size()];
        int i = 0;
        for (Object next : list) {
            int a;
            int i2 = i + 1;
            if (next != null) {
                a = flattener.a(next, this);
            } else {
                a = 0;
            }
            iArr[i] = a;
            i = i2;
        }
        return m21487a(iArr, z);
    }

    private void m21471g() {
        if (this.f15017e != null) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public final void m21510c(int i) {
        m21471g();
        this.f15017e = new int[i];
        this.f15018f = m21501b();
    }

    private void m21454a(int i, byte b, int i2) {
        if (b != i2) {
            m21490a(b);
            m21474i(i);
        }
    }

    public final void m21497a(int i, short s, int i2) {
        if (s != i2) {
            m21462b(s);
            m21474i(i);
        }
    }

    public final void m21494a(int i, int i2, int i3) {
        if (i2 != i3) {
            m21491a(i2);
            m21474i(i);
        }
    }

    public final void m21495a(int i, long j, long j2) {
        if (j != j2) {
            m21499a(j);
            m21474i(i);
        }
    }

    public final void m21492a(int i, double d, double d2) {
        if (d != d2) {
            m21493a(8, 0);
            ByteBuffer byteBuffer = this.f15014a;
            int i2 = this.f15015b - 8;
            this.f15015b = i2;
            byteBuffer.putDouble(i2, d);
            m21474i(i);
        }
    }

    public final void m21498a(int i, boolean z) {
        if (z) {
            m21454a(i, (byte) 1, 0);
        }
    }

    public final void m21496a(int i, Enum enumR) {
        if (enumR != null) {
            m21462b((short) enumR.ordinal());
            m21474i(i);
        }
    }

    public final int m21477a(Enum enumR) {
        if (enumR != null) {
            return m21502b(enumR.name());
        }
        return 0;
    }

    public final int m21479a(String str) {
        return m21502b(str);
    }

    public final int m21502b(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        byte[] bytes = str.getBytes(f15012c);
        m21490a((byte) 0);
        m21460b(1, bytes.length, 1);
        ByteBuffer byteBuffer = this.f15014a;
        int length = this.f15015b - bytes.length;
        this.f15015b = length;
        byteBuffer.position(length);
        this.f15014a.put(bytes, 0, bytes.length);
        return m21473h(bytes.length);
    }

    private int m21453a(short[] sArr, boolean z) {
        if (sArr == null || (sArr.length == 0 && z)) {
            return 0;
        }
        m21460b(2, sArr.length, 2);
        for (int length = sArr.length - 1; length >= 0; length--) {
            m21456a(sArr[length]);
        }
        return m21473h(sArr.length);
    }

    private int m21458b(int[] iArr, boolean z) {
        if (iArr == null || (iArr.length == 0 && z)) {
            return 0;
        }
        m21460b(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            m21472g(iArr[length]);
        }
        return m21473h(iArr.length);
    }

    private int m21457b(int[] iArr) {
        return m21458b(iArr, true);
    }

    public final int m21486a(int[] iArr) {
        return m21457b(iArr);
    }

    public final int m21488a(String[] strArr) {
        int i = 0;
        if (strArr != null && (strArr.length != 0 || 1 == null)) {
            int[] iArr = new int[strArr.length];
            while (i < strArr.length) {
                iArr[i] = m21502b(strArr[i]);
                i++;
            }
            i = m21487a(iArr, true);
        }
        return i;
    }

    private int m21466c(List<Integer> list, boolean z) {
        if (list != null) {
            int size = list.size();
            if (!(size == 0 && z)) {
                m21460b(4, size, 4);
                for (int i = size - 1; i >= 0; i--) {
                    m21472g(((Integer) list.get(i)).intValue());
                }
                return m21473h(size);
            }
        }
        return 0;
    }

    public final int m21481a(List<Integer> list) {
        return m21466c((List) list, true);
    }

    private int m21467d(List<Long> list, boolean z) {
        if (list != null) {
            int size = list.size();
            if (!(size == 0 && z)) {
                m21460b(8, size, 8);
                for (int i = size - 1; i >= 0; i--) {
                    m21461b(((Long) list.get(i)).longValue());
                }
                return m21473h(size);
            }
        }
        return 0;
    }

    public final int m21503b(List<Long> list) {
        return m21467d(list, true);
    }

    private int m21465c(int i, int i2) {
        m21510c(2);
        m21507b(0, i);
        m21507b(1, i2);
        return m21511d();
    }

    public final <F extends Flattenable> int m21485a(Map<String, F> map, boolean z) {
        if (map == null || (map.isEmpty() && z)) {
            return 0;
        }
        Set entrySet = map.entrySet();
        return m21465c(m21509c(new MapEntrySetToKeyListAdapter(entrySet)), m21483a(new MapEntrySetToValueListAdapter(entrySet), true));
    }

    public final <T, F extends Flattener<T>> int m21484a(Map<String, T> map, F f, boolean z) {
        if (map == null || (map.isEmpty() && z)) {
            return 0;
        }
        Set entrySet = map.entrySet();
        return m21465c(m21509c(new MapEntrySetToKeyListAdapter(entrySet)), m21482a(new MapEntrySetToValueListAdapter(entrySet), (Flattener) f, true));
    }

    public final <E extends Enum> int m21505b(Map<String, String> map, boolean z) {
        if (map == null || (map.isEmpty() && z)) {
            return 0;
        }
        Set entrySet = map.entrySet();
        return m21465c(m21509c(new MapEntrySetToKeyListAdapter(entrySet)), m21509c(new MapEntrySetToValueListAdapter(entrySet)));
    }

    public final int m21504b(List<String> list, boolean z) {
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && z) {
            return 0;
        }
        int[] iArr = new int[list.size()];
        int i = 0;
        for (String b : list) {
            int i2 = i + 1;
            iArr[i] = m21502b(b);
            i = i2;
        }
        return m21487a(iArr, z);
    }

    public final int m21509c(List<String> list) {
        return m21504b((List) list, true);
    }

    public final <E extends Enum> int m21512d(List<E> list) {
        int i = 0;
        if (list != null) {
            int size = list.size();
            if (size != 0 || 1 == null) {
                int[] iArr = new int[size];
                int i2 = 0;
                for (E e : list) {
                    if (e == null) {
                        size = i2 + 1;
                        iArr[i2] = 0;
                        i2 = size;
                    } else {
                        int i3 = i2 + 1;
                        iArr[i2] = m21502b(e.name());
                        i2 = i3;
                    }
                }
                i = m21487a(iArr, true);
            }
        }
        return i;
    }

    private <T extends Enum> int m21469f(List<T> list, boolean z) {
        if (list == null) {
            return 0;
        }
        if (list.size() <= 0 && z) {
            return 0;
        }
        short[] sArr = new short[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                sArr[i] = (short) ((Enum) list.get(i)).ordinal();
            } else {
                sArr[i] = (short) -1;
            }
        }
        return m21453a(sArr, z);
    }

    public final <T extends Enum> int m21514e(List<T> list) {
        return m21469f(list, true);
    }

    public final void m21507b(int i, int i2) {
        if (i2 != 0) {
            m21506b(i2);
            m21474i(i);
        }
    }

    private void m21474i(int i) {
        Assertions.m5471b(this.f15017e);
        this.f15017e[i] = m21501b();
    }

    public final int m21511d() {
        int i = 0;
        if (f15013i || this.f15017e != null) {
            int i2;
            m21491a(0);
            int b = m21501b();
            for (int length = this.f15017e.length - 1; length >= 0; length--) {
                if (this.f15017e[length] != 0) {
                    i2 = b - this.f15017e[length];
                } else {
                    i2 = 0;
                }
                if (i2 > 32767) {
                    throw new RuntimeException("Object size exceeded 32K limit during flatbuffer serialzation");
                }
                m21462b((short) i2);
            }
            m21462b((short) (b - this.f15018f));
            m21462b((short) ((this.f15017e.length + 2) * 2));
            loop1:
            for (i2 = 0; i2 < this.f15020h; i2++) {
                int capacity = this.f15014a.capacity() - this.f15019g[i2];
                int i3 = this.f15015b;
                short s = this.f15014a.getShort(capacity);
                if (s == this.f15014a.getShort(i3)) {
                    short s2 = (short) 2;
                    while (s2 < s) {
                        if (this.f15014a.getShort(capacity + s2) == this.f15014a.getShort(i3 + s2)) {
                            s2 += 2;
                        }
                    }
                    i = this.f15019g[i2];
                    break loop1;
                }
            }
            if (i != 0) {
                this.f15015b = this.f15014a.capacity() - b;
                this.f15014a.putInt(this.f15015b, i - b);
            } else {
                if (this.f15020h == this.f15019g.length) {
                    this.f15019g = Arrays.copyOf(this.f15019g, this.f15020h * 2);
                }
                int[] iArr = this.f15019g;
                i = this.f15020h;
                this.f15020h = i + 1;
                iArr[i] = m21501b();
                this.f15014a.putInt(this.f15014a.capacity() - b, m21501b() - b);
            }
            this.f15017e = null;
            return b;
        }
        throw new AssertionError();
    }

    public final void m21513d(int i) {
        m21455a(i, "FLAT");
    }

    private void m21455a(int i, String str) {
        m21493a(this.f15016d, 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i2 = 3; i2 >= 0; i2--) {
            m21490a((byte) str.charAt(i2));
        }
        m21506b(i);
        this.f15014a.position(this.f15015b);
    }

    public final byte[] m21515e() {
        byte[] bArr = new byte[(this.f15014a.capacity() - this.f15015b)];
        this.f15014a.position(this.f15015b);
        this.f15014a.get(bArr);
        return bArr;
    }

    @Nullable
    public static byte[] m21463b(Flattenable flattenable) {
        return m21464b(flattenable, null);
    }

    @Nullable
    public static byte[] m21464b(Flattenable flattenable, @Nullable VirtualFlattenableResolver virtualFlattenableResolver) {
        if (virtualFlattenableResolver != null && virtualFlattenableResolver.mo2869a(flattenable) == (short) -1) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(2048);
        int a = virtualFlattenableResolver == null ? flatBufferBuilder.m21475a(flattenable) : flatBufferBuilder.m21476a(flattenable, virtualFlattenableResolver);
        if (a <= 0) {
            return null;
        }
        flatBufferBuilder.m21513d(a);
        return flatBufferBuilder.m21515e();
    }
}
