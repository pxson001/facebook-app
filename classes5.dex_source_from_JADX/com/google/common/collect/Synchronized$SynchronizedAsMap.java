package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedAsMap<K, V> extends Synchronized$SynchronizedMap<K, Collection<V>> {
    transient Set<Entry<K, Collection<V>>> f7567a;
    transient Collection<Collection<V>> f7568b;

    Synchronized$SynchronizedAsMap(Map<K, Collection<V>> map, @Nullable Object obj) {
        super(map, obj);
    }

    public Object get(Object obj) {
        Object d;
        synchronized (this.mutex) {
            Collection collection = (Collection) super.get(obj);
            d = collection == null ? null : Synchronized.d(collection, this.mutex);
        }
        return d;
    }

    public Set<Entry<K, Collection<V>>> entrySet() {
        Set<Entry<K, Collection<V>>> set;
        synchronized (this.mutex) {
            if (this.f7567a == null) {
                this.f7567a = new Synchronized$SynchronizedAsMapEntries(m13670a().entrySet(), this.mutex);
            }
            set = this.f7567a;
        }
        return set;
    }

    public Collection<Collection<V>> values() {
        Collection<Collection<V>> collection;
        synchronized (this.mutex) {
            if (this.f7568b == null) {
                this.f7568b = new Synchronized$SynchronizedAsMapValues(m13670a().values(), this.mutex);
            }
            collection = this.f7568b;
        }
        return collection;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }
}
