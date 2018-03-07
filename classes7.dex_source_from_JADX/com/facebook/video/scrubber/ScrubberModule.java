package com.facebook.video.scrubber;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: dispatchNonBatchedUIOperations */
public class ScrubberModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @TargetApi(10)
    public static MediaMetadataRetriever m19674a() {
        return new MediaMetadataRetriever();
    }
}
