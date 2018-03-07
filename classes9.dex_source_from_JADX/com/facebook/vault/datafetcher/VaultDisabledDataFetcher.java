package com.facebook.vault.datafetcher;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.collect.ImmutableList;

/* compiled from: timeline_composer */
public class VaultDisabledDataFetcher implements VaultDataFetcher {
    public static VaultDisabledDataFetcher m1727a(InjectorLike injectorLike) {
        return new VaultDisabledDataFetcher();
    }

    public final boolean mo59a() {
        return false;
    }

    public final void mo58a(ImmutableList<PhotoItem> immutableList) {
    }
}
