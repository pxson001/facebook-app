package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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
/* compiled from: success_resend_sms_code */
public class MultiShareChannelFeedDividerPartDefinition extends MultiRowSinglePartDefinition<Void, Void, AnyEnvironment, View> {
    public static final ViewType f2621a = new C02421();
    private static MultiShareChannelFeedDividerPartDefinition f2622b;
    private static final Object f2623c = new Object();

    /* compiled from: success_resend_sms_code */
    final class C02421 extends ViewType {
        C02421() {
        }

        public final View m2528a(Context context) {
            return LayoutInflater.from(context).inflate(2130905358, null);
        }
    }

    private static MultiShareChannelFeedDividerPartDefinition m2530c() {
        return new MultiShareChannelFeedDividerPartDefinition();
    }

    public final ViewType m2531a() {
        return f2621a;
    }

    public final boolean m2532a(Object obj) {
        return true;
    }

    public static MultiShareChannelFeedDividerPartDefinition m2529a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareChannelFeedDividerPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2623c) {
                MultiShareChannelFeedDividerPartDefinition multiShareChannelFeedDividerPartDefinition;
                if (a2 != null) {
                    multiShareChannelFeedDividerPartDefinition = (MultiShareChannelFeedDividerPartDefinition) a2.a(f2623c);
                } else {
                    multiShareChannelFeedDividerPartDefinition = f2622b;
                }
                if (multiShareChannelFeedDividerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m2530c();
                        if (a2 != null) {
                            a2.a(f2623c, c);
                        } else {
                            f2622b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = multiShareChannelFeedDividerPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
