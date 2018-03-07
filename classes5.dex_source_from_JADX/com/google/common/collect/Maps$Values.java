package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: camera */
public class Maps$Values<K, V> extends AbstractCollection<V> {
    @Weak
    public final Map<K, V> f7480c;

    Maps$Values(Map<K, V> map) {
        this.f7480c = (Map) Preconditions.checkNotNull(map);
    }

    private Map<K, V> m13541a() {
        return this.f7480c;
    }

    public void clear() {
        this.f7480c.clear();
    }

    public boolean contains(@Nullable Object obj) {
        return this.f7480c.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f7480c.isEmpty();
    }

    public Iterator<V> iterator() {
        return Maps.b(this.f7480c.entrySet().iterator());
    }

    public int size() {
        return this.f7480c.size();
    }

    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException e) {
            for (Entry entry : m13541a().entrySet()) {
                if (Objects.equal(obj, entry.getValue())) {
                    m13541a().remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException e) {
            Collection a = Sets.a();
            for (Entry entry : m13541a().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    a.add(entry.getKey());
                }
            }
            return m13541a().keySet().removeAll(a);
        }
    }

    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException e) {
            Collection a = Sets.a();
            for (Entry entry : m13541a().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    a.add(entry.getKey());
                }
            }
            return m13541a().keySet().retainAll(a);
        }
    }
}
