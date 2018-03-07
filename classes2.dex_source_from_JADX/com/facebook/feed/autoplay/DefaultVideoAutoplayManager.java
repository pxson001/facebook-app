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
/* compiled from: is_secondary */
public class DefaultVideoAutoplayManager<V extends View> {
    private static DefaultVideoAutoplayManager f18893b;
    private static final Object f18894c = new Object();
    private final VideoDisplayedCoordinator<V> f18895a;

    private static DefaultVideoAutoplayManager m26571b(InjectorLike injectorLike) {
        return new DefaultVideoAutoplayManager(new DefaultVideoDisplayedSelector(VideoAutoplayVisibilityDecider.m26575a(injectorLike)), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class));
    }

    @Inject
    public DefaultVideoAutoplayManager(DefaultVideoDisplayedSelector defaultVideoDisplayedSelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider) {
        this.f18895a = videoDisplayedCoordinatorProvider.m26579a(defaultVideoDisplayedSelector, true);
    }

    public final void m26572a(V v, VideoViewController videoViewController) {
        this.f18895a.m26587a((View) v, videoViewController);
    }

    public static DefaultVideoAutoplayManager m26570a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultVideoAutoplayManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18894c) {
                DefaultVideoAutoplayManager defaultVideoAutoplayManager;
                if (a2 != null) {
                    defaultVideoAutoplayManager = (DefaultVideoAutoplayManager) a2.mo818a(f18894c);
                } else {
                    defaultVideoAutoplayManager = f18893b;
                }
                if (defaultVideoAutoplayManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26571b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18894c, b3);
                        } else {
                            f18893b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultVideoAutoplayManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
