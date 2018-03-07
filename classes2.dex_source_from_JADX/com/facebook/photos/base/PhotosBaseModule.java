package com.facebook.photos.base;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.base.analytics.efficiency.DefaultImageFetchTracker;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencySampler;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencyTracker;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencyTrackerProvider;
import com.facebook.photos.base.analytics.efficiency.UriRecordManagerProvider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: on_resume */
public class PhotosBaseModule extends AbstractLibraryModule {

    /* compiled from: on_resume */
    final class C04661 implements ImageFetchEfficiencySampler {
        C04661() {
        }

        public final boolean mo2113a(ImageRequest imageRequest, CallerContext callerContext) {
            return imageRequest.hashCode() % 200 == 0;
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @DefaultImageFetchTracker
    static ImageFetchEfficiencyTracker m16409a(ImageFetchEfficiencyTrackerProvider imageFetchEfficiencyTrackerProvider, UriRecordManagerProvider uriRecordManagerProvider) {
        return imageFetchEfficiencyTrackerProvider.m16407a(new C04661(), uriRecordManagerProvider.m16408a(""));
    }
}
