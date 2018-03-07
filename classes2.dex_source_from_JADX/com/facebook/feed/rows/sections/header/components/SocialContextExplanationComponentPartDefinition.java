package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.header.BaseExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friending_blacklist_people_you_should_follow */
public class SocialContextExplanationComponentPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> implements HasSpecialStyling {
    private static SocialContextExplanationComponentPartDefinition f23134f;
    private static final Object f23135g = new Object();
    private final ExplanationComponent<E> f23136c;
    private final FeedBackgroundStylerComponentWrapper f23137d;
    private final AndroidComponentsExperimentHelper f23138e;

    private static SocialContextExplanationComponentPartDefinition m31246b(InjectorLike injectorLike) {
        return new SocialContextExplanationComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ExplanationComponent.m31252a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final boolean m31249a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).f13444a).aG() != null && this.f23138e.m10062n();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    @Inject
    public SocialContextExplanationComponentPartDefinition(Context context, ExplanationComponent explanationComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f23136c = explanationComponent;
        this.f23137d = feedBackgroundStylerComponentWrapper;
        this.f23138e = androidComponentsExperimentHelper;
    }

    private Component<?> m31244a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return this.f23137d.m28339a(componentContext, (HasPositionInformation) e, new StylingData(feedProps, BaseExplanationPartDefinition.m31280a((FeedProps) feedProps)), this.f23136c.m31254a(componentContext).a(feedProps).a((HasInvalidate) e).a(TextHeaderStyle.SOCIAL_CONTEXT).mo3296d());
    }

    public static SocialContextExplanationComponentPartDefinition m31245a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialContextExplanationComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23135g) {
                SocialContextExplanationComponentPartDefinition socialContextExplanationComponentPartDefinition;
                if (a2 != null) {
                    socialContextExplanationComponentPartDefinition = (SocialContextExplanationComponentPartDefinition) a2.mo818a(f23135g);
                } else {
                    socialContextExplanationComponentPartDefinition = f23134f;
                }
                if (socialContextExplanationComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31246b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23135g, b3);
                        } else {
                            f23134f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = socialContextExplanationComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }
}
