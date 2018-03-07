package com.facebook.photos.creativecam.ui;

import android.support.annotation.Nullable;
import android.view.ViewGroup.LayoutParams;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.Assisted;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.creativecam.controller.CreativeCamSwipeableFramesLogController;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.10;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.Listener;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesCirclePageIndicatorController;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilder;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: start_photo_id_in_gallery */
public class CreativeCamSwipeableController {
    public final C02641 f2220a = new C02641(this);
    public final CreativeEditingSwipeableControllerProvider f2221b;
    public final Provider<SwipeableDraweeControllerGeneratorImpl> f2222c;
    public final SwipeableFramesCirclePageIndicatorController f2223d;
    public final CreativeEditingSwipeableLayout f2224e;
    public final CreativeEditingLogger f2225f;
    public final CreativeCamSource f2226g;
    @Nullable
    public final ProfilePictureOverlaySwipeableFramesLogController f2227h;
    private final SwipeableParamsListBuilderProvider f2228i;
    @Nullable
    public ImmutableList<Frame> f2229j;
    @Nullable
    public String f2230k;
    @Nullable
    public CreativeEditingSwipeableController f2231l;
    @Nullable
    public SwipeableDraweeControllerGeneratorImpl f2232m;
    @Nullable
    public ImmutableList<SwipeableParams> f2233n;
    public 10 f2234o;
    public int f2235p;
    public int f2236q;
    public boolean f2237r;
    public final EventListener f2238s = new C02663(this);

    /* compiled from: start_photo_id_in_gallery */
    public class C02641 {
        public final /* synthetic */ CreativeCamSwipeableController f2217a;

        C02641(CreativeCamSwipeableController creativeCamSwipeableController) {
            this.f2217a = creativeCamSwipeableController;
        }
    }

    /* compiled from: start_photo_id_in_gallery */
    public class C02652 implements Listener {
        final /* synthetic */ CreativeCamSwipeableController f2218a;

        public C02652(CreativeCamSwipeableController creativeCamSwipeableController) {
            this.f2218a = creativeCamSwipeableController;
        }

        public final void m2381a(FrameModel frameModel) {
            this.f2218a.f2229j = ImmutableList.builder().b(this.f2218a.f2229j).c(frameModel).b();
            this.f2218a.f2233n = CreativeCamSwipeableController.m2389d(this.f2218a);
            CreativeCamSwipeableController creativeCamSwipeableController = this.f2218a;
            creativeCamSwipeableController.f2223d.a(creativeCamSwipeableController.f2237r, creativeCamSwipeableController.f2233n, creativeCamSwipeableController.f2230k);
            if (this.f2218a.f2227h != null) {
                this.f2218a.f2227h.a();
            }
        }
    }

    /* compiled from: start_photo_id_in_gallery */
    class C02663 implements EventListener {
        final /* synthetic */ CreativeCamSwipeableController f2219a;

        public final void m2384a(String str, SwipeableParams swipeableParams, int i) {
            if (swipeableParams.c == SwipeableItemType.FRAME) {
                this.f2219a.f2225f.a(this.f2219a.f2226g, swipeableParams.b);
                if (this.f2219a.f2227h != null) {
                    ProfilePictureOverlaySwipeableFramesLogController profilePictureOverlaySwipeableFramesLogController = this.f2219a.f2227h;
                    if (i == 0) {
                        profilePictureOverlaySwipeableFramesLogController.c++;
                    } else {
                        profilePictureOverlaySwipeableFramesLogController.d++;
                    }
                    if (!(profilePictureOverlaySwipeableFramesLogController.b == -1 || profilePictureOverlaySwipeableFramesLogController.b == i)) {
                        profilePictureOverlaySwipeableFramesLogController.e++;
                    }
                    profilePictureOverlaySwipeableFramesLogController.b = i;
                }
            }
        }

        C02663(CreativeCamSwipeableController creativeCamSwipeableController) {
            this.f2219a = creativeCamSwipeableController;
        }

        public final void m2382a(String str) {
        }

        public final void m2383a(String str, int i) {
        }

