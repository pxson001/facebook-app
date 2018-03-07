package rx.internal.util.unsafe;

/* compiled from: boarding_time_label */
public abstract class SpmcArrayQueueConsumerField<E> extends SpmcArrayQueueL2Pad<E> {
    protected static final long f7884e;
    public volatile long f7885g;

    static {
        try {
            f7884e = UnsafeAccess.f7894a.objectFieldOffset(SpmcArrayQueueConsumerField.class.getDeclaredField("g"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SpmcArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final boolean m14038a(long j, long j2) {
        return UnsafeAccess.f7894a.compareAndSwapLong(this, f7884e, j, j2);
    }
}
