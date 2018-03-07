package com.facebook.analytics2.logger;

/* compiled from: tap_composer_profile_photo_from_feed */
public class SimpleUploadSchedulerParamsProvider implements UploadSchedulerParamsProvider {
    private final UploadSchedulerParams f3260a;
    private final UploadSchedulerParams f3261b;

    public SimpleUploadSchedulerParamsProvider(UploadSchedulerParams uploadSchedulerParams, UploadSchedulerParams uploadSchedulerParams2) {
        this.f3260a = uploadSchedulerParams;
        this.f3261b = uploadSchedulerParams2;
    }

    public final UploadSchedulerParams mo738a() {
        return this.f3260a;
    }

    public final UploadSchedulerParams mo739b() {
        return this.f3261b;
    }
}
