package com.facebook.photos.photogallery;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.annotation.IsPhotoExpandAnimationEnabled;

@InjectorModule
/* compiled from: isLoading */
public class PhotoGalleryModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPhotoExpandAnimationEnabled
    static Boolean m12884a() {
        return Boolean.TRUE;
    }
}
