package com.facebook.groups.feed.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.Tuple;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.groups.abtest.GroupsExperimentalFeatures;
import com.facebook.groups.datautil.GroupsIdempotentRequestRunner;
import com.facebook.groups.datautil.GroupsIdempotentRequestRunner.RunnerDelegate;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.logging.GroupsSequenceLogger;
import com.facebook.groups.perf.DefaultGroupsPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.ui.OfflineSnackbarView;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed to fetch frames */
public class GroupsFeedPager implements IHaveUserData {
    public static final String f13920a = GroupsFeedPager.class.getSimpleName();
    public String f13921A;
    @Nullable
    public GroupsSequenceLogger f13922b;
    public final FeedUnitCollection f13923c;
    public final FbNetworkManager f13924d;
    public final LocalBroadcastManager f13925e;
    public final DefaultGroupsPerfLogger f13926f;
    private final GroupsExperimentalFeatures f13927g;
    public final GroupsIdempotentRequestRunner f13928h;
    public final GroupsIdempotentRequestRunner f13929i;
    public final NetworkConnectivityBroadcastReceiver f13930j = new NetworkConnectivityBroadcastReceiver(this);
    public final NetworkMonitor f13931k;
    public final ClickableToastBuilder f13932l;
    public final Activity f13933m;
    public GroupsFeedPagerProtocol f13934n;
    private long f13935o;
    private int f13936p;
    public PagerListener f13937q;
    public boolean f13938r;
    public boolean f13939s;
    private long f13940t;
    private int f13941u;
    public boolean f13942v;
    public boolean f13943w;
    public boolean f13944x;
    private MonotonicClock f13945y;
    public String f13946z;

    /* compiled from: failed to fetch frames */
    class C14771 implements RunnerDelegate<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> {
        final /* synthetic */ GroupsFeedPager f13914a;

        public final ListenableFuture<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> mo838a() {
            int i;
            String str = GroupsFeedPager.f13920a;
            if (this.f13914a.f13939s && this.f13914a.f13922b != null) {
                this.f13914a.f13922b.m15736h();
            }
            GroupsFeedPager.m15566j(this.f13914a);
            DataFreshnessParam dataFreshnessParam = this.f13914a.f13939s ? DataFreshnessParam.DO_NOT_CHECK_SERVER : DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            GroupsFeedPagerProtocol groupsFeedPagerProtocol = this.f13914a.f13934n;
            String r = this.f13914a.f13923c.r();
            boolean z = this.f13914a.f13939s;
            FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
            if (z) {
                i = groupsFeedPagerProtocol.f13953g;
            } else {
                i = groupsFeedPagerProtocol.f13952f;
            }
            fetchFeedParamsBuilder.c = i;
            FetchFeedParamsBuilder fetchFeedParamsBuilder2 = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder2.b = groupsFeedPagerProtocol.f13954h;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.a = dataFreshnessParam;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.l = groupsFeedPagerProtocol.f13955i;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.f = r;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.n = groupsFeedPagerProtocol.f13950d.a();
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchFeedParams", fetchFeedParamsBuilder2.q());
            return Futures.a(BlueServiceOperationFactoryDetour.a(groupsFeedPagerProtocol.f13948b, "feed_fetch_news_feed_after", bundle, -1548161705).b(), GroupsFeedPagerProtocol.f13947a, groupsFeedPagerProtocol.f13949c);
        }

        C14771(GroupsFeedPager groupsFeedPager) {
            this.f13914a = groupsFeedPager;
        }
    }

    /* compiled from: failed to fetch frames */
    class C14782 implements FutureCallback<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> {
        final /* synthetic */ GroupsFeedPager f13915a;

        C14782(GroupsFeedPager groupsFeedPager) {
            this.f13915a = groupsFeedPager;
        }

