package rx.internal.util.unsafe;

/* compiled from: blurredCoverPhoto */
public abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    private static final long f7892i;
    protected long f7893f;

    static {
        try {
            f7892i = UnsafeAccess.f7894a.objectFieldOffset(SpscArrayQueueConsumerField.class.getDeclaredField("f"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public SpscArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final long m14040a() {
        return UnsafeAccess.f7894a.getLongVolatile(this, f7892i);
    }
}
