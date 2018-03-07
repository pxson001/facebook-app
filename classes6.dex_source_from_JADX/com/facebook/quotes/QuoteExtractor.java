package com.facebook.quotes;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import javax.annotation.Nullable;

/* compiled from: family_non_user_members */
public class QuoteExtractor {
    @Nullable
    public static String m22968a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.QUOTED_SHARE) && graphQLStoryAttachment.z() != null && graphQLStoryAttachment.z().go() != null) {
            return graphQLStoryAttachment.z().go().a();
        }
        if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, GraphQLStoryAttachmentStyle.QUOTE)) {
            return graphQLStoryAttachment.A();
        }
        return null;
    }
}
