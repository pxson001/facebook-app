package com.facebook.timeline.header.controllers;

import com.facebook.inject.Assisted;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.google.common.base.Supplier;
import javax.inject.Inject;

/* compiled from: flowerBorderActive */
public class TimelineCoverPhotoControllerImpl implements TimelineCoverPhotoController {
    private final Supplier<TimelineEditPhotoHelper> f11634a;

    @Inject
    public TimelineCoverPhotoControllerImpl(@Assisted Supplier<TimelineEditPhotoHelper> supplier) {
        this.f11634a = supplier;
    }

    public final void mo544a() {
        ((TimelineEditPhotoHelper) this.f11634a.get()).a(false, false);
    }

    public final void mo545b() {
        ((TimelineEditPhotoHelper) this.f11634a.get()).a();
    }
}
