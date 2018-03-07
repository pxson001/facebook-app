package com.google.common.collect;

import android.support.v7.widget.LinearLayoutCompat;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_report_image_ */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    public final transient Reference<AvlNode<E>> f7595a;
    public final transient GeneralRange<E> f7596b;
    public final transient AvlNode<E> f7597c;

    /* compiled from: bug_report_image_ */
    class C08552 implements Iterator<Entry<E>> {
        AvlNode<E> f7578a;
        Entry<E> f7579b;
        final /* synthetic */ TreeMultiset f7580c;

        C08552(TreeMultiset treeMultiset) {
            AvlNode avlNode;
            this.f7580c = treeMultiset;
            TreeMultiset treeMultiset2 = this.f7580c;
            if (((AvlNode) treeMultiset2.f7595a.f7594a) == null) {
                avlNode = null;
            } else {
                if (treeMultiset2.f7596b.hasLowerBound) {
                    Object obj = treeMultiset2.f7596b.lowerEndpoint;
                    avlNode = AvlNode.m13708b((AvlNode) treeMultiset2.f7595a.f7594a, treeMultiset2.comparator(), obj);
                    if (avlNode == null) {
                        avlNode = null;
                    } else if (treeMultiset2.f7596b.lowerBoundType == BoundType.OPEN && treeMultiset2.comparator().compare(obj, avlNode.mo889a()) == 0) {
                        avlNode = avlNode.f7593i;
                    }
                } else {
                    avlNode = treeMultiset2.f7597c.f7593i;
                }
                if (avlNode == treeMultiset2.f7597c || !treeMultiset2.f7596b.m13346c(avlNode.mo889a())) {
                    avlNode = null;
                }
            }
            this.f7578a = avlNode;
        }

        public boolean hasNext() {
            if (this.f7578a == null) {
                return false;
            }
            if (!this.f7580c.f7596b.m13345b(this.f7578a.mo889a())) {
                return true;
            }
            this.f7578a = null;
            return false;
        }

        public Object next() {
            if (hasNext()) {
                Multisets$AbstractEntry b = TreeMultiset.m13735b(this.f7580c, this.f7578a);
                this.f7579b = b;
                if (this.f7578a.f7593i == this.f7580c.f7597c) {
                    this.f7578a = null;
                } else {
                    this.f7578a = this.f7578a.f7593i;
                }
                return b;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z;
            if (this.f7579b != null) {
                z = true;
            } else {
                z = false;
            }
            CollectPreconditions.a(z);
            this.f7580c.c(this.f7579b.mo889a(), 0);
            this.f7579b = null;
        }
    }

    /* compiled from: bug_report_image_ */
    class C08563 implements Iterator<Entry<E>> {
        AvlNode<E> f7581a;
        Entry<E> f7582b;
        final /* synthetic */ TreeMultiset f7583c;

        C08563(TreeMultiset treeMultiset) {
            AvlNode avlNode;
            this.f7583c = treeMultiset;
            TreeMultiset treeMultiset2 = this.f7583c;
            if (((AvlNode) treeMultiset2.f7595a.f7594a) == null) {
                avlNode = null;
            } else {
                if (treeMultiset2.f7596b.hasUpperBound) {
                    Object obj = treeMultiset2.f7596b.upperEndpoint;
                    avlNode = AvlNode.m13711c((AvlNode) treeMultiset2.f7595a.f7594a, treeMultiset2.comparator(), obj);
                    if (avlNode == null) {
                        avlNode = null;
                    } else if (treeMultiset2.f7596b.upperBoundType == BoundType.OPEN && treeMultiset2.comparator().compare(obj, avlNode.mo889a()) == 0) {
                        avlNode = avlNode.f7592h;
                    }
                } else {
                    avlNode = treeMultiset2.f7597c.f7592h;
                }
                if (avlNode == treeMultiset2.f7597c || !treeMultiset2.f7596b.m13346c(avlNode.mo889a())) {
                    avlNode = null;
                }
            }
            this.f7581a = avlNode;
            this.f7582b = null;
        }

        public boolean hasNext() {
            if (this.f7581a == null) {
                return false;
            }
            if (!this.f7583c.f7596b.m13344a(this.f7581a.mo889a())) {
                return true;
            }
            this.f7581a = null;
            return false;
        }

        public Object next() {
            if (hasNext()) {
                Multisets$AbstractEntry b = TreeMultiset.m13735b(this.f7583c, this.f7581a);
                this.f7582b = b;
                if (this.f7581a.f7592h == this.f7583c.f7597c) {
                    this.f7581a = null;
                } else {
                    this.f7581a = this.f7581a.f7592h;
                }
                return b;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z;
            if (this.f7582b != null) {
                z = true;
            } else {
                z = false;
            }
            CollectPreconditions.a(z);
            this.f7583c.c(this.f7582b.mo889a(), 0);
            this.f7582b = null;
        }
    }

    /* compiled from: bug_report_image_ */
    /* synthetic */ class C08574 {
        static final /* synthetic */ int[] f7584a = new int[BoundType.values().length];

        static {
            try {
                f7584a[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7584a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: bug_report_image_ */
    enum Aggregate {
        SIZE {
            final int nodeAggregate(AvlNode<?> avlNode) {
                return avlNode.f7586b;
            }

            final long treeAggregate(@Nullable AvlNode<?> avlNode) {
                return avlNode == null ? 0 : avlNode.f7588d;
            }
        },
        DISTINCT {
            final int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            final long treeAggregate(@Nullable AvlNode<?> avlNode) {
                return avlNode == null ? 0 : (long) avlNode.f7587c;
            }
        };

        abstract int nodeAggregate(AvlNode<?> avlNode);

        abstract long treeAggregate(@Nullable AvlNode<?> avlNode);
    }

    /* compiled from: bug_report_image_ */
    public final class AvlNode<E> extends Multisets$AbstractEntry<E> {
        @Nullable
        public final E f7585a;
        public int f7586b;
        public int f7587c;
        public long f7588d;
        private int f7589e;
        public AvlNode<E> f7590f;
        public AvlNode<E> f7591g;
        public AvlNode<E> f7592h;
        public AvlNode<E> f7593i;

        AvlNode(@Nullable E e, int i) {
            Preconditions.checkArgument(i > 0);
            this.f7585a = e;
            this.f7586b = i;
            this.f7588d = (long) i;
            this.f7587c = 1;
            this.f7589e = 1;
            this.f7590f = null;
            this.f7591g = null;
        }

        public final int m13722a(Comparator<? super E> comparator, E e) {
            int compare = comparator.compare(e, this.f7585a);
            if (compare < 0) {
                if (this.f7590f == null) {
                    return 0;
                }
                return this.f7590f.m13722a((Comparator) comparator, (Object) e);
            } else if (compare <= 0) {
                return this.f7586b;
            } else {
                if (this.f7591g != null) {
                    return this.f7591g.m13722a((Comparator) comparator, (Object) e);
                }
                return 0;
            }
        }

        private AvlNode<E> m13707a(E e, int i) {
            this.f7591g = new AvlNode(e, i);
            TreeMultiset.m13737b(this, this.f7591g, this.f7593i);
            this.f7589e = Math.max(2, this.f7589e);
            this.f7587c++;
            this.f7588d += (long) i;
            return this;
        }

        private AvlNode<E> m13709b(E e, int i) {
            this.f7590f = new AvlNode(e, i);
            TreeMultiset.m13737b(this.f7592h, this.f7590f, this);
            this.f7589e = Math.max(2, this.f7589e);
            this.f7587c++;
            this.f7588d += (long) i;
            return this;
        }

        final AvlNode<E> m13724a(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            boolean z = false;
            int compare = comparator.compare(e, this.f7585a);
            AvlNode avlNode;
            int i2;
            if (compare < 0) {
                avlNode = this.f7590f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return m13709b(e, i);
                }
                i2 = avlNode.f7589e;
                this.f7590f = avlNode.m13724a(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.f7587c++;
                }
                this.f7588d += (long) i;
                if (this.f7590f.f7589e != i2) {
                    return m13714g();
                }
                return this;
            } else if (compare > 0) {
                avlNode = this.f7591g;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return m13707a((Object) e, i);
                }
                i2 = avlNode.f7589e;
                this.f7591g = avlNode.m13724a(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.f7587c++;
                }
                this.f7588d += (long) i;
                if (this.f7591g.f7589e != i2) {
                    return m13714g();
                }
                return this;
            } else {
                iArr[0] = this.f7586b;
                if (((long) this.f7586b) + ((long) i) <= 2147483647L) {
                    z = true;
                }
                Preconditions.checkArgument(z);
                this.f7586b += i;
                this.f7588d += (long) i;
                return this;
            }
        }

        final AvlNode<E> m13727b(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.f7585a);
            AvlNode avlNode;
            if (compare < 0) {
                avlNode = this.f7590f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f7590f = avlNode.m13727b(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f7587c--;
                        this.f7588d -= (long) iArr[0];
                    } else {
                        this.f7588d -= (long) i;
                    }
                }
                if (iArr[0] != 0) {
                    return m13714g();
                }
                return this;
            } else if (compare > 0) {
                avlNode = this.f7591g;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f7591g = avlNode.m13727b(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f7587c--;
                        this.f7588d -= (long) iArr[0];
                    } else {
                        this.f7588d -= (long) i;
                    }
                }
                return m13714g();
            } else {
                iArr[0] = this.f7586b;
                if (i >= this.f7586b) {
                    return m13710c();
                }
                this.f7586b -= i;
                this.f7588d -= (long) i;
                return this;
            }
        }

        final AvlNode<E> m13728c(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.f7585a);
            AvlNode avlNode;
            if (compare < 0) {
                avlNode = this.f7590f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i > 0 ? m13709b(e, i) : this;
                } else {
                    this.f7590f = avlNode.m13728c(comparator, e, i, iArr);
                    if (i == 0 && iArr[0] != 0) {
                        this.f7587c--;
                    } else if (i > 0 && iArr[0] == 0) {
                        this.f7587c++;
                    }
                    this.f7588d += (long) (i - iArr[0]);
                    return m13714g();
                }
            } else if (compare > 0) {
                avlNode = this.f7591g;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        return m13707a((Object) e, i);
                    }
                    return this;
                }
                this.f7591g = avlNode.m13728c(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.f7587c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.f7587c++;
                }
                this.f7588d += (long) (i - iArr[0]);
                return m13714g();
            } else {
                iArr[0] = this.f7586b;
                if (i == 0) {
                    return m13710c();
                }
                this.f7588d += (long) (i - this.f7586b);
                this.f7586b = i;
                return this;
            }
        }

        final AvlNode<E> m13723a(Comparator<? super E> comparator, @Nullable E e, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e, this.f7585a);
            AvlNode avlNode;
            if (compare < 0) {
                avlNode = this.f7590f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i != 0 || i2 <= 0) {
                        return this;
                    }
                    return m13709b(e, i2);
                }
                this.f7590f = avlNode.m13723a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f7587c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f7587c++;
                    }
                    this.f7588d += (long) (i2 - iArr[0]);
                }
                return m13714g();
            } else if (compare > 0) {
                avlNode = this.f7591g;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i != 0 || i2 <= 0) {
                        return this;
                    }
                    return m13707a((Object) e, i2);
                }
                this.f7591g = avlNode.m13723a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f7587c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f7587c++;
                    }
                    this.f7588d += (long) (i2 - iArr[0]);
                }
                return m13714g();
            } else {
                iArr[0] = this.f7586b;
                if (i != this.f7586b) {
                    return this;
                }
                if (i2 == 0) {
                    return m13710c();
                }
                this.f7588d += (long) (i2 - this.f7586b);
                this.f7586b = i2;
                return this;
            }
        }

        private AvlNode<E> m13710c() {
            int i = this.f7586b;
            this.f7586b = 0;
            TreeMultiset.m13736b(this.f7592h, this.f7593i);
            if (this.f7590f == null) {
                return this.f7591g;
            }
            if (this.f7591g == null) {
                return this.f7590f;
            }
            if (this.f7590f.f7589e >= this.f7591g.f7589e) {
                AvlNode avlNode = this.f7592h;
                avlNode.f7590f = this.f7590f.m13719j(avlNode);
                avlNode.f7591g = this.f7591g;
                avlNode.f7587c = this.f7587c - 1;
                avlNode.f7588d = this.f7588d - ((long) i);
                return avlNode.m13714g();
            }
            avlNode = this.f7593i;
            avlNode.f7591g = this.f7591g.m13717i(avlNode);
            avlNode.f7590f = this.f7590f;
            avlNode.f7587c = this.f7587c - 1;
            avlNode.f7588d = this.f7588d - ((long) i);
            return avlNode.m13714g();
        }

        private AvlNode<E> m13717i(AvlNode<E> avlNode) {
            if (this.f7590f == null) {
                return this.f7591g;
            }
            this.f7590f = this.f7590f.m13717i(avlNode);
            this.f7587c--;
            this.f7588d -= (long) avlNode.f7586b;
            return m13714g();
        }

        private AvlNode<E> m13719j(AvlNode<E> avlNode) {
            if (this.f7591g == null) {
                return this.f7590f;
            }
            this.f7591g = this.f7591g.m13719j(avlNode);
            this.f7587c--;
            this.f7588d -= (long) avlNode.f7586b;
            return m13714g();
        }

        private void m13713f() {
            this.f7587c = (TreeMultiset.m13731a(this.f7590f) + 1) + TreeMultiset.m13731a(this.f7591g);
            this.f7588d = (((long) this.f7586b) + m13720k(this.f7590f)) + m13720k(this.f7591g);
            m13712e();
        }

        private void m13712e() {
            this.f7589e = Math.max(m13721l(this.f7590f), m13721l(this.f7591g)) + 1;
        }

        private AvlNode<E> m13714g() {
            switch (m13715h()) {
                case -2:
                    if (this.f7591g.m13715h() > 0) {
                        this.f7591g = this.f7591g.m13718j();
                    }
                    return m13716i();
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    if (this.f7590f.m13715h() < 0) {
                        this.f7590f = this.f7590f.m13716i();
                    }
                    return m13718j();
                default:
                    m13712e();
                    return this;
            }
        }

        private int m13715h() {
            return m13721l(this.f7590f) - m13721l(this.f7591g);
        }

        private AvlNode<E> m13716i() {
            Preconditions.checkState(this.f7591g != null);
            AvlNode<E> avlNode = this.f7591g;
            this.f7591g = avlNode.f7590f;
            avlNode.f7590f = this;
            avlNode.f7588d = this.f7588d;
            avlNode.f7587c = this.f7587c;
            m13713f();
            avlNode.m13712e();
            return avlNode;
        }

        private AvlNode<E> m13718j() {
            Preconditions.checkState(this.f7590f != null);
            AvlNode<E> avlNode = this.f7590f;
            this.f7590f = avlNode.f7591g;
            avlNode.f7591g = this;
            avlNode.f7588d = this.f7588d;
            avlNode.f7587c = this.f7587c;
            m13713f();
            avlNode.m13712e();
            return avlNode;
        }

        public static long m13720k(@Nullable AvlNode<?> avlNode) {
            return avlNode == null ? 0 : avlNode.f7588d;
        }

        private static int m13721l(@Nullable AvlNode<?> avlNode) {
            return avlNode == null ? 0 : avlNode.f7589e;
        }

        @Nullable
        public static AvlNode m13708b(AvlNode avlNode, Comparator comparator, Object obj) {
            int compare = comparator.compare(obj, avlNode.f7585a);
            if (compare < 0) {
                if (avlNode.f7590f == null) {
                    return avlNode;
                }
                return (AvlNode) MoreObjects.firstNonNull(m13708b(avlNode.f7590f, comparator, obj), avlNode);
            } else if (compare != 0) {
                return avlNode.f7591g == null ? null : m13708b(avlNode.f7591g, comparator, obj);
            } else {
                return avlNode;
            }
        }

        @Nullable
        public static AvlNode m13711c(AvlNode avlNode, Comparator comparator, Object obj) {
            int compare = comparator.compare(obj, avlNode.f7585a);
            if (compare > 0) {
                if (avlNode.f7591g == null) {
                    return avlNode;
                }
                return (AvlNode) MoreObjects.firstNonNull(m13711c(avlNode.f7591g, comparator, obj), avlNode);
            } else if (compare != 0) {
                return avlNode.f7590f == null ? null : m13711c(avlNode.f7590f, comparator, obj);
            } else {
                return avlNode;
            }
        }

        public final E mo889a() {
            return this.f7585a;
        }

        public final int mo890b() {
            return this.f7586b;
        }

        public final String toString() {
            return Multisets.a(mo889a(), mo890b()).toString();
        }
    }

    /* compiled from: bug_report_image_ */
    public final class Reference<T> {
        @Nullable
        public T f7594a;

        @Nullable
        public final T m13729a() {
            return this.f7594a;
        }

        public final void m13730a(@Nullable T t, T t2) {
            if (this.f7594a != t) {
                throw new ConcurrentModificationException();
            }
            this.f7594a = t2;
        }
    }

    public final /* bridge */ /* synthetic */ Set mo897a() {
        return super.mo897a();
    }

    public final /* bridge */ /* synthetic */ boolean add(@Nullable Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ boolean contains(@Nullable Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public final /* bridge */ /* synthetic */ boolean remove(@Nullable Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.f7596b = GeneralRange.m13342a((Comparator) comparator);
        this.f7597c = new AvlNode(null, 1);
        m13736b(this.f7597c, this.f7597c);
        this.f7595a = new Reference();
    }

    private TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.comparator);
        this.f7595a = reference;
        this.f7596b = generalRange;
        this.f7597c = avlNode;
    }

    private long m13732a(Aggregate aggregate) {
        AvlNode avlNode = (AvlNode) this.f7595a.f7594a;
        long treeAggregate = aggregate.treeAggregate(avlNode);
        if (this.f7596b.hasLowerBound) {
            treeAggregate -= m13733a(aggregate, avlNode);
        }
        if (this.f7596b.hasUpperBound) {
            return treeAggregate - m13734b(aggregate, avlNode);
        }
        return treeAggregate;
    }

    private long m13733a(Aggregate aggregate, @Nullable AvlNode<E> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(this.f7596b.lowerEndpoint, avlNode.f7585a);
        if (compare < 0) {
            return m13733a(aggregate, avlNode.f7590f);
        }
        if (compare != 0) {
            return (aggregate.treeAggregate(avlNode.f7590f) + ((long) aggregate.nodeAggregate(avlNode))) + m13733a(aggregate, avlNode.f7591g);
        }
        switch (C08574.f7584a[this.f7596b.lowerBoundType.ordinal()]) {
            case 1:
                return ((long) aggregate.nodeAggregate(avlNode)) + aggregate.treeAggregate(avlNode.f7590f);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return aggregate.treeAggregate(avlNode.f7590f);
            default:
                throw new AssertionError();
        }
    }

    private long m13734b(Aggregate aggregate, @Nullable AvlNode<E> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(this.f7596b.upperEndpoint, avlNode.f7585a);
        if (compare > 0) {
            return m13734b(aggregate, avlNode.f7591g);
        }
        if (compare != 0) {
            return (aggregate.treeAggregate(avlNode.f7591g) + ((long) aggregate.nodeAggregate(avlNode))) + m13734b(aggregate, avlNode.f7590f);
        }
        switch (C08574.f7584a[this.f7596b.upperBoundType.ordinal()]) {
            case 1:
                return ((long) aggregate.nodeAggregate(avlNode)) + aggregate.treeAggregate(avlNode.f7591g);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return aggregate.treeAggregate(avlNode.f7591g);
            default:
                throw new AssertionError();
        }
    }

    public final int size() {
        return Ints.b(m13732a(Aggregate.SIZE));
    }

    final int m13746c() {
        return Ints.b(m13732a(Aggregate.DISTINCT));
    }

    public final int m13738a(@Nullable Object obj) {
        try {
            AvlNode avlNode = (AvlNode) this.f7595a.m13729a();
            if (!this.f7596b.m13346c(obj) || avlNode == null) {
                return 0;
            }
            return avlNode.m13722a(comparator(), obj);
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public final int m13739a(@Nullable E e, int i) {
        CollectPreconditions.a(i, "occurrences");
        if (i == 0) {
            return a(e);
        }
        Preconditions.checkArgument(this.f7596b.m13346c(e));
        AvlNode avlNode = (AvlNode) this.f7595a.f7594a;
        if (avlNode == null) {
            comparator().compare(e, e);
            AvlNode avlNode2 = new AvlNode(e, i);
            m13737b(this.f7597c, avlNode2, this.f7597c);
            this.f7595a.m13730a(avlNode, avlNode2);
            return 0;
        }
        int[] iArr = new int[1];
        this.f7595a.m13730a(avlNode, avlNode.m13724a(comparator(), e, i, iArr));
        return iArr[0];
    }

    public final int m13743b(@Nullable Object obj, int i) {
        CollectPreconditions.a(i, "occurrences");
        if (i == 0) {
            return a(obj);
        }
        AvlNode avlNode = (AvlNode) this.f7595a.m13729a();
        int[] iArr = new int[1];
        try {
            if (!this.f7596b.m13346c(obj) || avlNode == null) {
                return 0;
            }
            this.f7595a.m13730a(avlNode, avlNode.m13727b(comparator(), obj, i, iArr));
            return iArr[0];
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public final int m13747c(@Nullable E e, int i) {
        CollectPreconditions.a(i, "count");
        if (this.f7596b.m13346c(e)) {
            AvlNode avlNode = (AvlNode) this.f7595a.f7594a;
            if (avlNode != null) {
                int[] iArr = new int[1];
                this.f7595a.m13730a(avlNode, avlNode.m13728c(comparator(), e, i, iArr));
                return iArr[0];
            } else if (i <= 0) {
                return 0;
            } else {
                a(e, i);
                return 0;
            }
        }
        boolean z;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return 0;
    }

    public final boolean m13742a(@Nullable E e, int i, int i2) {
        CollectPreconditions.a(i2, "newCount");
        CollectPreconditions.a(i, "oldCount");
        Preconditions.checkArgument(this.f7596b.m13346c(e));
        AvlNode avlNode = (AvlNode) this.f7595a.f7594a;
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.f7595a.m13730a(avlNode, avlNode.m13723a(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 > 0) {
                a(e, i2);
            }
            return true;
        }
    }

    public static Multisets$AbstractEntry m13735b(TreeMultiset treeMultiset, final AvlNode avlNode) {
        return new Multisets$AbstractEntry<E>(treeMultiset) {
            final /* synthetic */ TreeMultiset f7577b;

            public final E mo889a() {
                return avlNode.mo889a();
            }

            public final int mo890b() {
                int b = avlNode.mo890b();
                if (b == 0) {
                    return this.f7577b.a(mo889a());
                }
                return b;
            }
        };
    }

    final Iterator<Entry<E>> m13745b() {
        return new C08552(this);
    }

    final Iterator<Entry<E>> mo1008l() {
        return new C08563(this);
    }

    public final SortedMultiset<E> mo895a(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.f7595a, this.f7596b.m13343a(new GeneralRange(comparator(), false, null, BoundType.OPEN, true, e, boundType)), this.f7597c);
    }

    public final SortedMultiset<E> mo898b(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.f7595a, this.f7596b.m13343a(new GeneralRange(comparator(), true, e, boundType, false, null, BoundType.OPEN)), this.f7597c);
    }

    public static int m13731a(@Nullable AvlNode<?> avlNode) {
        return avlNode == null ? 0 : avlNode.f7587c;
    }

    public static <T> void m13736b(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        avlNode.f7593i = avlNode2;
        avlNode2.f7592h = avlNode;
    }

    public static <T> void m13737b(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        m13736b((AvlNode) avlNode, (AvlNode) avlNode2);
        m13736b((AvlNode) avlNode2, (AvlNode) avlNode3);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(mo903g().comparator());
        Serialization.m13652a((Multiset) this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.m13647a(AbstractSortedMultiset.class, "comparator").m13645a((Object) this, (Object) comparator);
        Serialization.m13647a(TreeMultiset.class, "range").m13645a((Object) this, GeneralRange.m13342a(comparator));
        Serialization.m13647a(TreeMultiset.class, "rootReference").m13645a((Object) this, new Reference());
        AvlNode avlNode = new AvlNode(null, 1);
        Serialization.m13647a(TreeMultiset.class, "header").m13645a((Object) this, (Object) avlNode);
        m13736b(avlNode, avlNode);
        Serialization.m13650a((Multiset) this, objectInputStream);
    }
}
