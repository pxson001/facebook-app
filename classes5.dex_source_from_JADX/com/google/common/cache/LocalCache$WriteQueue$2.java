package com.google.common.cache;

import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.cache.LocalCache.WriteQueue;
import com.google.common.collect.AbstractSequentialIterator;

/* compiled from: campaign_title */
class LocalCache$WriteQueue$2 extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    final /* synthetic */ WriteQueue f7235a;

    LocalCache$WriteQueue$2(WriteQueue writeQueue, ReferenceEntry referenceEntry) {
        this.f7235a = writeQueue;
        super(referenceEntry);
    }

    protected final Object mo871a(Object obj) {
        ReferenceEntry nextInWriteQueue = ((ReferenceEntry) obj).getNextInWriteQueue();
        return nextInWriteQueue == this.f7235a.a ? null : nextInWriteQueue;
    }
}
