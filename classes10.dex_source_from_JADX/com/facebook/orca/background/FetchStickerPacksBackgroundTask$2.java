package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: page_like_promotion */
public class FetchStickerPacksBackgroundTask$2 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ SettableFuture f5241a;
    final /* synthetic */ FetchStickerPacksBackgroundTask f5242b;

    public FetchStickerPacksBackgroundTask$2(FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask, Class cls, SettableFuture settableFuture) {
        this.f5242b = fetchStickerPacksBackgroundTask;
        this.f5241a = settableFuture;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4685a((OperationResult) obj);
    }

    public final void m4685a(OperationResult operationResult) {
        super.a(operationResult);
        FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask = this.f5242b;
        SettableFuture settableFuture = this.f5241a;
        if (operationResult != null) {
            Builder builder = new Builder();
            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) operationResult.h();
            fetchStickerPacksBackgroundTask.e.edit().putBoolean(StickerPrefKeys.i, ((ImmutableList) fetchStickerPacksResult.b.get()).size() > 2).commit();
            ImmutableList immutableList = (ImmutableList) fetchStickerPacksResult.b.get();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                StickerPack stickerPack = (StickerPack) immutableList.get(i);
                if (stickerPack.r) {
                    builder.b(stickerPack.t);
                }
            }
            FetchStickersParams fetchStickersParams = new FetchStickersParams(builder.b(), StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED);
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickersParams", fetchStickersParams);
            Futures.a(BlueServiceOperationFactoryDetour.a(fetchStickerPacksBackgroundTask.d, "fetch_stickers", bundle, ErrorPropagation.BY_EXCEPTION, FetchStickerPacksBackgroundTask.c, -735443108).a(), new FetchStickerPacksBackgroundTask$3(fetchStickerPacksBackgroundTask, settableFuture), fetchStickerPacksBackgroundTask.g);
        }
    }

    public void onFailure(Throwable th) {
        this.f5241a.a(th);
    }
}
