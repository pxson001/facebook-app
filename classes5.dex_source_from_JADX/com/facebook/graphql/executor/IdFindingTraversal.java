package com.facebook.graphql.executor;

import android.text.TextUtils;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.graphql.executor.cache.ConsistencyConfig;
import com.facebook.graphql.executor.cache.GraphQLConsistencyMemoryCache;
import com.facebook.graphql.modelutil.ConsistencyIndexValue;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: lightweight_extra */
public class IdFindingTraversal {
    private static final C02481 f3216a = new C02481();

    /* compiled from: lightweight_extra */
    public final class C02481 {
        C02481() {
        }

        public final int m6256a() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: lightweight_extra */
    interface Accumulator {
        public static final Object f3207a = new Object();

        void mo610a(Object obj, int i, int i2);
    }

    /* compiled from: lightweight_extra */
    class AccumulatorImpl implements Accumulator {
        final int f3208b = 0;
        final int f3209c = 1;
        private final Collection<String> f3210d;
        private final Collection<ConsistencyIndexValue> f3211e;
        private final ArrayList<String> f3212f = new ArrayList(10);
        private int f3213g = 0;
        private int f3214h = 0;
        private String f3215i = null;

        public AccumulatorImpl(Collection<String> collection, Collection<ConsistencyIndexValue> collection2) {
            this.f3210d = collection;
            this.f3211e = collection2;
        }

        public final void mo610a(Object obj, int i, int i2) {
            if (this.f3213g == 0) {
                m6258a(obj);
            } else if (this.f3213g == 1) {
                m6259b(obj, i, i2);
            } else {
                throw new IllegalStateException();
            }
        }

        public final void m6261a() {
            this.f3213g = 0;
            this.f3212f.clear();
        }

        public final void m6263a(String str) {
            this.f3213g = 1;
            this.f3214h = 0;
            this.f3215i = str;
        }

        private void m6258a(Object obj) {
            if (m6260b(obj)) {
                this.f3212f.add((String) obj);
                this.f3210d.add((String) obj);
                return;
            }
            this.f3212f.add(null);
        }

        private void m6259b(Object obj, int i, int i2) {
            boolean z = true;
            if (obj != a) {
                String str = (String) this.f3212f.get(this.f3214h);
                if (GraphQLConsistencyMemoryCache.a(str, obj)) {
                    Preconditions.checkState(i != -1);
                    if (i2 == -1) {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    this.f3211e.add(new ConsistencyIndexValue(str, this.f3215i, obj, i, i2));
                }
            }
            this.f3214h++;
        }

        private static boolean m6260b(Object obj) {
            return (obj instanceof String) && !TextUtils.isEmpty((String) obj);
        }
    }

    private static int m6264a(int i, short s, C02481 c02481) {
        int i2 = 268435455 & i;
        if (s != (short) -1) {
            return c02481.m6256a();
        }
        return i2;
    }

    private static boolean m6273b(int i) {
        return (i & Integer.MIN_VALUE) == Integer.MIN_VALUE;
    }

    private static boolean m6274c(int i) {
        return (i & 1073741824) == 1073741824;
    }

    private static boolean m6275d(int i) {
        return (i & 536870912) == 536870912;
    }

    public static void m6271a(ByteBuffer byteBuffer, int[][] iArr, ConsistencyConfig consistencyConfig, Collection<ConsistencyIndexValue> collection, Collection<String> collection2) {
        m6270a(byteBuffer, iArr, consistencyConfig, f3216a, collection, collection2);
    }

    private static void m6270a(ByteBuffer byteBuffer, int[][] iArr, ConsistencyConfig consistencyConfig, VirtualReferenceFieldResolver virtualReferenceFieldResolver, Collection<ConsistencyIndexValue> collection, Collection<String> collection2) {
        int a = FlatBuffer.a(byteBuffer);
        Accumulator accumulatorImpl = new AccumulatorImpl(collection2, collection);
        int i = 0;
        while (i < iArr.length) {
            int[] iArr2 = iArr[i];
            Preconditions.checkState(iArr2.length > 1);
            int i2 = iArr2[0];
            accumulatorImpl.m6261a();
            m6269a(accumulatorImpl, byteBuffer, virtualReferenceFieldResolver, a, (short) -1, iArr2, String.class);
            int i3 = i + 1;
            for (i = 0; i < i2; i++) {
                iArr2 = iArr[i + i3];
                Preconditions.checkState(iArr2.length > 1);
                int i4 = iArr2[0];
                Class c = consistencyConfig.c(i4);
                accumulatorImpl.m6263a(consistencyConfig.b(i4));
                m6269a(accumulatorImpl, byteBuffer, virtualReferenceFieldResolver, a, (short) -1, iArr2, c);
            }
            i = i3 + i2;
        }
    }

