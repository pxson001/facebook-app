package com.facebook.composer.stickerpost;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_text_tab */
public class ComposerStickerPostLogger {
    private final AnalyticsLogger f16957a;
    @Nullable
    public String f16958b;

    /* compiled from: composer_text_tab */
    enum Event {
        STICKER_PICKER_OPENED("sticker_picker_opened"),
        STICKER_PICKER_SELECTED_STICKER("sticker_picker_selected_sticker"),
        STICKER_PICKER_TAPPED_BACK_BUTTON("sticker_picker_tapped_back_button");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: composer_text_tab */
    enum Extras {
        IS_FROM_COMPOSER("is_from_composer"),
        STICKER_ID("sticker_id"),
        PACK_ID("pack_id");
        
        private final String name;

        private Extras(String str) {
            this.name = str;
        }

        public final String getParamKey() {
            return this.name;
        }
    }

    @Inject
    public ComposerStickerPostLogger(AnalyticsLogger analyticsLogger) {
        this.f16957a = analyticsLogger;
    }

    public final void m20921a(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.STICKER_PICKER_OPENED.toString());
        honeyClientEvent.c = "composer";
        m20919a(honeyClientEvent.a(Extras.IS_FROM_COMPOSER.getParamKey(), z));
    }

    public final void m20920a(ComposerStickerData composerStickerData) {
        Preconditions.checkNotNull(composerStickerData);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.STICKER_PICKER_SELECTED_STICKER.toString());
        honeyClientEvent.c = "composer";
        m20919a(honeyClientEvent.b(Extras.STICKER_ID.getParamKey(), composerStickerData.stickerId).b(Extras.PACK_ID.getParamKey(), composerStickerData.packId));
    }

    public final void m20922b(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.STICKER_PICKER_TAPPED_BACK_BUTTON.toString());
        honeyClientEvent.c = "composer";
        m20919a(honeyClientEvent.a(Extras.IS_FROM_COMPOSER.getParamKey(), z));
    }

    private void m20919a(HoneyClientEvent honeyClientEvent) {
        if (!Strings.isNullOrEmpty(this.f16958b)) {
            honeyClientEvent.f = this.f16958b;
        }
        this.f16957a.a(honeyClientEvent);
    }
}
