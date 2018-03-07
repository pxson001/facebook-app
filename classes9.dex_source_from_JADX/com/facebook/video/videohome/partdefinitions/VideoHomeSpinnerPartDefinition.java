package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: single_line_address */
public class VideoHomeSpinnerPartDefinition extends MultiRowSinglePartDefinition<LoadingMoreSentinelFeedUnit, Void, AnyEnvironment, View> {
    public static final ViewType<View> f3177a = ViewType.a(2130906703);
    private static VideoHomeSpinnerPartDefinition f3178b;
    private static final Object f3179c = new Object();

    private static VideoHomeSpinnerPartDefinition m3026c() {
        return new VideoHomeSpinnerPartDefinition();
    }

    public final ViewType m3027a() {
        return f3177a;
    }

    public final boolean m3028a(Object obj) {
        return true;
    }

    public static VideoHomeSpinnerPartDefinition m3025a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeSpinnerPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3179c) {
                VideoHomeSpinnerPartDefinition videoHomeSpinnerPartDefinition;
                if (a2 != null) {
                    videoHomeSpinnerPartDefinition = (VideoHomeSpinnerPartDefinition) a2.a(f3179c);
                } else {
                    videoHomeSpinnerPartDefinition = f3178b;
                }
                if (videoHomeSpinnerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m3026c();
                        if (a2 != null) {
                            a2.a(f3179c, c);
                        } else {
                            f3178b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = videoHomeSpinnerPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
