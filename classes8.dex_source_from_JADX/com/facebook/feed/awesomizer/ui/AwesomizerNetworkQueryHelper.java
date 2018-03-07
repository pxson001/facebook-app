package com.facebook.feed.awesomizer.ui;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams.Builder;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQL.FeedAwesomizerDiscoverCardQueryString;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQL.FeedAwesomizerDiscoverTopicQueryString;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQL.FeedAwesomizerFollowingQueryString;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQL.FeedAwesomizerSeefirstCardQueryString;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQL.FeedAwesomizerUnfollowingQueryString;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel.NodeModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.NodesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.calls.GroupSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.GroupUnsubscribeInputData;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: handler_time */
public class AwesomizerNetworkQueryHelper {
    public final Lazy<FriendingClient> f11783a;
    public final GraphQLQueryExecutor f11784b;
    public final Lazy<GroupsClient> f11785c;
    private final Lazy<ModernFeedbackGraphQLGenerator> f11786d;
    private final Provider<GraphQLActorCache> f11787e;
    public final TasksManager f11788f;
    private final Executor f11789g;

    /* compiled from: handler_time */
    public class C12611 implements Callable<ListenableFuture> {
        final /* synthetic */ int f11763a;
        final /* synthetic */ String f11764b;
        final /* synthetic */ AwesomizerNetworkQueryHelper f11765c;

        public Object call() {
            TypedGraphQlQueryString feedAwesomizerFollowingQueryString = new FeedAwesomizerFollowingQueryString();
            feedAwesomizerFollowingQueryString.a("num_profiles", Integer.valueOf(this.f11763a));
            AwesomizerNetworkQueryHelper.m13869b(feedAwesomizerFollowingQueryString);
            if (this.f11764b != null) {
                feedAwesomizerFollowingQueryString.a("after_cursor", this.f11764b);
            }
            return this.f11765c.f11784b.a(GraphQLRequest.a(feedAwesomizerFollowingQueryString));
        }

        public C12611(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, int i, String str) {
            this.f11765c = awesomizerNetworkQueryHelper;
            this.f11763a = i;
            this.f11764b = str;
        }
    }

    /* compiled from: handler_time */
    public class C12622 implements Callable<ListenableFuture> {
        final /* synthetic */ int f11766a;
        final /* synthetic */ String f11767b;
        final /* synthetic */ AwesomizerNetworkQueryHelper f11768c;

        public Object call() {
            TypedGraphQlQueryString feedAwesomizerUnfollowingQueryString = new FeedAwesomizerUnfollowingQueryString();
            feedAwesomizerUnfollowingQueryString.a("num_profiles", Integer.valueOf(this.f11766a));
            AwesomizerNetworkQueryHelper.m13869b(feedAwesomizerUnfollowingQueryString);
            if (this.f11767b != null) {
                feedAwesomizerUnfollowingQueryString.a("after_cursor", this.f11767b);
            }
            return this.f11768c.f11784b.a(GraphQLRequest.a(feedAwesomizerUnfollowingQueryString));
        }

        public C12622(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, int i, String str) {
            this.f11768c = awesomizerNetworkQueryHelper;
            this.f11766a = i;
            this.f11767b = str;
        }
    }

    /* compiled from: handler_time */
    public class C12633 implements Callable<ListenableFuture> {
        final /* synthetic */ int f11769a;
        final /* synthetic */ String f11770b;
        final /* synthetic */ AwesomizerNetworkQueryHelper f11771c;

        public C12633(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, int i, String str) {
            this.f11771c = awesomizerNetworkQueryHelper;
            this.f11769a = i;
            this.f11770b = str;
        }

        public Object call() {
            TypedGraphQlQueryString feedAwesomizerSeefirstCardQueryString = new FeedAwesomizerSeefirstCardQueryString();
            feedAwesomizerSeefirstCardQueryString.a("num_profiles", Integer.valueOf(this.f11769a));
            AwesomizerNetworkQueryHelper.m13869b(feedAwesomizerSeefirstCardQueryString);
            if (this.f11770b != null) {
                feedAwesomizerSeefirstCardQueryString.a("after_cursor", this.f11770b);
            }
            return this.f11771c.f11784b.a(GraphQLRequest.a(feedAwesomizerSeefirstCardQueryString));
        }
    }

