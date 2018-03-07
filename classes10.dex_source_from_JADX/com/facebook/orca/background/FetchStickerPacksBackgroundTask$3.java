package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPackIdsParams;
import com.facebook.stickers.service.FetchStickerPackIdsParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: page_like_promotion */
public class FetchStickerPacksBackgroundTask$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ SettableFuture f5243a;
    final /* synthetic */ FetchStickerPacksBackgroundTask f5244b;

    public FetchStickerPacksBackgroundTask$3(FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask, SettableFuture settableFuture) {
        this.f5244b = fetchStickerPacksBackgroundTask;
        this.f5243a = settableFuture;
    }

    public void onSuccess(Object obj) {
        FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask = this.f5244b;
        SettableFuture settableFuture = this.f5243a;
        long a = fetchStickerPacksBackgroundTask.e.a(StickerPrefKeys.g, 0);
        FetchStickerPackIdsParamsBuilder newBuilder = FetchStickerPackIdsParams.newBuilder();
        newBuilder.a = StickerPackType.STORE_PACKS;
        newBuilder = newBuilder;
        newBuilder.b = a;
        FetchStickerPackIdsParams d = newBuilder.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPackIdsParams", d);
        Futures.a(BlueServiceOperationFactoryDetour.a(fetchStickerPacksBackgroundTask.d, "fetch_sticker_pack_ids", bundle, ErrorPropagation.BY_EXCEPTION, FetchStickerPacksBackgroundTask.c, -78360772).a(), new FetchStickerPacksBackgroundTask$4(fetchStickerPacksBackgroundTask, settableFuture), fetchStickerPacksBackgroundTask.g);
    }

    public void onFailure(Throwable th) {
        this.f5243a.a(th);
    }
}
