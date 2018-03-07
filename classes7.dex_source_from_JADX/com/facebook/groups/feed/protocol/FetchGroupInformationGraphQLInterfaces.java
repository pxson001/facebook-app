package com.facebook.groups.feed.protocol;

import com.facebook.annotationprocessors.transformer.api.Stub;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLInterfaces.GroupSellInformation;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLInterfaces.GroupPurposesInformation;
import javax.annotation.Nullable;

/* compiled from: ratingComment */
public class FetchGroupInformationGraphQLInterfaces {

    /* compiled from: ratingComment */
    public interface GroupPinnedPost {
    }

    /* compiled from: ratingComment */
    public interface GroupSuggestionTips {
    }

    /* compiled from: ratingComment */
    public interface GroupViewerInviteInformation {
    }

    /* compiled from: ratingComment */
    public interface GroupViewerStatus {
        @Nullable
        GraphQLGroupAdminType mo287n();

        @Nullable
        GraphQLGroupJoinState mo288p();
    }

    @Stub(processor = "com.facebook.dracula.transformer.Transformer", to = "FetchGroupInformation$")
    public interface FetchGroupInformation extends GroupSellInformation, GroupPinnedPost, GroupSuggestionTips, GroupViewerInviteInformation, GroupViewerStatus, GroupPurposesInformation {
    }
}
