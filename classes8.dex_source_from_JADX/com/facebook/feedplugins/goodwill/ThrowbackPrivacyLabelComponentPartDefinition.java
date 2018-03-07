package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feedplugins.goodwill.ThrowbackPrivacyLabelComponent.Builder;
import com.facebook.feedplugins.goodwill.ThrowbackPrivacyLabelComponent.State;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_campaign_dismissed_preview */
public class ThrowbackPrivacyLabelComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, E> {
    private static ThrowbackPrivacyLabelComponentPartDefinition f12474f;
    private static final Object f12475g = new Object();
    private final ThrowbackPrivacyLabelComponent f12476c;
    private final FeedBackgroundStylerComponentWrapper f12477d;
    private final AndroidComponentsExperimentHelper f12478e;

    private static ThrowbackPrivacyLabelComponentPartDefinition m14363b(InjectorLike injectorLike) {
        return new ThrowbackPrivacyLabelComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ThrowbackPrivacyLabelComponent.m14357a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final boolean m14366a(Object obj) {
        return ThrowbackPrivacyLabelPartDefinition.m14373a((FeedProps) obj) && this.f12478e.f();
    }

    public final CacheableEntity m14367b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public ThrowbackPrivacyLabelComponentPartDefinition(Context context, ThrowbackPrivacyLabelComponent throwbackPrivacyLabelComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f12476c = throwbackPrivacyLabelComponent;
        this.f12477d = feedBackgroundStylerComponentWrapper;
        this.f12478e = androidComponentsExperimentHelper;
    }

    private Component<?> m14361a(ComponentContext componentContext, FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps, E e) {
        State state = new State(this.f12476c);
        Builder builder = (Builder) ThrowbackPrivacyLabelComponent.f12470b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m14354a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f12464a.f12468a = feedProps;
        builder2.f12467d.set(0);
        return this.f12477d.a(componentContext, (HasPositionInformation) e, ThrowbackPrivacyLabelPartDefinition.m14374b((FeedProps) feedProps), builder2.d());
    }

    public static ThrowbackPrivacyLabelComponentPartDefinition m14362a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPrivacyLabelComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12475g) {
                ThrowbackPrivacyLabelComponentPartDefinition throwbackPrivacyLabelComponentPartDefinition;
                if (a2 != null) {
                    throwbackPrivacyLabelComponentPartDefinition = (ThrowbackPrivacyLabelComponentPartDefinition) a2.a(f12475g);
                } else {
                    throwbackPrivacyLabelComponentPartDefinition = f12474f;
                }
                if (throwbackPrivacyLabelComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14363b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12475g, b3);
                        } else {
                            f12474f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPrivacyLabelComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
