package com.facebook.stickers.keyboard;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.service.FetchRecentStickersResult;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collection;
import java.util.List;

/* compiled from: edited_story_id */
class StickerKeyboardMetadataLoader$1 implements FutureCallback<List<OperationResult>> {
    final /* synthetic */ List f16636a;
    final /* synthetic */ StickerKeyboardMetadataLoader$Params f16637b;
    final /* synthetic */ SettableFuture f16638c;
    final /* synthetic */ StickerKeyboardMetadataLoader f16639d;

    StickerKeyboardMetadataLoader$1(StickerKeyboardMetadataLoader stickerKeyboardMetadataLoader, List list, StickerKeyboardMetadataLoader$Params stickerKeyboardMetadataLoader$Params, SettableFuture settableFuture) {
        this.f16639d = stickerKeyboardMetadataLoader;
        this.f16636a = list;
        this.f16637b = stickerKeyboardMetadataLoader$Params;
        this.f16638c = settableFuture;
    }

    public void onSuccess(Object obj) {
        List list = (List) obj;
        this.f16639d.f = null;
        if (!this.f16639d.b) {
            FetchRecentStickersResult fetchRecentStickersResult = (FetchRecentStickersResult) ((OperationResult) list.get(0)).h();
            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) ((OperationResult) list.get(1)).h();
            if (fetchStickerPacksResult.b.isPresent()) {
                this.f16636a.addAll((Collection) fetchStickerPacksResult.b.get());
            }
            fetchStickerPacksResult = (FetchStickerPacksResult) ((OperationResult) list.get(2)).h();
            StickerKeyboardMetadataLoader stickerKeyboardMetadataLoader = this.f16639d;
            List list2 = (List) fetchStickerPacksResult.b.get();
            ImmutableList copyOf = ImmutableList.copyOf(StickerKeyboardMetadataLoader.a(this.f16637b, this.f16636a));
            StickerKeyboardMetadataLoader stickerKeyboardMetadataLoader2 = this.f16639d;
            StickerKeyboardMetadataLoader$Results stickerKeyboardMetadataLoader$Results = new StickerKeyboardMetadataLoader$Results(copyOf, StickerKeyboardMetadataLoader.a(this.f16636a, list2), ImmutableList.copyOf(fetchRecentStickersResult.f16881a));
            this.f16639d.d.b(this.f16637b, stickerKeyboardMetadataLoader$Results);
            FutureDetour.a(this.f16638c, stickerKeyboardMetadataLoader$Results, 497023836);
        }
    }

    public void onFailure(Throwable th) {
        this.f16639d.f = null;
        this.f16638c.a(th);
        if (!this.f16639d.b) {
            this.f16639d.d.c(this.f16637b, th);
        }
    }
}
