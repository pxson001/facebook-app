package com.facebook.stickers.client;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ui.images.webp.AnimatedImageDecoder;

/* compiled from: endOffset */
public class Boolean_IsAnimatedStickersEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return StickerClientModule.a(IdBasedProvider.a(this, 4335), AnimatedImageDecoder.a(this));
    }
}
