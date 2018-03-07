package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksAndStickersParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: p2p_group_send_recipient_picked */
class StickerAssetFlushBackgroundTask$2 implements AsyncFunction<OperationResult, OperationResult> {
    final /* synthetic */ StickerAssetFlushBackgroundTask f5263a;

    StickerAssetFlushBackgroundTask$2(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask) {
        this.f5263a = stickerAssetFlushBackgroundTask;
    }

    public final ListenableFuture m4691a(Object obj) {
        FetchStickerPacksAndStickersParams fetchStickerPacksAndStickersParams = new FetchStickerPacksAndStickersParams(StickerPackType.STORE_PACKS, DataFreshnessParam.DO_NOT_CHECK_SERVER);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksAndStickersParams", fetchStickerPacksAndStickersParams);
        return BlueServiceOperationFactoryDetour.a(this.f5263a.g, "fetch_sticker_packs_and_stickers", bundle, ErrorPropagation.BY_EXCEPTION, StickerAssetFlushBackgroundTask.b, -2026433510).a();
    }
}
