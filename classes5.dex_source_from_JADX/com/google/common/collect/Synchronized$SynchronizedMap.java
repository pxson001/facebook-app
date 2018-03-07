package com.google.common.collect;

import com.google.common.collect.Synchronized.SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
public class Synchronized$SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
    transient Set<K> f7564c;
    transient Collection<V> f7565d;
    transient Set<Entry<K, V>> f7566e;

    final /* synthetic */ Object m13671c() {
        return m13670a();
    }

    Synchronized$SynchronizedMap(Map<K, V> map, @Nullable Object obj) {
        super(map, obj);
    }

    final Map<K, V> m13670a() {
        return (Map) super.c();
    }

    public void clear() {
        synchronized (this.mutex) {
            m13670a().clear();
        }
    }

    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = m13670a().containsKey(obj);
        }
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = m13670a().containsValue(obj);
        }
        return containsValue;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set;
        synchronized (this.mutex) {
            if (this.f7566e == null) {
                this.f7566e = Synchronized.a(m13670a().entrySet(), this.mutex);
            }
            set = this.f7566e;
        }
        return set;
    }

    public V get(Object obj) {
        V v;
        synchronized (this.mutex) {
            v = m13670a().get(obj);
        }
        return v;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = m13670a().isEmpty();
        }
        return isEmpty;
    }

    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.f7564c == null) {
                this.f7564c = Synchronized.a(m13670a().keySet(), this.mutex);
            }
            set = this.f7564c;
        }
        return set;
    }

    public V put(K k, V v) {
        V put;
        synchronized (this.mutex) {
            put = m13670a().put(k, v);
        }
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        synchronized (this.mutex) {
            m13670a().putAll(map);
        }
    }

    public V remove(Object obj) {
        V remove;
        synchronized (this.mutex) {
            remove = m13670a().remove(obj);
        }
        return remove;
    }

    public int size() {
        int size;
        synchronized (this.mutex) {
            size = m13670a().size();
        }
        return size;
    }

    public Collection<V> values() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.f7565d == null) {
                this.f7565d = Synchronized.c(m13670a().values(), this.mutex);
            }
            collection = this.f7565d;
        }
        return collection;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean equals;
        synchronized (this.mutex) {
            equals = m13670a().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = m13670a().hashCode();
        }
        return hashCode;
    }
}
