package com.facebook.flatbuffers;

import android.util.SparseArray;
import com.facebook.common.foreach.RandomAccessList;
import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: markerNoteWithAnnotation */
public final class MutableFlatBuffer {
    public final ByteBuffer f15021a;
    @Nullable
    private volatile DeltaBuffer f15022b;
    @Nullable
    private volatile ExtraBuffer f15023c;
    public boolean f15024d;
    @Nullable
    private final DefaultFlatBufferCorruptionHandler f15025e;
    @Nullable
    private SparseArray<Object> f15026f;

    /* compiled from: markerNoteWithAnnotation */
    class MutableFlattenableIterator<T extends Flattenable> implements Iterator<T> {
        private final MutableFlatBuffer f15091a;
        private final int f15092b;
        private final int f15093c;
        @Nullable
        private final Class<T> f15094d;
        @Nullable
        private final VirtualFlattenableResolver f15095e = null;
        private int f15096f = 0;

        @Nullable
        public Object next() {
            if (this.f15096f < 0 || this.f15096f >= this.f15093c) {
                throw new NoSuchElementException("Out of bound for iteration");
            }
            int i = this.f15092b + (this.f15096f * 4);
            this.f15096f++;
            ByteBuffer a = this.f15091a.m21533a();
            int i2 = a.getInt(i);
            if (i2 == 0) {
                return null;
            }
            if (this.f15094d != null) {
                try {
                    Flattenable flattenable = (Flattenable) this.f15094d.newInstance();
                    flattenable.mo1412a(this.f15091a, i + i2);
                    return flattenable;
                } catch (Throwable e) {
                    throw new RuntimeException("Not able to create object", e);
                } catch (Throwable e2) {
                    throw new RuntimeException("Access to constructor denied", e2);
                }
            } else if (this.f15095e != null) {
                short a2 = FlatBuffer.m4039a(a, i + i2, 0, (short) 0);
                int o = FlatBuffer.m4060o(a, i + i2, 1);
                Flattenable a3 = this.f15095e.mo2868a(a2);
                if (a3 == null) {
                    return null;
                }
                a3.mo1412a(this.f15091a, o);
                return a3;
            } else {
                throw new RuntimeException("Either clazz or resolver should be provided");
            }
        }

        MutableFlattenableIterator(MutableFlatBuffer mutableFlatBuffer, int i, int i2, Class<T> cls) {
            this.f15091a = mutableFlatBuffer;
            this.f15092b = i;
            this.f15093c = i2;
            this.f15094d = cls;
        }

