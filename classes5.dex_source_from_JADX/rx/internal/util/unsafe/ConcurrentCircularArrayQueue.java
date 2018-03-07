package rx.internal.util.unsafe;

import java.util.Iterator;

/* compiled from: body_text */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int f7869a = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long f7870e = ((long) (UnsafeAccess.f7894a.arrayBaseOffset(Object[].class) + (32 << (f7871f - f7869a))));
    private static final int f7871f;
    protected final int f7872b;
    protected final long f7873c = ((long) (this.f7872b - 1));
    protected final E[] f7874d = new Object[((this.f7872b << f7869a) + 64)];

    static {
        int arrayIndexScale = UnsafeAccess.f7894a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f7871f = f7869a + 2;
        } else if (8 == arrayIndexScale) {
            f7871f = f7869a + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public ConcurrentCircularArrayQueue(int i) {
        this.f7872b = 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    protected final long m14028a(long j) {
        return f7870e + ((this.f7873c & j) << f7871f);
    }

    protected final void m14029a(long j, E e) {
        m14025a(this.f7874d, j, e);
    }

    protected static void m14025a(E[] eArr, long j, E e) {
        UnsafeAccess.f7894a.putObject(eArr, j, e);
    }

    protected static void m14027b(E[] eArr, long j, E e) {
        UnsafeAccess.f7894a.putOrderedObject(eArr, j, e);
    }

    protected final E m14030b(long j) {
        return m14024a(this.f7874d, j);
    }

    protected static E m14024a(E[] eArr, long j) {
        return UnsafeAccess.f7894a.getObject(eArr, j);
    }

    protected final E m14031c(long j) {
        return m14026b(this.f7874d, j);
    }

    protected static E m14026b(E[] eArr, long j) {
        return UnsafeAccess.f7894a.getObjectVolatile(eArr, j);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
