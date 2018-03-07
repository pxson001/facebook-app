package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.greetingcard.GreetingCardPartDefinition.Props;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: deleted_stories_count */
public class GreetingCardPromoContentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGreetingCardPromotionFeedUnit>, Void, HasPositionInformation, GreetingCardView> {
    public static final ViewType f7700a = new C09821();
    private static GreetingCardPromoContentPartDefinition f7701e;
    private static final Object f7702f = new Object();
    private final BackgroundPartDefinition f7703b;
    private final DefaultPaddingStyleResolver f7704c;
    private final GreetingCardPartDefinition f7705d;

    /* compiled from: deleted_stories_count */
    final class C09821 extends ViewType {
        C09821() {
        }

        public final View m8888a(Context context) {
            return new GreetingCardView(context);
        }
    }

    private static GreetingCardPromoContentPartDefinition m8890b(InjectorLike injectorLike) {
        return new GreetingCardPromoContentPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), GreetingCardPartDefinition.m8881a(injectorLike));
    }

    public final Object m8892a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGreetingCardPromotionFeedUnit graphQLGreetingCardPromotionFeedUnit = (GraphQLGreetingCardPromotionFeedUnit) feedProps.a;
        subParts.a(this.f7703b, new StylingData(feedProps, this.f7704c.h()));
        subParts.a(this.f7705d, new Props(graphQLGreetingCardPromotionFeedUnit.l(), Boolean.valueOf(true), Boolean.valueOf(true)));
        return null;
    }

    @Inject
    public GreetingCardPromoContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, GreetingCardPartDefinition greetingCardPartDefinition) {
        this.f7703b = backgroundPartDefinition;
        this.f7704c = defaultPaddingStyleResolver;
        this.f7705d = greetingCardPartDefinition;
    }

    public final ViewType m8891a() {
        return f7700a;
    }

    public final boolean m8893a(Object obj) {
        return true;
    }

    public static GreetingCardPromoContentPartDefinition m8889a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7702f) {
                GreetingCardPromoContentPartDefinition greetingCardPromoContentPartDefinition;
                if (a2 != null) {
                    greetingCardPromoContentPartDefinition = (GreetingCardPromoContentPartDefinition) a2.a(f7702f);
                } else {
                    greetingCardPromoContentPartDefinition = f7701e;
                }
                if (greetingCardPromoContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7702f, b3);
                        } else {
                            f7701e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
