package com.facebook.composer.publish.helpers;

import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: contacts_upload_failed */
public class TopicFeedsHelper {
    public static ImmutableList<String> m20848a(ProvidesTopics providesTopics) {
        if (providesTopics.af() == null || providesTopics.af().isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList af = providesTopics.af();
        int size = af.size();
        for (int i = 0; i < size; i++) {
            builder.c(((GraphQLExploreFeed) af.get(i)).n());
        }
        return builder.b();
    }
}
