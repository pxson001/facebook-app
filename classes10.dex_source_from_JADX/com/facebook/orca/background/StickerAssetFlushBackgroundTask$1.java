package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.service.FetchStickerPackIdsResult;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: p2p_group_send_recipient_picked */
class StickerAssetFlushBackgroundTask$1 implements AsyncFunction<OperationResult, BackgroundResult> {
    final /* synthetic */ List f5259a;
    final /* synthetic */ boolean f5260b;
    final /* synthetic */ int f5261c;
    final /* synthetic */ StickerAssetFlushBackgroundTask f5262d;

    StickerAssetFlushBackgroundTask$1(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, List list, boolean z, int i) {
        this.f5262d = stickerAssetFlushBackgroundTask;
        this.f5259a = list;
        this.f5260b = z;
        this.f5261c = i;
    }

    public final ListenableFuture m4690a(Object obj) {
        return StickerAssetFlushBackgroundTask.a(this.f5262d, this.f5259a, ((FetchStickerPackIdsResult) ((OperationResult) obj).h()).a, this.f5260b ? this.f5261c : -1);
    }
}
