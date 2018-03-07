package com.facebook.feed.rows.sections.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: identity_keys */
public class FeedBackgroundStylerComponentWrapper {
    private final FeedBackgroundStylerComponent f20592a;
    private final PositionResolver f20593b;
    private final GraphQLStoryUtil f20594c;

    public static FeedBackgroundStylerComponentWrapper m28338b(InjectorLike injectorLike) {
        return new FeedBackgroundStylerComponentWrapper(FeedBackgroundStylerComponent.m28341a(injectorLike), PositionResolver.m19143a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    @Inject
    public FeedBackgroundStylerComponentWrapper(FeedBackgroundStylerComponent feedBackgroundStylerComponent, PositionResolver positionResolver, GraphQLStoryUtil graphQLStoryUtil) {
        this.f20592a = feedBackgroundStylerComponent;
        this.f20593b = positionResolver;
        this.f20594c = graphQLStoryUtil;
    }

    public final Component<?> m28339a(ComponentContext componentContext, HasPositionInformation hasPositionInformation, StylingData stylingData, Component<?> component) {
        return m28337a(componentContext, hasPositionInformation, stylingData, component, false);
    }

    public final Component<?> m28340b(ComponentContext componentContext, HasPositionInformation hasPositionInformation, StylingData stylingData, Component<?> component) {
        return m28337a(componentContext, hasPositionInformation, stylingData, component, true);
    }

    private Component<?> m28337a(ComponentContext componentContext, HasPositionInformation hasPositionInformation, StylingData stylingData, Component<?> component, boolean z) {
        int a = BackgroundStyles.m26966a(stylingData.f19251a, this.f20594c);
        Builder a2 = this.f20592a.m28343a(componentContext).m30681a((Component) component).m30686h(a).m30683a(BackgroundStyles.m26972a(a, stylingData.f19251a, stylingData.f19255e, this.f20593b, hasPositionInformation.mo2449f(), hasPositionInformation.hK_(), hasPositionInformation.mo2451h(), hasPositionInformation.mo2455i(), hasPositionInformation.mo2456j())).m30682a(stylingData);
        a2.f22715a.f22713e = z;
        return a2.mo3296d();
    }
}