    public static AwesomizerNetworkQueryHelper m13867b(InjectorLike injectorLike) {
        return new AwesomizerNetworkQueryHelper(IdBasedLazy.a(injectorLike, 2073), GraphQLQueryExecutor.a(injectorLike), IdBasedLazy.a(injectorLike, 7066), IdBasedLazy.a(injectorLike, 997), IdBasedSingletonScopeProvider.a(injectorLike, 262), TasksManager.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AwesomizerNetworkQueryHelper(Lazy<FriendingClient> lazy, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<GroupsClient> lazy2, Lazy<ModernFeedbackGraphQLGenerator> lazy3, Provider<GraphQLActorCache> provider, TasksManager tasksManager, Executor executor) {
        this.f11783a = lazy;
        this.f11784b = graphQLQueryExecutor;
        this.f11785c = lazy2;
        this.f11786d = lazy3;
        this.f11787e = provider;
        this.f11788f = tasksManager;
        this.f11789g = executor;
    }

    public final void m13875a(AbstractDisposableFutureCallback abstractDisposableFutureCallback, int i, int i2, int i3, int i4) {
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        this.f11788f.a("QUERY_AWESOMIZER_DISCOVER_TASK_ID", new Callable<ListenableFuture>(this) {
            final /* synthetic */ AwesomizerNetworkQueryHelper f11776e;

            public Object call() {
                TypedGraphQlQueryString feedAwesomizerDiscoverCardQueryString = new FeedAwesomizerDiscoverCardQueryString();
                feedAwesomizerDiscoverCardQueryString.a("num_page_profiles", Integer.valueOf(i5));
                feedAwesomizerDiscoverCardQueryString.a("min_suggested_page_count", Integer.valueOf(i6));
                feedAwesomizerDiscoverCardQueryString.a("num_connected_friends", Integer.valueOf(i7));
                feedAwesomizerDiscoverCardQueryString.a("connected_friends_profile_picture_size", Integer.valueOf(i8));
                AwesomizerNetworkQueryHelper.m13869b(feedAwesomizerDiscoverCardQueryString);
                return this.f11776e.f11784b.a(GraphQLRequest.a(feedAwesomizerDiscoverCardQueryString));
            }
        }, abstractDisposableFutureCallback);
    }

    public final void m13876a(AbstractDisposableFutureCallback abstractDisposableFutureCallback, String str, int i, int i2, int i3, @Nullable String str2) {
        final String str3 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final String str4 = str2;
        this.f11788f.a("QUERY_AWESOMIZER_DISCOVER_TOPIC_TASK_ID", new Callable<ListenableFuture>(this) {
            final /* synthetic */ AwesomizerNetworkQueryHelper f11782f;

            public Object call() {
                TypedGraphQlQueryString feedAwesomizerDiscoverTopicQueryString = new FeedAwesomizerDiscoverTopicQueryString();
                feedAwesomizerDiscoverTopicQueryString.a("topic_id", str3);
                feedAwesomizerDiscoverTopicQueryString.a("num_profiles", Integer.valueOf(i4));
                feedAwesomizerDiscoverTopicQueryString.a("num_connected_friends", Integer.valueOf(i5));
                feedAwesomizerDiscoverTopicQueryString.a("connected_friends_profile_picture_size", Integer.valueOf(i6));
                if (str4 != null) {
                    feedAwesomizerDiscoverTopicQueryString.a("after_cursor", str4);
                }
                AwesomizerNetworkQueryHelper.m13869b(feedAwesomizerDiscoverTopicQueryString);
                return this.f11782f.f11784b.a(GraphQLRequest.a(feedAwesomizerDiscoverTopicQueryString));
            }
        }, abstractDisposableFutureCallback);
    }

    public final FollowedProfilesModel m13871a(FollowedProfilesModel followedProfilesModel, EdgesModel edgesModel, FutureCallback futureCallback) {
        Preconditions.checkNotNull(followedProfilesModel);
        if (edgesModel == null || edgesModel.m13664a() == null || edgesModel.m13664a().m13541o() == null || edgesModel.m13664a().m13536j() == null) {
            return followedProfilesModel;
        }
        GraphQLSubscribeStatus o = edgesModel.m13664a().m13541o();
        ListenableFuture a = m13865a(o, edgesModel.m13664a().m13536j().g(), Long.valueOf(Long.parseLong(edgesModel.m13664a().m13539m())));
        followedProfilesModel = AwesomizerMutator.m13859a(followedProfilesModel, edgesModel, m13864a(o));
        Futures.a(a, futureCallback, this.f11789g);
        return followedProfilesModel;
    }

    public final UnfollowedProfilesModel m13873a(UnfollowedProfilesModel unfollowedProfilesModel, UnfollowedProfilesModel.EdgesModel edgesModel, FutureCallback futureCallback) {
        Preconditions.checkNotNull(unfollowedProfilesModel);
        if (edgesModel == null || edgesModel.m13753a() == null || edgesModel.m13753a().m13541o() == null || edgesModel.m13753a().m13536j() == null) {
            return unfollowedProfilesModel;
        }
        GraphQLSubscribeStatus o = edgesModel.m13753a().m13541o();
        ListenableFuture a = m13865a(o, edgesModel.m13753a().m13536j().g(), Long.valueOf(Long.parseLong(edgesModel.m13753a().m13539m())));
        unfollowedProfilesModel = AwesomizerMutator.m13861a(unfollowedProfilesModel, edgesModel, m13864a(o));
        Futures.a(a, futureCallback, this.f11789g);
        return unfollowedProfilesModel;
    }

    public final FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel m13872a(FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel followedProfilesModel, FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.EdgesModel edgesModel, FutureCallback futureCallback) {
        Preconditions.checkNotNull(followedProfilesModel);
        if (edgesModel == null || edgesModel.m13724a() == null) {
            return followedProfilesModel;
        }
        GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus;
        NewStatus newStatus;
        Long valueOf = Long.valueOf(Long.parseLong(edgesModel.m13724a().m13712m()));
        if (edgesModel.m13724a().m13714o() == GraphQLSecondarySubscribeStatus.SEE_FIRST) {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
            newStatus = NewStatus.REGULAR_FOLLOW;
        } else {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.SEE_FIRST;
            newStatus = NewStatus.SEE_FIRST;
        }
        ListenableFuture a = ((FriendingClient) this.f11783a.get()).a(String.valueOf(valueOf), newStatus, Location.FEED_AWESOMIZER_SEE_FIRST_CARD);
        followedProfilesModel = AwesomizerMutator.m13860a(followedProfilesModel, edgesModel, graphQLSecondarySubscribeStatus);
        Futures.a(a, futureCallback, this.f11789g);
        return followedProfilesModel;
    }

    public final ImmutableList<PageTopicsByCountModel> m13874a(ImmutableList<PageTopicsByCountModel> immutableList, NodeModel nodeModel, FutureCallback<OperationResult> futureCallback) {
        Preconditions.checkNotNull(immutableList);
        if (nodeModel == null || nodeModel.m13591m() == null || nodeModel.m13593o() == null) {
            return immutableList;
        }
        Futures.a(m13866a(nodeModel.m13593o() != GraphQLSubscribeStatus.IS_SUBSCRIBED, Long.valueOf(Long.parseLong(nodeModel.m13591m()))), futureCallback, this.f11789g);
        return AwesomizerMutator.m13862a((ImmutableList) immutableList, nodeModel, m13868b(nodeModel.m13593o()));
    }

    public final SuggestedPagesModel m13870a(SuggestedPagesModel suggestedPagesModel, NodesModel nodesModel, FutureCallback<OperationResult> futureCallback) {
        Preconditions.checkNotNull(suggestedPagesModel);
        if (nodesModel == null || nodesModel.m13632m() == null || nodesModel.m13634o() == null) {
            return suggestedPagesModel;
        }
        Futures.a(m13866a(nodesModel.m13634o() != GraphQLSubscribeStatus.IS_SUBSCRIBED, Long.valueOf(Long.parseLong(nodesModel.m13632m()))), futureCallback, this.f11789g);
        return AwesomizerMutator.m13858a(suggestedPagesModel, nodesModel, m13868b(nodesModel.m13634o()));
    }

    private ListenableFuture<Void> m13865a(GraphQLSubscribeStatus graphQLSubscribeStatus, int i, Long l) {
        ListenableFuture<Void> a;
        if (i == 69076575) {
            if (graphQLSubscribeStatus == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
                a = ((GroupsClient) this.f11785c.get()).m16965a(String.valueOf(l), SubscribeLocation.FEED_AWESOMIZER_FOLLOW_CARD);
            } else {
                a = ((GroupsClient) this.f11785c.get()).m16966a(String.valueOf(l), GroupUnsubscribeInputData.SubscribeLocation.FEED_AWESOMIZER_FOLLOW_CARD);
            }
            return a;
        }
        if (graphQLSubscribeStatus == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
            a = ((FriendingClient) this.f11783a.get()).a(String.valueOf(l), ActorSubscribeInputData.SubscribeLocation.FEED_AWESOMIZER_FOLLOW_CARD);
        } else {
            a = ((FriendingClient) this.f11783a.get()).a(String.valueOf(l), ActorUnsubscribeInputData.SubscribeLocation.FEED_AWESOMIZER_FOLLOW_CARD);
        }
        return a;
    }

    private ListenableFuture<OperationResult> m13866a(boolean z, Long l) {
        ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator = (ModernFeedbackGraphQLGenerator) this.f11786d.get();
        Builder a = TogglePageLikeParams.a();
        a.c = ((GraphQLActorCacheImpl) this.f11787e.get()).a();
        Builder builder = a;
        builder.b = z;
        builder = builder;
        builder.a = String.valueOf(l);
        builder = builder;
        builder.e = "awesomizer_discovery";
        builder = builder;
        FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
        builder2.c = "pages_identity";
        builder.d = builder2.a();
        return modernFeedbackGraphQLGenerator.a(builder.a());
    }

    private static GraphQLSubscribeStatus m13864a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (graphQLSubscribeStatus == GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
            return GraphQLSubscribeStatus.IS_SUBSCRIBED;
        }
        return GraphQLSubscribeStatus.CAN_SUBSCRIBE;
    }

    private static GraphQLSubscribeStatus m13868b(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (graphQLSubscribeStatus == GraphQLSubscribeStatus.CANNOT_SUBSCRIBE) {
            return GraphQLSubscribeStatus.IS_SUBSCRIBED;
        }
        return GraphQLSubscribeStatus.CANNOT_SUBSCRIBE;
    }

    public static void m13869b(TypedGraphQlQueryString typedGraphQlQueryString) {
        typedGraphQlQueryString.a("profile_picture_scale", Integer.valueOf(1));
        typedGraphQlQueryString.a("profile_picture_size", Integer.valueOf(120));
    }
}
