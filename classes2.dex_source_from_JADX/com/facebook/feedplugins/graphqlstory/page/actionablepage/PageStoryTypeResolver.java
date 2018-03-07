package com.facebook.feedplugins.graphqlstory.page.actionablepage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;

/* compiled from: imagepipeline */
public class PageStoryTypeResolver {
    private PageStoryTypeResolver() {
    }

    public static PageStoryType m28081a(FeedProps<GraphQLStory> feedProps) {
        PageStoryType pageStoryType;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStory c = StoryProps.m27456c(feedProps);
        if (c == null || c.m22326L() != graphQLStory) {
            pageStoryType = PageStoryType.UNSET;
        } else {
            GraphQLStoryActionLink d = StoryActionLinkHelper.m28077d(c);
            if (!(d == null || d.m22901a() == null || -581184810 != d.m22901a().m22301g())) {
                d = PrimaryActionLinkResolver.m31292a(graphQLStory);
                if (d != null && d.m22901a() != null && (-581184810 == d.m22901a().m22301g() || -508788748 == d.m22901a().m22301g())) {
                    pageStoryType = PageStoryType.GROUPER_ATTACHED_STORY;
                } else if (!PageStoryType.OFFER.equals(m28082a(graphQLStory))) {
                    pageStoryType = PageStoryType.GROUPER_ATTACHED_STORY;
                }
            }
            pageStoryType = PageStoryType.UNSET;
        }
        PageStoryType pageStoryType2 = pageStoryType;
        if (pageStoryType2 != PageStoryType.UNSET) {
            return pageStoryType2;
        }
        GraphQLStory graphQLStory2 = (GraphQLStory) feedProps.f13444a;
        GraphQLStoryActionLink c2 = StoryActionLinkHelper.m28076c(graphQLStory2);
        GraphQLSponsoredData ay = graphQLStory2.ay();
        if (c2 != null && c2.m22901a() != null && -581184810 == c2.m22901a().m22301g()) {
            pageStoryType = PageStoryType.NCPP;
        } else if (ay == null || !ay.m24813m()) {
            pageStoryType = PageStoryType.UNSET;
        } else {
            pageStoryType = PageStoryType.NCPP;
        }
        PageStoryType pageStoryType3 = pageStoryType;
        if (pageStoryType3 != PageStoryType.UNSET) {
            return pageStoryType3;
        }
        pageStoryType3 = m28082a(graphQLStory2);
        if (pageStoryType3 != PageStoryType.UNSET) {
            return pageStoryType3;
        }
        c2 = StoryActionLinkHelper.m28077d(graphQLStory2);
        if (c2 == null || c2.m22901a() == null || -581184810 != c2.m22901a().m22301g()) {
            pageStoryType = PageStoryType.UNSET;
        } else {
            graphQLStory = graphQLStory2.m22326L();
            if (graphQLStory == null || !PageStoryType.OFFER.equals(m28082a(graphQLStory))) {
                pageStoryType = PageStoryType.GROUPER;
            } else {
                pageStoryType = PageStoryType.GROUPER_WITH_OFFER;
            }
        }
        pageStoryType2 = pageStoryType;
        return pageStoryType2 == PageStoryType.UNSET ? PageStoryType.OTHER : pageStoryType2;
    }

    public static PageStoryType m28082a(GraphQLStory graphQLStory) {
        GraphQLStoryActionLink e = StoryActionLinkHelper.m28078e(graphQLStory);
        GraphQLSponsoredData ay = graphQLStory.ay();
        if (e == null || e.m22901a() == null) {
            return PageStoryType.UNSET;
        }
        int g = e.m22901a().m22301g();
        if (-581184810 == g) {
            return (ay == null || !ay.m24813m()) ? PageStoryType.PAGE_LIKE : PageStoryType.NCPP;
        } else {
            if (-314375316 == g) {
                return PageStoryType.OFFER;
            }
            if (-508788748 == g) {
                return (ay == null || !ay.m24813m()) ? PageStoryType.OTHER : PageStoryType.NCPP;
            } else {
                return PageStoryType.UNSET;
            }
        }
    }
}
