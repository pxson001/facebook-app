package com.facebook.messaging.media.download;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsPhotosAutoDownloadAvailable;

@InjectorModule
/* compiled from: mExpiryTimeStamp */
public class MediaDownloadModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsPhotosAutoDownloadAvailable
    public static Boolean m12182a() {
        return Boolean.valueOf(false);
    }
}
