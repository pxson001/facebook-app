package com.facebook.feed.rows.sections.header;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageLikeActionLinkResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryType;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryTypeResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PrimaryActionLinkResolver;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: images/places/map/pink-place-dot.png */
public class StoryActionLinkUtil {
    private final PageLikeActionLinkResolver f20370a;

    public static StoryActionLinkUtil m28026b(InjectorLike injectorLike) {
        return new StoryActionLinkUtil(PageLikeActionLinkResolver.m14608a(injectorLike));
    }

    @Inject
    public StoryActionLinkUtil(PageLikeActionLinkResolver pageLikeActionLinkResolver) {
        this.f20370a = pageLikeActionLinkResolver;
    }

    public final GraphQLStoryActionLink m28027a(FeedProps<GraphQLStory> feedProps) {
        Object obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (PageStoryTypeResolver.m28081a((FeedProps) feedProps) != PageStoryType.NCPP || PrimaryActionLinkResolver.m31292a((GraphQLStory) feedProps.f13444a) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (graphQLStory.aG() != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                if (feedProps.m19807c() == null || !PageStoryType.GROUPER_ATTACHED_STORY.equals(PageStoryTypeResolver.m28081a((FeedProps) feedProps))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    return PageLikeActionLinkResolver.m14609a(StoryProps.m27456c(feedProps));
                }
                return null;
            }
        }
        return PageLikeActionLinkResolver.m14609a(graphQLStory);
    }
}
