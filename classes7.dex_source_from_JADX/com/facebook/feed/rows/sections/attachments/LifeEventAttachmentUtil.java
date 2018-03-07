package com.facebook.feed.rows.sections.attachments;

import com.facebook.graphql.model.GraphQLAttachmentProperty;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.collect.ImmutableList;

/* compiled from: ZTE; */
public class LifeEventAttachmentUtil {
    private LifeEventAttachmentUtil() {
    }

    public static GraphQLTextWithEntities m23682a(GraphQLStoryAttachment graphQLStoryAttachment, String str) {
        ImmutableList l = graphQLStoryAttachment.l();
        for (int size = l.size() - 1; size >= 0; size--) {
            GraphQLAttachmentProperty graphQLAttachmentProperty = (GraphQLAttachmentProperty) l.get(size);
            if (str.equals(graphQLAttachmentProperty.j())) {
                return graphQLAttachmentProperty.m();
            }
        }
        return null;
    }
}
