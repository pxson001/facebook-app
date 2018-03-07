package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedAsMapEntries<K, V> extends Synchronized$SynchronizedSet<Entry<K, Collection<V>>> {
    Synchronized$SynchronizedAsMapEntries(Set<Entry<K, Collection<V>>> set, @Nullable Object obj) {
        super(set, obj);
    }

    public Iterator<Entry<K, Collection<V>>> iterator() {
        return new TransformedIterator<Entry<K, Collection<V>>, Entry<K, Collection<V>>>(this, super.iterator()) {
            final /* synthetic */ Synchronized$SynchronizedAsMapEntries f7571a;

            final Object m13674a(Object obj) {
                final Entry entry = (Entry) obj;
                return new ForwardingMapEntry<K, Collection<V>>(this) {
                    final /* synthetic */ C08511 f7570b;

                    protected final /* synthetic */ Object m13673e() {
                        return m13672a();
                    }

                    protected final Entry<K, Collection<V>> m13672a() {
                        return entry;
                    }

                    public Object getValue() {
                        return Synchronized.d((Collection) entry.getValue(), this.f7570b.f7571a.mutex);
                    }
                };
            }
        };
    }

    public Object[] toArray() {
        Object[] a;
        synchronized (this.mutex) {
            a = ObjectArrays.a(mo1001a());
        }
        return a;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] a;
        synchronized (this.mutex) {
            a = ObjectArrays.a(mo1001a(), tArr);
        }
        return a;
    }

    public boolean contains(Object obj) {
        boolean a;
        synchronized (this.mutex) {
            a = Maps.a(mo1001a(), obj);
        }
        return a;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean a;
        synchronized (this.mutex) {
            a = Collections2.a(mo1001a(), collection);
        }
        return a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean a;
        synchronized (this.mutex) {
            a = Sets.a(mo1001a(), obj);
        }
        return a;
    }

    public boolean remove(Object obj) {
        boolean b;
        synchronized (this.mutex) {
            b = Maps.b(mo1001a(), obj);
        }
        return b;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean a;
        synchronized (this.mutex) {
            a = Iterators.a(mo1001a().iterator(), collection);
        }
        return a;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean b;
        synchronized (this.mutex) {
            b = Iterators.b(mo1001a().iterator(), collection);
        }
        return b;
    }
}
