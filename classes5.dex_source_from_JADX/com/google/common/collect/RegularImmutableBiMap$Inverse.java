package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: bugreporter-doodle- */
final class RegularImmutableBiMap$Inverse extends ImmutableBiMap<V, K> {
    final /* synthetic */ RegularImmutableBiMap this$0;

    /* compiled from: bugreporter-doodle- */
    final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {

        /* compiled from: bugreporter-doodle- */
        class C08371 extends ImmutableAsList<Entry<V, K>> {
            C08371() {
            }

            public Object get(int i) {
                Entry entry = RegularImmutableBiMap$Inverse.this.this$0.d[i];
                return Maps.a(entry.getValue(), entry.getKey());
            }

            final ImmutableCollection<Entry<V, K>> m13618a() {
                return InverseEntrySet.this;
            }
        }

        InverseEntrySet() {
        }

        final ImmutableMap<V, K> m13619a() {
            return RegularImmutableBiMap$Inverse.this;
        }

        final boolean isHashCodeFast() {
            return true;
        }

        public final int hashCode() {
            return RegularImmutableBiMap$Inverse.this.this$0.f;
        }

        public final UnmodifiableIterator<Entry<V, K>> iterator() {
            return asList().iterator();
        }

        final ImmutableList<Entry<V, K>> createAsList() {
            return new C08371();
        }
    }

    public RegularImmutableBiMap$Inverse(RegularImmutableBiMap regularImmutableBiMap) {
        this.this$0 = regularImmutableBiMap;
    }

    public final /* synthetic */ BiMap a_() {
        return m13620e();
    }

    public final int size() {
        return m13620e().size();
    }

    public final ImmutableBiMap<K, V> m13620e() {
        return this.this$0;
    }

    public final K get(@Nullable Object obj) {
        if (obj == null || this.this$0.c == null) {
            return null;
        }
        for (ImmutableEntry immutableEntry = this.this$0.c[Hashing.a(obj.hashCode()) & this.this$0.e]; immutableEntry != null; immutableEntry = immutableEntry.b()) {
            if (obj.equals(immutableEntry.getValue())) {
                return immutableEntry.getKey();
            }
        }
        return null;
    }

    final ImmutableSet<Entry<V, K>> createEntrySet() {
        return new InverseEntrySet();
    }

    final boolean isPartialView() {
        return false;
    }

    final Object writeReplace() {
        return new RegularImmutableBiMap$InverseSerializedForm(this.this$0);
    }
}
