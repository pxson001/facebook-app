package com.facebook.stickers.data;

import com.facebook.stickers.model.StickerPackType;

/* compiled from: emojilikeString */
public class StickersDbProperties {
    public static final StickersDbPropertyKey f16491a = new StickersDbPropertyKey("server_sync/");
    public static final StickersDbPropertyKey f16492b = new StickersDbPropertyKey("last_update_time_ms");

    public static StickersDbPropertyKey m23959a(StickerPackType stickerPackType) {
        return (StickersDbPropertyKey) ((StickersDbPropertyKey) f16491a.a(stickerPackType.name().concat("/"))).a(f16492b.a());
    }
}
