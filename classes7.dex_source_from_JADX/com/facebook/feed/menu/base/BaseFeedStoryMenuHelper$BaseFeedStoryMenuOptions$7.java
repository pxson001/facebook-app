package com.facebook.feed.menu.base;

import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.google.common.base.Predicate;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$7 implements Predicate<GraphQLStoryAttachment> {
    final /* synthetic */ BaseFeedStoryMenuOptions f19432a;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$7(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions) {
        this.f19432a = baseFeedStoryMenuOptions;
    }

    public boolean apply(Object obj) {
        return GraphQLStoryAttachmentUtil.g((GraphQLStoryAttachment) obj);
    }
}
