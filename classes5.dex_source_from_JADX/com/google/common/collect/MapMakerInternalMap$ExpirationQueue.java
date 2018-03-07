package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap.ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$ExpirationQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> f7437a = new C08271(this);

    /* compiled from: bulk_claim_importer */
    class C08271 extends MapMakerInternalMap$AbstractReferenceEntry<K, V> {
        ReferenceEntry<K, V> f7433a = this;
        ReferenceEntry<K, V> f7434b = this;
        final /* synthetic */ MapMakerInternalMap$ExpirationQueue f7435c;

        C08271(MapMakerInternalMap$ExpirationQueue mapMakerInternalMap$ExpirationQueue) {
            this.f7435c = mapMakerInternalMap$ExpirationQueue;
        }

        public long getExpirationTime() {
            return Long.MAX_VALUE;
        }

        public void setExpirationTime(long j) {
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.f7433a;
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.f7433a = referenceEntry;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.f7434b;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.f7434b = referenceEntry;
        }
    }

    MapMakerInternalMap$ExpirationQueue() {
    }

    public final boolean offer(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        MapMakerInternalMap.a(referenceEntry.getPreviousExpirable(), referenceEntry.getNextExpirable());
        MapMakerInternalMap.a(this.f7437a.getPreviousExpirable(), referenceEntry);
        MapMakerInternalMap.a(referenceEntry, this.f7437a);
        return true;
    }

    public final /* synthetic */ Object peek() {
        return m13516a();
    }

    private ReferenceEntry<K, V> m13516a() {
        ReferenceEntry<K, V> nextExpirable = this.f7437a.getNextExpirable();
        return nextExpirable == this.f7437a ? null : nextExpirable;
    }

    public final Object poll() {
        ReferenceEntry nextExpirable = this.f7437a.getNextExpirable();
        if (nextExpirable == this.f7437a) {
            return null;
        }
        remove(nextExpirable);
        return nextExpirable;
    }

    public final boolean remove(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        ReferenceEntry previousExpirable = referenceEntry.getPreviousExpirable();
        ReferenceEntry nextExpirable = referenceEntry.getNextExpirable();
        MapMakerInternalMap.a(previousExpirable, nextExpirable);
        MapMakerInternalMap.d(referenceEntry);
        return nextExpirable != MapMakerInternalMap$NullEntry.INSTANCE;
    }

    public final boolean contains(Object obj) {
        return ((ReferenceEntry) obj).getNextExpirable() != MapMakerInternalMap$NullEntry.INSTANCE;
    }

    public final boolean isEmpty() {
        return this.f7437a.getNextExpirable() == this.f7437a;
    }

    public final int size() {
        int i = 0;
        for (ReferenceEntry nextExpirable = this.f7437a.getNextExpirable(); nextExpirable != this.f7437a; nextExpirable = nextExpirable.getNextExpirable()) {
            i++;
        }
        return i;
    }

    public final void clear() {
        ReferenceEntry nextExpirable = this.f7437a.getNextExpirable();
        while (nextExpirable != this.f7437a) {
            ReferenceEntry nextExpirable2 = nextExpirable.getNextExpirable();
            MapMakerInternalMap.d(nextExpirable);
            nextExpirable = nextExpirable2;
        }
        this.f7437a.setNextExpirable(this.f7437a);
        this.f7437a.setPreviousExpirable(this.f7437a);
    }

    public final Iterator<ReferenceEntry<K, V>> iterator() {
        return new AbstractSequentialIterator<ReferenceEntry<K, V>>(this, m13516a()) {
            final /* synthetic */ MapMakerInternalMap$ExpirationQueue f7436a;

            protected final Object mo871a(Object obj) {
                ReferenceEntry nextExpirable = ((ReferenceEntry) obj).getNextExpirable();
                return nextExpirable == this.f7436a.f7437a ? null : nextExpirable;
            }
        };
    }
}
