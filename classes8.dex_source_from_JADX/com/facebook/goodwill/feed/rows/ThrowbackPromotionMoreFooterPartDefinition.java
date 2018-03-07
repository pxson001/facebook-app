package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: fb.me */
public class ThrowbackPromotionMoreFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<ThrowbackPromotionFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f13786a = ViewType.a(2130907419);
    private static ThrowbackPromotionMoreFooterPartDefinition f13787b;
    private static final Object f13788c = new Object();

    private static ThrowbackPromotionMoreFooterPartDefinition m15443b() {
        return new ThrowbackPromotionMoreFooterPartDefinition();
    }

    public final boolean m15445a(Object obj) {
        return ((ThrowbackPromotionFeedUnit) ((FeedProps) obj).a).f13778d;
    }

    public final ViewType m15444a() {
        return f13786a;
    }

    public static ThrowbackPromotionMoreFooterPartDefinition m15442a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotionMoreFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13788c) {
                ThrowbackPromotionMoreFooterPartDefinition throwbackPromotionMoreFooterPartDefinition;
                if (a2 != null) {
                    throwbackPromotionMoreFooterPartDefinition = (ThrowbackPromotionMoreFooterPartDefinition) a2.a(f13788c);
                } else {
                    throwbackPromotionMoreFooterPartDefinition = f13787b;
                }
                if (throwbackPromotionMoreFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m15443b();
                        if (a2 != null) {
                            a2.a(f13788c, b3);
                        } else {
                            f13787b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotionMoreFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
