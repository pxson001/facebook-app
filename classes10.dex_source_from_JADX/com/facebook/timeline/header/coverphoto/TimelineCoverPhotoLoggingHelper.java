package com.facebook.timeline.header.coverphoto;

import com.facebook.inject.InjectorLike;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: finish_registration_notif_clicked */
public class TimelineCoverPhotoLoggingHelper {
    private TimelinePerformanceLogger f11664a;
    private ProfileControllerDelegate f11665b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: finish_registration_notif_clicked */
    public @interface Resolution {
    }

    public static TimelineCoverPhotoLoggingHelper m11729b(InjectorLike injectorLike) {
        return new TimelineCoverPhotoLoggingHelper(TimelinePerformanceLogger.a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineCoverPhotoLoggingHelper(TimelinePerformanceLogger timelinePerformanceLogger, ProfileControllerDelegate profileControllerDelegate) {
        this.f11664a = timelinePerformanceLogger;
        this.f11665b = profileControllerDelegate;
    }

    public final void m11733a() {
        m11727a(0);
    }

    public final void m11734b() {
        m11727a(1);
    }

    public final void m11735c() {
        m11728a(PhotoLoadState.PHOTO_NONE);
    }

    public static TimelineCoverPhotoLoggingHelper m11726a(InjectorLike injectorLike) {
        return m11729b(injectorLike);
    }

    public final void m11736d() {
        m11730b(0);
    }

    public final void m11737e() {
        m11732d(0);
    }

    public final void m11738f() {
        m11730b(1);
    }

    public final void m11739g() {
        m11732d(1);
    }

    private void m11727a(int i) {
        TimelinePerformanceLogger timelinePerformanceLogger = this.f11664a;
        PhotoLoadState c = m11731c(i);
        if ((c == PhotoLoadState.PHOTO_LOW_RES || c == PhotoLoadState.PHOTO_MINI_PREVIEW) && timelinePerformanceLogger.f.e == PhotoLoadState.PHOTO_NOT_LOADED) {
            timelinePerformanceLogger.c.a("TimelineLoadCoverPhotoLowRes");
        } else if (timelinePerformanceLogger.f.e != PhotoLoadState.PHOTO_HIGH_RES) {
            timelinePerformanceLogger.c.a("TimelineLoadCoverPhoto");
        }
    }

    private void m11730b(int i) {
        m11728a(m11731c(i));
    }

    private static PhotoLoadState m11731c(int i) {
        switch (i) {
            case 0:
                return PhotoLoadState.PHOTO_MINI_PREVIEW;
            case 1:
                return PhotoLoadState.PHOTO_HIGH_RES;
            default:
                throw new IllegalArgumentException("Unexpected resolution: " + i);
        }
    }

    private void m11728a(PhotoLoadState photoLoadState) {
        this.f11665b.mo484u().mo525a(photoLoadState);
    }

    private void m11732d(int i) {
        m11728a(i == 1 ? PhotoLoadState.PHOTO_HIGH_RES_FAILED : PhotoLoadState.PHOTO_MINI_PREVIEW_FAILED);
    }
}
