package rx.internal.util.unsafe;

/* compiled from: body */
public abstract class MpmcArrayQueueConsumerField<E> extends MpmcArrayQueueL2Pad<E> {
    private static final long f7880f;
    public volatile long f7881g;

    static {
        try {
            f7880f = UnsafeAccess.f7894a.objectFieldOffset(MpmcArrayQueueConsumerField.class.getDeclaredField("g"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public MpmcArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final boolean m14036a(long j, long j2) {
        return UnsafeAccess.f7894a.compareAndSwapLong(this, f7880f, j, j2);
    }
}
