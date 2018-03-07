package com.facebook.photos.creativeediting.stickers;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.stickers.abtest.IsAnimatedStickersInGridEnabled;

@InjectorModule
/* compiled from: mServerUtcSecs */
public class StickerOnPhotosModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsAnimatedStickersInGridEnabled
    public static Boolean m11539a() {
        return Boolean.valueOf(false);
    }
}
