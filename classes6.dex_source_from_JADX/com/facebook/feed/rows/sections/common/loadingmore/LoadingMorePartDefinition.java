package com.facebook.feed.rows.sections.common.loadingmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: message_capping_settings_optout */
public class LoadingMorePartDefinition extends MultiRowSinglePartDefinition<FeedProps<LoadingMoreSentinelFeedUnit>, Void, AnyEnvironment, View> {
    public static final ViewType f10399a = new C06291();
    private static LoadingMorePartDefinition f10400b;
    private static final Object f10401c = new Object();

    /* compiled from: message_capping_settings_optout */
    final class C06291 extends ViewType {
        C06291() {
        }

        public final View m16575a(Context context) {
            return LayoutInflater.from(context).inflate(2130904314, null);
        }
    }

    private static LoadingMorePartDefinition m16577c() {
        return new LoadingMorePartDefinition();
    }

    public final ViewType m16578a() {
        return f10399a;
    }

    public final boolean m16579a(Object obj) {
        return true;
    }

    public static LoadingMorePartDefinition m16576a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoadingMorePartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10401c) {
                LoadingMorePartDefinition loadingMorePartDefinition;
                if (a2 != null) {
                    loadingMorePartDefinition = (LoadingMorePartDefinition) a2.a(f10401c);
                } else {
                    loadingMorePartDefinition = f10400b;
                }
                if (loadingMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m16577c();
                        if (a2 != null) {
                            a2.a(f10401c, c);
                        } else {
                            f10400b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = loadingMorePartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
