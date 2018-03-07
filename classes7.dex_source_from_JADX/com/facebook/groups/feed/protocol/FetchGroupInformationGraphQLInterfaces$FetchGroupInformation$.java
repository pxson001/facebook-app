package com.facebook.groups.feed.protocol;

import com.facebook.annotationprocessors.transformer.api.Clone;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLInterfaces.GroupSellInformation;
import com.facebook.groupcommerce.protocol.GroupSellInformationGraphQLModels.GroupSellInformationModel.GroupSellConfigModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.FetchGroupInformation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupPinnedPost;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupSuggestionTips;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerInviteInformation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupHeaderInformationModel.GroupConfigsModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupPinnedPostModel.GroupPinnedStoriesModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupSuggestionTipsModel.TipsChannelModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.GroupViewerInviteInformationModel.ViewerInviteToGroupModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLInterfaces.GroupPurposesInformation;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.GroupPurposesModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.SuggestedPurposeModel;
import javax.annotation.Nullable;

@Clone(from = "FetchGroupInformation", processor = "com.facebook.dracula.transformer.Transformer")
/* compiled from: ratingComment */
public interface FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ extends GroupSellInformation, FetchGroupInformation, FetchGroupInformationGraphQLInterfaces$GroupHeaderInformation$, GroupPinnedPost, GroupSuggestionTips, GroupViewerInviteInformation, GroupViewerStatus, GroupPurposesInformation {
    @Clone(from = "getAdminAwareGroup", processor = "com.facebook.dracula.transformer.Transformer")
    @Nullable
    DraculaReturnValue mo289b();

    boolean mo290c();

    @Clone(from = "getGroupConfigs", processor = "com.facebook.dracula.transformer.Transformer")
    @Nullable
    GroupConfigsModel mo291d();

    @Nullable
    GroupPurposesModel mo292g();

    @Nullable
    String gW_();

    @Nullable
    GroupSellConfigModel gX_();

    @Nullable
    GroupPinnedStoriesModel gY_();

    boolean mo296j();

    @Nullable
    GraphQLSubscribeStatus mo297k();

    @Nullable
    SuggestedPurposeModel mo298l();

    @Nullable
    TipsChannelModel mo299m();

    @Nullable
    GraphQLGroupAdminType mo287n();

    @Nullable
    ViewerInviteToGroupModel mo300o();

    @Nullable
    GraphQLGroupJoinState mo288p();

    @Nullable
    GraphQLGroupPostStatus mo301q();
}
