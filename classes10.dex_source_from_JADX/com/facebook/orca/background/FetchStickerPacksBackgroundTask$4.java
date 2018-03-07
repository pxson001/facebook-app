package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPackIdsResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: page_like_promotion */
public class FetchStickerPacksBackgroundTask$4 implements FutureCallback<OperationResult> {
    final /* synthetic */ SettableFuture f5245a;
    final /* synthetic */ FetchStickerPacksBackgroundTask f5246b;

    public FetchStickerPacksBackgroundTask$4(FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask, SettableFuture settableFuture) {
        this.f5246b = fetchStickerPacksBackgroundTask;
        this.f5245a = settableFuture;
    }

    public void onSuccess(Object obj) {
        this.f5246b.e.edit().a(StickerPrefKeys.h, ((FetchStickerPackIdsResult) ((OperationResult) obj).h()).a.size()).a(FetchStickerPacksBackgroundTask.a, this.f5246b.f.a()).commit();
        FutureDetour.a(this.f5245a, new BackgroundResult(true), 1224359787);
    }

    public void onFailure(Throwable th) {
        this.f5245a.a(th);
    }
}
