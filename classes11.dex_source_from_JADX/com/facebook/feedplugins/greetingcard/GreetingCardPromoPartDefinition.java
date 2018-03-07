package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: debug_info_map */
public class GreetingCardPromoPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGreetingCardPromotionFeedUnit>, Void, FeedEnvironment> {
    private static GreetingCardPromoPartDefinition f7741d;
    private static final Object f7742e = new Object();
    private final GreetingCardPromoContentPartDefinition f7743a;
    private final GreetingCardPromoHeaderPartDefinition<FeedEnvironment> f7744b;
    private final GreetingCardPromoHeaderComponentPartDefinition<FeedEnvironment> f7745c;

    private static GreetingCardPromoPartDefinition m8921b(InjectorLike injectorLike) {
        return new GreetingCardPromoPartDefinition(GreetingCardPromoHeaderComponentPartDefinition.m8902a(injectorLike), GreetingCardPromoHeaderPartDefinition.m8913a(injectorLike), GreetingCardPromoContentPartDefinition.m8889a(injectorLike));
    }

    public final Object m8922a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f7745c, feedProps).a(this.f7744b, feedProps);
        baseMultiRowSubParts.a(this.f7743a, feedProps);
        return null;
    }

    @Inject
    public GreetingCardPromoPartDefinition(GreetingCardPromoHeaderComponentPartDefinition greetingCardPromoHeaderComponentPartDefinition, GreetingCardPromoHeaderPartDefinition greetingCardPromoHeaderPartDefinition, GreetingCardPromoContentPartDefinition greetingCardPromoContentPartDefinition) {
        this.f7745c = greetingCardPromoHeaderComponentPartDefinition;
        this.f7743a = greetingCardPromoContentPartDefinition;
        this.f7744b = greetingCardPromoHeaderPartDefinition;
    }

    public final boolean m8923a(Object obj) {
        return true;
    }

    public static GreetingCardPromoPartDefinition m8920a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7742e) {
                GreetingCardPromoPartDefinition greetingCardPromoPartDefinition;
                if (a2 != null) {
                    greetingCardPromoPartDefinition = (GreetingCardPromoPartDefinition) a2.a(f7742e);
                } else {
                    greetingCardPromoPartDefinition = f7741d;
                }
                if (greetingCardPromoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8921b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7742e, b3);
                        } else {
                            f7741d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
