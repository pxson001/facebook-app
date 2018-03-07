package com.facebook.graphql.linkutil;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: WWW_CHAT_HOVERCARD */
public class GraphQLLinkExtractorGraphQLInterfaces {

    /* compiled from: WWW_CHAT_HOVERCARD */
    public interface LinkableTextWithEntities {
        @Nullable
        String mo1227a();

        @Nonnull
        ImmutableList<? extends LinkableTextWithEntitiesRange> mo1228b();
    }

    /* compiled from: WWW_CHAT_HOVERCARD */
    public interface LinkableTextWithEntitiesRange {
        @Nullable
        GetEntityFbLinkGraphQL mo1229a();

        int mo1230b();

        int mo1231c();
    }
}
