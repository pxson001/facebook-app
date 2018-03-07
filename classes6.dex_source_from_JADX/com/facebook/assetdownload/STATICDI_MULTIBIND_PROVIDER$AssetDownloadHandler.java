package com.facebook.assetdownload;

import com.facebook.facedetection.FaceDetectionAssetDownloader;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.orca.background.StickerAssetDownloadHandler;
import com.facebook.orca.background.StickerAssetDownloadManagerHelper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$AssetDownloadHandler implements MultiBindIndexedProvider<AssetDownloadHandler>, Provider<Set<AssetDownloadHandler>> {
    private final InjectorLike f7265a;

    private STATICDI_MULTIBIND_PROVIDER$AssetDownloadHandler(InjectorLike injectorLike) {
        this.f7265a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7265a.getScopeAwareInjector(), this);
    }

    public static Set<AssetDownloadHandler> m10384a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$AssetDownloadHandler(injectorLike));
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FaceDetectionAssetDownloader.m15537b(injector);
            case 1:
                return new StickerAssetDownloadHandler(StickerAssetDownloadManagerHelper.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
