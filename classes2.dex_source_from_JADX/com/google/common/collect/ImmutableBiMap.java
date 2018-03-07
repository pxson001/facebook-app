package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/facepile_profile_picture_urls_key */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {
    public abstract ImmutableBiMap<V, K> mo73e();

    public /* synthetic */ BiMap a_() {
        return mo73e();
    }

    public final /* synthetic */ Set mo67c() {
        return m983f();
    }

    public /* synthetic */ ImmutableCollection values() {
        return m983f();
    }

    public /* synthetic */ Collection m32803values() {
        return m983f();
    }

    public static <K, V> ImmutableBiMap<K, V> m976a() {
        return RegularImmutableBiMap.f695a;
    }

    public static <K, V> ImmutableBiMap<K, V> m978b(K k, V v) {
        return new SingletonImmutableBiMap(k, v);
    }

    public static <K, V> Builder<K, V> m979d() {
        return new Builder();
    }

    public static <K, V> ImmutableBiMap<K, V> m977a(Map<? extends K, ? extends V> map) {
        ImmutableBiMap<K, V> immutableBiMap;
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap immutableBiMap2 = (ImmutableBiMap) map;
            if (!immutableBiMap2.isPartialView()) {
                return immutableBiMap2;
            }
        }
        Entry[] entryArr = (Entry[]) Iterables.m958a(map.entrySet(), ImmutableMap.EMPTY_ENTRY_ARRAY);
        switch (entryArr.length) {
            case 0:
                immutableBiMap = RegularImmutableBiMap.f695a;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Entry entry = entryArr[0];
                immutableBiMap = m978b(entry.getKey(), entry.getValue());
                break;
            default:
                immutableBiMap = RegularImmutableBiMap.m1432a(entryArr.length, entryArr);
                break;
        }
        return immutableBiMap;
    }

    ImmutableBiMap() {
    }

    public final ImmutableSet<V> m983f() {
        return mo73e().keySet();
    }

    @Deprecated
    public final V mo65a(K k, V v) {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
