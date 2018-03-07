package com.facebook.stickers.service;

import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import javax.inject.Inject;

/* compiled from: reaction_icon_scale */
public class RecentStickersHandler {
    public final StickerCache f3781a;
    public final StickerDbStorageImpl f3782b;

    @Inject
    public RecentStickersHandler(StickerCache stickerCache, StickerDbStorageImpl stickerDbStorageImpl) {
        this.f3781a = stickerCache;
        this.f3782b = stickerDbStorageImpl;
    }
}
