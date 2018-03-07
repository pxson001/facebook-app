package com.facebook.redspace.data;

import android.support.annotation.Nullable;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.ActorModel.RedspaceModel.RecentStoryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.RedspaceModel.FriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpacePageInfoModel;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: PrivacyCheckupSingleStepActivity started without type */
public class RedSpaceFriendsFetchResult {
    public final Collection<RedSpaceFeedProfileFragmentModel> f11777a;
    public final OverflowFriendsModel f11778b;
    public final RedSpacePageInfoModel f11779c;
    public final RecentStoryModel f11780d;

    public RedSpaceFriendsFetchResult(Collection<RedSpaceFeedProfileFragmentModel> collection, RedSpacePageInfoModel redSpacePageInfoModel, OverflowFriendsModel overflowFriendsModel, RecentStoryModel recentStoryModel) {
        this.f11777a = collection;
        this.f11778b = overflowFriendsModel;
        this.f11779c = redSpacePageInfoModel;
        this.f11780d = recentStoryModel;
    }

    public static RedSpaceFriendsFetchResult m12225a(@Nullable GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult, @Nullable GraphQLResult<RedSpaceFriendsOverflowCountQueryModel> graphQLResult2) {
        RedSpacePageInfoModel redSpacePageInfoModel;
        Collection collection;
        RecentStoryModel recentStoryModel;
        if (graphQLResult == null || graphQLResult.e == null || ((RedSpaceFriendsQueryModel) graphQLResult.e).j() == null || ((RedSpaceFriendsQueryModel) graphQLResult.e).j().a() == null) {
            redSpacePageInfoModel = null;
            collection = null;
        } else {
            FriendsModel a = ((RedSpaceFriendsQueryModel) graphQLResult.e).j().a();
            ImmutableList a2 = a.a();
            redSpacePageInfoModel = a.j();
            collection = a2;
        }
        if (graphQLResult == null || graphQLResult.e == null || ((RedSpaceFriendsQueryModel) graphQLResult.e).a() == null || ((RedSpaceFriendsQueryModel) graphQLResult.e).a().a() == null) {
            recentStoryModel = null;
        } else {
            recentStoryModel = ((RedSpaceFriendsQueryModel) graphQLResult.e).a().a().a();
        }
        OverflowFriendsModel a3 = (graphQLResult2 == null || graphQLResult2.e == null || ((RedSpaceFriendsOverflowCountQueryModel) graphQLResult2.e).a() == null) ? null : ((RedSpaceFriendsOverflowCountQueryModel) graphQLResult2.e).a().a();
        return new RedSpaceFriendsFetchResult(collection, redSpacePageInfoModel, a3, recentStoryModel);
    }
}
