package com.facebook.stickers.service;

import com.facebook.stickers.model.StickerPackType;

/* compiled from: editPhotoCaptionParams */
/* synthetic */ class FetchStickerPackIdsMethod$1 {
    static final /* synthetic */ int[] f16882a = new int[StickerPackType.values().length];

    static {
        try {
            f16882a[StickerPackType.DOWNLOADED_PACKS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f16882a[StickerPackType.OWNED_PACKS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f16882a[StickerPackType.STORE_PACKS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f16882a[StickerPackType.AUTODOWNLOADED_PACKS.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
