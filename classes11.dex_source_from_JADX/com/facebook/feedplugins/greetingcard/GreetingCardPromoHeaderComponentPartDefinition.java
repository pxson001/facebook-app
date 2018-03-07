package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.greetingcard.GreetingCardPromoHeaderComponent.Builder;
import com.facebook.feedplugins.greetingcard.GreetingCardPromoHeaderComponent.State;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: default_group_id */
public class GreetingCardPromoHeaderComponentPartDefinition<E extends HasContext & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLGreetingCardPromotionFeedUnit>, E> {
    private static GreetingCardPromoHeaderComponentPartDefinition f7720f;
    private static final Object f7721g = new Object();
    private final GreetingCardPromoHeaderComponent f7722c;
    private final FeedBackgroundStylerComponentWrapper f7723d;
    private final AndroidComponentsExperimentHelper f7724e;

    private static GreetingCardPromoHeaderComponentPartDefinition m8903b(InjectorLike injectorLike) {
        return new GreetingCardPromoHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), GreetingCardPromoHeaderComponent.m8897a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    @Inject
    public GreetingCardPromoHeaderComponentPartDefinition(Context context, GreetingCardPromoHeaderComponent greetingCardPromoHeaderComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f7722c = greetingCardPromoHeaderComponent;
        this.f7723d = feedBackgroundStylerComponentWrapper;
        this.f7724e = androidComponentsExperimentHelper;
    }

    private Component<?> m8901a(ComponentContext componentContext, FeedProps<GraphQLGreetingCardPromotionFeedUnit> feedProps, E e) {
        State state = new State(this.f7722c);
        Builder builder = (Builder) GreetingCardPromoHeaderComponent.f7716b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m8894a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f7709a.f7713a = feedProps;
        builder2.f7712d.set(0);
        Builder builder3 = builder2;
        builder3.f7709a.f7714b = ((HasMenuButtonProvider) e).e();
        builder3.f7712d.set(1);
        return this.f7723d.b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.i), builder3.d());
    }

    public static GreetingCardPromoHeaderComponentPartDefinition m8902a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7721g) {
                GreetingCardPromoHeaderComponentPartDefinition greetingCardPromoHeaderComponentPartDefinition;
                if (a2 != null) {
                    greetingCardPromoHeaderComponentPartDefinition = (GreetingCardPromoHeaderComponentPartDefinition) a2.a(f7721g);
                } else {
                    greetingCardPromoHeaderComponentPartDefinition = f7720f;
                }
                if (greetingCardPromoHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8903b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7721g, b3);
                        } else {
                            f7720f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m8907b(Object obj) {
        return null;
    }

    public final boolean m8906a(Object obj) {
        return this.f7724e.b();
    }
}
