package com.facebook.feed.rows.sections.attachments.calltoaction;

import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: WRITE_POST */
public class AttachmentRatingHelper {
    private AttachmentRatingHelper() {
    }

    public static boolean m23810a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().gq() == null || graphQLStoryAttachment.z().gq().j() == 0 || ((float) graphQLStoryAttachment.z().gq().k()) == 0.0f) ? false : true;
    }

    public static int m23811b(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().gq() == null) ? 0 : graphQLStoryAttachment.z().gq().j();
    }

    public static float m23812c(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().gq() == null) ? 0.0f : (float) graphQLStoryAttachment.z().gq().k();
    }
}
