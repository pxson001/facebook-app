package com.facebook.timeline.header;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.caspian.ui.standardheader.StandardProfileImageView;
import com.facebook.caspian.ui.standardheader.StandardProfileImageViewBinder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.ImageResolutionQuality;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.tempprofilepic.TemporaryAffordanceViewController;
import com.facebook.widget.LazyView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fragment being reset. setupGroupLeaveActionResponder should be called only once */
public class TimelineProfileImageFrameController {
    private static final Class<?> f11551a = TimelineProfileImageFrameController.class;
    private static final CallerContext f11552b = CallerContext.a(StandardProfileImageView.class, "timeline", "profile_pic");
    public final TemporaryAffordanceViewController f11553c;
    private final StandardProfileImageViewBinder f11554d;
    private final ProfileControllerDelegate f11555e;
    public final TimelinePerformanceLogger f11556f;
    private final QeAccessor f11557g;
    public boolean f11558h = false;
    public TimelineHeaderUserData f11559i;
    @Nullable
    private ImageRequest f11560j;
    @Nullable
    private ImageRequest f11561k;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: fragment being reset. setupGroupLeaveActionResponder should be called only once */
    public @interface EditIconConfig {
    }

    /* compiled from: fragment being reset. setupGroupLeaveActionResponder should be called only once */
    class ProfileImageControllerListener extends BaseControllerListener {
        final /* synthetic */ TimelineProfileImageFrameController f11548a;
        private final boolean f11549b;
        private final View f11550c;

        public final void m11577a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            int i = 0;
            int f = closeableImage != null ? closeableImage.f() : 0;
            if (closeableImage != null) {
                i = closeableImage.g();
            }
            ImageResolutionQuality imageResolutionQuality = (this.f11550c.getWidth() > f || this.f11550c.getHeight() > i) ? ImageResolutionQuality.SCALED_UP : ImageResolutionQuality.FULL;
            this.f11548a.f11559i.i = imageResolutionQuality;
            TimelineProfileImageFrameController.m11583b(this.f11548a, this.f11549b);
        }

        public ProfileImageControllerListener(TimelineProfileImageFrameController timelineProfileImageFrameController, boolean z, View view) {
            this.f11548a = timelineProfileImageFrameController;
            this.f11549b = z;
            this.f11550c = view;
        }

        public final void m11576a(String str, Object obj) {
            TimelineProfileImageFrameController timelineProfileImageFrameController = this.f11548a;
            boolean z = this.f11549b;
            TimelinePerformanceLogger timelinePerformanceLogger = timelineProfileImageFrameController.f11556f;
            if (z && timelinePerformanceLogger.f.d == PhotoLoadState.PHOTO_NOT_LOADED) {
                timelinePerformanceLogger.c.a("TimelineLoadProfilePicPreview");
            } else if (timelinePerformanceLogger.f.d != PhotoLoadState.PHOTO_HIGH_RES) {
                timelinePerformanceLogger.c.a("TimelineLoadProfilePic");
            }
        }

