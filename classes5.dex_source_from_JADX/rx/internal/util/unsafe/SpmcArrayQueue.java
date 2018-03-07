package rx.internal.util.unsafe;

/* compiled from: boarding_time_label */
public final class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    public final boolean isEmpty() {
        return this.f7885g == this.f7883e;
    }

    public final E peek() {
        return m14031c(m14028a(this.f7885g));
    }

    public final int size() {
        long j = this.f7885g;
        while (true) {
            long j2 = this.f7883e;
            long j3 = this.f7885g;
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public SpmcArrayQueue(int i) {
        super(i);
    }

    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] objArr = this.f7874d;
        long j = this.f7883e;
        long a = m14028a(j);
        if (ConcurrentCircularArrayQueue.m14026b(objArr, a) == null) {
            ConcurrentCircularArrayQueue.m14025a(objArr, a, e);
            m14037d(1 + j);
        } else if (((int) (j - this.f7885g)) == this.f7872b) {
            return false;
        } else {
            do {
            } while (ConcurrentCircularArrayQueue.m14026b(objArr, a) != null);
        }
        ConcurrentCircularArrayQueue.m14025a(objArr, a, e);
        m14037d(1 + j);
        return true;
    }

    public final E poll() {
        long j;
        long j2 = this.f7886g;
        do {
            j = this.f7885g;
            if (j >= j2) {
                long j3 = this.f7883e;
                if (j >= j3) {
                    return null;
                }
                this.f7886g = j3;
            }
        } while (!m14038a(j, 1 + j));
        j2 = m14028a(j);
        Object[] objArr = this.f7874d;
        E a = ConcurrentCircularArrayQueue.m14024a(objArr, j2);
        ConcurrentCircularArrayQueue.m14027b(objArr, j2, null);
        return a;
    }
}
