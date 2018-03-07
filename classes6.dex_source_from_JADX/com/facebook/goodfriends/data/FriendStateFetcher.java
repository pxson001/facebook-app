package com.facebook.goodfriends.data;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.goodfriends.data.FriendData.Status;
import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriends.GoodFriendsAudienceQueryString;
import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriendsModels.GoodFriendsAudienceQueryModel;
import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriendsModels.GoodFriendsAudienceQueryModel.FriendListsModel.NodesModel;
import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriendsModels.GoodFriendsAudienceQueryModel.FriendListsModel.NodesModel.EditMembersModel.EditMembersNodesModel;
import com.facebook.goodfriends.protocol.FetchAllFriendsAndGoodFriendsModels.GoodFriendsAudienceQueryModel.FriendListsModel.NodesModel.EditMembersModel.EditMembersNodesModel.UserModel;
import com.facebook.graphql.enums.GraphQLFriendListEditEntryStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mSrcUrlBig */
public class FriendStateFetcher {
    public final int f10906a;
    public final GraphQLQueryExecutor f10907b;
    public final Executor f10908c;
    public final Executor f10909d;

    /* compiled from: mSrcUrlBig */
    public /* synthetic */ class C06733 {
        public static final /* synthetic */ int[] f10905a = new int[GraphQLFriendListEditEntryStatus.values().length];

        static {
            try {
                f10905a[GraphQLFriendListEditEntryStatus.LIST_MEMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10905a[GraphQLFriendListEditEntryStatus.NON_LIST_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10905a[GraphQLFriendListEditEntryStatus.SUGGESTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10905a[GraphQLFriendListEditEntryStatus.PRESELECTED_SUGGESTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: mSrcUrlBig */
    public interface Callback {
        void mo1320a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2);

        void mo1321a(Throwable th);
    }

    public static FriendStateFetcher m17453b(InjectorLike injectorLike) {
        return new FriendStateFetcher(GraphQLQueryExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FriendStateFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, Executor executor2, Context context) {
        this.f10907b = graphQLQueryExecutor;
        this.f10908c = executor;
        this.f10909d = executor2;
        this.f10906a = (int) context.getResources().getDimension(2131430810);
    }

    public final void m17454a(boolean z, Callback callback) {
        m17452a(z, false, -1, callback);
    }

    public final void m17455a(boolean z, Callback callback, int i) {
        m17452a(z, true, i, callback);
    }

    private void m17452a(boolean z, final boolean z2, final int i, final Callback callback) {
        GraphQLCachePolicy graphQLCachePolicy;
        if (z) {
            graphQLCachePolicy = GraphQLCachePolicy.d;
        } else {
            graphQLCachePolicy = GraphQLCachePolicy.a;
        }
        final C06722 c06722 = new FutureCallback<GraphQLResult<GoodFriendsAudienceQueryModel>>(this) {
            final /* synthetic */ FriendStateFetcher f10904d;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                final ImmutableList a = FriendStateFetcher.m17450a((GoodFriendsAudienceQueryModel) graphQLResult.e, z2, i);
                final ImmutableList a2 = FriendStateFetcher.m17451a(a);
                final int a3 = ((NodesModel) ((GoodFriendsAudienceQueryModel) graphQLResult.e).m17516a().m17513a().get(0)).m17509k().m17493a();
                ExecutorDetour.a(this.f10904d.f10908c, new Runnable(this) {
                    final /* synthetic */ C06722 f10898d;

                    public void run() {
                        callback.mo1320a(a, a3, a2);
                    }
                }, 1423621616);
            }

            public void onFailure(final Throwable th) {
                ExecutorDetour.a(this.f10904d.f10908c, new Runnable(this) {
                    final /* synthetic */ C06722 f10900b;

                    public void run() {
                        callback.mo1321a(th);
                    }
                }, 494758585);
            }
        };
        GraphQlQueryString goodFriendsAudienceQueryString = new GoodFriendsAudienceQueryString();
        goodFriendsAudienceQueryString.a("0", Integer.valueOf(this.f10906a));
        GraphQLRequest a = GraphQLRequest.a(goodFriendsAudienceQueryString).a(graphQLCachePolicy).a(900);
        a.b = true;
        Futures.a(this.f10907b.a(a), new FutureCallback<GraphQLResult<GoodFriendsAudienceQueryModel>>(this) {
            final /* synthetic */ FriendStateFetcher f10894b;

            public void onSuccess(@Nullable Object obj) {
                c06722.onSuccess((GraphQLResult) obj);
            }

            public void onFailure(Throwable th) {
                c06722.onFailure(th);
            }
        }, this.f10909d);
    }

    @VisibleForTesting
    public static ImmutableList<FriendData> m17450a(GoodFriendsAudienceQueryModel goodFriendsAudienceQueryModel, boolean z, int i) {
        int i2 = 0;
        Builder builder = new Builder();
        ImmutableList a = ((NodesModel) goodFriendsAudienceQueryModel.m17516a().m17513a().get(0)).m17508j().m17490a();
        int size = a.size();
        int i3 = 0;
        while (i3 < size) {
            EditMembersNodesModel editMembersNodesModel = (EditMembersNodesModel) a.get(i3);
            if (i2 == i) {
                return builder.b();
            }
            Status status;
            int i4;
            FriendData friendData = null;
            UserModel j = editMembersNodesModel.m17486j();
            String k = j.m17480k();
            String l = j.m17481l();
            String j2 = j.m17479j();
            Uri parse = j.m17482m() == null ? null : Uri.parse(j.m17482m().m17472a());
            if (editMembersNodesModel.m17484a() != null) {
                switch (C06733.f10905a[editMembersNodesModel.m17484a().ordinal()]) {
                    case 1:
                        status = Status.SELECTED;
                        break;
                    case 2:
                        status = Status.NOT_SELECTED;
                        break;
                    case 3:
                        status = Status.SUGGESTED;
                        break;
                    case 4:
                        status = Status.SUGGESTED;
                        break;
                }
            }
            status = null;
            if (k != null && (!z || status == Status.SELECTED)) {
                friendData = new FriendData(k, l, parse, status, j2);
            }
            FriendData friendData2 = friendData;
            if (friendData2 != null) {
                builder.c(friendData2);
                i4 = i2 + 1;
            } else {
                i4 = i2;
            }
            i3++;
            i2 = i4;
        }
        return builder.b();
    }

    @VisibleForTesting
    public static ImmutableList<FriendData> m17451a(ImmutableList<FriendData> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            FriendData friendData = (FriendData) immutableList.get(i);
            if (friendData.f10891d == Status.SUGGESTED) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                builder.c(friendData);
            }
        }
        return builder.b();
    }
}
