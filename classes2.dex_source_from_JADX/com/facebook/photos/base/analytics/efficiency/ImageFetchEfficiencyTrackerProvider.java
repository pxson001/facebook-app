package com.facebook.photos.base.analytics.efficiency;

import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: one */
public class ImageFetchEfficiencyTrackerProvider extends AbstractAssistedProvider<ImageFetchEfficiencyTracker> {
    public final ImageFetchEfficiencyTracker m16407a(ImageFetchEfficiencySampler imageFetchEfficiencySampler, UriRecordManager uriRecordManager) {
        return new ImageFetchEfficiencyTracker(imageFetchEfficiencySampler, uriRecordManager, SystemClockMethodAutoProvider.m1498a(this));
    }
}
