package com.facebook.ufiservices.util;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ProfilePicture;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: gql_notifications/# */
public interface LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL {

    /* compiled from: gql_notifications/# */
    public interface Ranges extends C0883x3380bccd, C0884x53bd6f74, LinkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL, C0885xba9ef6ad {

        /* compiled from: gql_notifications/# */
        public interface Entity extends GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, com.facebook.ufiservices.util.C0883x3380bccd.Entity, com.facebook.ufiservices.util.C0884x53bd6f74.Entity, com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.Entity, C0889x95241f73, com.facebook.ufiservices.util.C0885xba9ef6ad.Entity {

            /* compiled from: gql_notifications/# */
            public interface Page extends com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL.Page, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL {
                @Nullable
                String C_();

                @Nullable
                String D_();

                @Nullable
                ProfilePicture ad_();

                @Nullable
                GraphQLObjectType mo3202b();

                @Nullable
                String mo3203d();
            }

            @Nullable
            GraphQLObjectType mo3202b();

            @Nonnull
            ImmutableList<String> mo3233c();

            @Nullable
            Page mo3239n();
        }

        int mo3226b();

        int mo3227c();

        @Nullable
        Entity mo3228d();
    }

    @Nullable
    String mo3223a();

    @Nonnull
    ImmutableList<? extends Ranges> mo3224b();
}
