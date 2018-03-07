package com.facebook.friendsharing.souvenirs.util;

import com.facebook.friendsharing.souvenirs.models.SouvenirBurstItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.google.common.collect.UnmodifiableIterator;

/* compiled from: RECOMMENDATIONS */
public class SouvenirDisplayItemIterator extends UnmodifiableIterator<SouvenirUriItem> {
    private final UnmodifiableIterator<SouvenirItem> f24210a;

    public SouvenirDisplayItemIterator(UnmodifiableIterator<SouvenirItem> unmodifiableIterator) {
        this.f24210a = unmodifiableIterator;
    }

    public boolean hasNext() {
        return this.f24210a.hasNext();
    }

    public Object next() {
        SouvenirItem souvenirItem = (SouvenirItem) this.f24210a.next();
        if (!(souvenirItem instanceof SouvenirBurstItem)) {
            return (SouvenirUriItem) souvenirItem;
        }
        SouvenirBurstItem souvenirBurstItem = (SouvenirBurstItem) souvenirItem;
        return (SouvenirUriItem) souvenirBurstItem.m26157b().get(souvenirBurstItem.m26158c());
    }
}
