package com.facebook.video.videohome.autoplay;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.CenterDistanceVideoDisplaySelector;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import javax.inject.Inject;

@ContextScoped
/* compiled from: step_phase */
public class VideoHomeCenteredAutoplayManager<V extends View> {
    private static VideoHomeCenteredAutoplayManager f2796c;
    private static final Object f2797d = new Object();
    public final VideoDisplayedCoordinator<V> f2798a;
    private final SessionStatusListener f2799b = new C02611(this);

    /* compiled from: step_phase */
    class C02611 implements SessionStatusListener {
        final /* synthetic */ VideoHomeCenteredAutoplayManager f2795a;

        C02611(VideoHomeCenteredAutoplayManager videoHomeCenteredAutoplayManager) {
            this.f2795a = videoHomeCenteredAutoplayManager;
        }

        public final void m2667a() {
            this.f2795a.f2798a.d();
        }

        public final void kM_() {
            this.f2795a.f2798a.a(EventTriggerType.BY_VIDEO_HOME_PAUSE);
        }

        public final void kN_() {
            this.f2795a.f2798a.d();
        }

        public final void m2668e() {
            this.f2795a.f2798a.a(EventTriggerType.BY_VIDEO_HOME_END);
        }
    }

    private static VideoHomeCenteredAutoplayManager m2670b(InjectorLike injectorLike) {
        return new VideoHomeCenteredAutoplayManager(CenterDistanceVideoDisplaySelector.b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), VideoHomeSessionManager.a(injectorLike));
    }

    @Inject
    public VideoHomeCenteredAutoplayManager(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, VideoHomeSessionManager videoHomeSessionManager) {
        this.f2798a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, false);
        videoHomeSessionManager.a(this.f2799b);
    }

    public static VideoHomeCenteredAutoplayManager m2669a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeCenteredAutoplayManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2797d) {
                VideoHomeCenteredAutoplayManager videoHomeCenteredAutoplayManager;
                if (a2 != null) {
                    videoHomeCenteredAutoplayManager = (VideoHomeCenteredAutoplayManager) a2.a(f2797d);
                } else {
                    videoHomeCenteredAutoplayManager = f2796c;
                }
                if (videoHomeCenteredAutoplayManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2670b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2797d, b3);
                        } else {
                            f2796c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeCenteredAutoplayManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2671a(V v, VideoViewController videoViewController) {
        this.f2798a.a(v, videoViewController);
    }
}
