package com.facebook.feed.permalink;

import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.widget.titlebar.HasTitleBar;

/* compiled from: advertising_id */
public class PermalinkRenderUtils {
    public static void m22911a(HasTitleBar hasTitleBar, FeedUnit feedUnit, FeedUnitDataController feedUnitDataController) {
        if (hasTitleBar != null && feedUnit != null) {
            hasTitleBar.kg_();
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (graphQLStory.aJ() != null && graphQLStory.aJ().j() != null && graphQLStory.aJ().b() != null) {
                    hasTitleBar.y_(2131233576);
                } else if (graphQLStory.L() != null) {
                    hasTitleBar.y_(2131233577);
                } else if (feedUnitDataController.a(graphQLStory).s) {
                    hasTitleBar.y_(2131233578);
                } else {
                    for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.x()) {
                        if (!StringUtil.a(graphQLStoryAttachment.A())) {
                            hasTitleBar.a_(graphQLStoryAttachment.A());
                            break;
                        }
                    }
                    hasTitleBar.y_(2131233576);
                }
            } else if (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit) {
                hasTitleBar.y_(2131233579);
            }
        }
    }
}
