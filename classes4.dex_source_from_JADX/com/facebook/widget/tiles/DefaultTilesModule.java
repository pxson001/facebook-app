package com.facebook.widget.tiles;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.widget.tiles.annotations.IsProfilePictureDiskCacheEnabled;

@InjectorModule
/* compiled from: owned_packs */
public class DefaultTilesModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsProfilePictureDiskCacheEnabled
    public static Boolean m6234a() {
        return Boolean.valueOf(false);
    }
}
