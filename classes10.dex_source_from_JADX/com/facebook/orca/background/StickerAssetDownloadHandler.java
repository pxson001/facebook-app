package com.facebook.orca.background;

import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadHandler;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.model.StickerAssetType;
import com.google.common.collect.ImmutableList;
import java.io.File;
import javax.inject.Inject;

/* compiled from: pageLoading */
public class StickerAssetDownloadHandler implements AssetDownloadHandler {
    private final StickerAssetDownloadManagerHelper f5255a;

    @Inject
    public StickerAssetDownloadHandler(StickerAssetDownloadManagerHelper stickerAssetDownloadManagerHelper) {
        this.f5255a = stickerAssetDownloadManagerHelper;
    }

    public final void m4688a(AssetDownloadConfiguration assetDownloadConfiguration, File file) {
        StickerAssetDownloadManagerHelper$StickerAssetInformation stickerAssetDownloadManagerHelper$StickerAssetInformation;
        StickerAssetDownloadManagerHelper stickerAssetDownloadManagerHelper = this.f5255a;
        String[] split = assetDownloadConfiguration.mIdentifier.split("_");
        if (split.length != 4) {
            stickerAssetDownloadManagerHelper$StickerAssetInformation = null;
        } else {
            stickerAssetDownloadManagerHelper$StickerAssetInformation = new StickerAssetDownloadManagerHelper$StickerAssetInformation(StickerAssetType.fromDbString(split[1]), split[2], split[3]);
        }
        StickerAssetDownloadManagerHelper$StickerAssetInformation stickerAssetDownloadManagerHelper$StickerAssetInformation2 = stickerAssetDownloadManagerHelper$StickerAssetInformation;
        if (stickerAssetDownloadManagerHelper$StickerAssetInformation2 != null) {
            StickerDbStorageImpl stickerDbStorageImpl = (StickerDbStorageImpl) stickerAssetDownloadManagerHelper.d.get();
            stickerDbStorageImpl.a(stickerAssetDownloadManagerHelper$StickerAssetInformation2.f5257b, stickerAssetDownloadManagerHelper$StickerAssetInformation2.f5256a, file);
            ((StickerCache) stickerAssetDownloadManagerHelper.e.get()).b(stickerDbStorageImpl.a(ImmutableList.of(stickerAssetDownloadManagerHelper$StickerAssetInformation2.f5257b)));
        }
    }

    public final boolean m4689a(AssetDownloadConfiguration assetDownloadConfiguration) {
        String str = assetDownloadConfiguration.mNamespace;
        boolean z = str != null && str.equals("sticker");
        return z;
    }
}
