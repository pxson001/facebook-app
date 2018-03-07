package com.facebook.stickers.service;

import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.model.StickerPack;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: quick_experiment_ids */
public class DownloadPreviewStickerPacksHandler {
    public final StickerPacksHandler f3909a;
    public final StickerCache f3910b;
    public final StickerDbStorageImpl f3911c;
    public final DownloadPreviewStickerPacksHelper f3912d;

    @Inject
    public DownloadPreviewStickerPacksHandler(StickerPacksHandler stickerPacksHandler, StickerCache stickerCache, StickerDbStorageImpl stickerDbStorageImpl, DownloadPreviewStickerPacksHelper downloadPreviewStickerPacksHelper) {
        this.f3909a = stickerPacksHandler;
        this.f3910b = stickerCache;
        this.f3911c = stickerDbStorageImpl;
        this.f3912d = downloadPreviewStickerPacksHelper;
    }

    public final OperationResult m4381a(OperationParams operationParams) {
        StickerPack stickerPack = (StickerPack) operationParams.c.getParcelable("stickerPack");
        this.f3911c.m4260b(stickerPack);
        if (this.f3910b.m12980d()) {
            ImmutableList c = this.f3910b.m12978c();
            List a = Lists.a(Math.max(0, c.size() - 1));
            int size = c.size();
            for (int i = 0; i < size; i++) {
                StickerPack stickerPack2 = (StickerPack) c.get(i);
                if (!stickerPack2.a.equals(stickerPack.a)) {
                    a.add(stickerPack2);
                }
            }
            this.f3910b.m12975b(a);
        }
        return OperationResult.a;
    }
}
