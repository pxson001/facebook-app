package com.facebook.stickers.client;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerAssetType;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: encoder */
public class StickerAssetManager {
    public static final Class<?> f16440a = StickerAssetManager.class;
    private final Provider<Boolean> f16441b;
    private final StickerAssetDownloadUtil f16442c;

    /* compiled from: encoder */
    class C11511 extends OperationResultFutureCallback {
        final /* synthetic */ StickerAssetManager f16439a;

        C11511(StickerAssetManager stickerAssetManager) {
            this.f16439a = stickerAssetManager;
        }

        protected final void m23921a(ServiceException serviceException) {
            BLog.b(StickerAssetManager.f16440a, "on the fly sticker asset download failed.", serviceException);
        }
    }

    public static StickerAssetManager m23925b(InjectorLike injectorLike) {
        return new StickerAssetManager(IdBasedProvider.a(injectorLike, 4336), StickerAssetDownloadUtil.m23919b(injectorLike));
    }

    @Inject
    StickerAssetManager(Provider<Boolean> provider, StickerAssetDownloadUtil stickerAssetDownloadUtil) {
        this.f16441b = provider;
        this.f16442c = stickerAssetDownloadUtil;
    }

    public final void m23926a(Sticker sticker, CallerContext callerContext) {
        if (((Boolean) this.f16441b.get()).booleanValue() && sticker.f4942e != null && sticker.f4943f == null) {
            m23924a(sticker.f4938a, StickerAssetType.ANIMATED, sticker.f4942e, callerContext);
        } else if (sticker.f4943f == null && sticker.f4941d == null) {
            m23924a(sticker.f4938a, StickerAssetType.STATIC, sticker.f4940c, callerContext);
        }
    }

    public static StickerAssetManager m23923a(InjectorLike injectorLike) {
        return m23925b(injectorLike);
    }

    private void m23924a(String str, StickerAssetType stickerAssetType, Uri uri, CallerContext callerContext) {
        ListenableFuture a = this.f16442c.m23920a(str, stickerAssetType, uri, callerContext);
        if (a != null) {
            Futures.a(a, new C11511(this), MoreExecutors.a());
        }
    }
}
