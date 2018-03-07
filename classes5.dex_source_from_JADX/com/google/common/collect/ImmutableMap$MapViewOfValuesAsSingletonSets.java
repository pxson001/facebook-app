package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: cache_ids */
final class ImmutableMap$MapViewOfValuesAsSingletonSets extends ImmutableMap$IteratorBasedImmutableMap<K, ImmutableSet<V>> {
    final /* synthetic */ ImmutableMap this$0;

    public ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap) {
        this.this$0 = immutableMap;
    }

    public final int size() {
        return this.this$0.size();
    }

    public final ImmutableSet<K> keySet() {
        return this.this$0.keySet();
    }

    public final boolean containsKey(@Nullable Object obj) {
        return this.this$0.containsKey(obj);
    }

    public final Object get(@Nullable Object obj) {
        Object obj2 = this.this$0.get(obj);
        return obj2 == null ? null : ImmutableSet.of(obj2);
    }

    final boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    public final int hashCode() {
        return this.this$0.hashCode();
    }

    final boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }

    final UnmodifiableIterator<Entry<K, ImmutableSet<V>>> mo925a() {
        final UnmodifiableIterator it = this.this$0.entrySet().iterator();
        return new UnmodifiableIterator<Entry<K, ImmutableSet<V>>>(this) {
            final /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets f7326b;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Object next() {
                final Entry entry = (Entry) it.next();
                return new AbstractMapEntry<K, ImmutableSet<V>>(this) {
                    final /* synthetic */ C08161 f7324b;

                    public K getKey() {
                        return entry.getKey();
                    }

                    public Object getValue() {
                        return ImmutableSet.of(entry.getValue());
                    }
                };
            }
        };
    }
}
