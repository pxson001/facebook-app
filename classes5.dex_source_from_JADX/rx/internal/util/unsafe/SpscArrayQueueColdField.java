package rx.internal.util.unsafe;

/* compiled from: blurredCoverPhoto */
public abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    private static final Integer f7887f = Integer.getInteger("jctoolts.spsc.max.lookahead.step", 4096);
    protected final int f7888e;

    public SpscArrayQueueColdField(int i) {
        super(i);
        this.f7888e = Math.min(i / 4, f7887f.intValue());
    }
}