        public final void m2385b(String str, int i) {
        }

        public final void m2386c(String str, int i) {
        }

        public final void m2387d(String str, int i) {
        }

        public final void m2388e(String str, int i) {
        }
    }

    @Inject
    public CreativeCamSwipeableController(@Assisted CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, @Assisted SwipeableFramesHScrollCirclePageIndicator swipeableFramesHScrollCirclePageIndicator, @Assisted CreativeEditingLogger creativeEditingLogger, @Nullable @Assisted ImmutableList<Frame> immutableList, @Nullable @Assisted String str, @Assisted CreativeCamSource creativeCamSource, @Nullable @Assisted CreativeCamSwipeableFramesLogController creativeCamSwipeableFramesLogController, CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider, Provider<SwipeableDraweeControllerGeneratorImpl> provider, SwipeableParamsListBuilderProvider swipeableParamsListBuilderProvider) {
        this.f2224e = (CreativeEditingSwipeableLayout) Preconditions.checkNotNull(creativeEditingSwipeableLayout);
        this.f2225f = creativeEditingLogger;
        this.f2226g = creativeCamSource;
        this.f2227h = creativeCamSwipeableFramesLogController;
        this.f2229j = immutableList;
        this.f2230k = str;
        this.f2221b = creativeEditingSwipeableControllerProvider;
        this.f2222c = provider;
        this.f2228i = swipeableParamsListBuilderProvider;
        this.f2223d = new SwipeableFramesCirclePageIndicatorController(swipeableFramesHScrollCirclePageIndicator);
    }

    public final void m2391a(int i, int i2, boolean z) {
        this.f2235p = i;
        this.f2236q = i2;
        this.f2237r = z;
        LayoutParams layoutParams = this.f2224e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f2224e.setLayoutParams(layoutParams);
        this.f2224e.requestLayout();
        if (this.f2231l != null) {
            this.f2230k = this.f2231l.g();
            this.f2231l.j();
        }
        if (this.f2229j == null || this.f2229j.isEmpty()) {
            this.f2231l = null;
            this.f2232m = null;
            return;
        }
        String str;
        this.f2233n = m2389d(this);
        this.f2232m = (SwipeableDraweeControllerGeneratorImpl) this.f2222c.get();
        this.f2231l = this.f2221b.a(this.f2238s, this.f2232m, null, "-1");
        this.f2231l.a(this.f2224e, this.f2235p, this.f2236q, true);
        this.f2231l.H = this.f2220a;
        if (!this.f2237r) {
            CreativeEditingSwipeableController creativeEditingSwipeableController = this.f2231l;
            creativeEditingSwipeableController.a(creativeEditingSwipeableController.p.a(creativeEditingSwipeableController.u, creativeEditingSwipeableController.v).a(creativeEditingSwipeableController.F).a().b(), null);
        }
        CreativeEditingSwipeableController creativeEditingSwipeableController2 = this.f2231l;
        ImmutableList immutableList = this.f2229j;
        if (this.f2230k != null) {
            str = this.f2230k;
        } else {
            str = ((SwipeableParams) this.f2233n.get(1)).b;
        }
        creativeEditingSwipeableController2.a(immutableList, null, str);
        this.f2231l.L.g = this.f2234o;
        this.f2231l.a(this.f2223d.c);
        this.f2231l.b(true);
    }

    public static ImmutableList m2389d(CreativeCamSwipeableController creativeCamSwipeableController) {
        SwipeableParamsListBuilder a = creativeCamSwipeableController.f2228i.a(creativeCamSwipeableController.f2235p, creativeCamSwipeableController.f2236q);
        if (!creativeCamSwipeableController.f2237r) {
            a.a();
        }
        return a.c(creativeCamSwipeableController.f2229j).b();
    }

    @Nullable
    public final String m2390a() {
        if (this.f2231l == null) {
            return null;
        }
        return this.f2231l.g();
    }

    @Nullable
    public final ImmutableList<StickerParams> m2392b() {
        if (this.f2231l == null) {
            return null;
        }
        return this.f2231l.i();
    }
}
