package rx.internal.util.unsafe;

/* compiled from: body */
public abstract class MpmcArrayQueueProducerField<E> extends MpmcArrayQueueL1Pad<E> {
    private static final long f7878f;
    public volatile long f7879g;

    static {
        try {
            f7878f = UnsafeAccess.f7894a.objectFieldOffset(MpmcArrayQueueProducerField.class.getDeclaredField("g"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public MpmcArrayQueueProducerField(int i) {
        super(i);
    }

    protected final boolean m14035b(long j, long j2) {
        return UnsafeAccess.f7894a.compareAndSwapLong(this, f7878f, j, j2);
    }
}
