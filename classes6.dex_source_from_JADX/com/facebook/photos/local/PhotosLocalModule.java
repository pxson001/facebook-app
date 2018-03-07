package com.facebook.photos.local;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Provider;

@InjectorModule
/* compiled from: has_viewer_archived */
public class PhotosLocalModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    static LocalMediaCursor m20433a(Provider<LocalMediaCursorImp> provider) {
        return (LocalMediaCursorImp) provider.get();
    }
}
