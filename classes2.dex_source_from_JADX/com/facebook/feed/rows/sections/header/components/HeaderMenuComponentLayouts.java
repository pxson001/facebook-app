package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.components.HeaderMenuComponent.State;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.ui.api.FeedMenuHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import javax.annotation.Nullable;

/* compiled from: http.request */
public class HeaderMenuComponentLayouts {
    private final HeaderMenuComponent f20776a;
    private final StoryHeaderUtil f20777b;

    public static HeaderMenuComponentLayouts m28491b(InjectorLike injectorLike) {
        return new HeaderMenuComponentLayouts(HeaderMenuComponent.m28494a(injectorLike), StoryHeaderUtil.m28330a(injectorLike));
    }

    @Inject
    private HeaderMenuComponentLayouts(HeaderMenuComponent headerMenuComponent, StoryHeaderUtil storyHeaderUtil) {
        this.f20776a = headerMenuComponent;
        this.f20777b = storyHeaderUtil;
    }

    @Nullable
    public final ComponentLayout$Builder m28492a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, FeedMenuHelper feedMenuHelper) {
        return m28493a(componentContext, feedProps, this.f20777b.m28333a(feedProps, feedMenuHelper), feedMenuHelper);
    }

    @Nullable
    public final ComponentLayout$Builder m28493a(ComponentContext componentContext, FeedProps<? extends FeedUnit> feedProps, MenuConfig menuConfig, FeedMenuHelper feedMenuHelper) {
        if (menuConfig == MenuConfig.HIDDEN) {
            return null;
        }
        State state = new State(this.f20776a);
        Builder builder = (HeaderMenuComponent.Builder) HeaderMenuComponent.f20778b.mo740a();
        if (builder == null) {
            builder = new HeaderMenuComponent.Builder();
        }
        HeaderMenuComponent.Builder.m31066a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f22960a.f22957b = feedProps;
        builder2.f22963d.set(1);
        builder2 = builder2;
        builder2.f22960a.f22958c = feedMenuHelper;
        builder2.f22963d.set(2);
        builder2 = builder2;
        builder2.f22960a.f22956a = menuConfig;
        builder2.f22963d.set(0);
        return builder2.m30663c().mo3346l(2131427600).mo3354p(2131427606).mo3336g(6, 2131427608).mo3336g(1, 2131427610).mo3336g(7, 2131427607).mo3336g(3, 2131427611);
    }
}
