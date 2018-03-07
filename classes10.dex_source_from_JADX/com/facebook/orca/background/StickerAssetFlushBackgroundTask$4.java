package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;

/* compiled from: p2p_group_send_recipient_picked */
class StickerAssetFlushBackgroundTask$4 implements FutureCallback<List<OperationResult>> {
    final /* synthetic */ int f5268a;
    final /* synthetic */ SettableFuture f5269b;
    final /* synthetic */ StickerAssetFlushBackgroundTask f5270c;

    StickerAssetFlushBackgroundTask$4(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, int i, SettableFuture settableFuture) {
        this.f5270c = stickerAssetFlushBackgroundTask;
        this.f5268a = i;
        this.f5269b = settableFuture;
    }

    public void onSuccess(Object obj) {
        if (this.f5268a != -1) {
            StickerAssetFlushBackgroundTask.a(this.f5270c, this.f5268a);
        }
        StickerAssetFlushBackgroundTask.m(this.f5270c);
        FutureDetour.a(this.f5269b, new BackgroundResult(true), 803420412);
        this.f5270c.j.b();
    }

    public void onFailure(Throwable th) {
        this.f5270c.j.b(th.getMessage());
        this.f5269b.a(th);
    }
}
