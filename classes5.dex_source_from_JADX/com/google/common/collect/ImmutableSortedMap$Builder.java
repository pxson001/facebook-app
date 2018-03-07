package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: button_uri */
public class ImmutableSortedMap$Builder<K, V> extends Builder<K, V> {
    private final Comparator<? super K> f7350e;

    public final /* synthetic */ Builder m13414b(Object obj, Object obj2) {
        return m13412a(obj, obj2);
    }

    public final /* synthetic */ ImmutableMap m13415b() {
        return m13413a();
    }

    public ImmutableSortedMap$Builder(Comparator<? super K> comparator) {
        this.f7350e = (Comparator) Preconditions.checkNotNull(comparator);
    }

    public final ImmutableSortedMap$Builder<K, V> m13412a(K k, V v) {
        super.b(k, v);
        return this;
    }

    public final Builder m13410a(Entry entry) {
        super.a(entry);
        return this;
    }

    public final Builder m13411a(Map map) {
        super.a(map);
        return this;
    }

    @Beta
    public final Builder m13409a(Iterable iterable) {
        super.a(iterable);
        return this;
    }

    public final ImmutableSortedMap<K, V> m13413a() {
        switch (this.c) {
            case 0:
                return ImmutableSortedMap.a(this.f7350e);
            case 1:
                return ImmutableSortedMap.b(this.f7350e, this.b[0].getKey(), this.b[0].getValue());
            default:
                return ImmutableSortedMap.b(this.f7350e, false, this.b, this.c);
        }
    }
}
