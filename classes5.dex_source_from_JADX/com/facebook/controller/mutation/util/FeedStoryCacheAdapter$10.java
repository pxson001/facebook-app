package com.facebook.controller.mutation.util;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PrimaryActionLinkResolver;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$10 extends StoryVisitor {
    final /* synthetic */ boolean f11641a;
    final /* synthetic */ FeedStoryCacheAdapter f11642b;

    public FeedStoryCacheAdapter$10(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, boolean z) {
        this.f11642b = feedStoryCacheAdapter;
        this.f11641a = z;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        GraphQLStoryActionLink a = PrimaryActionLinkResolver.a(graphQLStory);
        if (a == null) {
            return graphQLStory;
        }
        GraphQLPage ab = a.ab();
        if (ab == null || ab.O() == this.f11641a) {
            return graphQLStory;
        }
        return (GraphQLStory) ((FeedStoryMutator) this.f11642b.a.get()).a(FeedProps.c(graphQLStory), a).a;
    }
}
