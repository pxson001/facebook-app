package com.facebook.flatbuffers;

import com.facebook.common.foreach.RandomAccessList;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: undefined adapter position */
public final class FlatBuffer {
    private static final Charset f1984a = Charset.forName("UTF-8");
    private static final HashMap<Class, Enum[]> f1985b = new HashMap();

    /* compiled from: undefined adapter position */
    class EnumListAccessor<T extends Enum> implements FlatBufferListAccessor<Class<T>, T> {
        static final EnumListAccessor f20371a = new EnumListAccessor();

        private EnumListAccessor() {
        }

        @Nullable
        public final Object mo3128a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
            Class cls = (Class) obj;
            int i3 = (i2 * 2) + i;
            if (byteBuffer.getShort(i3) == (short) -1) {
                return Enum.valueOf(cls, "UNSET_OR_UNRECOGNIZED_ENUM_VALUE");
            }
            return FlatBuffer.m4033a(byteBuffer.getShort(i3), cls);
        }
    }

    /* compiled from: undefined adapter position */
    interface FlatBufferListAccessor<THelper, TItem> {
        @Nullable
        TItem mo3128a(THelper tHelper, ByteBuffer byteBuffer, int i, int i2);
    }

    /* compiled from: undefined adapter position */
    class FlatBufferIterator<THelper, TItem> implements Iterator<TItem> {
        private final ByteBuffer f20372a;
        private final int f20373b;
        private final int f20374c;
        private final FlatBufferListAccessor<THelper, TItem> f20375d;
        private final THelper f20376e;
        private int f20377f = 0;

        FlatBufferIterator(ByteBuffer byteBuffer, int i, int i2, FlatBufferListAccessor<THelper, TItem> flatBufferListAccessor, THelper tHelper) {
            this.f20372a = byteBuffer;
            this.f20373b = i;
            this.f20374c = i2;
            this.f20375d = flatBufferListAccessor;
            this.f20376e = tHelper;
        }

        public boolean hasNext() {
            return this.f20377f < this.f20374c;
        }

        @Nullable
        public TItem next() {
            if (this.f20377f < 0 || this.f20377f >= this.f20374c) {
                throw new NoSuchElementException("Out of bound for iteration");
            }
            FlatBufferListAccessor flatBufferListAccessor = this.f20375d;
            Object obj = this.f20376e;
            ByteBuffer byteBuffer = this.f20372a;
            int i = this.f20373b;
            int i2 = this.f20377f;
            this.f20377f = i2 + 1;
            return flatBufferListAccessor.mo3128a(obj, byteBuffer, i, i2);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: undefined adapter position */
    class StringListAccessor implements FlatBufferListAccessor<Class<Void>, String> {
        static final StringListAccessor f22066a = new StringListAccessor();

        private StringListAccessor() {
        }

        @Nullable
        public final Object mo3128a(Object obj, ByteBuffer byteBuffer, int i, int i2) {
            int i3 = (i2 * 4) + i;
            int i4 = byteBuffer.getInt(i3);
            if (i4 == 0) {
                return null;
            }
            return FlatBuffer.m4035a(byteBuffer, i3 + i4);
        }
    }

    public static byte m4022a(ByteBuffer byteBuffer, int i, int i2, byte b) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.get(p) : b;
    }

    public static short m4039a(ByteBuffer byteBuffer, int i, int i2, short s) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.getShort(p) : s;
    }

    public static int m4027a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.getInt(p) : i3;
    }

    public static long m4030a(ByteBuffer byteBuffer, int i, int i2, long j) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.getLong(p) : j;
    }

    public static float m4024a(ByteBuffer byteBuffer, int i, int i2, float f) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.getFloat(p) : f;
    }

    public static double m4023a(ByteBuffer byteBuffer, int i, int i2, double d) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? byteBuffer.getDouble(p) : d;
    }

    public static boolean m4040a(ByteBuffer byteBuffer, int i, int i2) {
        int p = m4061p(byteBuffer, i, i2);
        if (p == 0) {
            return false;
        }
        if (byteBuffer.get(p) == (byte) 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public static <T extends Enum> T m4032a(ByteBuffer byteBuffer, int i, int i2, Class<T> cls) {
        short a = m4039a(byteBuffer, i, i2, (short) -1);
        if (a != (short) -1) {
            return m4033a(a, (Class) cls);
        }
        return null;
    }

    @Nullable
    public static String m4044b(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o != 0) {
            return m4035a(byteBuffer, o);
        }
        return null;
    }

    @Nullable
    public static <T> T m4034a(ByteBuffer byteBuffer, int i, int i2, Flattener<T> flattener) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        try {
            return flattener.a(byteBuffer, o);
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    @Nullable
    public static byte[] m4049d(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        ByteBuffer slice;
        byte[] bArr = new byte[m4041b(byteBuffer, o)];
        synchronized (byteBuffer) {
            slice = byteBuffer.slice();
        }
        slice.position(m4025a(o));
        slice.get(bArr);
        return bArr;
    }

    @Nullable
    public static short[] m4051e(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        int b = m4041b(byteBuffer, o);
        int i3 = o + 4;
        short[] sArr = new short[b];
        for (int i4 = 0; i4 < b; i4++) {
            sArr[i4] = byteBuffer.getShort((i4 * 2) + i3);
        }
        return sArr;
    }

    @Nullable
    public static int[] m4053f(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        int b = m4041b(byteBuffer, o);
        int i3 = o + 4;
        int[] iArr = new int[b];
        for (int i4 = 0; i4 < b; i4++) {
            iArr[i4] = byteBuffer.getInt((i4 * 4) + i3);
        }
        return iArr;
    }

    @Nullable
    public static long[] m4054g(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        int b = m4041b(byteBuffer, o);
        int i3 = o + 4;
        long[] jArr = new long[b];
        for (int i4 = 0; i4 < b; i4++) {
            jArr[i4] = byteBuffer.getLong((i4 * 8) + i3);
        }
        return jArr;
    }

    @Nullable
    public static double[] m4055h(ByteBuffer byteBuffer, int i, int i2) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        int b = m4041b(byteBuffer, o);
        int i3 = o + 4;
        double[] dArr = new double[b];
        for (int i4 = 0; i4 < b; i4++) {
            dArr[i4] = byteBuffer.getDouble((i4 * 8) + i3);
        }
        return dArr;
    }

    public static int m4028a(ByteBuffer byteBuffer, int i, int i2, String str) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return -1;
        }
        int b = m4041b(byteBuffer, o);
        if (b == 0) {
            return -1;
        }
        int i3 = o + 4;
        b = 0;
        int i4 = (b + 0) - 1;
        while (i4 >= b) {
            o = ((i4 - b) / 2) + b;
            int i5 = (o * 4) + i3;
            int i6 = byteBuffer.getInt(i5);
            if (i6 == 0) {
                return -1;
            }
            i5 = m4029a(byteBuffer, i5 + i6, str);
            if (i5 == 0) {
                return o;
            }
            if (i5 > 0) {
                i4 = o - 1;
            } else {
                b = o + 1;
            }
        }
        return -1;
    }

    @Nullable
    public static <L extends List<String>> L m4045b(ByteBuffer byteBuffer, int i, int i2, Class<L> cls) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        int b = m4041b(byteBuffer, o);
        int a = m4025a(o);
        try {
            List list = (List) cls.newInstance();
            for (int i3 = 0; i3 < b; i3++) {
                int i4 = (i3 * 4) + a;
                int i5 = byteBuffer.getInt(i4);
                if (i5 == 0) {
                    list.add(null);
                } else {
                    list.add(m4035a(byteBuffer, i4 + i5));
                }
            }
            return list;
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    @Nullable
    public static <V, L extends List<V>, F extends Flattener<V>> L m4036a(ByteBuffer byteBuffer, int i, int i2, Class<L> cls, F f) {
        L l = null;
        try {
            int o = m4060o(byteBuffer, i, i2);
            if (o != 0) {
                int b = m4041b(byteBuffer, o);
                int a = m4025a(o);
                l = (List) cls.newInstance();
                for (o = 0; o < b; o++) {
                    int i3 = (o * 4) + a;
                    int i4 = byteBuffer.getInt(i3);
                    if (i4 == 0) {
                        l.add(null);
                    } else {
                        l.add(f.a(byteBuffer, i3 + i4));
                    }
                }
            }
            return l;
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    @Nullable
    public static Iterator<Integer> m4056k(ByteBuffer byteBuffer, int i, int i2) {
        return m4043b(byteBuffer, i, i2, IntegerListAccessor.a, Void.TYPE);
    }

    @Nullable
    public static Iterator<Long> m4057l(ByteBuffer byteBuffer, int i, int i2) {
        return m4043b(byteBuffer, i, i2, LongListAccessor.a, Void.TYPE);
    }

    @Nullable
    public static Iterator<String> m4058m(ByteBuffer byteBuffer, int i, int i2) {
        return m4043b(byteBuffer, i, i2, StringListAccessor.f22066a, Void.TYPE);
    }

    @Nullable
    public static <T extends Enum> Iterator<T> m4047c(ByteBuffer byteBuffer, int i, int i2, Class<T> cls) {
        return m4043b(byteBuffer, i, i2, EnumListAccessor.f20371a, cls);
    }

    @Nullable
    public static <T extends Enum> Iterator<T> m4048d(ByteBuffer byteBuffer, int i, int i2, Class<T> cls) {
        Method method;
        try {
            method = cls.getMethod("fromString", new Class[]{String.class});
        } catch (Exception e) {
            method = null;
        }
        return m4043b(byteBuffer, i, i2, new EnumStringListAccessor(method), cls);
    }

    @Nullable
    public static <T extends Enum<T>> RandomAccessList<T> m4050e(ByteBuffer byteBuffer, int i, int i2, Class<T> cls) {
        Method method;
        try {
            method = cls.getMethod("fromString", new Class[]{String.class});
        } catch (Exception e) {
            method = null;
        }
        return m4031a(byteBuffer, i, i2, new EnumStringListAccessor(method), (Object) cls);
    }

    @Nullable
    public static <M extends Map<String, String>> M m4052f(ByteBuffer byteBuffer, int i, int i2, Class<M> cls) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        return m4038a((Class) cls, m4058m(byteBuffer, o, 0), m4058m(byteBuffer, o, 1));
    }

    public static <K, V, M extends Map<K, V>> M m4038a(Class<M> cls, @Nullable Iterator<K> it, @Nullable Iterator<V> it2) {
        if (it == null || it2 == null) {
            return m4037a((Class) cls);
        }
        return m4046b((Class) cls, (Iterator) it, (Iterator) it2);
    }

    private static <M extends Map<?, ?>> M m4037a(Class<M> cls) {
        try {
            return (Map) cls.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    private static <K, V, M extends Map<K, V>> M m4046b(Class<M> cls, Iterator<K> it, Iterator<V> it2) {
        try {
            Map map = (Map) cls.newInstance();
            while (it.hasNext() && it2.hasNext()) {
                map.put(it.next(), it2.next());
            }
            return map;
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    public static String m4035a(ByteBuffer byteBuffer, int i) {
        if (byteBuffer.hasArray()) {
            return new String(byteBuffer.array(), i + 4, byteBuffer.getInt(i), f1984a);
        }
        byte[] bArr = new byte[byteBuffer.getInt(i)];
        synchronized (byteBuffer) {
            int position = byteBuffer.position();
            byteBuffer.position(i + 4);
            byteBuffer.get(bArr);
            byteBuffer.position(position);
        }
        return new String(bArr, 0, bArr.length, f1984a);
    }

    private static int m4029a(ByteBuffer byteBuffer, int i, String str) {
        int i2 = 0;
        int i3 = byteBuffer.getInt(i);
        int length = str.length();
        int i4 = 0;
        while (i4 < i3 && i2 < length) {
            int i5 = byteBuffer.get((i + 4) + i4) & 255;
            int charAt = str.charAt(i2) & 255;
            if (i5 != charAt) {
                return i5 - charAt;
            }
            i4++;
            i2++;
        }
        return i3 - length;
    }

    public static int m4042b(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i == 0) {
            return i3;
        }
        return (i2 < 0 || i2 >= m4041b(byteBuffer, i)) ? i3 : byteBuffer.getInt((i + 4) + (i2 * 4));
    }

    public static int m4059n(ByteBuffer byteBuffer, int i, int i2) {
        if (i == 0) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        int b = m4041b(byteBuffer, i);
        if (i2 < 0 || i2 >= b) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
        b = (i + 4) + (i2 * 4);
        int i3 = byteBuffer.getInt(b);
        if (i3 == 0) {
            return 0;
        }
        return b + i3;
    }

    public static int m4041b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i);
    }

    public static int m4025a(int i) {
        return i + 4;
    }

    public static int m4026a(ByteBuffer byteBuffer) {
        int position;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        synchronized (byteBuffer) {
            position = byteBuffer.position();
        }
        for (int i = 0; i < 4; i++) {
            if (byteBuffer.get((position + 4) + i) != ((byte) "FLAT".charAt(i))) {
                throw new RuntimeException("Flatbuffer has an invalid identifier");
            }
        }
        return byteBuffer.getInt(position) + position;
    }

    public static int m4060o(ByteBuffer byteBuffer, int i, int i2) {
        int p = m4061p(byteBuffer, i, i2);
        return p != 0 ? p + byteBuffer.getInt(p) : 0;
    }

    public static int m4061p(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i - byteBuffer.getInt(i);
        short s = (i2 * 2) + 4;
        if (s < byteBuffer.getShort(i3)) {
            short s2 = byteBuffer.getShort(i3 + s);
            if (s2 != (short) 0) {
                return s2 + i;
            }
        }
        return 0;
    }

    @Nullable
    private static <THelper, TItem> FlatBufferList<THelper, TItem> m4031a(ByteBuffer byteBuffer, int i, int i2, FlatBufferListAccessor<THelper, TItem> flatBufferListAccessor, THelper tHelper) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        return new FlatBufferList(byteBuffer, o + 4, m4041b(byteBuffer, o), flatBufferListAccessor, tHelper);
    }

    @Nullable
    public static <THelper, TItem> FlatBufferIterator<THelper, TItem> m4043b(ByteBuffer byteBuffer, int i, int i2, FlatBufferListAccessor<THelper, TItem> flatBufferListAccessor, THelper tHelper) {
        int o = m4060o(byteBuffer, i, i2);
        if (o == 0) {
            return null;
        }
        return new FlatBufferIterator(byteBuffer, o + 4, m4041b(byteBuffer, o), flatBufferListAccessor, tHelper);
    }

    public static <T extends Enum> T m4033a(short s, Class<T> cls) {
        Enum[] enumArr = (Enum[]) f1985b.get(cls);
        if (enumArr == null) {
            enumArr = (Enum[]) cls.getEnumConstants();
            f1985b.put(cls, enumArr);
        }
        return enumArr[s];
    }
}
