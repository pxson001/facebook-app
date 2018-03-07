package com.facebook.feed.rows.sections.attachments;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: [\D] */
public final class AttachmentTextPersistentStateId {
    public static String m23586a(GraphQLStory graphQLStory, String str) {
        return "attachment:text" + m23585a(graphQLStory) + graphQLStory.T_() + str;
    }

    public static String m23585a(GraphQLStory graphQLStory) {
        return graphQLStory.g() != null ? graphQLStory.g() : String.valueOf(graphQLStory.V());
    }
}
