package com.google.common.collect;

import com.google.common.collect.ImmutableMap.Builder;
import java.io.Serializable;
import java.util.Map.Entry;

/* compiled from: cache_ids */
public class ImmutableMap$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object[] keys;
    private final Object[] values;

    ImmutableMap$SerializedForm(ImmutableMap<?, ?> immutableMap) {
        this.keys = new Object[immutableMap.size()];
        this.values = new Object[immutableMap.size()];
        UnmodifiableIterator it = immutableMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            this.keys[i] = entry.getKey();
            this.values[i] = entry.getValue();
            i++;
        }
    }

    Object readResolve() {
        return m13360a(new Builder(this.keys.length));
    }

    final Object m13360a(Builder<Object, Object> builder) {
        for (int i = 0; i < this.keys.length; i++) {
            builder.b(this.keys[i], this.values[i]);
        }
        return builder.b();
    }
}
