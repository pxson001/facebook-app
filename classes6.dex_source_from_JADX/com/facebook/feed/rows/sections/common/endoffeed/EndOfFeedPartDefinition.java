package com.facebook.feed.rows.sections.common.endoffeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.api.feed.data.EndOfFeedSentinel.EndOfFeedSentinelFeedUnit;
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
/* compiled from: message_seller */
public class EndOfFeedPartDefinition extends MultiRowSinglePartDefinition<FeedProps<EndOfFeedSentinelFeedUnit>, Void, AnyEnvironment, View> {
    public static final ViewType f10396a = new C06281();
    private static EndOfFeedPartDefinition f10397b;
    private static final Object f10398c = new Object();

    /* compiled from: message_seller */
    final class C06281 extends ViewType {
        C06281() {
        }

        public final View m16570a(Context context) {
            return LayoutInflater.from(context).inflate(2130904293, null);
        }
    }

    private static EndOfFeedPartDefinition m16572c() {
        return new EndOfFeedPartDefinition();
    }

    public final ViewType m16573a() {
        return f10396a;
    }

    public final boolean m16574a(Object obj) {
        return true;
    }

    public static EndOfFeedPartDefinition m16571a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EndOfFeedPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10398c) {
                EndOfFeedPartDefinition endOfFeedPartDefinition;
                if (a2 != null) {
                    endOfFeedPartDefinition = (EndOfFeedPartDefinition) a2.a(f10398c);
                } else {
                    endOfFeedPartDefinition = f10397b;
                }
                if (endOfFeedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m16572c();
                        if (a2 != null) {
                            a2.a(f10398c, c);
                        } else {
                            f10397b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = endOfFeedPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
