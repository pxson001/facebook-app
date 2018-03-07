package com.google.common.collect;

import java.util.Map.Entry;

/* compiled from: button_uri */
class ImmutableSortedMap$1EntrySet extends ImmutableMapEntrySet<K, V> {
    final /* synthetic */ ImmutableSortedMap this$0;

    /* compiled from: button_uri */
    class C08181 extends ImmutableAsList<Entry<K, V>> {
        C08181() {
        }

        public Object get(int i) {
            return Maps.a(ImmutableSortedMap$1EntrySet.this.this$0.c.asList().get(i), ImmutableSortedMap$1EntrySet.this.this$0.d.get(i));
        }

        final ImmutableCollection<Entry<K, V>> m13407a() {
            return ImmutableSortedMap$1EntrySet.this;
        }
    }

    ImmutableSortedMap$1EntrySet(ImmutableSortedMap immutableSortedMap) {
        this.this$0 = immutableSortedMap;
    }

    public UnmodifiableIterator<Entry<K, V>> iterator() {
        return asList().iterator();
    }

    ImmutableList<Entry<K, V>> createAsList() {
        return new C08181();
    }

    final ImmutableMap<K, V> m13408a() {
        return this.this$0;
    }
}
