package com.facebook.graphql.linkutil;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL.RedirectionInfo;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: gps */
public interface GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL extends GraphQLLinkExtractorGraphQLInterfaces$GetRedirectionLinkGraphQL {

    /* compiled from: gps */
    public interface Page {
        @Nullable
        String mo3203d();
    }

    @Nullable
    String C_();

    @Nullable
    String D_();

    @Nullable
    GraphQLObjectType mo3202b();

    @Nullable
    String mo3203d();

    @Nullable
    String mo3234g();

    @Nullable
    Page mo3235j();

    @Nonnull
    ImmutableList<? extends RedirectionInfo> mo3236k();
}
