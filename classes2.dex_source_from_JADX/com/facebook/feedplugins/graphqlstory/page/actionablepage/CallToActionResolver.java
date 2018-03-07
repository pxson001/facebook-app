package com.facebook.feedplugins.graphqlstory.page.actionablepage;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.InjectorLike;

/* compiled from: same_story_on_top_logging_allowed */
public class CallToActionResolver {
    public static CallToActionResolver m10678a(InjectorLike injectorLike) {
        return new CallToActionResolver();
    }

    public final boolean m10679a(GraphQLStory graphQLStory) {
        Object obj;
        GraphQLStoryActionLink e = StoryActionLinkHelper.m28078e(graphQLStory);
        if (ActionablePageLinkAnalyzer.m28080b(e) && ActionablePageLinkAnalyzer.m28079a(e)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            boolean z = false;
            GraphQLStoryActionLink d = StoryActionLinkHelper.m28077d(graphQLStory);
            if (ActionablePageLinkAnalyzer.m28080b(d) && -581184810 == d.m22901a().m22301g() && graphQLStory.m22326L() != null) {
                d = PrimaryActionLinkResolver.m31292a(graphQLStory.m22326L());
                if (ActionablePageLinkAnalyzer.m28080b(d) && ActionablePageLinkAnalyzer.m28079a(d)) {
                    z = m10679a(graphQLStory.m22326L());
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
