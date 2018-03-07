package com.facebook.feedplugins.growth.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLNoContentFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: other_pss */
public class NoContentFeedPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLNoContentFeedUnit>, Void, AnyEnvironment, View> {
    public static final ViewType f5848a = new C02571();
    private static NoContentFeedPartDefinition f5849b;
    private static final Object f5850c = new Object();

    /* compiled from: other_pss */
    final class C02571 extends ViewType {
        C02571() {
        }

        public final View m6342a(Context context) {
            return LayoutInflater.from(context).inflate(2130904317, null);
        }
    }

    private static NoContentFeedPartDefinition m6339c() {
        return new NoContentFeedPartDefinition();
    }

    public final ViewType m6340a() {
        return f5848a;
    }

    public final boolean m6341a(Object obj) {
        return true;
    }

    public static NoContentFeedPartDefinition m6338a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NoContentFeedPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5850c) {
                NoContentFeedPartDefinition noContentFeedPartDefinition;
                if (a2 != null) {
                    noContentFeedPartDefinition = (NoContentFeedPartDefinition) a2.a(f5850c);
                } else {
                    noContentFeedPartDefinition = f5849b;
                }
                if (noContentFeedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m6339c();
                        if (a2 != null) {
                            a2.a(f5850c, c);
                        } else {
                            f5849b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = noContentFeedPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
