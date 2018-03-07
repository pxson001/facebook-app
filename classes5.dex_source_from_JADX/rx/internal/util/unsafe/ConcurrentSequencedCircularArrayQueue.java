package rx.internal.util.unsafe;

/* compiled from: body_markdown_html */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long f7875f = ((long) (UnsafeAccess.f7894a.arrayBaseOffset(long[].class) + (32 << (f7876g - ConcurrentCircularArrayQueue.f7869a))));
    private static final int f7876g = (ConcurrentCircularArrayQueue.f7869a + 3);
    protected final long[] f7877e = new long[((this.f7872b << ConcurrentCircularArrayQueue.f7869a) + 64)];

    static {
        if (8 == UnsafeAccess.f7894a.arrayIndexScale(long[].class)) {
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        for (long j = 0; j < ((long) this.f7872b); j++) {
            m14033a(this.f7877e, m14034d(j), j);
        }
    }

    protected final long m14034d(long j) {
        return f7875f + ((this.f7873c & j) << f7876g);
    }

    protected static void m14033a(long[] jArr, long j, long j2) {
        UnsafeAccess.f7894a.putOrderedLong(jArr, j, j2);
    }

    protected static long m14032a(long[] jArr, long j) {
        return UnsafeAccess.f7894a.getLongVolatile(jArr, j);
    }
}
