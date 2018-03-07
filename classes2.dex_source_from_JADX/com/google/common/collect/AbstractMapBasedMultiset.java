package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: offersite/detail/view/?offer_view_id=%s&share_id=%s&site_uri=%s&title=%s&offer_code=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    public transient Map<E, Count> f11459a;
    public transient long f11460b = ((long) super.size());

    protected AbstractMapBasedMultiset(Map<E, Count> map) {
        this.f11459a = (Map) Preconditions.checkNotNull(map);
    }

    final Iterator<Entry<E>> mo2166b() {
        final Iterator it = this.f11459a.entrySet().iterator();
        return new Iterator<Entry<E>>(this) {
            Map.Entry<E, Count> f11464a;
            final /* synthetic */ AbstractMapBasedMultiset f11466c;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Object next() {
                Map.Entry entry = (Map.Entry) it.next();
                this.f11464a = entry;
                return new 1(this, entry);
            }

            public void remove() {
                boolean z;
                if (this.f11464a != null) {
                    z = true;
                } else {
                    z = false;
                }
                CollectPreconditions.m617a(z);
                this.f11466c.f11460b -= (long) ((Count) this.f11464a.getValue()).d(0);
                it.remove();
                this.f11464a = null;
            }
        };
    }

    public void clear() {
        for (Count count : this.f11459a.values()) {
            count.value = 0;
        }
        this.f11459a.clear();
        this.f11460b = 0;
    }

    final int mo2167c() {
        return this.f11459a.size();
    }

    public int size() {
        return Ints.m4489b(this.f11460b);
    }

    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator(this);
    }

    public int mo2163a(@Nullable Object obj) {
        Count count = (Count) Maps.m810a(this.f11459a, obj);
        return count == null ? 0 : count.value;
    }

    public int mo2164a(@Nullable E e, int i) {
        int i2 = 0;
        if (i == 0) {
            return mo2163a(e);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = (Count) this.f11459a.get(e);
        if (count == null) {
            this.f11459a.put(e, new Count(i));
        } else {
            int i3 = count.value;
            Preconditions.checkArgument(((long) i3) + ((long) i) <= 2147483647L, "too many occurrences: %s", Long.valueOf(((long) i3) + ((long) i)));
            count.value += i;
            i2 = i3;
        }
        this.f11460b += (long) i;
        return i2;
    }

    public int mo2165b(@Nullable Object obj, int i) {
        if (i == 0) {
            return mo2163a(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = (Count) this.f11459a.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.value;
        if (i2 <= i) {
            this.f11459a.remove(obj);
            i = i2;
        }
        count.b(-i);
        this.f11460b -= (long) i;
        return i2;
    }

    public int mo2168c(@Nullable E e, int i) {
        int a;
        CollectPreconditions.m615a(i, "count");
        if (i == 0) {
            a = m16743a((Count) this.f11459a.remove(e), i);
        } else {
            Count count = (Count) this.f11459a.get(e);
            int a2 = m16743a(count, i);
            if (count == null) {
                this.f11459a.put(e, new Count(i));
            }
            a = a2;
        }
        this.f11460b += (long) (i - a);
        return a;
    }

    private static int m16743a(Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.d(i);
    }
}
