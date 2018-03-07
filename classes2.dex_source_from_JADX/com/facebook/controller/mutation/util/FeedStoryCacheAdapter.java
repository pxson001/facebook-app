package com.facebook.controller.mutation.util;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_user_accepted_reply_dialog_key */
public class FeedStoryCacheAdapter {
    public final Lazy<FeedStoryMutator> f9574a;
    public final Clock f9575b;

    public static FeedStoryCacheAdapter m14594b(InjectorLike injectorLike) {
        return new FeedStoryCacheAdapter(IdBasedLazy.m1808a(injectorLike, 994), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public FeedStoryCacheAdapter(Lazy<FeedStoryMutator> lazy, Clock clock) {
        this.f9574a = lazy;
        this.f9575b = clock;
    }

    final StoryVisitor m14595a(String str, GraphQLStory graphQLStory) {
        return new 4(this, str, graphQLStory);
    }

    final StoryVisitor m14596a(String str, ProductItemAttachment productItemAttachment) {
        Preconditions.checkNotNull(productItemAttachment);
        Preconditions.checkNotNull(str);
        return new 5(this, str, productItemAttachment);
    }

    final StoryVisitor m14597a(String str, boolean z) {
        Preconditions.checkNotNull(str);
        return new 6(this, str, z);
    }

    final CacheVisitor m14598a(String str, @Nullable GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        return new 13(this, str, graphQLPaginatedPeopleYouMayKnowFeedUnit);
    }

    final CacheVisitor m14599a(String str, @Nullable GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        return new 14(this, str, graphQLPeopleYouMayInviteFeedUnit);
    }

    final CacheVisitor m14600a(String str, @Nullable GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        return new 15(this, str, graphQLPeopleYouShouldFollowFeedUnit);
    }
}