        public void onSuccess(Object obj) {
            Tuple tuple = (Tuple) obj;
            boolean z = true;
            GroupsFeedPager.m15567k(this.f13915a);
            GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) tuple.a;
            int size = graphQLFeedHomeStories.k().size();
            this.f13915a.f13943w = true;
            if (this.f13915a.f13922b != null) {
                this.f13915a.f13922b.m15727a(size);
            }
            String str;
            if (tuple.b == DataFreshnessResult.FROM_SERVER) {
                str = GroupsFeedPager.f13920a;
                Integer.valueOf(size);
            } else {
                str = GroupsFeedPager.f13920a;
                Integer.valueOf(size);
            }
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) Preconditions.checkNotNull(graphQLFeedHomeStories.n());
            List list = (List) Preconditions.checkNotNull(graphQLFeedHomeStories.k());
            GroupsFeedPager groupsFeedPager = this.f13915a;
            if (graphQLPageInfo.b() || tuple.b != DataFreshnessResult.FROM_SERVER) {
                z = false;
            }
            groupsFeedPager.f13938r = z;
            GroupsFeedPager.m15562a(this.f13915a, tuple, list);
            this.f13915a.f13923c.a(list, graphQLPageInfo);
            this.f13915a.f13937q.m15561b(false);
            this.f13915a.f13937q.m15558a();
            GroupsFeedPager.m15566j(this.f13915a);
            DefaultGroupsPerfLogger defaultGroupsPerfLogger = this.f13915a.f13926f;
        }

        public void onFailure(Throwable th) {
            if (th instanceof ServiceException) {
                GroupsFeedPager.m15563a(this.f13915a, (ServiceException) th);
            }
            GroupsFeedPager.m15564a(this.f13915a, this.f13915a.f13928h);
            GroupsFeedPager.m15566j(this.f13915a);
            DefaultGroupsPerfLogger defaultGroupsPerfLogger = this.f13915a.f13926f;
            if (this.f13915a.f13922b != null) {
                this.f13915a.f13922b.m15739k();
            }
        }
    }

    /* compiled from: failed to fetch frames */
    class C14793 implements RunnerDelegate<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> {
        final /* synthetic */ GroupsFeedPager f13916a;

        public final ListenableFuture<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> mo838a() {
            String str;
            Object obj;
            FetchFeedCause fetchFeedCause;
            String str2 = GroupsFeedPager.f13920a;
            if (this.f13916a.f13939s && this.f13916a.f13922b != null) {
                this.f13916a.f13922b.m15737i();
            }
            if (!(this.f13916a.f13931k == null || this.f13916a.f13932l == null || this.f13916a.f13931k.a())) {
                this.f13916a.f13932l.a(new OfflineSnackbarView(this.f13916a.f13933m), 3000).a();
            }
            if (this.f13916a.f13939s) {
                str = "cold_start_cursor";
            } else {
                str = this.f13916a.f13923c.j();
            }
            GroupsFeedPager.m15566j(this.f13916a);
            GroupsFeedPagerProtocol groupsFeedPagerProtocol = this.f13916a.f13934n;
            boolean z = this.f13916a.f13942v;
            boolean z2 = this.f13916a.f13939s;
            if (z && groupsFeedPagerProtocol.f13951e.a()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                GroupsFeedTypeValueParams groupsFeedTypeValueParams = (GroupsFeedTypeValueParams) groupsFeedPagerProtocol.f13954h.f;
                if (groupsFeedTypeValueParams.d != null) {
                    groupsFeedTypeValueParams.d.clear();
                }
            }
            FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
            fetchFeedParamsBuilder.c = z2 ? groupsFeedPagerProtocol.f13953g : groupsFeedPagerProtocol.f13952f;
            FetchFeedParamsBuilder fetchFeedParamsBuilder2 = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder2.b = groupsFeedPagerProtocol.f13954h;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.l = groupsFeedPagerProtocol.f13955i;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            if (z) {
                fetchFeedCause = FetchFeedCause.PULL_TO_REFRESH;
            } else if (z2) {
                fetchFeedCause = FetchFeedCause.INITIALIZATION;
            } else {
                fetchFeedCause = FetchFeedCause.SCROLLING;
            }
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2.a(fetchFeedCause);
            fetchFeedParamsBuilder2.g = str;
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            fetchFeedParamsBuilder2.n = groupsFeedPagerProtocol.f13950d.a();
            fetchFeedParamsBuilder2 = fetchFeedParamsBuilder2;
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchFeedParams", fetchFeedParamsBuilder2.q());
            return Futures.a(BlueServiceOperationFactoryDetour.a(groupsFeedPagerProtocol.f13948b, "feed_fetch_news_feed_before", bundle, -253973741).b(), GroupsFeedPagerProtocol.f13947a, groupsFeedPagerProtocol.f13949c);
        }

        C14793(GroupsFeedPager groupsFeedPager) {
            this.f13916a = groupsFeedPager;
        }
    }

    /* compiled from: failed to fetch frames */
    class C14804 implements FutureCallback<Tuple<GraphQLFeedHomeStories, DataFreshnessResult>> {
        final /* synthetic */ GroupsFeedPager f13917a;

        C14804(GroupsFeedPager groupsFeedPager) {
            this.f13917a = groupsFeedPager;
        }

        public void onSuccess(Object obj) {
            Tuple tuple = (Tuple) obj;
            GroupsFeedPager.m15567k(this.f13917a);
            this.f13917a.f13944x = true;
            GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) tuple.a;
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) Preconditions.checkNotNull(graphQLFeedHomeStories.n());
            List list = (List) Preconditions.checkNotNull(graphQLFeedHomeStories.k());
            if (this.f13917a.f13922b != null) {
                this.f13917a.f13922b.m15730b(list.size());
            }
            if (!list.isEmpty() && tuple.b == DataFreshnessResult.FROM_SERVER) {
                this.f13917a.f13923c.e();
            }
            GroupsFeedPager.m15562a(this.f13917a, tuple, list);
            this.f13917a.f13923c.a(list, graphQLPageInfo, FetchPortion.FULL);
            if (this.f13917a.f13923c.a() == 0) {
                this.f13917a.f13938r = true;
            } else if (this.f13917a.f13923c.s()) {
                this.f13917a.f13923c.q();
                this.f13917a.f13938r = false;
            }
            if (this.f13917a.f13942v) {
                this.f13917a.f13937q.m15561b(true);
                this.f13917a.f13942v = false;
            }
            this.f13917a.f13937q.m15558a();
            GroupsFeedPager.m15566j(this.f13917a);
        }

        public void onFailure(Throwable th) {
            this.f13917a.f13942v = false;
            GroupsFeedPager.m15566j(this.f13917a);
            this.f13917a.f13937q.m15560b();
            if (th instanceof ServiceException) {
                GroupsFeedPager.m15563a(this.f13917a, (ServiceException) th);
            }
            GroupsFeedPager.m15564a(this.f13917a, this.f13917a.f13929i);
            if (this.f13917a.f13922b != null) {
                this.f13917a.f13922b.m15740l();
            }
        }
    }

    /* compiled from: failed to fetch frames */
    public class C14815 implements Runnable {
        final /* synthetic */ GroupsFeedPager f13918a;

        public C14815(GroupsFeedPager groupsFeedPager) {
            this.f13918a = groupsFeedPager;
        }

        public void run() {
            this.f13918a.f13928h.m15474a();
        }
    }

    /* compiled from: failed to fetch frames */
    class NetworkConnectivityBroadcastReceiver extends DynamicSecureBroadcastReceiver {

        /* compiled from: failed to fetch frames */
        class NetworkConnectivityChangeAction implements ActionReceiver {
            private final GroupsFeedPager f13919a;

            public NetworkConnectivityChangeAction(GroupsFeedPager groupsFeedPager) {
                this.f13919a = groupsFeedPager;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1601731091);
                if (this.f13919a.f13924d.d()) {
                    this.f13919a.m15571a(false);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1526680541, a);
            }
        }

        public NetworkConnectivityBroadcastReceiver(GroupsFeedPager groupsFeedPager) {
            super("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new NetworkConnectivityChangeAction(groupsFeedPager));
        }
    }

    /* compiled from: failed to fetch frames */
    public interface PagerListener {
        void m15558a();

        void m15559a(boolean z);

        void m15560b();

        void m15561b(boolean z);
    }

    public static GroupsFeedPager m15565b(InjectorLike injectorLike) {
        return new GroupsFeedPager(ActivityMethodAutoProvider.b(injectorLike), NetworkMonitor.a(injectorLike), ClickableToastBuilder.b(injectorLike), FeedUnitCollection.b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), FbNetworkManager.a(injectorLike), LocalBroadcastManagerMethodAutoProvider.a(injectorLike), new DefaultGroupsPerfLogger(), GroupsExperimentalFeatures.b(injectorLike));
    }

    public static void m15563a(GroupsFeedPager groupsFeedPager, ServiceException serviceException) {
        Parcelable parcelable = (Parcelable) serviceException.result.k();
        GraphQLError graphQLError = parcelable instanceof GraphQLError ? (GraphQLError) parcelable : null;
        if (graphQLError != null && graphQLError.code == 1675011) {
            groupsFeedPager.m15568l();
            Operation a = BlueServiceOperationFactoryDetour.a(groupsFeedPager.f13934n.f13948b, "feed_clear_cache", new Bundle(), -1561482189);
            a.a(true);
            a.a();
        }
    }

    public final void m15569a() {
        long now = this.f13945y.now();
        long j = now - 1;
        this.f13946z = StringFormatUtil.formatStrLocaleSafe("%020d:", Long.valueOf(now));
        this.f13921A = StringFormatUtil.formatStrLocaleSafe("%020d:", Long.valueOf(j));
    }

    @Inject
    public GroupsFeedPager(Activity activity, NetworkMonitor networkMonitor, ClickableToastBuilder clickableToastBuilder, FeedUnitCollection feedUnitCollection, MonotonicClock monotonicClock, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbNetworkManager fbNetworkManager, LocalBroadcastManager localBroadcastManager, DefaultGroupsPerfLogger defaultGroupsPerfLogger, GroupsExperimentalFeatures groupsExperimentalFeatures) {
        this.f13923c = feedUnitCollection;
        this.f13924d = fbNetworkManager;
        this.f13925e = localBroadcastManager;
        this.f13926f = defaultGroupsPerfLogger;
        this.f13931k = networkMonitor;
        this.f13932l = clickableToastBuilder;
        this.f13933m = activity;
        this.f13945y = monotonicClock;
        this.f13927g = groupsExperimentalFeatures;
        this.f13928h = new GroupsIdempotentRequestRunner(new C14771(this), new C14782(this), monotonicClock, defaultAndroidThreadUtil);
        this.f13929i = new GroupsIdempotentRequestRunner(new C14793(this), new C14804(this), monotonicClock, defaultAndroidThreadUtil);
    }

    public static void m15562a(GroupsFeedPager groupsFeedPager, Tuple tuple, List list) {
        if (groupsFeedPager.f13927g.a()) {
            if (groupsFeedPager.f13942v) {
                groupsFeedPager.m15569a();
            }
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : list) {
                String str;
                if (tuple.b == DataFreshnessResult.FROM_SERVER) {
                    str = groupsFeedPager.f13946z + graphQLFeedUnitEdge.d();
                } else {
                    str = groupsFeedPager.f13921A + graphQLFeedUnitEdge.d();
                }
                PropertyHelper.a(graphQLFeedUnitEdge, str);
            }
        }
    }

    public static void m15566j(GroupsFeedPager groupsFeedPager) {
        groupsFeedPager.f13937q.m15559a(groupsFeedPager.f13942v);
    }

    public final void m15570a(GroupsFeedPagerProtocol groupsFeedPagerProtocol, PagerListener pagerListener, long j, int i, @Nullable GroupsSequenceLogger groupsSequenceLogger) {
        this.f13934n = (GroupsFeedPagerProtocol) Preconditions.checkNotNull(groupsFeedPagerProtocol);
        this.f13937q = (PagerListener) Preconditions.checkNotNull(pagerListener);
        this.f13922b = groupsSequenceLogger;
        Preconditions.checkArgument(j > 0);
        this.f13935o = j;
        this.f13936p = i;
    }

    public final void m15571a(boolean z) {
        this.f13942v = z;
        this.f13929i.m15474a();
    }

    public final FeedUnitCollection m15572e() {
        return this.f13923c;
    }

    public void clearUserData() {
        m15568l();
    }

    public String toString() {
        ToStringHelper toStringHelper = Objects.toStringHelper(GroupsFeedPager.class);
        String str = "loading";
        Object obj = (this.f13929i.f13829f || this.f13928h.f13829f) ? "no" : "yes";
        return toStringHelper.add(str, obj).add("totalStories", this.f13923c.a()).add("freshStories", this.f13923c.u()).add("mHasReachedEndOfFeed", this.f13938r).toString();
    }

    public final void m15573g() {
        m15568l();
        this.f13929i.m15475b();
        this.f13928h.m15475b();
        this.f13925e.a(this.f13930j);
    }

    public final boolean m15574h() {
        return this.f13929i.f13829f || this.f13928h.f13829f;
    }

    public static void m15567k(GroupsFeedPager groupsFeedPager) {
        groupsFeedPager.f13940t = groupsFeedPager.f13935o;
        groupsFeedPager.f13941u = 0;
    }

    private void m15568l() {
        this.f13929i.m15475b();
        this.f13928h.m15475b();
        this.f13923c.m();
        this.f13938r = false;
        m15567k(this);
    }

    public static void m15564a(GroupsFeedPager groupsFeedPager, GroupsIdempotentRequestRunner groupsIdempotentRequestRunner) {
        int i = groupsFeedPager.f13941u;
        groupsFeedPager.f13941u = i + 1;
        if (i < groupsFeedPager.f13936p) {
            long j = groupsFeedPager.f13940t * 2;
            groupsFeedPager.f13940t = j;
            groupsIdempotentRequestRunner.m15473a(j);
        }
    }
}
