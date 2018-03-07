package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;

/* compiled from: TV_GENERAL */
public class StoryCommerceHelper {
    private StoryCommerceHelper() {
    }

    public static GraphQLStoryAttachment m22575a(GraphQLStory graphQLStory) {
        for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.x()) {
            if (GraphQLStoryAttachmentUtil.g(graphQLStoryAttachment)) {
                return graphQLStoryAttachment;
            }
        }
        return null;
    }

    public static boolean m22580f(GraphQLStory graphQLStory) {
        for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.x()) {
            if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.GROUP_SELL_PRODUCT_ITEM_MARK_AS_SOLD)) {
                break;
            }
        }
        GraphQLStoryAttachment graphQLStoryAttachment2 = null;
        return graphQLStoryAttachment2 != null;
    }

    public static boolean m22576b(GraphQLStory graphQLStory) {
        return m22575a(graphQLStory) != null;
    }

    public static boolean m22577c(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment a = m22575a(graphQLStory);
        if (a == null) {
            return false;
        }
        return a.z().aB();
    }

    public static boolean m22578d(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment a = m22575a(graphQLStory);
        if (a == null || a.z() == null || a.z().dV()) {
            return false;
        }
        return true;
    }

    public static boolean m22579e(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment a = m22575a(graphQLStory);
        if (a == null || !a.z().hh() || a.z().dV()) {
            return false;
        }
        return true;
    }
}
