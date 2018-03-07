package com.facebook.feed.rows.sections.attachments;

import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLeadGenDeepLinkUserStatus;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: device_type */
public class AngoraAttachmentUtil {
    private AngoraAttachmentUtil() {
    }

    public static GraphQLImage m14642a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return graphQLStoryAttachment.z() != null ? graphQLStoryAttachment.z().gi() : null;
    }

    public static boolean m14643b(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, 1185006756);
        if (a == null) {
            return false;
        }
        GraphQLLeadGenDeepLinkUserStatus O = a.O();
        if (O == null || O.j()) {
            return false;
        }
        return true;
    }
}
