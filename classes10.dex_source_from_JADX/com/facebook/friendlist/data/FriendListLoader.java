package com.facebook.friendlist.data;

import android.util.Pair;
import com.facebook.common.time.Clock;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.protocol.FetchFriendListGraphQL.FetchFriendListQueryString;
import com.facebook.friendlist.protocol.FetchFriendListGraphQL.FetchMutualFriendListQueryString;
import com.facebook.friendlist.protocol.FetchFriendListGraphQL.FetchRecentlyAddedFriendListQueryString;
import com.facebook.friendlist.protocol.FetchFriendListGraphQL.FetchSuggestionsFriendListQueryString;
import com.facebook.friendlist.protocol.FetchFriendListGraphQL.FetchWithNewPostsFriendListQueryString;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchFriendListQueryModel.FriendsModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchMutualFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchMutualFriendListQueryModel.MutualFriendsModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchRecentlyAddedFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchSuggestionsFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.FetchWithNewPostsFriendListQueryModel;
import com.facebook.friendlist.protocol.FetchFriendListGraphQLModels.UserFieldsModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.Assisted;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: adPositionX */
public class FriendListLoader {
    public static final Builder f20292a;
    private final GraphQLQueryExecutor f20293b;
    private final Clock f20294c;
    private final String f20295d;
    private final FriendListType f20296e;

    /* compiled from: adPositionX */
    class C28911 implements Function<GraphQLResult<FetchFriendListQueryModel>, Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> {
        final /* synthetic */ FriendListLoader f20285a;

