package com.facebook.friends;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.model.FetchFriendRequestResult;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQL.FriendRequestQueryString;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLModels.FriendingPossibilityModel;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLModels.FriendingPossibilityModel.SuggestersModel;
import com.facebook.friends.protocol.FetchFriendRequestsGraphQLModels.FriendingPossibilityUserModel;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQL.PeopleYouMayKnowQueryString;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PeopleYouMayKnowQueryModel;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PersonYouMayKnowEdgeModel;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PersonYouMayKnowFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: frame_rate */
public class FriendingQueryExecutor {
    private static volatile FriendingQueryExecutor f23313e;
    private final int f23314a;
    private final ExecutorService f23315b;
    private final GraphQLQueryExecutor f23316c;
    private final GraphQLImageHelper f23317d;

    public static com.facebook.friends.FriendingQueryExecutor m31461a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23313e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friends.FriendingQueryExecutor.class;
        monitor-enter(r1);
        r0 = f23313e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m31465b(r0);	 Catch:{ all -> 0x0035 }
        f23313e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23313e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.FriendingQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.friends.FriendingQueryExecutor");
    }

    private static FriendingQueryExecutor m31465b(InjectorLike injectorLike) {
        return new FriendingQueryExecutor(ResourcesMethodAutoProvider.m6510a(injectorLike), C0055x2995691a.m1881a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphQLImageHelper.m10139a(injectorLike));
    }

    @Inject
    public FriendingQueryExecutor(Resources resources, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper) {
        this.f23314a = resources.getDimensionPixelSize(2131428791);
        this.f23315b = executorService;
        this.f23316c = graphQLQueryExecutor;
        this.f23317d = graphQLImageHelper;
    }

    public final ListenableFuture<FetchFriendRequestResult> m31469a(@Nullable String str, int i, CallerContext callerContext) {
        Preconditions.checkArgument(i > 0);
        TypedGraphQlQueryString friendRequestQueryString = new FriendRequestQueryString();
        friendRequestQueryString.m11315a("after_param", str).m11315a("first_param", String.valueOf(i)).m11313a("media_type", this.f23317d.m10145b()).m11315a("picture_size", String.valueOf(this.f23314a));
        GraphQLRequest a = GraphQLRequest.m11587a(friendRequestQueryString).m11594a(GraphQLCachePolicy.f7109a);
        a.f7087e = ImmutableSet.of("REQUESTS_TAB_REQUESTS_QUERY_TAG");
        a = a;
        a.f7084b = true;
        a = a.m11596a(RequestPriority.INTERACTIVE);
        a.f7088f = callerContext;
        a = a.m11590a(3600);
        a.f7096o.mo1608a(true);
        return Futures.m2450a(this.f23316c.m10446a(a), new 1(this), this.f23315b);
    }

    public final ListenableFuture<FetchPeopleYouMayKnowResult> m31470a(@Nullable String str, int i, @Nullable Integer num, PeopleYouMayKnowLocation peopleYouMayKnowLocation, CallerContext callerContext) {
        Preconditions.checkArgument(i > 0);
        if (num == null) {
            num = Integer.valueOf(this.f23314a);
        }
        return Futures.m2450a(this.f23316c.m10446a(m31468a(str, i, num.intValue(), peopleYouMayKnowLocation, callerContext)), new 2(this), this.f23315b);
    }

    public final GraphQLRequest<PeopleYouMayKnowQueryModel> m31468a(@Nullable String str, int i, int i2, PeopleYouMayKnowLocation peopleYouMayKnowLocation, CallerContext callerContext) {
        TypedGraphQlQueryString peopleYouMayKnowQueryString = new PeopleYouMayKnowQueryString();
        peopleYouMayKnowQueryString.m11315a("after_param", str).m11315a("first_param", String.valueOf(i)).m11315a("location", peopleYouMayKnowLocation.value).m11315a("max", "250").m11313a("media_type", this.f23317d.m10145b()).m11315a("picture_size", String.valueOf(i2)).mo1608a(true);
        GraphQLRequest a = GraphQLRequest.m11587a(peopleYouMayKnowQueryString).m11594a(GraphQLCachePolicy.f7109a);
        a.f7087e = ImmutableSet.of("REQUESTS_TAB_PYMK_QUERY_TAG");
        a = a;
        a.f7084b = true;
        a = a.m11596a(RequestPriority.INTERACTIVE);
        a.f7088f = callerContext;
        return a.m11590a(3600);
    }

    @VisibleForTesting
    public static ImmutableList<FriendRequest> m31464a(ImmutableList<FriendingPossibilityModel> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str;
            String str2;
            boolean z;
            FriendingPossibilityModel friendingPossibilityModel = (FriendingPossibilityModel) immutableList.get(i);
            FriendingPossibilityUserModel j = friendingPossibilityModel.j();
            ImmutableList c = m31467c(friendingPossibilityModel.k());
            String k = j.k();
            String l = j.l();
            if (j.m() == null) {
                str = null;
            } else {
                str = j.m().a();
            }
            GraphQLFriendshipStatus j2 = j.j();
            if (j.n() == null) {
                str2 = null;
            } else {
                str2 = j.n().a();
            }
            GraphQLFriendshipStatus j3 = j.j();
            if (c.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            builder.m1069c(new FriendRequest(k, l, str, j2, str2, c, m31462a(j3, z), friendingPossibilityModel.a(), friendingPossibilityModel.l()));
        }
        return builder.m1068b();
    }

    public static ImmutableList<PersonYouMayKnow> m31466b(ImmutableList<PersonYouMayKnowEdgeModel> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PersonYouMayKnowEdgeModel personYouMayKnowEdgeModel = (PersonYouMayKnowEdgeModel) immutableList.get(i);
            PersonYouMayKnowFieldsModel a = personYouMayKnowEdgeModel.a();
            builder.m1069c(new PersonYouMayKnow(Long.parseLong(a.k()), a.m(), a.n() != null ? a.n().a() : "", a.l() != null ? a.l().a() : 0, a.j(), personYouMayKnowEdgeModel.j()));
        }
        return builder.m1068b();
    }

    public static GraphQLPageInfo m31463a(DefaultPageInfoFieldsModel defaultPageInfoFieldsModel) {
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        builder.f15932g = defaultPageInfoFieldsModel.c();
        builder = builder;
        builder.f15931f = defaultPageInfoFieldsModel.b();
        builder = builder;
        builder.f15933h = defaultPageInfoFieldsModel.v_();
        builder = builder;
        builder.f15930e = defaultPageInfoFieldsModel.a();
        return builder.m22681a();
    }

    private static ImmutableList<String> m31467c(ImmutableList<SuggestersModel> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.m1069c(((SuggestersModel) immutableList.get(i)).a());
        }
        return builder.m1068b();
    }

    private static FriendRequestState m31462a(GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        if (z) {
            if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                return FriendRequestState.ACCEPTED;
            }
        } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) {
            return FriendRequestState.ACCEPTED;
        } else {
            if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST) {
                return FriendRequestState.REJECTED;
            }
        }
        return FriendRequestState.NEEDS_RESPONSE;
    }
}
