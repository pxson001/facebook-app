package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$EvictionQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> f7432a = new C08251(this);

    /* compiled from: bulk_claim_importer */
    class C08251 extends MapMakerInternalMap$AbstractReferenceEntry<K, V> {
        ReferenceEntry<K, V> f7428a = this;
        ReferenceEntry<K, V> f7429b = this;
        final /* synthetic */ MapMakerInternalMap$EvictionQueue f7430c;

        C08251(MapMakerInternalMap$EvictionQueue mapMakerInternalMap$EvictionQueue) {
            this.f7430c = mapMakerInternalMap$EvictionQueue;
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.f7428a;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.f7428a = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.f7429b;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.f7429b = referenceEntry;
        }
    }

    MapMakerInternalMap$EvictionQueue() {
    }

    public final boolean offer(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        MapMakerInternalMap.b(referenceEntry.getPreviousEvictable(), referenceEntry.getNextEvictable());
        MapMakerInternalMap.b(this.f7432a.getPreviousEvictable(), referenceEntry);
        MapMakerInternalMap.b(referenceEntry, this.f7432a);
        return true;
    }

    public final /* synthetic */ Object peek() {
        return m13514a();
    }

    private ReferenceEntry<K, V> m13514a() {
        ReferenceEntry<K, V> nextEvictable = this.f7432a.getNextEvictable();
        return nextEvictable == this.f7432a ? null : nextEvictable;
    }

    public final Object poll() {
        ReferenceEntry nextEvictable = this.f7432a.getNextEvictable();
        if (nextEvictable == this.f7432a) {
            return null;
        }
        remove(nextEvictable);
        return nextEvictable;
    }

    public final boolean remove(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        ReferenceEntry previousEvictable = referenceEntry.getPreviousEvictable();
        ReferenceEntry nextEvictable = referenceEntry.getNextEvictable();
        MapMakerInternalMap.b(previousEvictable, nextEvictable);
        MapMakerInternalMap.e(referenceEntry);
        return nextEvictable != MapMakerInternalMap$NullEntry.INSTANCE;
    }

    public final boolean contains(Object obj) {
        return ((ReferenceEntry) obj).getNextEvictable() != MapMakerInternalMap$NullEntry.INSTANCE;
    }

    public final boolean isEmpty() {
        return this.f7432a.getNextEvictable() == this.f7432a;
    }

    public final int size() {
        int i = 0;
        for (ReferenceEntry nextEvictable = this.f7432a.getNextEvictable(); nextEvictable != this.f7432a; nextEvictable = nextEvictable.getNextEvictable()) {
            i++;
        }
        return i;
    }

    public final void clear() {
        ReferenceEntry nextEvictable = this.f7432a.getNextEvictable();
        while (nextEvictable != this.f7432a) {
            ReferenceEntry nextEvictable2 = nextEvictable.getNextEvictable();
            MapMakerInternalMap.e(nextEvictable);
            nextEvictable = nextEvictable2;
        }
        this.f7432a.setNextEvictable(this.f7432a);
        this.f7432a.setPreviousEvictable(this.f7432a);
    }

    public final Iterator<ReferenceEntry<K, V>> iterator() {
        return new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, m13514a()) {
            final /* synthetic */ MapMakerInternalMap$EvictionQueue f7431a;

            protected final Object mo871a(Object obj) {
                ReferenceEntry nextEvictable = ((ReferenceEntry) obj).getNextEvictable();
                return nextEvictable == this.f7431a.f7432a ? null : nextEvictable;
            }
        };
    }
}
