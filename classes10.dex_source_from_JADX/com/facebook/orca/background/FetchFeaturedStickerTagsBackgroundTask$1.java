package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: page_sections */
public class FetchFeaturedStickerTagsBackgroundTask$1 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ SettableFuture f5231a;
    final /* synthetic */ FetchFeaturedStickerTagsBackgroundTask f5232b;

    public FetchFeaturedStickerTagsBackgroundTask$1(FetchFeaturedStickerTagsBackgroundTask fetchFeaturedStickerTagsBackgroundTask, Class cls, SettableFuture settableFuture) {
        this.f5232b = fetchFeaturedStickerTagsBackgroundTask;
        this.f5231a = settableFuture;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4679a((OperationResult) obj);
    }

    public final void m4679a(OperationResult operationResult) {
        this.f5232b.e.edit().a(this.f5232b.a, this.f5232b.f.a()).commit();
        FutureDetour.a(this.f5231a, new BackgroundResult(true), 1277057587);
    }

    public void onFailure(Throwable th) {
        this.f5231a.a(th);
    }
}
