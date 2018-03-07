package com.facebook.feed.autoplay;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.engine.VideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: qe_sessionless */
public class FeedAutoplayActivityListener {
    private static FeedAutoplayActivityListener f8530c;
    private static final Object f8531d = new Object();
    private VideoEngineUtils f8532a;
    public List<WeakReference<VideoDisplayedCoordinator>> f8533b = new ArrayList();

    private static FeedAutoplayActivityListener m13077b(InjectorLike injectorLike) {
        return new FeedAutoplayActivityListener(VideoEngineUtils.m13007a(injectorLike));
    }

    @Inject
    public FeedAutoplayActivityListener(VideoEngineUtils videoEngineUtils) {
        this.f8532a = videoEngineUtils;
    }

    public final void m13078a() {
        VideoEngineUtils.m13008a(this.f8533b);
        for (WeakReference weakReference : this.f8533b) {
            VideoDisplayedCoordinator videoDisplayedCoordinator = (VideoDisplayedCoordinator) weakReference.get();
            if (videoDisplayedCoordinator != null) {
                videoDisplayedCoordinator.m26593d();
            }
        }
    }

    public static FeedAutoplayActivityListener m13076a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedAutoplayActivityListener b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f8531d) {
                FeedAutoplayActivityListener feedAutoplayActivityListener;
                if (a2 != null) {
                    feedAutoplayActivityListener = (FeedAutoplayActivityListener) a2.mo818a(f8531d);
                } else {
                    feedAutoplayActivityListener = f8530c;
                }
                if (feedAutoplayActivityListener == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m13077b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f8531d, b3);
                        } else {
                            f8530c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedAutoplayActivityListener;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
