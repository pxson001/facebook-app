package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.Segment;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: campaign_title */
public abstract class LocalCache$HashIterator<T> implements Iterator<T> {
    int f7188b;
    int f7189c = -1;
    Segment<K, V> f7190d;
    AtomicReferenceArray<ReferenceEntry<K, V>> f7191e;
    ReferenceEntry<K, V> f7192f;
    LocalCache$WriteThroughEntry f7193g;
    LocalCache$WriteThroughEntry f7194h;
    final /* synthetic */ LocalCache f7195i;

    LocalCache$HashIterator(LocalCache localCache) {
        this.f7195i = localCache;
        this.f7188b = localCache.d.length - 1;
        m13151b();
    }

    private void m13151b() {
        this.f7193g = null;
        if (!m13152c() && !m13153d()) {
            while (this.f7188b >= 0) {
                Segment[] segmentArr = this.f7195i.d;
                int i = this.f7188b;
                this.f7188b = i - 1;
                this.f7190d = segmentArr[i];
                if (this.f7190d.count != 0) {
                    this.f7191e = this.f7190d.table;
                    this.f7189c = this.f7191e.length() - 1;
                    if (m13153d()) {
                        return;
                    }
                }
            }
        }
    }

    private boolean m13152c() {
        if (this.f7192f != null) {
            this.f7192f = this.f7192f.getNext();
            while (this.f7192f != null) {
                if (m13150a(this.f7192f)) {
                    return true;
                }
                this.f7192f = this.f7192f.getNext();
            }
        }
        return false;
    }

    private boolean m13153d() {
        while (this.f7189c >= 0) {
            AtomicReferenceArray atomicReferenceArray = this.f7191e;
            int i = this.f7189c;
            this.f7189c = i - 1;
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
            this.f7192f = referenceEntry;
            if (referenceEntry != null && (m13150a(this.f7192f) || m13152c())) {
                return true;
            }
        }
        return false;
    }

    private boolean m13150a(ReferenceEntry<K, V> referenceEntry) {
        try {
            long read = this.f7195i.q.read();
            Object key = referenceEntry.getKey();
            Object a = this.f7195i.a(referenceEntry, read);
            if (a != null) {
                this.f7193g = new LocalCache$WriteThroughEntry(this.f7195i, key, a);
                return true;
            }
            this.f7190d.b();
            return false;
        } finally {
            this.f7190d.b();
        }
    }

    public boolean hasNext() {
        return this.f7193g != null;
    }

    final LocalCache$WriteThroughEntry m13154a() {
        if (this.f7193g == null) {
            throw new NoSuchElementException();
        }
        this.f7194h = this.f7193g;
        m13151b();
        return this.f7194h;
    }

    public void remove() {
        Preconditions.checkState(this.f7194h != null);
        this.f7195i.remove(this.f7194h.getKey());
        this.f7194h = null;
    }
}
