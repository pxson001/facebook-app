package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: bytes_downloaded */
class ImmutableMultimap$Keys extends ImmutableMultiset<K> {
    final /* synthetic */ ImmutableMultimap this$0;

    ImmutableMultimap$Keys(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
    }

    public boolean contains(@Nullable Object obj) {
        return this.this$0.f(obj);
    }

    public final int m13387a(@Nullable Object obj) {
        Collection collection = (Collection) this.this$0.b.get(obj);
        return collection == null ? 0 : collection.size();
    }

    public final Set<K> m13389d() {
        return this.this$0.e();
    }

    public int size() {
        return this.this$0.f();
    }

    final Entry<K> mo928a(int i) {
        Map.Entry entry = (Map.Entry) this.this$0.b.entrySet().asList().get(i);
        return Multisets.a(entry.getKey(), ((Collection) entry.getValue()).size());
    }

    boolean isPartialView() {
        return true;
    }
}
