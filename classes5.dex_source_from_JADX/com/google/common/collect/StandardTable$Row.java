package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: bug_report_untracked_directory_deleted */
public class StandardTable$Row extends IteratorBasedAbstractMap<C, V> {
    public final R f7557a;
    Map<C, V> f7558b;
    public final /* synthetic */ StandardTable f7559c;

    StandardTable$Row(StandardTable standardTable, R r) {
        this.f7559c = standardTable;
        this.f7557a = Preconditions.checkNotNull(r);
    }

    private Map<C, V> m13666b() {
        if (this.f7558b != null && (!this.f7558b.isEmpty() || !this.f7559c.backingMap.containsKey(this.f7557a))) {
            return this.f7558b;
        }
        Map<C, V> map = (Map) this.f7559c.backingMap.get(this.f7557a);
        this.f7558b = map;
        return map;
    }

    final void m13667a() {
        if (m13666b() != null && this.f7558b.isEmpty()) {
            this.f7559c.backingMap.remove(this.f7557a);
            this.f7558b = null;
        }
    }

    public boolean containsKey(Object obj) {
        Map b = m13666b();
        return (obj == null || b == null || !Maps.b(b, obj)) ? false : true;
    }

    public V get(Object obj) {
        Map b = m13666b();
        return (obj == null || b == null) ? null : Maps.a(b, obj);
    }

    public V put(C c, V v) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(v);
        if (this.f7558b == null || this.f7558b.isEmpty()) {
            return this.f7559c.a(this.f7557a, c, v);
        }
        return this.f7558b.put(c, v);
    }

    public V remove(Object obj) {
        Map b = m13666b();
        if (b == null) {
            return null;
        }
        V c = Maps.c(b, obj);
        m13667a();
        return c;
    }

    public void clear() {
        Map b = m13666b();
        if (b != null) {
            b.clear();
        }
        m13667a();
    }

    public int size() {
        Map b = m13666b();
        return b == null ? 0 : b.size();
    }

    final Iterator<Entry<C, V>> m13668d() {
        Map b = m13666b();
        if (b == null) {
            return Iterators.b;
        }
        final Iterator it = b.entrySet().iterator();
        return new Iterator<Entry<C, V>>(this) {
            final /* synthetic */ StandardTable$Row f7556b;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Object next() {
                final Entry entry = (Entry) it.next();
                return new ForwardingMapEntry<C, V>(this) {
                    final /* synthetic */ C08481 f7554b;

                    protected final /* synthetic */ Object m13665e() {
                        return m13664a();
                    }

                    protected final Entry<C, V> m13664a() {
                        return entry;
                    }

                    public V setValue(V v) {
                        return super.setValue(Preconditions.checkNotNull(v));
                    }

                    public boolean equals(Object obj) {
                        return a(obj);
                    }
                };
            }

            public void remove() {
                it.remove();
                this.f7556b.m13667a();
            }
        };
    }
}
