package com.facebook.vault.service;

import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.vault.protocol.VaultGetSyncedImageStatus;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: first_full_upload_success_timestamp */
public class VaultRowStatusUpdater {
    private static final String f11582a = VaultRowStatusUpdater.class.getSimpleName();
    public final VaultLocalImageFetcher f11583b;
    private final BitmapUtils f11584c;
    public final AbstractFbErrorReporter f11585d;

    @Inject
    public VaultRowStatusUpdater(VaultLocalImageFetcher vaultLocalImageFetcher, BitmapUtils bitmapUtils, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11583b = vaultLocalImageFetcher;
        this.f11584c = bitmapUtils;
        this.f11585d = (AbstractFbErrorReporter) Preconditions.checkNotNull(abstractFbErrorReporter);
    }

    public static List<VaultImageProviderRow> m12073a(List<VaultImageProviderRow> list, Map<String, VaultGetSyncedImageStatus> map) {
        List<VaultImageProviderRow> a = Lists.a();
        for (int i = 0; i < list.size(); i++) {
            VaultImageProviderRow vaultImageProviderRow = (VaultImageProviderRow) list.get(i);
            VaultGetSyncedImageStatus vaultGetSyncedImageStatus = (VaultGetSyncedImageStatus) map.get(vaultImageProviderRow.a);
            if (vaultGetSyncedImageStatus != null && vaultGetSyncedImageStatus.mDeleted) {
                list.remove(i);
                a.add(vaultImageProviderRow);
            }
        }
        return a;
    }
}
