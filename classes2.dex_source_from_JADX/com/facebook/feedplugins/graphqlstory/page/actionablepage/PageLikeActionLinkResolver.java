package com.facebook.feedplugins.graphqlstory.page.actionablepage;

import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;

/* compiled from: platform_show_reply_dialog_wait_interval_days */
public class PageLikeActionLinkResolver {
    public static PageLikeActionLinkResolver m14608a(InjectorLike injectorLike) {
        return new PageLikeActionLinkResolver();
    }

    public static GraphQLStoryActionLink m14609a(GraphQLStory graphQLStory) {
        int i = 0;
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        GraphQLStoryActionLink a = o != null ? ActionLinkHelper.m22936a(o, -581184810) : null;
        if (a != null) {
            return a;
        }
        a = PrimaryActionLinkResolver.m31292a(graphQLStory);
        if (a != null && GraphQLHelper.m22493b(a)) {
            return a;
        }
        ImmutableList a2 = StoryActionLinkHelper.m28074a(graphQLStory);
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a = (GraphQLStoryActionLink) a2.get(i2);
            if (GraphQLHelper.m22493b(a)) {
                return a;
            }
        }
        ImmutableList b = StoryActionLinkHelper.m28075b(graphQLStory);
        int size2 = b.size();
        while (i < size2) {
            a = (GraphQLStoryActionLink) b.get(i);
            if (GraphQLHelper.m22493b(a)) {
                return a;
            }
            i++;
        }
        return null;
    }
}
