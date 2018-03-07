package com.facebook.fbreactcomponents.stickers;

import android.view.View;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.stickers.keyboard.StickerKeyboardView.StickerKeyboardListener;
import com.facebook.stickers.model.Sticker;
import java.util.Map;

/* compiled from: edit_uri */
public class StickerViewInputManager extends SimpleViewManager<StickerKeyboardWrapper> {
    protected final void m8681a(ThemedReactContext themedReactContext, View view) {
        final StickerKeyboardWrapper stickerKeyboardWrapper = (StickerKeyboardWrapper) view;
        final EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a;
        stickerKeyboardWrapper.f7487a.f = new StickerKeyboardListener(this) {
            final /* synthetic */ StickerViewInputManager f7492c;

            public final void m8675a(Sticker sticker) {
                eventDispatcher.a(new StickerSelectedEvent(stickerKeyboardWrapper.getId(), SystemClock.b(), sticker.a));
            }

            public final void m8676a(String str) {
            }

            public final void m8674a() {
            }

            public final void m8677b() {
            }

            public final void m8678c() {
            }
        };
    }

    public final String m8680a() {
        return "RCTStickerInputView";
    }

    protected final View m8679a(ThemedReactContext themedReactContext) {
        return new StickerKeyboardWrapper(themedReactContext);
    }

    public final Map m8682h() {
        return MapBuilder.a("topStickerSelect", MapBuilder.a("registrationName", "onStickerSelect"));
    }
}