        public boolean hasNext() {
            return this.f15096f < this.f15093c;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public MutableFlatBuffer(ByteBuffer byteBuffer, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, boolean z, @Nullable DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler) {
        this.f15021a = byteBuffer;
        this.f15024d = z;
        this.f15025e = defaultFlatBufferCorruptionHandler;
        if (this.f15024d) {
            this.f15022b = new DeltaBuffer(byteBuffer2);
            if (byteBuffer3 != null) {
                this.f15023c = new ExtraBuffer(byteBuffer3);
            }
        }
    }

    public final ByteBuffer m21533a() {
        return this.f15021a;
    }

    public final boolean m21545b() {
        if (this.f15022b != null) {
            return this.f15022b.m21574b();
        }
        return false;
    }

    @Nullable
    public final ByteBuffer m21548c() {
        if (this.f15022b == null) {
            return null;
        }
        this.f15022b.m21575c();
        return this.f15022b.m21570a();
    }

    public final boolean m21553d() {
        if (this.f15023c != null) {
            return this.f15023c.m28662b();
        }
        return false;
    }

    @Nullable
    public final ByteBuffer m21554e() {
        if (this.f15023c == null) {
            return null;
        }
        this.f15023c.m28663c();
        return this.f15023c.m28661a();
    }

    public final boolean m21559f() {
        return this.f15024d;
    }

    public final void m21535a(int i) {
        this.f15021a.putInt(0, i);
        this.f15024d = true;
    }

    public final <T extends Extra> T m21531a(int i, Flattenable flattenable, Class<T> cls) {
        if (this.f15024d) {
            if (this.f15023c == null) {
                this.f15023c = new ExtraBuffer();
            }
            return this.f15023c.m28660a(i, flattenable, cls);
        }
        throw new UnsupportedOperationException("getExtra called when mMutationSupported = false");
    }

    public final synchronized void m21539a(int i, Object obj) {
        if (this.f15026f == null) {
            this.f15026f = new SparseArray();
        }
        this.f15026f.put(i, obj);
    }

    public final synchronized Object m21541b(int i) {
        Object obj;
        if (this.f15026f == null) {
            obj = null;
        } else {
            obj = this.f15026f.get(i);
        }
        return obj;
    }

    public final short m21534a(int i, int i2, short s) {
        try {
            return FlatBuffer.m4039a(this.f15021a, i, i2, s);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final int m21524a(int i, int i2, int i3) {
        try {
            if (this.f15022b == null || !this.f15022b.m21572a(i, i2)) {
                return FlatBuffer.m4027a(this.f15021a, i, i2, i3);
            }
            return this.f15022b.m21573b(i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final void m21544b(int i, int i2, int i3) {
        if (this.f15024d) {
            if (this.f15022b == null) {
                this.f15022b = new DeltaBuffer();
            }
            this.f15022b.m21571a(i, i2, Integer.valueOf(i3));
            return;
        }
        throw new UnsupportedOperationException("Mutation support is not turned on.");
    }

    public final long m21525a(int i, int i2, long j) {
        try {
            return FlatBuffer.m4030a(this.f15021a, i, i2, j);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final double m21523a(int i, int i2, double d) {
        try {
            return FlatBuffer.m4023a(this.f15021a, i, i2, d);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final boolean m21540a(int i, int i2) {
        if (i == 0) {
            return false;
        }
        try {
            if (this.f15022b == null || !this.f15022b.m21572a(i, i2)) {
                return FlatBuffer.m4040a(this.f15021a, i, i2);
            }
            return this.f15022b.m21576c(i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final void m21538a(int i, int i2, boolean z) {
        if (this.f15024d) {
            if (this.f15022b == null) {
                this.f15022b = new DeltaBuffer();
            }
            this.f15022b.m21571a(i, i2, Boolean.valueOf(z));
            return;
        }
        throw new UnsupportedOperationException("Mutation support is not turned on.");
    }

    @Nullable
    public final <T extends Enum> T m21532a(int i, int i2, Class<T> cls) {
        if (i == 0) {
            return null;
        }
        try {
            if (this.f15022b == null || !this.f15022b.m21572a(i, i2)) {
                return FlatBuffer.m4032a(this.f15021a, i, i2, (Class) cls);
            }
            return FlatBuffer.m4033a((short) this.f15022b.m21573b(i, i2), (Class) cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final void m21536a(int i, int i2, Enum enumR) {
        if (!this.f15024d) {
            throw new UnsupportedOperationException("Mutation support is not turned on.");
        } else if (enumR == null) {
            throw new IllegalArgumentException("value for setEnum call should not be null");
        } else {
            if (this.f15022b == null) {
                this.f15022b = new DeltaBuffer();
            }
            this.f15022b.m21571a(i, i2, Integer.valueOf(enumR.ordinal()));
        }
    }

    @Nullable
    public final String m21542b(int i, int i2) {
        return m21547c(i, i2);
    }

    @Nullable
    public final String m21547c(int i, int i2) {
        try {
            if (this.f15022b == null || !this.f15022b.m21572a(i, i2)) {
                return FlatBuffer.m4044b(this.f15021a, i, i2);
            }
            return this.f15022b.m21577d(i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final void m21537a(int i, int i2, String str) {
        if (this.f15024d) {
            if (this.f15022b == null) {
                this.f15022b = new DeltaBuffer();
            }
            this.f15022b.m21571a(i, i2, str);
            return;
        }
        throw new UnsupportedOperationException("Mutation support is not turned on.");
    }

    @Nullable
    public final Iterator<Integer> m21552d(int i, int i2) {
        try {
            return FlatBuffer.m4056k(this.f15021a, i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final Iterator<Long> m21555e(int i, int i2) {
        try {
            return FlatBuffer.m4057l(this.f15021a, i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final Iterator<String> m21558f(int i, int i2) {
        try {
            return FlatBuffer.m4058m(this.f15021a, i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Enum> Iterator<T> m21543b(int i, int i2, Class<T> cls) {
        try {
            return FlatBuffer.m4047c(this.f15021a, i, i2, cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Enum> Iterator<T> m21549c(int i, int i2, Class<T> cls) {
        try {
            return FlatBuffer.m4048d(this.f15021a, i, i2, cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final int m21560g(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        try {
            return FlatBuffer.m4060o(this.f15021a, i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Flattenable> T m21551d(int i, int i2, Class<T> cls) {
        int g = m21560g(i, i2);
        if (g == 0) {
            return null;
        }
        try {
            Flattenable flattenable = (Flattenable) cls.newInstance();
            flattenable.mo1412a(this, g);
            return flattenable;
        } catch (Throwable e) {
            throw new RuntimeException("Not able to create object", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Access to constructor denied", e2);
        }
    }

    @Nullable
    public final Flattenable m21526a(int i, int i2, VirtualFlattenableResolver virtualFlattenableResolver) {
        int g = m21560g(i, i2);
        if (g == 0) {
            return null;
        }
        try {
            short a = FlatBuffer.m4039a(this.f15021a, g, 0, (short) 0);
            int o = FlatBuffer.m4060o(this.f15021a, g, 1);
            Flattenable a2 = virtualFlattenableResolver.mo2868a(a);
            if (a2 == null) {
                return null;
            }
            a2.mo1412a(this, o);
            return a2;
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Flattenable> Iterator<T> m21556e(int i, int i2, Class<T> cls) {
        try {
            int o = FlatBuffer.m4060o(this.f15021a, i, i2);
            if (o == 0) {
                return null;
            }
            return new MutableFlattenableIterator(this, FlatBuffer.m4025a(o), FlatBuffer.m4041b(this.f15021a, o), cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Flattenable> T m21530a(Class<T> cls) {
        try {
            int a = FlatBuffer.m4026a(this.f15021a);
            if (a <= 0) {
                return null;
            }
            return m21528a(a, (Class) cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public final <T extends Flattenable> T m21528a(int i, Class<T> cls) {
        try {
            Flattenable flattenable = (Flattenable) cls.newInstance();
            flattenable.mo1412a(this, i);
            return flattenable;
        } catch (Throwable e) {
            throw new RuntimeException("Illegal access for root object:" + cls.getSimpleName(), e);
        } catch (Throwable e2) {
            throw new RuntimeException("Not able to create root object:" + cls.getSimpleName(), e2);
        }
    }

    @Nullable
    public final Flattenable m21527a(int i, VirtualFlattenableResolver virtualFlattenableResolver) {
        if (i <= 0) {
            return null;
        }
        short a = FlatBuffer.m4039a(this.f15021a, i, 0, (short) 0);
        int g = m21560g(i, 1);
        Flattenable a2 = virtualFlattenableResolver.mo2868a(a);
        if (a2 == null) {
            return null;
        }
        a2.mo1412a(this, g);
        return a2;
    }

    @Nullable
    public final Flattenable m21529a(VirtualFlattenableResolver virtualFlattenableResolver) {
        try {
            return m21527a(FlatBuffer.m4026a(this.f15021a), virtualFlattenableResolver);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    @Nullable
    public static <T extends Flattenable> T m21520a(ByteBuffer byteBuffer, Class<T> cls, @Nullable FlatBufferCorruptionHandler flatBufferCorruptionHandler) {
        return m21521a(byteBuffer, (Class) cls, null, null, false, (DefaultFlatBufferCorruptionHandler) flatBufferCorruptionHandler);
    }

    @Nullable
    public static <T extends Flattenable> T m21521a(ByteBuffer byteBuffer, Class<T> cls, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, boolean z, @Nullable FlatBufferCorruptionHandler flatBufferCorruptionHandler) {
        return new MutableFlatBuffer(byteBuffer, byteBuffer2, byteBuffer3, z, flatBufferCorruptionHandler).m21530a((Class) cls);
    }

    @Nullable
    public static Flattenable m21518a(ByteBuffer byteBuffer, VirtualFlattenableResolver virtualFlattenableResolver, @Nullable DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler) {
        return m21519a(byteBuffer, virtualFlattenableResolver, null, null, false, defaultFlatBufferCorruptionHandler);
    }

    @Nullable
    private static Flattenable m21519a(ByteBuffer byteBuffer, VirtualFlattenableResolver virtualFlattenableResolver, @Nullable ByteBuffer byteBuffer2, @Nullable ByteBuffer byteBuffer3, boolean z, @Nullable DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler) {
        return new MutableFlatBuffer(byteBuffer, byteBuffer2, byteBuffer3, z, defaultFlatBufferCorruptionHandler).m21529a(virtualFlattenableResolver);
    }

    public final int m21546c(int i) {
        if (i == 0) {
            return 0;
        }
        try {
            return FlatBuffer.m4041b(this.f15021a, i);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final int m21550d(int i) {
        if (i == 0) {
            throw new NullPointerException();
        }
        try {
            return FlatBuffer.m4041b(this.f15021a, i);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final boolean m21562h(int i, int i2) {
        if (i != 0) {
            return m21540a(i, i2);
        }
        throw new NullPointerException();
    }

    public final short m21563i(int i, int i2) {
        if (i != 0) {
            return m21534a(i, i2, (short) 0);
        }
        throw new NullPointerException();
    }

    public final int m21564j(int i, int i2) {
        if (i != 0) {
            return m21524a(i, i2, 0);
        }
        throw new NullPointerException();
    }

    @Nullable
    public final String m21565k(int i, int i2) {
        if (i != 0) {
            return m21547c(i, i2);
        }
        throw new NullPointerException();
    }

    @Nullable
    public final <T extends Enum<T>> T m21557f(int i, int i2, Class<T> cls) {
        if (i == 0) {
            throw new NullPointerException();
        }
        String b = m21542b(i, i2);
        if (b == null) {
            return null;
        }
        return Enum.valueOf(cls, b.toUpperCase(Locale.US));
    }

    @Nullable
    public final <T extends Enum> RandomAccessList<T> m21561g(int i, int i2, Class<T> cls) {
        if (i == 0) {
            throw new NullPointerException();
        }
        try {
            return FlatBuffer.m4050e(this.f15021a, i, i2, cls);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    public final int m21566l(int i, int i2) {
        if (i != 0) {
            return m21560g(i, i2);
        }
        throw new NullPointerException();
    }

    public final int m21567m(int i, int i2) {
        if (i == 0) {
            throw new NullPointerException();
        }
        try {
            return FlatBuffer.m4059n(this.f15021a, i, i2);
        } catch (IndexOutOfBoundsException e) {
            m21522a(e);
            throw e;
        }
    }

    private void m21522a(IndexOutOfBoundsException indexOutOfBoundsException) {
        if (this.f15025e != null) {
            this.f15025e.m21221a();
        }
    }
}
