package com.facebook.timeline.header.coverphoto;

import android.graphics.drawable.Animatable;
import com.facebook.caspian.ui.standardheader.StandardCoverPhotoView;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.ImageResolutionQuality;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: finish_registration_notif_scheduled */
public class TimelineCoverPhotoControllerListener extends BaseControllerListener {
    public final StandardCoverPhotoView f11661a;
    private final TimelineCoverPhotoLoggingHelper f11662b;
    public final TimelineHeaderUserData f11663c;

    public final void m11721a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        CloseableImage closeableImage = (CloseableImage) obj;
        if (this.f11661a.c()) {
            int i = 0;
            if (this.f11663c != null) {
                int f = closeableImage != null ? closeableImage.f() : 0;
                if (closeableImage != null) {
                    i = closeableImage.g();
                }
                ImageResolutionQuality imageResolutionQuality = (this.f11661a.getWidth() > f || this.f11661a.getHeight() > i) ? ImageResolutionQuality.SCALED_UP : ImageResolutionQuality.FULL;
                this.f11663c.j = imageResolutionQuality;
            }
            this.f11662b.m11738f();
        }
    }

    @Inject
    public TimelineCoverPhotoControllerListener(@Assisted StandardCoverPhotoView standardCoverPhotoView, @Assisted TimelineCoverPhotoLoggingHelper timelineCoverPhotoLoggingHelper, @Assisted TimelineHeaderUserData timelineHeaderUserData) {
        this.f11661a = standardCoverPhotoView;
        this.f11662b = timelineCoverPhotoLoggingHelper;
        this.f11663c = timelineHeaderUserData;
    }

    public final void m11720a(String str, Object obj) {
        if (this.f11661a.c()) {
            this.f11662b.m11734b();
        }
    }

    public final void m11722a(String str, Throwable th) {
    }

    public final void m11724b(String str, Throwable th) {
        if (this.f11661a.c()) {
            this.f11662b.m11739g();
        }
    }
}
