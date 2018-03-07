package com.facebook.orca.stickers.ui;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.stickers.ui.StickerAnimator;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: nearby_friends_now_nux_privacy_changed */
public class StickersAnimationManager {
    public final Map<String, StickerAnimator> f6389a = Maps.c();
    public final Provider<Boolean> f6390b;

    public static StickersAnimationManager m6089a(InjectorLike injectorLike) {
        return new StickersAnimationManager(IdBasedProvider.a(injectorLike, 4091));
    }

    @Inject
    public StickersAnimationManager(Provider<Boolean> provider) {
        this.f6390b = provider;
    }

    public static String m6090d(Message message) {
        return message.n != null ? message.n : message.a;
    }

    public final synchronized void m6091a() {
        for (String str : this.f6389a.keySet()) {
            ((StickerAnimator) this.f6389a.get(str)).c();
        }
        this.f6389a.clear();
    }
}
