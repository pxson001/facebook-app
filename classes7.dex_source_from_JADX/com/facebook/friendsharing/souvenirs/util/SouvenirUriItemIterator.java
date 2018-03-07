package com.facebook.friendsharing.souvenirs.util;

import com.facebook.friendsharing.souvenirs.models.SouvenirBurstItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirPhotoItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: REACTORS */
public class SouvenirUriItemIterator extends UnmodifiableIterator<SouvenirUriItem> {
    private final UnmodifiableIterator<SouvenirItem> f24217a;
    @Nullable
    private UnmodifiableIterator<SouvenirPhotoItem> f24218b;
    @Nullable
    private SouvenirUriItem f24219c = m26459a();

    public SouvenirUriItemIterator(UnmodifiableIterator<SouvenirItem> unmodifiableIterator) {
        this.f24217a = unmodifiableIterator;
    }

    @Nullable
    private SouvenirUriItem m26459a() {
        if (this.f24218b != null) {
            SouvenirUriItem souvenirUriItem = (SouvenirUriItem) this.f24218b.next();
            if (this.f24218b.hasNext()) {
                return souvenirUriItem;
            }
            this.f24218b = null;
            return souvenirUriItem;
        } else if (!this.f24217a.hasNext()) {
            return null;
        } else {
            SouvenirItem souvenirItem = (SouvenirItem) this.f24217a.next();
            if (!(souvenirItem instanceof SouvenirBurstItem)) {
                return (SouvenirUriItem) souvenirItem;
            }
            this.f24218b = ((SouvenirBurstItem) souvenirItem).m26157b().iterator();
            SouvenirPhotoItem souvenirPhotoItem = (SouvenirPhotoItem) this.f24218b.next();
            Preconditions.checkState(this.f24218b.hasNext());
            return souvenirPhotoItem;
        }
    }

    public boolean hasNext() {
        return this.f24219c != null;
    }

    public Object next() {
        SouvenirUriItem souvenirUriItem = this.f24219c;
        if (souvenirUriItem == null) {
            throw new NoSuchElementException();
        }
        this.f24219c = m26459a();
        return souvenirUriItem;
    }
}
