package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.engine.VideoEngineUtils;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: qe_sessioned */
public class AutoplayVisibilityRunnableActivityListener {
    private static AutoplayVisibilityRunnableActivityListener f8534c;
    private static final Object f8535d = new Object();
    @VisibleForTesting
    public List<WeakReference<AutoplayVisibilityRunnable>> f8536a = new ArrayList();
    private final VideoEngineUtils f8537b;

    private static AutoplayVisibilityRunnableActivityListener m13080b(InjectorLike injectorLike) {
        return new AutoplayVisibilityRunnableActivityListener(VideoEngineUtils.m13007a(injectorLike));
    }

    @Inject
    public AutoplayVisibilityRunnableActivityListener(VideoEngineUtils videoEngineUtils) {
        this.f8537b = videoEngineUtils;
    }

    public final void m13082a(AutoplayVisibilityRunnable autoplayVisibilityRunnable) {
        this.f8536a.add(new WeakReference(autoplayVisibilityRunnable));
    }

    public final void m13081a() {
        VideoEngineUtils.m13008a(this.f8536a);
        for (WeakReference weakReference : this.f8536a) {
            AutoplayVisibilityRunnable autoplayVisibilityRunnable = (AutoplayVisibilityRunnable) weakReference.get();
            if (autoplayVisibilityRunnable != null) {
                autoplayVisibilityRunnable.b();
            }
        }
    }

    public static AutoplayVisibilityRunnableActivityListener m13079a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoplayVisibilityRunnableActivityListener b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f8535d) {
                AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener;
                if (a2 != null) {
                    autoplayVisibilityRunnableActivityListener = (AutoplayVisibilityRunnableActivityListener) a2.mo818a(f8535d);
                } else {
                    autoplayVisibilityRunnableActivityListener = f8534c;
                }
                if (autoplayVisibilityRunnableActivityListener == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m13080b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f8535d, b3);
                        } else {
                            f8534c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = autoplayVisibilityRunnableActivityListener;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
