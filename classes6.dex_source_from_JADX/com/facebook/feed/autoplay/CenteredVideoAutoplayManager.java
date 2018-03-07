package com.facebook.feed.autoplay;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nearby_map */
public class CenteredVideoAutoplayManager<V extends View> {
    private static CenteredVideoAutoplayManager f10130b;
    private static final Object f10131c = new Object();
    public final VideoDisplayedCoordinator<V> f10132a;

    private static CenteredVideoAutoplayManager m15805b(InjectorLike injectorLike) {
        return new CenteredVideoAutoplayManager(CenterDistanceVideoDisplaySelector.m15801b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class));
    }

    @Inject
    public CenteredVideoAutoplayManager(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider) {
        this.f10132a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
    }

    public final void m15806a(V v, VideoViewController videoViewController) {
        this.f10132a.a(v, videoViewController);
    }

    public static CenteredVideoAutoplayManager m15804a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CenteredVideoAutoplayManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10131c) {
                CenteredVideoAutoplayManager centeredVideoAutoplayManager;
                if (a2 != null) {
                    centeredVideoAutoplayManager = (CenteredVideoAutoplayManager) a2.a(f10131c);
                } else {
                    centeredVideoAutoplayManager = f10130b;
                }
                if (centeredVideoAutoplayManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15805b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10131c, b3);
                        } else {
                            f10130b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = centeredVideoAutoplayManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
