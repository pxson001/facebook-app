package com.facebook.stickers.service;

import com.facebook.stickers.service.FetchTaggedStickersParams.FilterType;

/* compiled from: eb04c61de96ecfc74ef6c3fbcb876241 */
/* synthetic */ class FetchStickersHelper$1 {
    static final /* synthetic */ int[] f16903a = new int[FilterType.values().length];

    static {
        try {
            f16903a[FilterType.AVAILABLE_STICKERS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f16903a[FilterType.TRAY_STICKERS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
