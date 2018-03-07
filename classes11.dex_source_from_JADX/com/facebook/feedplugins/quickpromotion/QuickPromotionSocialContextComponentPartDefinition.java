package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.quickpromotion.QuickPromotionSocialContextComponent.Builder;
import com.facebook.feedplugins.quickpromotion.QuickPromotionSocialContextComponent.State;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: category_history/ */
public class QuickPromotionSocialContextComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, E> {
    private static QuickPromotionSocialContextComponentPartDefinition f8957f;
    private static final Object f8958g = new Object();
    private final QuickPromotionSocialContextComponent f8959c;
    private final FeedBackgroundStylerComponentWrapper f8960d;
    private final AndroidComponentsExperimentHelper f8961e;

    private static QuickPromotionSocialContextComponentPartDefinition m9677b(InjectorLike injectorLike) {
        return new QuickPromotionSocialContextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AndroidComponentsExperimentHelper.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), QuickPromotionSocialContextComponent.m9671a(injectorLike));
    }

    public final boolean m9680a(Object obj) {
        return QuickPromotionFeedUnitUtils.m9628b((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a) && this.f8961e.f();
    }

    public final CacheableEntity m9681b(Object obj) {
        return (CacheableEntity) ((FeedProps) obj).a;
    }

    @Inject
    public QuickPromotionSocialContextComponentPartDefinition(Context context, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, QuickPromotionSocialContextComponent quickPromotionSocialContextComponent) {
        super(context);
        this.f8961e = androidComponentsExperimentHelper;
        this.f8960d = feedBackgroundStylerComponentWrapper;
        this.f8959c = quickPromotionSocialContextComponent;
    }

    private Component<?> m9675a(ComponentContext componentContext, FeedProps<GraphQLQuickPromotionFeedUnit> feedProps, E e) {
        FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper = this.f8960d;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) e;
        StylingData stylingData = new StylingData(feedProps, PaddingStyle.a);
        State state = new State(this.f8959c);
        Builder builder = (Builder) QuickPromotionSocialContextComponent.f8953b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m9668a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f8947a.f8951a = feedProps;
        builder2.f8950d.set(0);
        return feedBackgroundStylerComponentWrapper.b(componentContext, hasPositionInformation, stylingData, builder2.d());
    }

    public static QuickPromotionSocialContextComponentPartDefinition m9676a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionSocialContextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8958g) {
                QuickPromotionSocialContextComponentPartDefinition quickPromotionSocialContextComponentPartDefinition;
                if (a2 != null) {
                    quickPromotionSocialContextComponentPartDefinition = (QuickPromotionSocialContextComponentPartDefinition) a2.a(f8958g);
                } else {
                    quickPromotionSocialContextComponentPartDefinition = f8957f;
                }
                if (quickPromotionSocialContextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9677b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8958g, b3);
                        } else {
                            f8957f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionSocialContextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
