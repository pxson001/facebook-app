package com.facebook.feedplugins.links;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.links.AttachmentLinkInspector;
import com.google.common.base.Strings;

/* compiled from: SUGGESTED_TEXT_ONLY */
public class AttachmentCallToActionButtonLinkUtils {
    public static String m25764a(FeedProps<GraphQLStoryAttachment> feedProps, AttachmentLinkInspector attachmentLinkInspector) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -508788748);
        return (a == null || Strings.isNullOrEmpty(a.aE())) ? attachmentLinkInspector.a(feedProps) : a.aE();
    }
}
