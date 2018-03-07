package com.facebook.ui.images.cache;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.google.common.annotations.VisibleForTesting;

@InjectorModule
/* compiled from: section */
public class ImageCacheModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @VisibleForTesting
    public static ImageCache getInstanceForTest_ImageCache(FbInjector fbInjector) {
        return ImageCache.a(fbInjector);
    }
}
