package rx.internal.util.unsafe;

/* compiled from: boarding_time_label */
public abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long f7882f;
    public volatile long f7883e;

    static {
        try {
            f7882f = UnsafeAccess.f7894a.objectFieldOffset(SpmcArrayQueueProducerField.class.getDeclaredField("e"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected final void m14037d(long j) {
        UnsafeAccess.f7894a.putOrderedLong(this, f7882f, j);
    }

    public SpmcArrayQueueProducerField(int i) {
        super(i);
    }
}
