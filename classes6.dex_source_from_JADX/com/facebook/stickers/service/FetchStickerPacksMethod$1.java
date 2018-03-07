package com.facebook.stickers.service;

import com.facebook.stickers.model.StickerPackType;

/* compiled from: ec787a50f403c70c83755e1ef68ceaad */
/* synthetic */ class FetchStickerPacksMethod$1 {
    static final /* synthetic */ int[] f16899a = new int[StickerPackType.values().length];

    static {
        try {
            f16899a[StickerPackType.DOWNLOADED_PACKS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f16899a[StickerPackType.OWNED_PACKS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f16899a[StickerPackType.STORE_PACKS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f16899a[StickerPackType.AUTODOWNLOADED_PACKS.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
