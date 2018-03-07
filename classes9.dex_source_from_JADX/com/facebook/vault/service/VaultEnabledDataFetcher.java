package com.facebook.vault.service;

import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.facebook.vault.datafetcher.VaultDataFetcher;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: thread key/idRefQuery must be specified */
public class VaultEnabledDataFetcher implements VaultDataFetcher {
    private final VaultTable f1883a;
    private VaultHelpers f1884b;

    @Inject
    public VaultEnabledDataFetcher(VaultTable vaultTable, VaultHelpers vaultHelpers) {
        this.f1883a = vaultTable;
        this.f1884b = vaultHelpers;
    }

    public final boolean mo59a() {
        return this.f1884b.b();
    }

    public final void mo58a(ImmutableList<PhotoItem> immutableList) {
        Map b = this.f1883a.b(0);
        if (b != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) immutableList.get(i);
                if ((mediaItem instanceof PhotoItem) && mediaItem.h() != null && mediaItem.j() > 0) {
                    String a = PhotoHashUtil.a(mediaItem.h(), mediaItem.j());
                    if (b.containsKey(a)) {
                        long longValue = ((Long) b.get(a)).longValue();
                        if (longValue > 0) {
                            mediaItem.e = longValue;
                        }
                    }
                }
            }
        }
    }
}
