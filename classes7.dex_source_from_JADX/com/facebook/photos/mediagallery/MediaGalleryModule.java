package com.facebook.photos.mediagallery;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.google.common.collect.ImmutableList;

@InjectorModule
/* compiled from: isom */
public class MediaGalleryModule extends AbstractLibraryModule {

    /* compiled from: isom */
    public class DefaultMediaGalleryMenuOptions {
        public final ImmutableList<Integer> m12751a() {
            return ImmutableList.of(Integer.valueOf(2001), Integer.valueOf(2007), Integer.valueOf(2005), Integer.valueOf(2002), Integer.valueOf(2003), Integer.valueOf(2006), Integer.valueOf(2004), Integer.valueOf(2008), Integer.valueOf(2000), Integer.valueOf(2010));
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static DefaultMediaGalleryMenuOptions m12752a() {
        return new DefaultMediaGalleryMenuOptions();
    }
}
