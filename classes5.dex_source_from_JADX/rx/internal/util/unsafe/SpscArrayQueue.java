package rx.internal.util.unsafe;

/* compiled from: blurredCoverPhoto */
public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i) {
        super(i);
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] objArr = this.f7874d;
        if (this.f7890g >= this.f7891h) {
            if (ConcurrentCircularArrayQueue.m14026b(objArr, m14028a(this.f7890g + ((long) this.f7888e))) != null) {
                return false;
            }
            this.h = this.f7890g + ((long) this.f7888e);
        }
        long a = m14028a(this.f7890g);
        this.g = this.f7890g + 1;
        ConcurrentCircularArrayQueue.m14027b(objArr, a, e);
        return true;
    }

    public final E poll() {
        long a = m14028a(this.f7893f);
        Object[] objArr = this.f7874d;
        E b = ConcurrentCircularArrayQueue.m14026b(objArr, a);
        if (b == null) {
            return null;
        }
        this.f = this.f7893f + 1;
        ConcurrentCircularArrayQueue.m14027b(objArr, a, null);
        return b;
    }

    public final E peek() {
        return m14031c(m14028a(this.f7893f));
    }

    public final int size() {
        long a = m14040a();
        while (true) {
            long b = m14039b();
            long a2 = m14040a();
            if (a == a2) {
                return (int) (b - a2);
            }
            a = a2;
        }
    }
}
