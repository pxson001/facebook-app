package rx.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

/* compiled from: boolean */
public final class IndexedRingBuffer<E> implements Subscription {
    static int f7838c;
    public static final int f7839d = f7838c;
    public static final ObjectPool<IndexedRingBuffer> f7840e = new C08911();
    public final AtomicInteger f7841a = new AtomicInteger();
    public final AtomicInteger f7842b = new AtomicInteger();
    public final ElementSection<E> f7843f = new ElementSection();
    private final IndexSection f7844g = new IndexSection();

    /* compiled from: boolean */
    final class C08911 extends ObjectPool<IndexedRingBuffer> {
        C08911() {
        }

        protected final Object mo1027a() {
            return new IndexedRingBuffer();
        }
    }

    /* compiled from: boolean */
    public class ElementSection<E> {
        public final AtomicReferenceArray<E> f7834a = new AtomicReferenceArray(IndexedRingBuffer.f7839d);
        public final AtomicReference<ElementSection<E>> f7835b = new AtomicReference();
    }

    /* compiled from: boolean */
    public class IndexSection {
        private final AtomicIntegerArray f7836a = new AtomicIntegerArray(IndexedRingBuffer.f7839d);
        public final AtomicReference<IndexSection> f7837b = new AtomicReference();

        public final int m13986a(int i, int i2) {
            return this.f7836a.getAndSet(i, i2);
        }

        public final void m13987b(int i, int i2) {
            this.f7836a.set(i, i2);
        }
    }

    static {
        f7838c = 256;
        if (PlatformDependent.m14000a()) {
            f7838c = 8;
        }
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                f7838c = Integer.parseInt(property);
            } catch (Exception e) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
    }

    public final void m13997b() {
        int i = this.f7841a.get();
        ElementSection elementSection = this.f7843f;
        int i2 = 0;
        loop0:
        while (elementSection != null) {
            int i3 = i2;
            i2 = 0;
            while (i2 < f7839d) {
                if (i3 >= i) {
                    break loop0;
                }
                elementSection.f7834a.set(i2, null);
                i2++;
                i3++;
            }
            elementSection = (ElementSection) elementSection.f7835b.get();
            i2 = i3;
        }
        this.f7841a.set(0);
        this.f7842b.set(0);
        f7840e.m13983a(this);
    }

    public final int m13994a(E e) {
        int e2 = m13992e();
        if (e2 < f7839d) {
            this.f7843f.f7834a.set(e2, e);
        } else {
            m13990c(e2).f7834a.set(e2 % f7839d, e);
        }
        return e2;
    }

    public final E m13996a(int i) {
        E andSet;
        if (i < f7839d) {
            andSet = this.f7843f.f7834a.getAndSet(i, null);
        } else {
            andSet = m13990c(i).f7834a.getAndSet(i % f7839d, null);
        }
        m13991d(i);
        return andSet;
    }

    private IndexSection m13989b(int i) {
        if (i < f7839d) {
            return this.f7844g;
        }
        int i2 = i / f7839d;
        IndexSection indexSection = this.f7844g;
        int i3 = 0;
        while (i3 < i2) {
            IndexSection indexSection2;
            if (indexSection.f7837b.get() != null) {
                indexSection2 = (IndexSection) indexSection.f7837b.get();
            } else {
                indexSection2 = new IndexSection();
                if (!indexSection.f7837b.compareAndSet(null, indexSection2)) {
                    indexSection2 = (IndexSection) indexSection.f7837b.get();
                }
            }
            i3++;
            indexSection = indexSection2;
        }
        return indexSection;
    }

    private ElementSection<E> m13990c(int i) {
        if (i < f7839d) {
            return this.f7843f;
        }
        int i2 = i / f7839d;
        ElementSection<E> elementSection = this.f7843f;
        int i3 = 0;
        while (i3 < i2) {
            ElementSection<E> elementSection2;
            if (elementSection.f7835b.get() != null) {
                elementSection2 = (ElementSection) elementSection.f7835b.get();
            } else {
                elementSection2 = new ElementSection();
                if (!elementSection.f7835b.compareAndSet(null, elementSection2)) {
                    elementSection2 = (ElementSection) elementSection.f7835b.get();
                }
            }
            i3++;
            elementSection = elementSection2;
        }
        return elementSection;
    }

    private synchronized int m13992e() {
        int f;
        f = m13993f();
        if (f >= 0) {
            if (f < f7839d) {
                f = this.f7844g.m13986a(f, -1);
            } else {
                f = m13989b(f).m13986a(f % f7839d, -1);
            }
            if (f == this.f7841a.get()) {
                this.f7841a.getAndIncrement();
            }
        } else {
            f = this.f7841a.getAndIncrement();
        }
        return f;
    }

    private synchronized int m13993f() {
        int i;
        do {
            i = this.f7842b.get();
            if (i <= 0) {
                i = -1;
                break;
            }
        } while (!this.f7842b.compareAndSet(i, i - 1));
        i--;
        return i;
    }

    private synchronized void m13991d(int i) {
        int andIncrement = this.f7842b.getAndIncrement();
        if (andIncrement < f7839d) {
            this.f7844g.m13987b(andIncrement, i);
        } else {
            m13989b(andIncrement).m13987b(andIncrement % f7839d, i);
        }
    }

    public final boolean m13998c() {
        return false;
    }

    public final int m13995a(Func1<? super E, Boolean> func1, int i) {
        int a = m13988a(func1, i, this.f7841a.get());
        if (i > 0 && a == this.f7841a.get()) {
            return m13988a(func1, 0, i);
        }
        if (a != this.f7841a.get()) {
            return a;
        }
        return 0;
    }

    private int m13988a(Func1<? super E, Boolean> func1, int i, int i2) {
        ElementSection c;
        int i3;
        int i4;
        int i5 = this.f7841a.get();
        ElementSection elementSection = this.f7843f;
        if (i >= f7839d) {
            c = m13990c(i);
            i3 = i % f7839d;
            i4 = i;
        } else {
            c = elementSection;
            i4 = i;
            i3 = i;
        }
        while (c != null) {
            int i6 = i4;
            for (i4 = i3; i4 < f7839d; i4++) {
                if (i6 >= i5 || i6 >= i2) {
                    return i6;
                }
                Object obj = c.f7834a.get(i4);
                if (obj != null && !((Boolean) func1.mo611a(obj)).booleanValue()) {
                    return i6;
                }
                i6++;
            }
            c = (ElementSection) c.f7835b.get();
            i4 = i6;
            i3 = 0;
        }
        return i4;
    }
}
