package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: password_account_eligibility_counter */
public final class Synchronized {

    /* compiled from: password_account_eligibility_counter */
    class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        transient Set<K> f10356a;
        transient Collection<V> f10357b;
        transient Collection<Entry<K, V>> f10358c;
        transient Map<K, Collection<V>> f10359d;
        transient Multiset<K> f10360e;

        final /* synthetic */ Object mo1991c() {
            return m15407a();
        }

        private Multimap<K, V> m15407a() {
            return (Multimap) super.mo1991c();
        }

        SynchronizedMultimap(Multimap<K, V> multimap, @Nullable Object obj) {
            super(multimap, obj);
        }

        public final int mo413f() {
            int f;
            synchronized (this.mutex) {
                f = m15407a().mo413f();
            }
            return f;
        }

        public final boolean mo420n() {
            boolean n;
            synchronized (this.mutex) {
                n = m15407a().mo420n();
            }
            return n;
        }

        public final boolean mo414f(Object obj) {
            boolean f;
            synchronized (this.mutex) {
                f = m15407a().mo414f(obj);
            }
            return f;
        }

        public final boolean mo410b(Object obj, Object obj2) {
            boolean b;
            synchronized (this.mutex) {
                b = m15407a().mo410b(obj, obj2);
            }
            return b;
        }

        public final Collection<V> mo427c(K k) {
            Collection<V> d;
            synchronized (this.mutex) {
                d = Synchronized.m15406d(m15407a().mo427c(k), this.mutex);
            }
            return d;
        }

        public final boolean mo431a(K k, V v) {
            boolean a;
            synchronized (this.mutex) {
                a = m15407a().mo431a((Object) k, (Object) v);
            }
            return a;
        }

        public final boolean mo409a(K k, Iterable<? extends V> iterable) {
            boolean a;
            synchronized (this.mutex) {
                a = m15407a().mo409a((Object) k, (Iterable) iterable);
            }
            return a;
        }

        public final boolean mo412c(Object obj, Object obj2) {
            boolean c;
            synchronized (this.mutex) {
                c = m15407a().mo412c(obj, obj2);
            }
            return c;
        }

        public final Collection<V> mo429d(Object obj) {
            Collection<V> d;
            synchronized (this.mutex) {
                d = m15407a().mo429d(obj);
            }
            return d;
        }

        public final void mo415g() {
            synchronized (this.mutex) {
                m15407a().mo415g();
            }
        }

        public final Set<K> mo421p() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.f10356a == null) {
                    this.f10356a = Synchronized.m15405c(m15407a().mo421p(), this.mutex);
                }
                set = this.f10356a;
            }
            return set;
        }

        public final Collection<V> mo418i() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.f10357b == null) {
                    this.f10357b = Synchronized.m15404c(m15407a().mo418i(), this.mutex);
                }
                collection = this.f10357b;
            }
            return collection;
        }

        public final Collection<Entry<K, V>> mo419k() {
            Collection<Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.f10358c == null) {
                    this.f10358c = Synchronized.m15406d(m15407a().mo419k(), this.mutex);
                }
                collection = this.f10358c;
            }
            return collection;
        }

        public final Map<K, Collection<V>> mo426b() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.f10359d == null) {
                    this.f10359d = new SynchronizedAsMap(m15407a().mo426b(), this.mutex);
                }
                map = this.f10359d;
            }
            return map;
        }

        public final Multiset<K> mo422q() {
            Multiset<K> multiset;
            synchronized (this.mutex) {
                if (this.f10360e == null) {
                    this.f10360e = Synchronized.m15400a(m15407a().mo422q(), this.mutex);
                }
                multiset = this.f10360e;
            }
            return multiset;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            boolean equals;
            synchronized (this.mutex) {
                equals = m15407a().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = m15407a().hashCode();
            }
            return hashCode;
        }
    }

    /* compiled from: password_account_eligibility_counter */
    public class SynchronizedObject implements Serializable {
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, @Nullable Object obj2) {
            this.delegate = Preconditions.checkNotNull(obj);
            if (obj2 == null) {
                obj2 = this;
            }
            this.mutex = obj2;
        }

        Object mo1991c() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    private Synchronized() {
    }

    public static <E> Collection<E> m15404c(Collection<E> collection, @Nullable Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    @VisibleForTesting
    static <E> Set<E> m15401a(Set<E> set, @Nullable Object obj) {
        return new SynchronizedSet(set, obj);
    }

    public static <E> SortedSet<E> m15403b(SortedSet<E> sortedSet, @Nullable Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    public static <E> List<E> m15402b(List<E> list, @Nullable Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static <E> Multiset<E> m15400a(Multiset<E> multiset, @Nullable Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    public static <K, V> Multimap<K, V> m15399a(Multimap<K, V> multimap, @Nullable Object obj) {
        return ((multimap instanceof SynchronizedMultimap) || (multimap instanceof ImmutableMultimap)) ? multimap : new SynchronizedMultimap(multimap, obj);
    }

    public static <E> Collection<E> m15406d(Collection<E> collection, @Nullable Object obj) {
        if (collection instanceof SortedSet) {
            return m15403b((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return m15401a((Set) collection, obj);
        }
        if (collection instanceof List) {
            return m15402b((List) collection, obj);
        }
        return m15404c((Collection) collection, obj);
    }

    public static <E> Set<E> m15405c(Set<E> set, @Nullable Object obj) {
        if (set instanceof SortedSet) {
            return m15403b((SortedSet) set, obj);
        }
        return m15401a((Set) set, obj);
    }
}
