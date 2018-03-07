package com.facebook.saved.perf;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.google.common.base.Absent;
import javax.inject.Inject;

@ContextScoped
/* compiled from: intent does not contain location signal data package */
public class SavedItemsScrollPerfLogger implements OnScrollListener {
    private static SavedItemsScrollPerfLogger f9236c;
    private static final Object f9237d = new Object();
    public final FrameRateLogger f9238a;
    private int f9239b = 0;

    private static SavedItemsScrollPerfLogger m9275b(InjectorLike injectorLike) {
        return new SavedItemsScrollPerfLogger((FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class));
    }

    @Inject
    public SavedItemsScrollPerfLogger(FrameRateLoggerProvider frameRateLoggerProvider) {
        this.f9238a = frameRateLoggerProvider.a(Boolean.valueOf(false), "saved_dash_items_scroll_perf", Absent.INSTANCE);
    }

    public final void m9276a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (this.f9239b == 0) {
            this.f9238a.a();
        } else if (i == 0) {
            this.f9238a.b();
        }
        this.f9239b = i;
    }

    public static SavedItemsScrollPerfLogger m9274a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedItemsScrollPerfLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9237d) {
                SavedItemsScrollPerfLogger savedItemsScrollPerfLogger;
                if (a2 != null) {
                    savedItemsScrollPerfLogger = (SavedItemsScrollPerfLogger) a2.a(f9237d);
                } else {
                    savedItemsScrollPerfLogger = f9236c;
                }
                if (savedItemsScrollPerfLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9275b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9237d, b3);
                        } else {
                            f9236c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedItemsScrollPerfLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m9277a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
    }
}
