package rx.internal.util.unsafe;

/* compiled from: blurredCoverPhoto */
public abstract class SpscArrayQueueProducerFields<E> extends SpscArrayQueueL1Pad<E> {
    private static final long f7889f;
    protected long f7890g;
    protected long f7891h;

    static {
        try {
            f7889f = UnsafeAccess.f7894a.objectFieldOffset(SpscArrayQueueProducerFields.class.getDeclaredField("g"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SpscArrayQueueProducerFields(int i) {
        super(i);
    }

    protected final long m14039b() {
        return UnsafeAccess.f7894a.getLongVolatile(this, f7889f);
    }
}
