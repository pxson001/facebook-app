package com.facebook.stickers.service;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.stickers.data.StickerAssetDownloader;
import com.facebook.stickers.data.StickerAssetsDownloadUtil;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorage;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.stickers.model.StickerBuilder;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackBuilder;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.inject.Provider;

/* compiled from: e5c6f7f9aad2b7ccbd3a770d7fcf2279 */
public class StickerAssetsHandler {
    private static final Class<?> f16911a = StickerAssetsHandler.class;
    private static final CallerContext f16912b = CallerContext.a(StickerAssetsHandler.class, "sticker_store");
    private final StickerCache f16913c;
    private final StickerDbStorageImpl f16914d;
    private final StickerAssetDownloader f16915e;
    private final FbNetworkManager f16916f;
    private final StickerAssetsDownloadUtil f16917g;
    private final Provider<Boolean> f16918h;
    private final GatekeeperStoreImpl f16919i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StickersHandler> f16920j = UltralightRuntime.b;

    final OperationResult m24619a(OperationParams operationParams) {
        StickerPack stickerPack = (StickerPack) operationParams.c.getParcelable("stickerPack");
        CallerContext callerContext = operationParams.e;
        FetchStickersResult a = ((StickersHandler) this.f16920j.get()).a(new FetchStickersParams(stickerPack.f4974t, StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED));
        BlueServiceProgressCallback blueServiceProgressCallback = operationParams.f;
        if (blueServiceProgressCallback != null) {
            blueServiceProgressCallback.a(OperationResult.a("0"));
        }
        if (((Boolean) this.f16918h.get()).booleanValue()) {
            return OperationResult.a(m24615a(operationParams, stickerPack, a, blueServiceProgressCallback, callerContext));
        }
        BLog.a(f16911a, "cannot save assets to disk");
        return OperationResult.a(ErrorCode.CACHE_DISK_ERROR);
    }

    @Inject
    public StickerAssetsHandler(StickerCache stickerCache, StickerDbStorage stickerDbStorage, StickerAssetDownloader stickerAssetDownloader, FbNetworkManager fbNetworkManager, StickerAssetsDownloadUtil stickerAssetsDownloadUtil, GatekeeperStore gatekeeperStore, Provider<Boolean> provider) {
        this.f16913c = stickerCache;
        this.f16914d = stickerDbStorage;
        this.f16915e = stickerAssetDownloader;
        this.f16916f = fbNetworkManager;
        this.f16917g = stickerAssetsDownloadUtil;
        this.f16918h = provider;
        this.f16919i = gatekeeperStore;
    }

    private FetchStickersResult m24615a(OperationParams operationParams, StickerPack stickerPack, FetchStickersResult fetchStickersResult, BlueServiceProgressCallback blueServiceProgressCallback, CallerContext callerContext) {
        FetchStickersResult a = m24616a(operationParams, fetchStickersResult, blueServiceProgressCallback, callerContext);
        this.f16913c.b(a.a);
        StickerPackBuilder stickerPackBuilder = new StickerPackBuilder();
        stickerPackBuilder.f4977a = stickerPack.f4955a;
        stickerPackBuilder.f4978b = stickerPack.f4956b;
        stickerPackBuilder.f4979c = stickerPack.f4957c;
        stickerPackBuilder.f4980d = stickerPack.f4958d;
        stickerPackBuilder.f4981e = stickerPack.f4959e;
        stickerPackBuilder.f4982f = stickerPack.f4960f;
        stickerPackBuilder.f4983g = stickerPack.f4961g;
        stickerPackBuilder.f4984h = stickerPack.f4962h;
        stickerPackBuilder.f4985i = stickerPack.f4963i;
        stickerPackBuilder.f4986j = stickerPack.m7732j();
        stickerPackBuilder.f4987k = stickerPack.f4965k;
        stickerPackBuilder.f4988l = stickerPack.f4966l;
        stickerPackBuilder.f4989m = stickerPack.f4967m;
        stickerPackBuilder.f4990n = stickerPack.f4968n;
        stickerPackBuilder.f4991o = stickerPack.f4969o;
        stickerPackBuilder.f4992p = stickerPack.f4970p;
        stickerPackBuilder.f4993q = stickerPack.f4971q;
        stickerPackBuilder.f4994r = stickerPack.f4972r;
        stickerPackBuilder.f4995s = stickerPack.f4973s;
        stickerPackBuilder.f4996t = stickerPack.f4974t;
        stickerPackBuilder.f4997u = stickerPack.f4975u;
        stickerPackBuilder.f4998v = stickerPack.f4976v;
        stickerPackBuilder = stickerPackBuilder;
        stickerPackBuilder.f4987k = true;
        stickerPackBuilder = stickerPackBuilder;
        if (this.f16919i.a(452, false)) {
            Uri a2 = m24614a(stickerPack, callerContext);
            String str = stickerPack.f4955a;
            Uri uri = stickerPack.f4959e;
            uri = stickerPack.f4960f;
            stickerPackBuilder.f4982f = a2;
        }
        StickerPack w = stickerPackBuilder.m7756w();
        this.f16914d.a(w);
        this.f16913c.a(w);
        return a;
    }

