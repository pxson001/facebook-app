package com.facebook.orca.background;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.service.FetchStickerPacksAndStickersResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;

/* compiled from: p2p_group_send_recipient_picked */
class StickerAssetFlushBackgroundTask$3 implements AsyncFunction<OperationResult, BackgroundResult> {
    final /* synthetic */ List f5264a;
    final /* synthetic */ List f5265b;
    final /* synthetic */ int f5266c;
    final /* synthetic */ StickerAssetFlushBackgroundTask f5267d;

    StickerAssetFlushBackgroundTask$3(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, List list, List list2, int i) {
        this.f5267d = stickerAssetFlushBackgroundTask;
        this.f5264a = list;
        this.f5265b = list2;
        this.f5266c = i;
    }

    private ListenableFuture<BackgroundResult> m4692a(OperationResult operationResult) {
        FetchStickerPacksAndStickersResult fetchStickerPacksAndStickersResult = (FetchStickerPacksAndStickersResult) operationResult.h();
        Set a = Sets.a();
        if (this.f5264a != null) {
            for (String add : this.f5264a) {
                a.add(add);
            }
        }
        Set a2 = Sets.a();
        for (String add2 : this.f5265b) {
            a2.add(add2);
        }
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        ImmutableList immutableList = fetchStickerPacksAndStickersResult.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            StickerPack stickerPack = (StickerPack) immutableList.get(i);
            ImmutableList immutableList2 = (ImmutableList) fetchStickerPacksAndStickersResult.c.get(stickerPack.a());
            int size2 = immutableList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Sticker sticker = (Sticker) immutableList2.get(i2);
                if (this.f5264a == null || a.contains(sticker.a)) {
                    builder.c(sticker.a);
                } else if (a2.contains(stickerPack.a())) {
                    builder2.c(sticker.a);
                }
            }
        }
        ImmutableList b = builder.b();
        this.f5267d.j.a(b);
        ImmutableList b2 = builder2.b();
        this.f5267d.j.b(b2);
        b = new Builder().b(b).b(b2).b();
        if (!b.isEmpty()) {
            return StickerAssetFlushBackgroundTask.a(this.f5267d, b, this.f5266c);
        }
        if (this.f5266c != -1) {
            StickerAssetFlushBackgroundTask.a(this.f5267d, this.f5266c);
        }
        StickerAssetFlushBackgroundTask.m(this.f5267d);
        this.f5267d.j.b();
        return Futures.a(new BackgroundResult(true));
    }
}