    private static void m6269a(Accumulator accumulator, ByteBuffer byteBuffer, C02481 c02481, int i, short s, int[] iArr, Class cls) {
        m6268a(accumulator, byteBuffer, c02481, i, s, iArr, 1, cls);
    }

    private static void m6268a(Accumulator accumulator, ByteBuffer byteBuffer, C02481 c02481, int i, short s, int[] iArr, int i2, Class cls) {
        int i3 = iArr[i2];
        int a = m6264a(i3, s, c02481);
        if (a < 0) {
            accumulator.mo610a(Accumulator.f3207a, -1, -1);
            return;
        }
        boolean b = m6273b(i3);
        boolean c = m6274c(i3);
        if (i2 == iArr.length - 1) {
            Preconditions.checkState(!b);
            Preconditions.checkState(!c);
            accumulator.mo610a(m6266a(byteBuffer, i, a, m6275d(i3), cls), i, a);
            return;
        }
        int o = FlatBuffer.o(byteBuffer, i, a);
        if (o == 0) {
            return;
        }
        short s2;
        if (b) {
            int b2 = FlatBuffer.b(byteBuffer, o);
            int a2 = FlatBuffer.a(o);
            for (int i4 = 0; i4 < b2; i4++) {
                int i5 = (i4 * 4) + a2;
                i3 = byteBuffer.getInt(i5);
                if (i3 != 0) {
                    o = i5 + i3;
                    s2 = (short) -1;
                    if (c) {
                        s2 = m6267a(byteBuffer, o);
                        o = m6272b(byteBuffer, o);
                    }
                    m6268a(accumulator, byteBuffer, c02481, o, s2, iArr, i2 + 1, cls);
                }
            }
            return;
        }
        s2 = (short) -1;
        if (c) {
            s2 = m6267a(byteBuffer, o);
            o = m6272b(byteBuffer, o);
        }
        m6268a(accumulator, byteBuffer, c02481, o, s2, iArr, i2 + 1, cls);
    }

    @Nullable
    private static Object m6266a(ByteBuffer byteBuffer, int i, int i2, boolean z, Class cls) {
        if (cls == Boolean.class) {
            return Boolean.valueOf(FlatBuffer.a(byteBuffer, i, i2));
        }
        if (cls == Integer.class) {
            return Integer.valueOf(FlatBuffer.a(byteBuffer, i, i2, 0));
        }
        if (cls == String.class) {
            return FlatBuffer.b(byteBuffer, i, i2);
        }
        if (cls == Long.class) {
            return Long.valueOf(FlatBuffer.a(byteBuffer, i, i2, 0));
        }
        if (cls == Double.class) {
            return Double.valueOf(FlatBuffer.a(byteBuffer, i, i2, 0.0d));
        }
        if (cls == Float.class) {
            return Float.valueOf(FlatBuffer.a(byteBuffer, i, i2, 0.0f));
        }
        if (!Enum.class.isAssignableFrom(cls)) {
            throw new UnsupportedOperationException();
        } else if (z) {
            return FlatBuffer.a(byteBuffer, i, i2, cls);
        } else {
            return m6265a(FlatBuffer.b(byteBuffer, i, i2), cls);
        }
    }

    @Nullable
    private static <T extends Enum> T m6265a(String str, Class<T> cls) {
        T t = null;
        if (str != null) {
            try {
                t = Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
            }
        }
        return t;
    }

    private static short m6267a(ByteBuffer byteBuffer, int i) {
        short a = FlatBuffer.a(byteBuffer, i, 0, Short.MIN_VALUE);
        if (a != Short.MIN_VALUE) {
            return a;
        }
        throw new IllegalArgumentException();
    }

    private static int m6272b(ByteBuffer byteBuffer, int i) {
        boolean z = true;
        int o = FlatBuffer.o(byteBuffer, i, 1);
        if (o == 0) {
            z = false;
        }
        Preconditions.checkState(z);
        return o;
    }
}
