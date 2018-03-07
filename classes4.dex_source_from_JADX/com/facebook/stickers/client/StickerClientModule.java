package com.facebook.stickers.client;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ui.images.webp.AnimatedImageDecoder;
import javax.inject.Provider;

@InjectorModule
/* compiled from: display_name */
public class StickerClientModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAnimatedStickersEnabled
    public static Boolean m14482a(Provider<Boolean> provider, AnimatedImageDecoder animatedImageDecoder) {
        boolean z = ((Boolean) provider.get()).booleanValue() && animatedImageDecoder.a();
        return Boolean.valueOf(z);
    }
}
