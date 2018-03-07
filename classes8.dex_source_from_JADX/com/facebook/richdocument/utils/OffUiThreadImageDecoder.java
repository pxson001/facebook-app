package com.facebook.richdocument.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pendingContactpoint */
public class OffUiThreadImageDecoder {
    private static OffUiThreadImageDecoder f6480c;
    private static final Object f6481d = new Object();
    private final ExecutorService f6482a;
    public final ExecutorService f6483b;

    /* compiled from: pendingContactpoint */
    public interface DrawableDecodedCallback {
        void mo470a(int i, Drawable drawable);
    }

    private static OffUiThreadImageDecoder m6858b(InjectorLike injectorLike) {
        return new OffUiThreadImageDecoder((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public OffUiThreadImageDecoder(ExecutorService executorService, ExecutorService executorService2) {
        this.f6482a = executorService;
        this.f6483b = executorService2;
    }

    public final void m6859a(final Context context, final int i, final DrawableDecodedCallback drawableDecodedCallback) {
        ExecutorDetour.a(this.f6482a, new Runnable(this) {
            final /* synthetic */ OffUiThreadImageDecoder f6479d;

            public void run() {
                final Drawable drawable = context.getResources().getDrawable(i);
                if (drawableDecodedCallback != null) {
                    ExecutorDetour.a(this.f6479d.f6483b, new Runnable(this) {
                        final /* synthetic */ C07391 f6475b;

                        public void run() {
                            drawableDecodedCallback.mo470a(i, drawable);
                        }
                    }, -906112366);
                }
            }
        }, -1339639356);
    }

    public static OffUiThreadImageDecoder m6857a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OffUiThreadImageDecoder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6481d) {
                OffUiThreadImageDecoder offUiThreadImageDecoder;
                if (a2 != null) {
                    offUiThreadImageDecoder = (OffUiThreadImageDecoder) a2.a(f6481d);
                } else {
                    offUiThreadImageDecoder = f6480c;
                }
                if (offUiThreadImageDecoder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6858b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6481d, b3);
                        } else {
                            f6480c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offUiThreadImageDecoder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
