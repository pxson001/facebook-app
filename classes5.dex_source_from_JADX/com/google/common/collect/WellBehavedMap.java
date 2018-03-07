package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
/* compiled from: bug_report_failed_to_upload */
final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
    private final Map<K, V> f7631a;
    private Set<Entry<K, V>> f7632b;

    /* compiled from: bug_report_failed_to_upload */
    final class EntrySet extends com.google.common.collect.Maps.EntrySet<K, V> {
        final /* synthetic */ WellBehavedMap f7630a;

        public EntrySet(WellBehavedMap wellBehavedMap) {
            this.f7630a = wellBehavedMap;
        }

        final Map<K, V> m13782a() {
            return this.f7630a;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new TransformedIterator<K, Entry<K, V>>(this, this.f7630a.keySet().iterator()) {
                final /* synthetic */ EntrySet f7629a;

                final Object m13781a(final Object obj) {
                    return new AbstractMapEntry<K, V>(this) {
                        final /* synthetic */ C08661 f7628b;

                        public K getKey() {
                            return obj;
                        }

                        public V getValue() {
                            return this.f7628b.f7629a.f7630a.get(obj);
                        }

                        public V setValue(V v) {
                            return this.f7628b.f7629a.f7630a.put(obj, v);
                        }
                    };
                }
            };
        }
    }

    protected final /* synthetic */ Object mo880e() {
        return mo877a();
    }

    private WellBehavedMap(Map<K, V> map) {
        this.f7631a = map;
    }

    static <K, V> WellBehavedMap<K, V> m13783a(Map<K, V> map) {
        return new WellBehavedMap(map);
    }

    protected final Map<K, V> mo877a() {
        return this.f7631a;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.f7632b;
        if (set != null) {
            return set;
        }
        set = new EntrySet(this);
        this.f7632b = set;
        return set;
    }
}
