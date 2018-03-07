package com.google.common.collect;

import android.support.v7.widget.LinearLayoutCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.MathPreconditions;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
/* compiled from: building */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    @VisibleForTesting
    public final int f7507a;
    private final Heap f7508b;
    private final Heap f7509c;
    public Object[] f7510d;
    public int f7511e;
    public int f7512f;

    @Beta
    /* compiled from: building */
    public final class Builder<B> {
        public final Comparator<B> f7492a;
        public int f7493b = -1;
        public int f7494c = Integer.MAX_VALUE;

        public Builder(Comparator<B> comparator) {
            this.f7492a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public final Builder<B> m13557a(int i) {
            Preconditions.checkArgument(i > 0);
            this.f7494c = i;
            return this;
        }

        public final <T extends B> MinMaxPriorityQueue<T> m13558a() {
            Iterable<Object> emptySet = Collections.emptySet();
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue(this, MinMaxPriorityQueue.m13575a(this.f7493b, this.f7494c, emptySet));
            for (Object offer : emptySet) {
                minMaxPriorityQueue.offer(offer);
            }
            return minMaxPriorityQueue;
        }
    }

    /* compiled from: building */
    public class Heap {
        public final Ordering<E> f7495a;
        @Weak
        Heap f7496b;
        public final /* synthetic */ MinMaxPriorityQueue f7497c;

        Heap(MinMaxPriorityQueue minMaxPriorityQueue, Ordering<E> ordering) {
            this.f7497c = minMaxPriorityQueue;
            this.f7495a = ordering;
        }

        final int m13568a(int i, int i2) {
            return this.f7495a.compare(this.f7497c.m13583a(i), this.f7497c.m13583a(i2));
        }

        final MoveDesc<E> m13569a(int i, int i2, E e) {
            int d = m13564d(i2, e);
            if (d == i2) {
                return null;
            }
            Object a;
            if (d < i) {
                a = this.f7497c.m13583a(i);
            } else {
                a = this.f7497c.m13583a(m13566f(i));
            }
            if (this.f7496b.m13571b(d, (Object) e) < i) {
                return new MoveDesc(e, a);
            }
            return null;
        }

        final void m13570a(int i, E e) {
            int c = m13562c(i, e);
            if (c != i) {
                this = this.f7496b;
                i = c;
            }
            m13571b(i, (Object) e);
        }

        final int m13571b(int i, E e) {
            while (i > 2) {
                int f = m13566f(m13566f(i));
                Object a = this.f7497c.m13583a(f);
                if (this.f7495a.compare(a, e) <= 0) {
                    break;
                }
                this.f7497c.f7510d[i] = a;
                i = f;
            }
            this.f7497c.f7510d[i] = e;
            return i;
        }

        private int m13560b(int i, int i2) {
            if (i >= this.f7497c.f7511e) {
                return -1;
            }
            Preconditions.checkState(i > 0);
            int min = Math.min(i, this.f7497c.f7511e - i2) + i2;
            int i3 = i;
            for (int i4 = i + 1; i4 < min; i4++) {
                if (m13568a(i4, i3) < 0) {
                    i3 = i4;
                }
            }
            return i3;
        }

        private int m13559b(int i) {
            return m13560b(m13563d(i), 2);
        }

        private int m13561c(int i) {
            int d = m13563d(i);
            if (d < 0) {
                return -1;
            }
            return m13560b(m13563d(d), 4);
        }

        private int m13562c(int i, E e) {
            if (i == 0) {
                this.f7497c.f7510d[0] = e;
                return 0;
            }
            Object a;
            int i2;
            int f = m13566f(i);
            Object a2 = this.f7497c.m13583a(f);
            if (f != 0) {
                int e2 = m13565e(m13566f(f));
                if (e2 != f && m13563d(e2) >= this.f7497c.f7511e) {
                    a = this.f7497c.m13583a(e2);
                    if (this.f7495a.compare(a, a2) < 0) {
                        i2 = e2;
                        if (this.f7495a.compare(a, e) >= 0) {
                            this.f7497c.f7510d[i] = a;
                            this.f7497c.f7510d[i2] = e;
                            return i2;
                        }
                        this.f7497c.f7510d[i] = e;
                        return i;
                    }
                }
            }
            a = a2;
            i2 = f;
            if (this.f7495a.compare(a, e) >= 0) {
                this.f7497c.f7510d[i] = e;
                return i;
            }
            this.f7497c.f7510d[i] = a;
            this.f7497c.f7510d[i2] = e;
            return i2;
        }

        private int m13564d(int i, E e) {
            int b = m13559b(i);
            if (b <= 0 || this.f7495a.compare(this.f7497c.m13583a(b), e) >= 0) {
                return m13562c(i, e);
            }
            this.f7497c.f7510d[i] = this.f7497c.m13583a(b);
            this.f7497c.f7510d[b] = e;
            return b;
        }

        final int m13567a(int i) {
            while (true) {
                int c = m13561c(i);
                if (c <= 0) {
                    return i;
                }
                this.f7497c.f7510d[i] = this.f7497c.m13583a(c);
                i = c;
            }
        }

        public static int m13563d(int i) {
            return (i * 2) + 1;
        }

        public static int m13565e(int i) {
            return (i * 2) + 2;
        }

        public static int m13566f(int i) {
            return (i - 1) / 2;
        }
    }

    /* compiled from: building */
    class MoveDesc<E> {
        final E f7498a;
        final E f7499b;

        MoveDesc(E e, E e2) {
            this.f7498a = e;
            this.f7499b = e2;
        }
    }

    /* compiled from: building */
    public class QueueIterator implements Iterator<E> {
        public final /* synthetic */ MinMaxPriorityQueue f7500a;
        private int f7501b = -1;
        private int f7502c = this.f7500a.f7512f;
        private Queue<E> f7503d;
        private List<E> f7504e;
        private E f7505f;
        private boolean f7506g;

        public QueueIterator(MinMaxPriorityQueue minMaxPriorityQueue) {
            this.f7500a = minMaxPriorityQueue;
        }

        public boolean hasNext() {
            m13573a();
            return m13572a(this.f7501b + 1) < this.f7500a.size() || !(this.f7503d == null || this.f7503d.isEmpty());
        }

        public E next() {
            m13573a();
            int a = m13572a(this.f7501b + 1);
            if (a < this.f7500a.size()) {
                this.f7501b = a;
                this.f7506g = true;
                return this.f7500a.m13583a(this.f7501b);
            }
            if (this.f7503d != null) {
                this.f7501b = this.f7500a.size();
                this.f7505f = this.f7503d.poll();
                if (this.f7505f != null) {
                    this.f7506g = true;
                    return this.f7505f;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        public void remove() {
            CollectPreconditions.a(this.f7506g);
            m13573a();
            this.f7506g = false;
            this.f7502c++;
            if (this.f7501b < this.f7500a.size()) {
                MoveDesc b = this.f7500a.m13584b(this.f7501b);
                if (b != null) {
                    if (this.f7503d == null) {
                        this.f7503d = new ArrayDeque();
                        this.f7504e = new ArrayList(3);
                    }
                    this.f7503d.add(b.f7498a);
                    this.f7504e.add(b.f7499b);
                }
                this.f7501b--;
                return;
            }
            Object obj = this.f7505f;
            boolean z = false;
            for (int i = 0; i < this.f7500a.f7511e; i++) {
                if (this.f7500a.f7510d[i] == obj) {
                    this.f7500a.m13584b(i);
                    z = true;
                    break;
                }
            }
            Preconditions.checkState(z);
            this.f7505f = null;
        }

        private void m13573a() {
            if (this.f7500a.f7512f != this.f7502c) {
                throw new ConcurrentModificationException();
            }
        }

        private int m13572a(int i) {
            if (this.f7504e != null) {
                while (i < this.f7500a.size()) {
                    Object obj;
                    Iterable<Object> iterable = this.f7504e;
                    Object a = this.f7500a.m13583a(i);
                    for (Object obj2 : iterable) {
                        if (obj2 == a) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        break;
                    }
                    i++;
                }
            }
            return i;
        }
    }

    public static <B> Builder<B> m13576a(Comparator<B> comparator) {
        return new Builder(comparator);
    }

    public MinMaxPriorityQueue(Builder<? super E> builder, int i) {
        Ordering a = Ordering.a(builder.f7492a);
        this.f7508b = new Heap(this, a);
        this.f7509c = new Heap(this, a.a());
        this.f7508b.f7496b = this.f7509c;
        this.f7509c.f7496b = this.f7508b;
        this.f7507a = builder.f7494c;
        this.f7510d = new Object[i];
    }

    public final int size() {
        return this.f7511e;
    }

    public final boolean add(E e) {
        offer(e);
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object offer : collection) {
            offer(offer);
            z = true;
        }
        return z;
    }

    public final boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.f7512f++;
        int i = this.f7511e;
        this.f7511e = i + 1;
        if (this.f7511e > this.f7510d.length) {
            int length = this.f7510d.length;
            if (length < 64) {
                length = (length + 1) * 2;
            } else {
                long j = ((long) 3) * ((long) (length / 2));
                MathPreconditions.b(j == ((long) ((int) j)));
                length = (int) j;
            }
            Object obj = new Object[m13574a(length, this.f7507a)];
            System.arraycopy(this.f7510d, 0, obj, 0, this.f7510d.length);
            this.f7510d = obj;
        }
        m13580d(i).m13570a(i, (Object) e);
        return this.f7511e <= this.f7507a || m13581d() != e;
    }

    public final E poll() {
        return isEmpty() ? null : m13579c(0);
    }

    public final E m13583a(int i) {
        return this.f7510d[i];
    }

    public final E peek() {
        return isEmpty() ? null : m13583a(0);
    }

    private int m13578c() {
        switch (this.f7511e) {
            case 1:
                return 0;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return 1;
            default:
                if (this.f7509c.m13568a(1, 2) <= 0) {
                    return 1;
                }
                return 2;
        }
    }

    private E m13581d() {
        return isEmpty() ? null : m13579c(m13578c());
    }

    public final E m13585b() {
        return isEmpty() ? null : m13583a(m13578c());
    }

    @VisibleForTesting
    public final MoveDesc<E> m13584b(int i) {
        Preconditions.checkPositionIndex(i, this.f7511e);
        this.f7512f++;
        this.f7511e--;
        if (this.f7511e == i) {
            this.f7510d[this.f7511e] = null;
            return null;
        }
        int e;
        int i2;
        Object a;
        MoveDesc<E> a2;
        Object a3 = m13583a(this.f7511e);
        Heap d = m13580d(this.f7511e);
        int f = Heap.m13566f(d.f7497c.f7511e);
        if (f != 0) {
            e = Heap.m13565e(Heap.m13566f(f));
            if (e != f && Heap.m13563d(e) >= d.f7497c.f7511e) {
                Object a4 = d.f7497c.m13583a(e);
                if (d.f7495a.compare(a4, a3) < 0) {
                    d.f7497c.f7510d[e] = a3;
                    d.f7497c.f7510d[d.f7497c.f7511e] = a4;
                    i2 = e;
                    a = m13583a(this.f7511e);
                    this.f7510d[this.f7511e] = null;
                    a2 = m13577a(i, a);
                    if (i2 < i) {
                        return a2;
                    }
                    if (a2 != null) {
                        return new MoveDesc(a3, a);
                    }
                    return new MoveDesc(a3, a2.f7499b);
                }
            }
        }
        e = d.f7497c.f7511e;
        i2 = e;
        a = m13583a(this.f7511e);
        this.f7510d[this.f7511e] = null;
        a2 = m13577a(i, a);
        if (i2 < i) {
            return a2;
        }
        if (a2 != null) {
            return new MoveDesc(a3, a2.f7499b);
        }
        return new MoveDesc(a3, a);
    }

    private MoveDesc<E> m13577a(int i, E e) {
        Heap d = m13580d(i);
        int a = d.m13567a(i);
        int b = d.m13571b(a, (Object) e);
        if (b == a) {
            return d.m13569a(i, a, e);
        }
        return b < i ? new MoveDesc(e, m13583a(i)) : null;
    }

    private E m13579c(int i) {
        E a = m13583a(i);
        m13584b(i);
        return a;
    }

    private Heap m13580d(int i) {
        return m13582e(i) ? this.f7508b : this.f7509c;
    }

    @VisibleForTesting
    private static boolean m13582e(int i) {
        boolean z;
        int i2 = i + 1;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "negative index");
        if ((1431655765 & i2) > (i2 & -1431655766)) {
            return true;
        }
        return false;
    }

    public final Iterator<E> iterator() {
        return new QueueIterator(this);
    }

    public final void clear() {
        for (int i = 0; i < this.f7511e; i++) {
            this.f7510d[i] = null;
        }
        this.f7511e = 0;
    }

    public final Object[] toArray() {
        Object obj = new Object[this.f7511e];
        System.arraycopy(this.f7510d, 0, obj, 0, this.f7511e);
        return obj;
    }

    @VisibleForTesting
    public static int m13575a(int i, int i2, Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof Collection) {
            i = Math.max(i, ((Collection) iterable).size());
        }
        return m13574a(i, i2);
    }

    public static int m13574a(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }
}
