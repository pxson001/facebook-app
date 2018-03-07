package com.facebook.ffmpeg;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mIdentifier */
public class FFMpegModule extends AbstractLibraryModule {
    @ProviderMethod
    @Singleton
    static FFMpegLib m8973a() {
        return new FFMpegLib();
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }
}
