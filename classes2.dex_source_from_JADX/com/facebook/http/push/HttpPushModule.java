package com.facebook.http.push;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencySampler;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencyTracker;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencyTrackerProvider;
import com.facebook.photos.base.analytics.efficiency.UriRecordManagerProvider;
import com.google.common.base.Preconditions;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: onReportServiceBinding must be called on the GoogleApiClient handler thread */
public class HttpPushModule extends AbstractLibraryModule {

    /* compiled from: onReportServiceBinding must be called on the GoogleApiClient handler thread */
    final class C04681 implements ImageFetchEfficiencySampler {
        C04681() {
        }

        public final boolean mo2113a(ImageRequest imageRequest, CallerContext callerContext) {
            if (callerContext != null && imageRequest.hashCode() % 10 == 0) {
                Preconditions.checkNotNull(callerContext);
                if (ImagePushSubscriber.class.getName().equals(callerContext.f5181b)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @PushedImageFetchEfficiencyTracker
    @ProviderMethod
    @Singleton
    static ImageFetchEfficiencyTracker m16435a(ImageFetchEfficiencyTrackerProvider imageFetchEfficiencyTrackerProvider, UriRecordManagerProvider uriRecordManagerProvider) {
        return imageFetchEfficiencyTrackerProvider.m16407a(new C04681(), uriRecordManagerProvider.m16408a("push"));
    }
}
