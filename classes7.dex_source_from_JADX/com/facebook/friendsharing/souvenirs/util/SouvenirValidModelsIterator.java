package com.facebook.friendsharing.souvenirs.util;

import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* compiled from: REACTION_CARD */
public class SouvenirValidModelsIterator extends UnmodifiableIterator<SouvenirModel> {
    private UnmodifiableIterator<SouvenirModel> f24220a;
    @Nullable
    private SouvenirModel f24221b = m26460a();

    public SouvenirValidModelsIterator(UnmodifiableIterator<SouvenirModel> unmodifiableIterator) {
        this.f24220a = unmodifiableIterator;
    }

    @Nullable
    private SouvenirModel m26460a() {
        while (this.f24220a.hasNext()) {
            SouvenirModel souvenirModel = (SouvenirModel) this.f24220a.next();
            if (SouvenirModelHelper.m26458d(souvenirModel)) {
                return souvenirModel;
            }
        }
        return null;
    }

    public boolean hasNext() {
        return this.f24221b != null;
    }

    public Object next() {
        SouvenirModel souvenirModel = this.f24221b;
        if (souvenirModel == null) {
            throw new NoSuchElementException();
        }
        this.f24221b = m26460a();
        return souvenirModel;
    }
}
