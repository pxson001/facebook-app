package com.facebook.messaging.composer.triggers;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.Emojis;
import javax.inject.Inject;

/* compiled from: messenger_customthreads_promo_check */
public class TriggerTextIteratorFactory {
    private final EmojiCharUtil f9926a;

    private static TriggerTextIteratorFactory m10475b(InjectorLike injectorLike) {
        return new TriggerTextIteratorFactory(new EmojiCharUtil(Emojis.a(injectorLike)));
    }

    @Inject
    public TriggerTextIteratorFactory(EmojiCharUtil emojiCharUtil) {
        this.f9926a = emojiCharUtil;
    }
}