        public final void m11578b(String str, Throwable th) {
            TimelineProfileImageFrameController.m11584c(this.f11548a, this.f11549b);
        }
    }

    @Inject
    public TimelineProfileImageFrameController(@Assisted TemporaryAffordanceViewController temporaryAffordanceViewController, StandardProfileImageViewBinder standardProfileImageViewBinder, ProfileControllerDelegate profileControllerDelegate, TimelinePerformanceLogger timelinePerformanceLogger, QeAccessor qeAccessor) {
        this.f11553c = temporaryAffordanceViewController;
        this.f11554d = standardProfileImageViewBinder;
        this.f11556f = timelinePerformanceLogger;
        this.f11555e = profileControllerDelegate;
        this.f11557g = qeAccessor;
    }

    public final void m11585a(TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext, boolean z, boolean z2, boolean z3, @Nullable OnClickListener onClickListener, StandardProfileImageView standardProfileImageView, LazyView<? extends View> lazyView, boolean z4) {
        final boolean z5;
        final boolean z6;
        final boolean z7;
        boolean z8;
        this.f11559i = timelineHeaderUserData;
        if (this.f11553c.a(timelineContext, this.f11559i, z2, z3)) {
            switch (this.f11553c.b()) {
                case 0:
                    final TimelineContext timelineContext2 = timelineContext;
                    z5 = z;
                    z6 = z2;
                    z7 = z3;
                    final OnClickListener onClickListener2 = onClickListener;
                    final StandardProfileImageView standardProfileImageView2 = standardProfileImageView;
                    final LazyView<? extends View> lazyView2 = lazyView;
                    this.f11553c.a(new Object(this) {
                        public final /* synthetic */ TimelineProfileImageFrameController f11547h;
                    });
                    this.f11553c.a(this.f11559i);
                    break;
                case 1:
                case 2:
                    break;
                case 3:
                    this.f11553c.a();
                    break;
                default:
                    BLog.b(f11551a, "unexpected animation state: %s", new Object[]{Integer.valueOf(this.f11553c.b())});
                    break;
            }
        }
        this.f11553c.a();
        if (!(z && z4)) {
            standardProfileImageView.setVisibility(0);
        }
        if (this.f11559i.m()) {
            this.f11561k = m11582b();
        } else {
            this.f11560j = ImageRequest.a(this.f11559i.L());
        }
        if (m11579a(timelineContext, timelineHeaderUserData, z2, z3) == 0) {
            lazyView.c();
        } else {
            lazyView.a().setVisibility(0);
            ImageView imageView = (ImageView) lazyView.a().findViewById(2131566343);
            imageView.setImageResource(2130842771);
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.setEnterFadeDuration(200);
            animationDrawable.setExitFadeDuration(200);
            animationDrawable.start();
        }
        StandardProfileImageViewBinder standardProfileImageViewBinder = this.f11554d;
        ImageRequest imageRequest = this.f11560j;
        ImageRequest imageRequest2 = this.f11561k;
        z5 = this.f11559i.v();
        z6 = m11581a(this.f11559i);
        z7 = timelineContext.b();
        CallerContext callerContext = f11552b;
        if (this.f11559i.m()) {
            z8 = false;
        } else {
            z8 = true;
        }
        standardProfileImageViewBinder.a(imageRequest, imageRequest2, z5, z6, z7, false, callerContext, onClickListener, new ProfileImageControllerListener(this, z8, standardProfileImageView), standardProfileImageView);
    }

    @Nullable
    private ImageRequest m11582b() {
        String L = this.f11559i.L();
        if (L == null) {
            return null;
        }
        Priority priority;
        if (this.f11560j == null || !this.f11557g.a(ExperimentsForTimelineAbTestModule.V, false)) {
            priority = Priority.HIGH;
        } else {
            priority = Priority.LOW;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(L));
        a.i = priority;
        return a.m();
    }

    private int m11579a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, boolean z, boolean z2) {
        if (z2 || !timelineContext.i() || this.f11559i.v()) {
            return 0;
        }
        if (!this.f11553c.a(timelineContext, timelineHeaderUserData, z, z2)) {
            return 1;
        }
        int i;
        if (this.f11553c.g == 2 || this.f11553c.g == 3) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    private static boolean m11581a(TimelineHeaderUserData timelineHeaderUserData) {
        return (timelineHeaderUserData.L() == null || timelineHeaderUserData.v()) ? false : true;
    }

    public static void m11583b(TimelineProfileImageFrameController timelineProfileImageFrameController, boolean z) {
        timelineProfileImageFrameController.m11580a(z ? PhotoLoadState.PHOTO_LOW_RES : PhotoLoadState.PHOTO_HIGH_RES);
    }

    public static void m11584c(TimelineProfileImageFrameController timelineProfileImageFrameController, boolean z) {
        timelineProfileImageFrameController.m11580a(z ? PhotoLoadState.PHOTO_LOW_RES_FAILED : PhotoLoadState.PHOTO_HIGH_RES_FAILED);
    }

    private void m11580a(PhotoLoadState photoLoadState) {
        this.f11555e.mo484u().mo527b(photoLoadState);
    }
}
