package rx.internal.util.unsafe;

/* compiled from: body */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    public boolean isEmpty() {
        return this.f7881g == this.f7879g;
    }

    public E peek() {
        return m14030b(m14028a(this.f7881g));
    }

    public int size() {
        long j = this.f7881g;
        while (true) {
            long j2 = this.f7879g;
            long j3 = this.f7881g;
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public MpmcArrayQueue(int i) {
        super(Math.max(2, i));
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long[] jArr = this.f7877e;
        while (true) {
            long j = this.f7879g;
            long d = m14034d(j);
            long a = ConcurrentSequencedCircularArrayQueue.m14032a(jArr, d) - j;
            if (a == 0) {
                if (m14035b(j, j + 1)) {
                    m14029a(m14028a(j), (Object) e);
                    ConcurrentSequencedCircularArrayQueue.m14033a(jArr, d, j + 1);
                    return true;
                }
            } else if (a < 0) {
                return false;
            }
        }
    }

    public E poll() {
        long[] jArr = this.f7877e;
        while (true) {
            long j = this.f7881g;
            long d = m14034d(j);
            long a = ConcurrentSequencedCircularArrayQueue.m14032a(jArr, d) - (1 + j);
            if (a == 0) {
                if (m14036a(j, 1 + j)) {
                    a = m14028a(j);
                    E b = m14030b(a);
                    m14029a(a, null);
                    ConcurrentSequencedCircularArrayQueue.m14033a(jArr, d, j + ((long) this.f7872b));
                    return b;
                }
            } else if (a < 0) {
                return null;
            }
        }
    }
}
