package com.facebook.events.feed.data;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.events.permalink.EventPermalinkFragment.C25282;
import com.facebook.events.permalink.perf.EventFeedFirstEventLogger;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger;
import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.LoadingState;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
public class EventFeedPager<T> implements IHaveUserData {
    public static final String f17347a = EventFeedPager.class.getSimpleName();
    public final EventPermalinkSequenceLogger f17348b;
    public final FeedUnitCollection f17349c;
    public final FbNetworkManager f17350d;
    public final LocalBroadcastManager f17351e;
    private final TasksManager f17352f;
    public final NetworkConnectivityBroadcastReceiver f17353g;
    private final Callable<ListenableFuture<EventFeedStories>> f17354h;
    private final AbstractDisposableFutureCallback<EventFeedStories> f17355i;
    private final Callable<ListenableFuture<EventFeedStories>> f17356j;
    private final AbstractDisposableFutureCallback<EventFeedStories> f17357k;
    public EventFeedPagerProtocol f17358l;
    public C25282 f17359m;
    public EventLoggerWithCount f17360n;
    public EventLoggerWithCount f17361o;
    public boolean f17362p;
    public int f17363q = 0;
    public boolean f17364r;

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    class C24471 implements Callable<ListenableFuture<EventFeedStories>> {
        final /* synthetic */ EventFeedPager f17338a;

        C24471(EventFeedPager eventFeedPager) {
            this.f17338a = eventFeedPager;
        }

        public Object call() {
            return this.f17338a.m17671a();
        }
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    class C24482 extends AbstractDisposableFutureCallback<EventFeedStories> {
        final /* synthetic */ EventFeedPager f17339a;

        C24482(EventFeedPager eventFeedPager) {
            this.f17339a = eventFeedPager;
        }

        protected final void m17660a(Object obj) {
            EventFeedStories eventFeedStories = (EventFeedStories) obj;
            ImmutableList immutableList = eventFeedStories.f17371a;
            int size = immutableList.size();
            DataFreshnessResult dataFreshnessResult = eventFeedStories.f17373c;
            String str;
            if (dataFreshnessResult == DataFreshnessResult.FROM_SERVER) {
                str = EventFeedPager.f17347a;
                Integer.valueOf(size);
            } else {
                str = EventFeedPager.f17347a;
                Integer.valueOf(size);
            }
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) Preconditions.checkNotNull(eventFeedStories.f17372b);
            List list = (List) Preconditions.checkNotNull(immutableList);
            if ((!graphQLPageInfo.b() || graphQLPageInfo.a() == null) && (dataFreshnessResult == DataFreshnessResult.FROM_SERVER || dataFreshnessResult == DataFreshnessResult.NO_DATA)) {
                this.f17339a.f17362p = true;
            } else {
                this.f17339a.f17362p = false;
            }
            this.f17339a.f17349c.a(list, graphQLPageInfo);
            this.f17339a.f17359m.m18283a();
            this.f17339a.f17360n.m17666a(size);
        }

        protected final void m17661a(Throwable th) {
            this.f17339a.f17360n.m17665b();
        }
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    class C24493 implements Callable<ListenableFuture<EventFeedStories>> {
        final /* synthetic */ EventFeedPager f17340a;

        C24493(EventFeedPager eventFeedPager) {
            this.f17340a = eventFeedPager;
        }

        public Object call() {
            return EventFeedPager.m17669j(this.f17340a);
        }
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    class C24504 extends AbstractDisposableFutureCallback<EventFeedStories> {
        final /* synthetic */ EventFeedPager f17341a;

        C24504(EventFeedPager eventFeedPager) {
            this.f17341a = eventFeedPager;
        }

        protected final void m17662a(Object obj) {
            EventFeedStories eventFeedStories = (EventFeedStories) obj;
            ImmutableList immutableList = eventFeedStories.f17371a;
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) Preconditions.checkNotNull(eventFeedStories.f17372b);
            List list = (List) Preconditions.checkNotNull(immutableList);
            if (!list.isEmpty() && eventFeedStories.f17373c == DataFreshnessResult.FROM_SERVER) {
                this.f17341a.f17349c.e();
            }
            this.f17341a.f17349c.a(list, graphQLPageInfo, FetchPortion.FULL);
            if (this.f17341a.f17349c.a() == 0) {
                this.f17341a.f17362p = true;
            } else if (this.f17341a.f17349c.s()) {
                this.f17341a.f17349c.q();
                this.f17341a.f17362p = false;
            }
            if (this.f17341a.f17364r) {
                this.f17341a.f17364r = false;
            }
            this.f17341a.f17359m.m18283a();
            this.f17341a.f17361o.m17666a(immutableList.size());
        }

        protected final void m17663a(Throwable th) {
            this.f17341a.f17364r = false;
            EventFeedPager.m17670l(this.f17341a);
            this.f17341a.f17361o.m17665b();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    public @interface ColdStartStage {
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    public class EventLoggerWithCount extends EventFeedFirstEventLogger {
        public final void m17666a(int i) {
            if (!this.f17345d) {
                ImmutableMap b = new Builder().b("stories_count", String.valueOf(i)).b();
                if (!this.f17345d) {
                    this.f17345d = true;
                    this.f17342a.m19079a(this.f17343b, b);
                }
            }
        }

        public EventLoggerWithCount(EventPermalinkSequenceLogger eventPermalinkSequenceLogger, LoadingState loadingState) {
            super(eventPermalinkSequenceLogger, loadingState);
        }
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    class NetworkConnectivityBroadcastReceiver extends DynamicSecureBroadcastReceiver {

        /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
        class NetworkConnectivityChangeAction implements ActionReceiver {
            private final EventFeedPager<?> f17346a;

            public NetworkConnectivityChangeAction(EventFeedPager<?> eventFeedPager) {
                this.f17346a = eventFeedPager;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1746063952);
                if (this.f17346a.f17350d.d()) {
                    this.f17346a.m17672a(false);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1801738394, a);
            }
        }

        public NetworkConnectivityBroadcastReceiver(EventFeedPager<?> eventFeedPager) {
            super("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new NetworkConnectivityChangeAction(eventFeedPager));
        }
    }

    /* compiled from: com.facebook.contacts.ACTION_CONTACT_ADDED */
    enum Task {
        LOAD_INITIAL_OLDER_FEED,
        LOAD_INITIAL_NEWER_FEED,
        LOAD_NEXT_PAGE,
        REFRESH_FEED
    }

    public static EventFeedPager m17668b(InjectorLike injectorLike) {
        return new EventFeedPager(EventPermalinkSequenceLogger.m19070a(injectorLike), TasksManager.b(injectorLike), FeedUnitCollection.b(injectorLike), FbNetworkManager.a(injectorLike), LocalBroadcastManagerMethodAutoProvider.a(injectorLike));
    }

    public static EventFeedPager m17667a(InjectorLike injectorLike) {
        return m17668b(injectorLike);
    }

    @Inject
    public EventFeedPager(EventPermalinkSequenceLogger eventPermalinkSequenceLogger, TasksManager tasksManager, FeedUnitCollection feedUnitCollection, FbNetworkManager fbNetworkManager, LocalBroadcastManager localBroadcastManager) {
        this.f17348b = eventPermalinkSequenceLogger;
        this.f17349c = feedUnitCollection;
        this.f17352f = tasksManager;
        this.f17350d = fbNetworkManager;
        this.f17351e = localBroadcastManager;
        this.f17354h = new C24471(this);
        this.f17355i = new C24482(this);
        this.f17356j = new C24493(this);
        this.f17357k = new C24504(this);
        this.f17353g = new NetworkConnectivityBroadcastReceiver(this);
    }

    public final ListenableFuture<EventFeedStories> m17671a() {
        this.f17360n.m17664a();
        DataFreshnessParam dataFreshnessParam = this.f17363q == 1 ? DataFreshnessParam.DO_NOT_CHECK_SERVER : DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        EventFeedPagerProtocol eventFeedPagerProtocol = this.f17358l;
        String r = this.f17349c.r();
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.c = eventFeedPagerProtocol.f17368d;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.b = eventFeedPagerProtocol.f17369e;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.a = dataFreshnessParam;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.l = eventFeedPagerProtocol.f17370f;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.f = r;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchFeedParams", fetchFeedParamsBuilder.q());
        return Futures.a(BlueServiceOperationFactoryDetour.a(eventFeedPagerProtocol.f17367c, "feed_fetch_news_feed_after", bundle, 208558110).c(), EventFeedPagerProtocol.f17365a, eventFeedPagerProtocol.f17366b);
    }

    public static ListenableFuture m17669j(EventFeedPager eventFeedPager) {
        String str;
        FetchFeedCause fetchFeedCause;
        eventFeedPager.f17361o.m17664a();
        if (eventFeedPager.f17363q == 1) {
            str = "cold_start_cursor";
        } else {
            str = eventFeedPager.f17349c.j();
        }
        EventFeedPagerProtocol eventFeedPagerProtocol = eventFeedPager.f17358l;
        if (eventFeedPager.f17364r) {
            fetchFeedCause = FetchFeedCause.PULL_TO_REFRESH;
        } else if (eventFeedPager.f17363q == 1) {
            fetchFeedCause = FetchFeedCause.INITIALIZATION;
        } else {
            fetchFeedCause = FetchFeedCause.SCROLLING;
        }
        FetchFeedCause fetchFeedCause2 = fetchFeedCause;
        FetchFeedParamsBuilder fetchFeedParamsBuilder = new FetchFeedParamsBuilder();
        fetchFeedParamsBuilder.c = eventFeedPagerProtocol.f17368d;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.b = eventFeedPagerProtocol.f17369e;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        fetchFeedParamsBuilder.l = eventFeedPagerProtocol.f17370f;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder.a(fetchFeedCause2);
        fetchFeedParamsBuilder.g = str;
        fetchFeedParamsBuilder = fetchFeedParamsBuilder;
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchFeedParams", fetchFeedParamsBuilder.q());
        return Futures.a(BlueServiceOperationFactoryDetour.a(eventFeedPagerProtocol.f17367c, "feed_fetch_news_feed_before", bundle, 2132503632).c(), EventFeedPagerProtocol.f17365a, eventFeedPagerProtocol.f17366b);
    }

    public final void m17673b() {
        this.f17362p = false;
        this.f17363q = 1;
        this.f17351e.a(this.f17353g, new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED"));
        this.f17352f.a(Task.LOAD_INITIAL_NEWER_FEED, m17669j(this), this.f17357k);
        this.f17352f.a(Task.LOAD_INITIAL_OLDER_FEED, m17671a(), this.f17355i);
        this.f17363q = 2;
    }

    public final void m17674c() {
        if (!this.f17362p) {
            this.f17352f.a(Task.LOAD_NEXT_PAGE, this.f17354h, this.f17355i);
        }
    }

    public final void m17672a(boolean z) {
        this.f17364r = z;
        this.f17352f.a(Task.REFRESH_FEED, this.f17356j, this.f17357k);
    }

    public final FeedUnitCollection m17675e() {
        return this.f17349c;
    }

    public final boolean m17676g() {
        return this.f17363q == 0;
    }

    public void clearUserData() {
        m17670l(this);
    }

    public String toString() {
        return Objects.toStringHelper(EventFeedPager.class).add("totalStories", this.f17349c.a()).add("freshStories", this.f17349c.u()).add("mHasReachedEndOfFeed", this.f17362p).toString();
    }

    public static void m17670l(EventFeedPager eventFeedPager) {
        eventFeedPager.f17352f.c();
        eventFeedPager.f17349c.m();
        eventFeedPager.f17362p = false;
    }
}
