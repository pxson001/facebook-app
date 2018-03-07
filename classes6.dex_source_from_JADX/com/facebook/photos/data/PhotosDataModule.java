package com.facebook.photos.data;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.data.cache.PhotoSetCacheMaxAge;
import com.facebook.photos.data.cache.PhotoSetCacheSize;
import com.facebook.photos.data.service.PhotosServiceHandler;
import com.facebook.photos.data.service.PhotosServiceMemoryCacheFilter;
import com.facebook.photos.data.service.PhotosServiceQueue;

@InjectorModule
/* compiled from: image_overlay_url */
public class PhotosDataModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PhotoSetCacheSize
    public static Integer m20261a() {
        return Integer.valueOf(20);
    }

    @ProviderMethod
    @PhotoSetCacheMaxAge
    public static Long m20262b() {
        return Long.valueOf(3600000);
    }

    @ProviderMethod
    @ContextScoped
    @PhotosServiceQueue
    static BlueServiceHandler m20260a(PhotosServiceMemoryCacheFilter photosServiceMemoryCacheFilter, PhotosServiceHandler photosServiceHandler) {
        return new FilterChainLink(photosServiceMemoryCacheFilter, photosServiceHandler);
    }
}
