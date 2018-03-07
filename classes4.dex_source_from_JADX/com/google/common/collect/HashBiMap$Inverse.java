package com.google.common.collect;

import com.google.common.collect.HashBiMap.BiEntry;
import com.google.common.collect.HashBiMap.InverseSerializedForm;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: language_switcher_login_more_clicked */
public final class HashBiMap$Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
    public final /* synthetic */ HashBiMap this$0;

    public HashBiMap$Inverse(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
    }

    public final /* synthetic */ Collection values() {
        return m10081c();
    }

    public final BiMap<K, V> a_() {
        return this.this$0;
    }

    public final Set<K> m10081c() {
        return this.this$0.keySet();
    }

    public final void clear() {
        this.this$0.clear();
    }

    public final boolean containsKey(@Nullable Object obj) {
        return this.this$0.containsValue(obj);
    }

    public final int size() {
        return this.this$0.e;
    }

    public final K get(@Nullable Object obj) {
        return Maps.b(HashBiMap.b(this.this$0, obj, Hashing.a(obj)));
    }

    public final K put(@Nullable V v, @Nullable K k) {
        return HashBiMap.b(this.this$0, v, k, false);
    }

    public final K m10080a(@Nullable V v, @Nullable K k) {
        return HashBiMap.b(this.this$0, v, k, true);
    }

    public final K remove(@Nullable Object obj) {
        BiEntry b = HashBiMap.b(this.this$0, obj, Hashing.a(obj));
        if (b == null) {
            return null;
        }
        HashBiMap.a(this.this$0, b);
        b.prevInKeyInsertionOrder = null;
        b.nextInKeyInsertionOrder = null;
        return b.key;
    }

    public final Set<V> keySet() {
        return new InverseKeySet(this);
    }

    public final Set<Entry<V, K>> entrySet() {
        return new 1(this);
    }

    final Object writeReplace() {
        return new InverseSerializedForm(this.this$0);
    }
}
