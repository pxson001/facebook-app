package com.google.common.cache;

import com.google.common.cache.LocalCache.AccessQueue;
import com.google.common.cache.LocalCache.ReferenceEntry;
import com.google.common.collect.AbstractSequentialIterator;

/* compiled from: campaign_title */
class LocalCache$AccessQueue$2 extends AbstractSequentialIterator<ReferenceEntry<K, V>> {
    final /* synthetic */ AccessQueue f7187a;

    LocalCache$AccessQueue$2(AccessQueue accessQueue, ReferenceEntry referenceEntry) {
        this.f7187a = accessQueue;
        super(referenceEntry);
    }

    protected final Object mo871a(Object obj) {
        ReferenceEntry nextInAccessQueue = ((ReferenceEntry) obj).getNextInAccessQueue();
        return nextInAccessQueue == this.f7187a.a ? null : nextInAccessQueue;
    }
}
