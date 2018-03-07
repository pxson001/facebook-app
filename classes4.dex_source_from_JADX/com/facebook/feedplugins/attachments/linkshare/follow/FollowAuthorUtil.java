package com.facebook.feedplugins.attachments.linkshare.follow;

import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: device_locale */
public class FollowAuthorUtil {
    private FollowAuthorUtil() {
    }

    public static boolean m14665a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
            Object obj = (a == null || a.a() == null || a.a().g() != -26657472 || a.ah() == null || a.ah().j() == null || a.Y() == null) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
