package com.facebook.ufiservices.flyout;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLModels.UFIProfileListFragmentGraphQLModel.ProfilePictureModel;
import com.facebook.ufiservices.flyout.views.FlyoutLikerViewGraphQLInterfaces$FlyoutLikerViewGraphQL;
import com.facebook.ufiservices.ui.ProfileListFragmentGraphQLInterfaces$ProfileListFragmentGraphQL;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel.MutualFriendsModel;
import javax.annotation.Nullable;

/* compiled from: native_sd */
public interface C0346x25f16e6a extends FlyoutLikerViewGraphQLInterfaces$FlyoutLikerViewGraphQL, ProfileListFragmentGraphQLInterfaces$ProfileListFragmentGraphQL {
    @Nullable
    String C_();

    @Nullable
    MutualFriendsModel mo606b();

    @Nullable
    GraphQLObjectType mo607c();

    @Nullable
    GraphQLFriendshipStatus mo608d();

    @Nullable
    ProfilePictureModel dF_();

    @Nullable
    String mo611g();

    @Nullable
    String mo612j();
}