    private FetchStickersResult m24616a(OperationParams operationParams, FetchStickersResult fetchStickersResult, BlueServiceProgressCallback blueServiceProgressCallback, CallerContext callerContext) {
        operationParams.c.getParcelable("stickerPack");
        ImmutableList a = fetchStickersResult.a();
        double a2 = (double) m24613a(a);
        Builder builder = ImmutableList.builder();
        StickerBuilder newBuilder = StickerBuilder.newBuilder();
        for (int i = 0; i < a.size(); i++) {
            Sticker sticker = (Sticker) a.get(i);
            newBuilder.m7715a(sticker);
            if (this.f16919i.a(451, false) || !this.f16916f.v()) {
                m24617a(sticker, newBuilder, callerContext);
            } else {
                m24618b(sticker, newBuilder, callerContext);
            }
            builder.c(newBuilder.m7713a());
            newBuilder.m7719b();
            if (blueServiceProgressCallback != null) {
                blueServiceProgressCallback.a(OperationResult.a(String.valueOf(((double) (i + 1)) / a2)));
            }
        }
        return new FetchStickersResult(builder.b());
    }

    private Uri m24614a(StickerPack stickerPack, CallerContext callerContext) {
        return Uri.fromFile(this.f16915e.a(stickerPack.f4955a, "thumbnail", StickerAssetType.PREVIEW, stickerPack.f4959e, callerContext));
    }

    private void m24617a(Sticker sticker, StickerBuilder stickerBuilder, CallerContext callerContext) {
        File a;
        if (sticker.f4944g != null && sticker.f4945h == null && sticker.f4941d == null) {
            a = this.f16915e.a(sticker.f4939b, sticker.f4938a, StickerAssetType.PREVIEW, sticker.f4944g, callerContext);
            this.f16914d.a(sticker.f4938a, StickerAssetType.PREVIEW, a);
            stickerBuilder.f4953h = Uri.fromFile(a);
        } else if (sticker.f4944g == null && sticker.f4941d == null) {
            a = this.f16915e.a(sticker.f4939b, sticker.f4938a, StickerAssetType.STATIC, sticker.f4940c, callerContext);
            this.f16914d.a(sticker.f4938a, StickerAssetType.STATIC, a);
            stickerBuilder.f4949d = Uri.fromFile(a);
        }
    }

    private void m24618b(Sticker sticker, StickerBuilder stickerBuilder, CallerContext callerContext) {
        if (sticker.f4941d == null) {
            File a = this.f16915e.a(sticker.f4939b, sticker.f4938a, StickerAssetType.STATIC, sticker.f4940c, callerContext);
            this.f16914d.a(sticker.f4938a, StickerAssetType.STATIC, a);
            stickerBuilder.f4949d = Uri.fromFile(a);
        }
    }

    private int m24613a(ImmutableList<Sticker> immutableList) {
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            Sticker sticker = (Sticker) immutableList.get(i);
            if (!StickerAssetsDownloadUtil.b(sticker) || StickerAssetsDownloadUtil.a(sticker) == TriState.NO) {
                i3 = i2;
            } else {
                i3 = i2 + 1;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }
}
