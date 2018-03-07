package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets.ImprovedAbstractSet;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: log_eligibility_waterfall */
public abstract class Maps$EntrySet<K, V> extends ImprovedAbstractSet<Entry<K, V>> {
    abstract Map<K, V> mo701a();

    Maps$EntrySet() {
    }

    public int size() {
        return mo701a().size();
    }

    public void clear() {
        mo701a().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        Object a = Maps.a(mo701a(), key);
        if (!Objects.equal(a, entry.getValue())) {
            return false;
        }
        if (a != null || mo701a().containsKey(key)) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return mo701a().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        return mo701a().keySet().remove(((Entry) obj).getKey());
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException e) {
            return Sets.a(this, collection.iterator());
        }
    }

    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        } catch (UnsupportedOperationException e) {
            Collection a = Sets.a(collection.size());
            for (Object next : collection) {
                if (contains(next)) {
                    a.add(((Entry) next).getKey());
                }
            }
            return mo701a().keySet().retainAll(a);
        }
    }
}
