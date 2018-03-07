package com.facebook.orca.background;

import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.debug.log.BLog;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.Params;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.Results;

/* compiled from: page_link_menu_management */
class FetchStickerKeyboardMetadataBackgroundTask$1 extends AbstractFbLoaderCallback<Params, Results, Throwable> {
    final /* synthetic */ FetchStickerKeyboardMetadataBackgroundTask f5238a;

    public final void m4682b(Object obj, Object obj2) {
        Class cls = FetchStickerKeyboardMetadataBackgroundTask.a;
    }

    FetchStickerKeyboardMetadataBackgroundTask$1(FetchStickerKeyboardMetadataBackgroundTask fetchStickerKeyboardMetadataBackgroundTask) {
        this.f5238a = fetchStickerKeyboardMetadataBackgroundTask;
    }

    public final void m4683c(Object obj, Object obj2) {
        BLog.a(FetchStickerKeyboardMetadataBackgroundTask.a, "Failed loading sticker keyboard metadata with error.", (Throwable) obj2);
    }
}
