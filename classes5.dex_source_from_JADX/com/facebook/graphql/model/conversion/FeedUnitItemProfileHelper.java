package com.facebook.graphql.model.conversion;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLCelebrationsFeedUnitItem;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendLocationFeedUnitItem;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnitItem;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitItem;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLSocialWifiFeedUnitItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import javax.annotation.Nullable;

/* compiled from: TURN_ON_PUSH */
public class FeedUnitItemProfileHelper {
    @Nullable
    public static GraphQLProfile m22599a(ItemListFeedUnitItem itemListFeedUnitItem) {
        if (itemListFeedUnitItem == null) {
            return null;
        }
        if (itemListFeedUnitItem instanceof GraphQLCelebrationsFeedUnitItem) {
            return GraphQLUserConversionHelper.m22614a(((GraphQLCelebrationsFeedUnitItem) itemListFeedUnitItem).m6751j());
        }
        if (itemListFeedUnitItem instanceof GraphQLCreativePagesYouMayLikeFeedUnitItem) {
            return GraphQLPageConversionHelper.m22612b(((GraphQLCreativePagesYouMayLikeFeedUnitItem) itemListFeedUnitItem).y());
        }
        if (itemListFeedUnitItem instanceof GraphQLFriendLocationFeedUnitItem) {
            return GraphQLUserConversionHelper.m22614a(((GraphQLFriendLocationFeedUnitItem) itemListFeedUnitItem).m7573o());
        }
        if (itemListFeedUnitItem instanceof GraphQLGroupsYouShouldJoinFeedUnitItem) {
            return GraphQLGroupConversionHelper.m22608a(((GraphQLGroupsYouShouldJoinFeedUnitItem) itemListFeedUnitItem).m8553m());
        }
        if (itemListFeedUnitItem instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) {
            return GraphQLGroupConversionHelper.m22608a(((GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) itemListFeedUnitItem).m20603l());
        }
        if (itemListFeedUnitItem instanceof GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) {
            return GraphQLGroupConversionHelper.m22608a(((GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) itemListFeedUnitItem).m21523j());
        }
        if (itemListFeedUnitItem instanceof GraphQLInstagramPhotosFromFriendsFeedUnitItem) {
            return ((GraphQLInstagramPhotosFromFriendsFeedUnitItem) itemListFeedUnitItem).m8713j();
        }
        if (itemListFeedUnitItem instanceof GraphQLPagesYouMayLikeFeedUnitItem) {
            return GraphQLPageConversionHelper.m22612b(((GraphQLPagesYouMayLikeFeedUnitItem) itemListFeedUnitItem).m20565u());
        }
        if (itemListFeedUnitItem instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) {
            return GraphQLUserConversionHelper.m22614a(((GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge) itemListFeedUnitItem).m());
        }
        if (itemListFeedUnitItem instanceof GraphQLPeopleYouMayKnowFeedUnitItem) {
            return GraphQLUserConversionHelper.m22614a(((GraphQLPeopleYouMayKnowFeedUnitItem) itemListFeedUnitItem).m20682m());
        }
        if (itemListFeedUnitItem instanceof GraphQLPYMLWithLargeImageFeedUnitItem) {
            return GraphQLPageConversionHelper.m22612b(((GraphQLPYMLWithLargeImageFeedUnitItem) itemListFeedUnitItem).D());
        }
        if (itemListFeedUnitItem instanceof GraphQLSocialWifiFeedUnitItem) {
            return GraphQLPageConversionHelper.m22612b(((GraphQLSocialWifiFeedUnitItem) itemListFeedUnitItem).m21679a());
        }
        if (itemListFeedUnitItem instanceof GraphQLPeopleYouShouldFollowFeedUnitItem) {
            return GraphQLUserConversionHelper.m22614a(((GraphQLPeopleYouShouldFollowFeedUnitItem) itemListFeedUnitItem).m20702m());
        }
        if (itemListFeedUnitItem instanceof GraphQLStory) {
            GraphQLActor b = StoryActorHelper.b((GraphQLStory) itemListFeedUnitItem);
            if (b != null) {
                return ActorToProfileConverter.m22598a(b);
            }
            return null;
        }
        BLog.c("FeedUnitItemProfileHelper", "Should not call getProfileAsProfileForFeedUnitItem() function bypassing in non-customized feed unit item type");
        return null;
    }
}
