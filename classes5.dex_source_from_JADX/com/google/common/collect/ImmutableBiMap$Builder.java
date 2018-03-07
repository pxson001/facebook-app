package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps.EntryFunction;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: cache_miss_count */
public final class ImmutableBiMap$Builder<K, V> extends Builder<K, V> {
    public final /* synthetic */ Builder m13358b(Object obj, Object obj2) {
        return m13353a(obj, obj2);
    }

    public final /* synthetic */ ImmutableMap m13359b() {
        return m13354a();
    }

    public final ImmutableBiMap$Builder<K, V> m13353a(K k, V v) {
        super.b(k, v);
        return this;
    }

    public final Builder m13356a(Entry entry) {
        super.a(entry);
        return this;
    }

    public final Builder m13357a(Map map) {
        super.a(map);
        return this;
    }

    @Beta
    public final Builder m13355a(Iterable iterable) {
        super.a(iterable);
        return this;
    }

    public final ImmutableBiMap<K, V> m13354a() {
        switch (this.c) {
            case 0:
                return RegularImmutableBiMap.a;
            case 1:
                return ImmutableBiMap.b(this.b[0].getKey(), this.b[0].getValue());
            default:
                if (this.a != null) {
                    if (this.d) {
                        this.b = (ImmutableMapEntry[]) ObjectArrays.b(this.b, this.c);
                    }
                    Arrays.sort(this.b, 0, this.c, Ordering.a(this.a).a(EntryFunction.VALUE));
                }
                this.d = this.c == this.b.length;
                return RegularImmutableBiMap.a(this.c, this.b);
        }
    }
}
