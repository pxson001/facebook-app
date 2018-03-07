package com.facebook.stickers.keyboard;

import com.facebook.stickers.model.StickerPack;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: edited_ */
public class StickerKeyboardPackPopupTabItem extends StickerKeyboardTabItem {
    public final StickerPack f16646a;
    final TabType f16647b;

    /* compiled from: edited_ */
    public enum TabType {
        DOWNLOADED,
        DOWNLOAD_PREVIEW,
        PULSING_DOWNLOAD_PREVIEW,
        PROMOTED
    }

    public StickerKeyboardPackPopupTabItem(StickerPack stickerPack, TabType tabType) {
        super(stickerPack.f4955a);
        this.f16646a = stickerPack;
        this.f16647b = tabType;
    }
}
