package com.facebook.stickers.client;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.stickers.service.SaveStickerAssetParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: encoderOutputBuffer  */
public class StickerAssetDownloadUtil {
    private Provider<Boolean> f16437a;
    private DefaultBlueServiceOperationFactory f16438b;

    public static StickerAssetDownloadUtil m23919b(InjectorLike injectorLike) {
        return new StickerAssetDownloadUtil(IdBasedProvider.a(injectorLike, 4342), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public StickerAssetDownloadUtil(Provider<Boolean> provider, BlueServiceOperationFactory blueServiceOperationFactory) {
        this.f16437a = provider;
        this.f16438b = blueServiceOperationFactory;
    }

    @Nullable
    public final ListenableFuture<OperationResult> m23920a(String str, StickerAssetType stickerAssetType, Uri uri, CallerContext callerContext) {
        if (!((Boolean) this.f16437a.get()).booleanValue()) {
            return null;
        }
        stickerAssetType.getDbName();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SaveStickerAssetParams", new SaveStickerAssetParams(str, stickerAssetType.getDbName(), uri));
        return BlueServiceOperationFactoryDetour.a(this.f16438b, "download_sticker_asset", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -162355727).a();
    }
}
