package com.facebook.ufiservices.util;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;

/* compiled from: gravity_settings */
public class FeedMultiPhotoGridHelper {
    public static boolean m29587a(GraphQLStory graphQLStory) {
        if (graphQLStory == null || !StoryAttachmentHelper.m28035h(graphQLStory)) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        for (GraphQLStoryAttachment graphQLStoryAttachment : StoryAttachmentHelper.m28036i(graphQLStory)) {
            if (m29589b(graphQLStoryAttachment)) {
                int i3;
                i2++;
                Object obj = null;
                if (m29589b(graphQLStoryAttachment)) {
                    GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.m28047a(graphQLStoryAttachment);
                    if (a != null && a.m27613o() > 0 && a.m27612n() > 0) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i = i3;
            }
        }
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public static boolean m29588b(GraphQLStory graphQLStory) {
        if (graphQLStory == null || !StoryAttachmentHelper.m28035h(graphQLStory)) {
            return false;
        }
        int i = 0;
        for (GraphQLStoryAttachment graphQLStoryAttachment : StoryAttachmentHelper.m28036i(graphQLStory)) {
            int i2;
            if (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24453j() == null || graphQLStoryAttachment.m23979r().m24453j().m22301g() != 77090322) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            if (i2 == 2) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public static boolean m29589b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24453j() == null || graphQLStoryAttachment.m23979r().m24453j().m22301g() != 77090322) {
            return false;
        }
        return true;
    }
}
