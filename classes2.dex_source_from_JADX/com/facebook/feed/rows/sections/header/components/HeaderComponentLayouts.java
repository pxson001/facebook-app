package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.ComponentLayout$ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: image_main */
public class HeaderComponentLayouts<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    public final HeaderActorComponent<E> f20402a;
    private final HeaderTitleAndSubtitleComponent<E> f20403b;

    public static HeaderComponentLayouts m28148b(InjectorLike injectorLike) {
        return new HeaderComponentLayouts(HeaderActorComponent.m28151a(injectorLike), HeaderTitleAndSubtitleComponent.m28242a(injectorLike));
    }

    @Inject
    private HeaderComponentLayouts(HeaderActorComponent headerActorComponent, HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent) {
        this.f20402a = headerActorComponent;
        this.f20403b = headerTitleAndSubtitleComponent;
    }

    public final ComponentLayout$ContainerBuilder m28150a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return Container.m30723a(componentContext).mo3300C(2).mo3302E(1).mo3316a(this.f20402a.m28154a(componentContext).m30952a((FeedProps) feedProps).m30951a((HasFeedListType) e).m30663c().mo3346l(2131427599).mo3354p(2131427598).mo3336g(6, 2131427596).mo3336g(1, 2131427595).mo3336g(7, 2131427597).mo3336g(3, 2131427591)).mo3316a(m28149c(componentContext, feedProps, e));
    }

    private ComponentLayout$Builder m28149c(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return this.f20403b.m28244a(componentContext).m31003a((FeedProps) feedProps).m31002a((HasContext) e).m30663c().mo3328c(7, 2131427602).mo3336g(1, 2131427605);
    }
}
