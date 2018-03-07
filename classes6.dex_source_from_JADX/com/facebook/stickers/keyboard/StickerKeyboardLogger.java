package com.facebook.stickers.keyboard;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.analytics.StickerLogger;
import javax.inject.Inject;

/* compiled from: edited_uri */
public class StickerKeyboardLogger {
    public final StickerLogger f16635a;

    public static StickerKeyboardLogger m24477b(InjectorLike injectorLike) {
        return new StickerKeyboardLogger(StickerLogger.m23898a(injectorLike));
    }

    @Inject
    public StickerKeyboardLogger(StickerLogger stickerLogger) {
        this.f16635a = stickerLogger;
    }

    public static StickerKeyboardLogger m24476a(InjectorLike injectorLike) {
        return m24477b(injectorLike);
    }

    final void m24478a(String str, boolean z) {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_keyboard");
        a.b("action", "sticker_tab_selected");
        a.a("is_promoted", z);
        a.b("sticker_pack", str);
        this.f16635a.m23900a(a);
    }
}
