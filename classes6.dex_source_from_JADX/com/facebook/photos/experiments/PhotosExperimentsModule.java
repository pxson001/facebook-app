package com.facebook.photos.experiments;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.annotation.MaxNumberPhotosPerUpload;

@InjectorModule
/* compiled from: subscribed_item */
public class PhotosExperimentsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MaxNumberPhotosPerUpload
    public static Integer m5502a() {
        return Integer.valueOf(30);
    }
}
