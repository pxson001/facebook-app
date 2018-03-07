package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: sun.misc.SharedSecrets */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {

    /* compiled from: sun.misc.SharedSecrets */
    public class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
        final int expectedSize;

        public Factory(int i) {
            this.expectedSize = i;
        }

        public Object get() {
            return Maps.m812a(this.expectedSize);
        }
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
    }

    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
