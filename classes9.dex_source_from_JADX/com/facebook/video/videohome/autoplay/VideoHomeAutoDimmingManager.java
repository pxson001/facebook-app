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
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import javax.inject.Inject;

@ContextScoped
/* compiled from: step_type */
public class VideoHomeAutoDimmingManager<V extends View> {
    private static VideoHomeAutoDimmingManager f2791c;
    private static final Object f2792d = new Object();
    public final VideoDisplayedCoordinator<V> f2793a;
    private final SessionStatusListener f2794b = new C02601(this);

    /* compiled from: step_type */
    class C02601 implements SessionStatusListener {
        final /* synthetic */ VideoHomeAutoDimmingManager f2790a;

        C02601(VideoHomeAutoDimmingManager videoHomeAutoDimmingManager) {
            this.f2790a = videoHomeAutoDimmingManager;
        }

        public final void m2662a() {
            this.f2790a.f2793a.d();
        }

        public final void kM_() {
            this.f2790a.f2793a.c();
        }

        public final void kN_() {
            this.f2790a.f2793a.d();
        }

        public final void m2663e() {
            this.f2790a.f2793a.c();
        }
    }

    private static VideoHomeAutoDimmingManager m2665b(InjectorLike injectorLike) {
        return new VideoHomeAutoDimmingManager(CenterDistanceVideoDisplaySelector.b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class), VideoHomeSessionManager.a(injectorLike));
    }

    @Inject
    public VideoHomeAutoDimmingManager(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider, VideoHomeSessionManager videoHomeSessionManager) {
        this.f2793a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, false);
        videoHomeSessionManager.a(this.f2794b);
    }

    public final void m2666a(V v, VideoViewController videoViewController) {
        this.f2793a.a(v, videoViewController);
    }

    public static VideoHomeAutoDimmingManager m2664a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeAutoDimmingManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2792d) {
                VideoHomeAutoDimmingManager videoHomeAutoDimmingManager;
                if (a2 != null) {
                    videoHomeAutoDimmingManager = (VideoHomeAutoDimmingManager) a2.a(f2792d);
                } else {
                    videoHomeAutoDimmingManager = f2791c;
                }
                if (videoHomeAutoDimmingManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2665b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2792d, b3);
                        } else {
                            f2791c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeAutoDimmingManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
