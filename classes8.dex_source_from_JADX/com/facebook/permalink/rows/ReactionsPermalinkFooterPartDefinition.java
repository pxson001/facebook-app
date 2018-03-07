package com.facebook.permalink.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
/* compiled from: stories_count */
public class ReactionsPermalinkFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanFeedback, ReactionsFooterView> {
    private static ReactionsPermalinkFooterPartDefinition f2049e;
    private static final Object f2050f = new Object();
    private final GraphQLStoryUtil f2051a;
    private final FooterBackgroundPartDefinition<ReactionsFooterView> f2052b;
    private final BaseReactionsFooterPartDefinition f2053c;
    private final PermalinkCommonFooterPartDefinition<ReactionsFooterView> f2054d;

    private static ReactionsPermalinkFooterPartDefinition m2277b(InjectorLike injectorLike) {
        return new ReactionsPermalinkFooterPartDefinition(GraphQLStoryUtil.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike), BaseReactionsFooterPartDefinition.a(injectorLike), PermalinkCommonFooterPartDefinition.m2263a(injectorLike));
    }

    public final Object m2279a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f2052b, new Props(feedProps, FooterLevel.PERMALINK));
        subParts.a(this.f2054d, graphQLStory);
        subParts.a(this.f2053c, new BaseReactionsFooterPartDefinition.Props(feedProps, false));
        return null;
    }

    public final boolean m2280a(Object obj) {
        return this.f2051a.n((FeedProps) obj);
    }

    @Inject
    public ReactionsPermalinkFooterPartDefinition(GraphQLStoryUtil graphQLStoryUtil, FooterBackgroundPartDefinition footerBackgroundPartDefinition, BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition, PermalinkCommonFooterPartDefinition permalinkCommonFooterPartDefinition) {
        this.f2051a = graphQLStoryUtil;
        this.f2052b = footerBackgroundPartDefinition;
        this.f2053c = baseReactionsFooterPartDefinition;
        this.f2054d = permalinkCommonFooterPartDefinition;
    }

    public final ViewType m2278a() {
        return ReactionsFooterView.h;
    }

    public static ReactionsPermalinkFooterPartDefinition m2276a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionsPermalinkFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2050f) {
                ReactionsPermalinkFooterPartDefinition reactionsPermalinkFooterPartDefinition;
                if (a2 != null) {
                    reactionsPermalinkFooterPartDefinition = (ReactionsPermalinkFooterPartDefinition) a2.a(f2050f);
                } else {
                    reactionsPermalinkFooterPartDefinition = f2049e;
                }
                if (reactionsPermalinkFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2277b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2050f, b3);
                        } else {
                            f2049e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionsPermalinkFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
