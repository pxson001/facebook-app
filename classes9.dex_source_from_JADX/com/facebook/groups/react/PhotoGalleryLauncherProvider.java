package com.facebook.groups.react;

import android.app.Activity;
import com.facebook.groups.treehouse.perf.TreehousePerfLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.react.bridge.ReactContext;

/* compiled from: payment_last_four */
public class PhotoGalleryLauncherProvider extends AbstractAssistedProvider<PhotoGalleryLauncher> {
    public final PhotoGalleryLauncher m7325a(ReactContext reactContext, Activity activity) {
        return new PhotoGalleryLauncher(reactContext, activity, IdBasedLazy.a(this, 9351), MediaGalleryLauncherParamsFactory.a(this), TreehousePerfLogger.m7326a(this), (GroupsReactDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(GroupsReactDataFetcherProvider.class));
    }
}