        C28911(FriendListLoader friendListLoader) {
            this.f20285a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchFriendListQueryModel) graphQLResult.e).m20702a() == null || ((FetchFriendListQueryModel) graphQLResult.e).m20702a().m20699j() == null) {
                return Pair.create(RegularImmutableList.a, FriendListLoader.f20292a.a());
            }
            FriendsModel a = ((FetchFriendListQueryModel) graphQLResult.e).m20702a();
            return Pair.create(a.m20698a(), a.m20699j());
        }
    }

    /* compiled from: adPositionX */
    class C28922 implements Function<GraphQLResult<FetchWithNewPostsFriendListQueryModel>, Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> {
        final /* synthetic */ FriendListLoader f20286a;

        C28922(FriendListLoader friendListLoader) {
            this.f20286a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchWithNewPostsFriendListQueryModel) graphQLResult.e).m20754a() == null || ((FetchWithNewPostsFriendListQueryModel) graphQLResult.e).m20754a().m20751j() == null) {
                return Pair.create(RegularImmutableList.a, FriendListLoader.f20292a.a());
            }
            FetchWithNewPostsFriendListQueryModel.FriendsModel a = ((FetchWithNewPostsFriendListQueryModel) graphQLResult.e).m20754a();
            return Pair.create(a.m20750a(), a.m20751j());
        }
    }

    /* compiled from: adPositionX */
    class C28933 implements Function<GraphQLResult<FetchMutualFriendListQueryModel>, Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> {
        final /* synthetic */ FriendListLoader f20287a;

        C28933(FriendListLoader friendListLoader) {
            this.f20287a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchMutualFriendListQueryModel) graphQLResult.e).m20715a() == null || ((FetchMutualFriendListQueryModel) graphQLResult.e).m20715a().m20712j() == null) {
                return Pair.create(RegularImmutableList.a, FriendListLoader.f20292a.a());
            }
            MutualFriendsModel a = ((FetchMutualFriendListQueryModel) graphQLResult.e).m20715a();
            return Pair.create(a.m20711a(), a.m20712j());
        }
    }

    /* compiled from: adPositionX */
    class C28944 implements Function<GraphQLResult<FetchRecentlyAddedFriendListQueryModel>, Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> {
        final /* synthetic */ FriendListLoader f20288a;

        C28944(FriendListLoader friendListLoader) {
            this.f20288a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchRecentlyAddedFriendListQueryModel) graphQLResult.e).m20728a() == null || ((FetchRecentlyAddedFriendListQueryModel) graphQLResult.e).m20728a().m20725j() == null) {
                return Pair.create(RegularImmutableList.a, FriendListLoader.f20292a.a());
            }
            FetchRecentlyAddedFriendListQueryModel.FriendsModel a = ((FetchRecentlyAddedFriendListQueryModel) graphQLResult.e).m20728a();
            return Pair.create(a.m20724a(), a.m20725j());
        }
    }

    /* compiled from: adPositionX */
    class C28955 implements Function<GraphQLResult<FetchSuggestionsFriendListQueryModel>, Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> {
        final /* synthetic */ FriendListLoader f20289a;

        C28955(FriendListLoader friendListLoader) {
            this.f20289a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchSuggestionsFriendListQueryModel) graphQLResult.e).m20741a() == null || ((FetchSuggestionsFriendListQueryModel) graphQLResult.e).m20741a().m20738j() == null) {
                return Pair.create(RegularImmutableList.a, FriendListLoader.f20292a.a());
            }
            FetchSuggestionsFriendListQueryModel.FriendsModel a = ((FetchSuggestionsFriendListQueryModel) graphQLResult.e).m20741a();
            return Pair.create(a.m20737a(), a.m20738j());
        }
    }

    /* compiled from: adPositionX */
    public class C28966 implements Function<Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>, FriendListLoaderResult> {
        final /* synthetic */ FriendListLoader f20290a;

        public C28966(FriendListLoader friendListLoader) {
            this.f20290a = friendListLoader;
        }

        public Object apply(@Nullable Object obj) {
            Pair pair = (Pair) obj;
            if (pair == null) {
                return new FriendListLoaderResult(null, null);
            }
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList immutableList = (ImmutableList) pair.first;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                builder.c(new FriendPageListItemModel((UserFieldsModel) immutableList.get(i)));
            }
            return new FriendListLoaderResult(builder.b(), (DefaultPageInfoFieldsModel) pair.second);
        }
    }

    /* compiled from: adPositionX */
    /* synthetic */ class C28977 {
        static final /* synthetic */ int[] f20291a = new int[FriendListType.values().length];

        static {
            try {
                f20291a[FriendListType.ALL_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20291a[FriendListType.FRIENDS_WITH_NEW_POSTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20291a[FriendListType.MUTUAL_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20291a[FriendListType.RECENTLY_ADDED_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20291a[FriendListType.SUGGESTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        Builder builder = new Builder();
        builder.c = false;
        builder = builder;
        builder.b = false;
        f20292a = builder;
    }

    @Inject
    public FriendListLoader(GraphQLQueryExecutor graphQLQueryExecutor, Clock clock, @Assisted String str, @Assisted FriendListType friendListType) {
        this.f20293b = graphQLQueryExecutor;
        this.f20294c = clock;
        this.f20295d = str;
        this.f20296e = friendListType;
    }

    public final ListenableFuture<FriendListLoaderResult> m20574a(String str) {
        return Futures.a(m20572b(str), new C28966(this), MoreExecutors.a());
    }

    private ListenableFuture<Pair<ImmutableList<UserFieldsModel>, DefaultPageInfoFieldsModel>> m20572b(String str) {
        switch (C28977.f20291a[this.f20296e.ordinal()]) {
            case 1:
                return Futures.a(this.f20293b.a(m20573c(str)), new C28911(this), MoreExecutors.a());
            case 2:
                return Futures.a(this.f20293b.a(m20573c(str)), new C28922(this), MoreExecutors.a());
            case 3:
                return Futures.a(this.f20293b.a(m20573c(str)), new C28933(this), MoreExecutors.a());
            case 4:
                return Futures.a(this.f20293b.a(m20573c(str)), new C28944(this), MoreExecutors.a());
            case 5:
                return Futures.a(this.f20293b.a(m20573c(str)), new C28955(this), MoreExecutors.a());
            default:
                return null;
        }
    }

    private GraphQLRequest m20573c(String str) {
        GraphQLRequest a;
        GraphQlQueryString fetchFriendListQueryString;
        switch (C28977.f20291a[this.f20296e.ordinal()]) {
            case 1:
                fetchFriendListQueryString = new FetchFriendListQueryString();
                fetchFriendListQueryString.a("profile_id", this.f20295d).a("after_param", str);
                a = GraphQLRequest.a(fetchFriendListQueryString);
                break;
            case 2:
                fetchFriendListQueryString = new FetchWithNewPostsFriendListQueryString();
                fetchFriendListQueryString.a("profile_id", this.f20295d).a("after_param", str);
                a = GraphQLRequest.a(fetchFriendListQueryString);
                break;
            case 3:
                fetchFriendListQueryString = new FetchMutualFriendListQueryString();
                fetchFriendListQueryString.a("profile_id", this.f20295d).a("after_param", str);
                a = GraphQLRequest.a(fetchFriendListQueryString);
                break;
            case 4:
                Preconditions.checkArgument(str == null);
                long a2 = ((this.f20294c.a() / 86400000) - 14) * 86400;
                fetchFriendListQueryString = new FetchRecentlyAddedFriendListQueryString();
                fetchFriendListQueryString.a("profile_id", this.f20295d).a("after_timestamp", String.valueOf(a2));
                a = GraphQLRequest.a(fetchFriendListQueryString);
                break;
            case 5:
                fetchFriendListQueryString = new FetchSuggestionsFriendListQueryString();
                fetchFriendListQueryString.a("profile_id", this.f20295d).a("after_param", str);
                a = GraphQLRequest.a(fetchFriendListQueryString);
                break;
            default:
                throw new IllegalArgumentException("Unexpected value for FriendListType");
        }
        String[] strArr = new String[1];
        strArr[0] = "friendlist_" + this.f20295d;
        a.e = Sets.a(strArr);
        return a.a(GraphQLCachePolicy.a).a(3600);
    }
}
