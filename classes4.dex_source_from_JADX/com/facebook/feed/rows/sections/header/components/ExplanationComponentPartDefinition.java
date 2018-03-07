package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.components.feed.FeedComponentView;
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
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: never_updated */
public class ExplanationComponentPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> implements HasSpecialStyling {
    public static final ExplanationComponentViewType f7164c = new ExplanationComponentViewType();
    private static ExplanationComponentPartDefinition f7165h;
    private static final Object f7166i = new Object();
    private final ExplanationComponent<E> f7167d;
    private final FeedBackgroundStylerComponentWrapper f7168e;
    private final FeedStoryUtil f7169f;
    private final AndroidComponentsExperimentHelper f7170g;

    /* compiled from: never_updated */
    class ExplanationComponentViewType extends ViewType {
        public final View m7497a(Context context) {
            return new FeedComponentView(context);
        }
    }

    private static ExplanationComponentPartDefinition m7490b(InjectorLike injectorLike) {
        return new ExplanationComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ExplanationComponent.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), FeedStoryUtil.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final boolean m7494a(Object obj) {
        return FeedStoryUtil.a((GraphQLStory) ((FeedProps) obj).a) && this.f7170g.n();
    }

    public final CacheableEntity m7496b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    public static ExplanationComponentPartDefinition m7489a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7166i) {
                ExplanationComponentPartDefinition explanationComponentPartDefinition;
                if (a2 != null) {
                    explanationComponentPartDefinition = (ExplanationComponentPartDefinition) a2.a(f7166i);
                } else {
                    explanationComponentPartDefinition = f7165h;
                }
                if (explanationComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7490b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7166i, b3);
                        } else {
                            f7165h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ExplanationComponentPartDefinition(Context context, ExplanationComponent explanationComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryUtil feedStoryUtil, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f7167d = explanationComponent;
        this.f7168e = feedBackgroundStylerComponentWrapper;
        this.f7169f = feedStoryUtil;
        this.f7170g = androidComponentsExperimentHelper;
    }

    private Component<?> m7488a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return this.f7168e.a(componentContext, (HasPositionInformation) e, new StylingData(feedProps, BaseExplanationPartDefinition.a(feedProps)), this.f7167d.a(componentContext).a(feedProps).a((HasInvalidate) e).a(TextHeaderStyle.SUGGESTED_CONTENT).d());
    }

    public final ViewType m7493a() {
        return f7164c;
    }

    public final SpecialStylingType m7495b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }
}
