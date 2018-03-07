package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksParams.TrayPacksUpdateOperation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: page_like_promotion */
public class FetchStickerPacksBackgroundTask$1 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ SettableFuture f5239a;
    final /* synthetic */ FetchStickerPacksBackgroundTask f5240b;

    public FetchStickerPacksBackgroundTask$1(FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask, Class cls, SettableFuture settableFuture) {
        this.f5240b = fetchStickerPacksBackgroundTask;
        this.f5239a = settableFuture;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4684a((OperationResult) obj);
    }

    public final void m4684a(OperationResult operationResult) {
        TrayPacksUpdateOperation trayPacksUpdateOperation;
        super.a(operationResult);
        FetchStickerPacksBackgroundTask fetchStickerPacksBackgroundTask = this.f5240b;
        SettableFuture settableFuture = this.f5239a;
        long a = fetchStickerPacksBackgroundTask.e.a(FetchStickerPacksBackgroundTask.a, 0);
        boolean booleanValue = ((Boolean) fetchStickerPacksBackgroundTask.i.get()).booleanValue();
        Builder builder = new Builder(StickerPackType.OWNED_PACKS, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        builder.c = InterfaceInputInterface.MESSAGES;
        builder = builder;
        builder.g = booleanValue;
        builder = builder;
        if (a == 0 || !booleanValue) {
            trayPacksUpdateOperation = TrayPacksUpdateOperation.REPLACE_FROM_NETWORK;
        } else {
            trayPacksUpdateOperation = TrayPacksUpdateOperation.APPEND_TO_DB;
        }
        builder.h = trayPacksUpdateOperation;
        FetchStickerPacksParams a2 = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a2);
        Futures.a(BlueServiceOperationFactoryDetour.a(fetchStickerPacksBackgroundTask.d, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, FetchStickerPacksBackgroundTask.c, -558694224).a(), new FetchStickerPacksBackgroundTask$2(fetchStickerPacksBackgroundTask, FetchStickerPacksBackgroundTask.b, settableFuture), fetchStickerPacksBackgroundTask.g);
    }

    public void onFailure(Throwable th) {
        this.f5239a.a(th);
    }
}
