package com.facebook.friendsharing.souvenirs.models;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: RKStorage */
public class SouvenirModel$Builder {
    private final Builder<SouvenirItem> f24069a = new Builder();
    @Nullable
    public SouvenirMetadata f24070b;

    public final SouvenirModel$Builder m26178a(SouvenirMetadata souvenirMetadata) {
        this.f24070b = souvenirMetadata;
        return this;
    }

    public final SouvenirModel$Builder m26177a(SouvenirItem souvenirItem) {
        this.f24069a.c(souvenirItem);
        return this;
    }

    public final SouvenirModel m26179a() {
        boolean z;
        ImmutableList b = this.f24069a.b();
        if (b.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        return new SouvenirModel((SouvenirMetadata) Preconditions.checkNotNull(this.f24070b), b);
    }
}
