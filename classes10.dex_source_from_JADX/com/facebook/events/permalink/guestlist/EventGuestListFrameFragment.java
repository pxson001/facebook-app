package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.graphql.EventsGraphQL.FetchEventGuestListQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventGuestCountsModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
public class EventGuestListFrameFragment extends FbFragment implements AnalyticsFragmentWithExtraData {
    @Inject
    FbTitleBarSupplier f18378a;
    public ImmutableList<EventGuestSingleListModel> al;
    public final EventGuestListFutureCallback am = new EventGuestListFutureCallback(this);
    public final EventGuestListGraphQLSubscriptionFutureCallback an = new EventGuestListGraphQLSubscriptionFutureCallback(this);
    public TabbedViewPagerIndicator ao;
    @Inject
    EventEventLogger f18379b;
    @Inject
    public EventSeenStateMegaphoneController f18380c;
    @Inject
    GraphQLQueryExecutor f18381d;
    @Inject
    TasksManager f18382e;
    @Inject
    GraphQLSubscriptionHolder f18383f;
    @Inject
    EventGuestListPagerAdapterProvider f18384g;
    public EventGuestListPagerAdapter f18385h;
    public int f18386i;

    /* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
    class C26051 extends SimpleOnPageChangeListener {
        final /* synthetic */ EventGuestListFrameFragment f18373a;

        C26051(EventGuestListFrameFragment eventGuestListFrameFragment) {
            this.f18373a = eventGuestListFrameFragment;
        }

        public final void e_(int i) {
            EventGuestListFrameFragment eventGuestListFrameFragment = this.f18373a;
            eventGuestListFrameFragment.f18386i++;
        }
    }

    /* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
    public class C26062 {
        public final /* synthetic */ EventGuestListFrameFragment f18374a;

        C26062(EventGuestListFrameFragment eventGuestListFrameFragment) {
            this.f18374a = eventGuestListFrameFragment;
        }
    }

    /* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
    public /* synthetic */ class C26073 {
        public static final /* synthetic */ int[] f18375a = new int[EventGuestListType.values().length];

        static {
            try {
                f18375a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18375a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18375a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18375a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
    class EventGuestListFutureCallback extends AbstractDisposableFutureCallback<GraphQLResult<EventGuestCountsModel>> {
        final /* synthetic */ EventGuestListFrameFragment f18376a;

        public EventGuestListFutureCallback(EventGuestListFrameFragment eventGuestListFrameFragment) {
            this.f18376a = eventGuestListFrameFragment;
        }

        protected final void m18721a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!this.f18376a.f18383f.a(EventGuestListFrameFragment.ar(this.f18376a))) {
                this.f18376a.f18383f.a(this.f18376a.an, EventGuestListFrameFragment.ar(this.f18376a), graphQLResult);
            }
            EventGuestListFrameFragment.m18725a(this.f18376a, graphQLResult);
        }

        public final void m18722a(Throwable th) {
        }
    }

    /* compiled from: boyzxccxzhhhq1qbmwfktsdfqui */
    class EventGuestListGraphQLSubscriptionFutureCallback extends AbstractDisposableFutureCallback<GraphQLResult<EventGuestCountsModel>> {
        final /* synthetic */ EventGuestListFrameFragment f18377a;

        public EventGuestListGraphQLSubscriptionFutureCallback(EventGuestListFrameFragment eventGuestListFrameFragment) {
            this.f18377a = eventGuestListFrameFragment;
        }

        public final void m18723a(Object obj) {
            EventGuestListFrameFragment.m18725a(this.f18377a, (GraphQLResult) obj);
        }

        public final void m18724a(Throwable th) {
            this.f18377a.am.m18722a(th);
        }
    }

    public static void m18727a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventGuestListFrameFragment) obj).m18726a((FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), EventEventLogger.m18119b(injectorLike), EventSeenStateMegaphoneController.m18847b(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), GraphQLSubscriptionHolder.b(injectorLike), (EventGuestListPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventGuestListPagerAdapterProvider.class));
    }

    public final void m18732c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventGuestListFrameFragment.class;
        m18727a((Object) this, getContext());
        EventsGuestListInitializationModel aq = aq();
        this.al = aq.h;
        EventGuestListPagerAdapterProvider eventGuestListPagerAdapterProvider = this.f18384g;
        this.f18385h = new EventGuestListPagerAdapter(EventsConnectionExperimentController.a(eventGuestListPagerAdapterProvider), NumberTruncationUtil.a(eventGuestListPagerAdapterProvider), s(), getContext(), Event.a(aq.e()));
        this.f18385h.m18775a(this.al, this.s);
        if (Event.a(aq.e()) && aq.g && Event.a(aq.d())) {
            as();
        }
    }

    public final View m18729a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1094701241);
        View inflate = layoutInflater.inflate(2130904039, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1257800646, a);
        return inflate;
    }

    public final void m18730a(View view, Bundle bundle) {
        super.a(view, bundle);
        ViewPager viewPager = (ViewPager) e(2131561307);
        viewPager.setAdapter(this.f18385h);
        this.ao = (TabbedViewPagerIndicator) e(2131561305);
        this.ao.setViewPager(viewPager);
        this.ao.l = new C26051(this);
        EventGuestListPagerAdapter eventGuestListPagerAdapter = this.f18385h;
        viewPager.setCurrentItem(eventGuestListPagerAdapter.f18429i.indexOf(EventGuestListType.fromString(this.s.getString("EVENT_GUEST_LIST_RSVP_TYPE"))));
        this.f18380c.m18850a(aq(), e(2131561306));
        this.f18385h.f18428h = new C26062(this);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1997286241);
        super.mi_();
        FbTitleBar fbTitleBar = (FbTitleBar) this.f18378a.get();
        if (fbTitleBar != null) {
            fbTitleBar.setTitle(2131237082);
            if (fbTitleBar instanceof Fb4aTitleBar) {
                ((Fb4aTitleBar) fbTitleBar).setSearchButtonVisible(false);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1769996203, a);
    }

    public final void m18728I() {
        int i = 0;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1894477447);
        Builder builder = new Builder();
        int size = this.al.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(((EventGuestSingleListModel) this.al.get(i2)).a.toString().intern());
        }
        Builder builder2 = new Builder();
        Builder builder3 = new Builder();
        Builder builder4 = new Builder();
        Builder builder5 = new Builder();
        Builder builder6 = new Builder();
        Builder builder7 = new Builder();
        while (i < this.f18385h.b()) {
            int i3;
            EventGuestListFragment eventGuestListFragment = (EventGuestListFragment) this.f18385h.a(i);
            EventGuestListPagerAdapter eventGuestListPagerAdapter = this.f18385h;
            if (eventGuestListPagerAdapter.f18430j == null || i >= eventGuestListPagerAdapter.f18430j.length) {
                i3 = 0;
            } else {
                i3 = eventGuestListPagerAdapter.f18430j[i];
            }
            builder2.c(Integer.valueOf(i3));
            builder3.c(Integer.valueOf(eventGuestListFragment.aq()));
            builder4.c(Integer.valueOf(eventGuestListFragment.ar()));
            builder5.c(Integer.valueOf(eventGuestListFragment.am));
            builder6.c(Integer.valueOf(eventGuestListFragment.ao));
            builder7.c(Integer.valueOf(eventGuestListFragment.an));
            i++;
        }
        this.f18379b.m18130a(ar(this), builder.b(), this.f18386i, builder2.b(), builder3.b(), builder4.b(), builder5.b(), builder6.b(), builder7.b());
        this.f18383f.a();
        super.I();
        LogUtils.f(730054707, a);
    }

    public final String am_() {
        return "event_guest_list";
    }

    public final Map<String, Object> m18731c() {
        return EventEventLogger.m18117a(ar(this));
    }

    public static String ar(EventGuestListFrameFragment eventGuestListFrameFragment) {
        return eventGuestListFrameFragment.aq().b;
    }

    private void as() {
        FetchEventGuestListQueryString fetchEventGuestListQueryString = new FetchEventGuestListQueryString();
        fetchEventGuestListQueryString.a("event_id", ar(this));
        this.f18382e.a("fetch_guest_list_graphql", this.f18381d.a(GraphQLRequest.a(new FetchEventGuestListQueryString()).a(GraphQLCachePolicy.c).a(fetchEventGuestListQueryString.a)), this.am);
    }

    private void m18726a(FbTitleBarSupplier fbTitleBarSupplier, EventEventLogger eventEventLogger, EventSeenStateMegaphoneController eventSeenStateMegaphoneController, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, GraphQLSubscriptionHolder graphQLSubscriptionHolder, EventGuestListPagerAdapterProvider eventGuestListPagerAdapterProvider) {
        this.f18378a = fbTitleBarSupplier;
        this.f18379b = eventEventLogger;
        this.f18380c = eventSeenStateMegaphoneController;
        this.f18381d = graphQLQueryExecutor;
        this.f18382e = tasksManager;
        this.f18383f = graphQLSubscriptionHolder;
        this.f18384g = eventGuestListPagerAdapterProvider;
    }

    public static void m18725a(EventGuestListFrameFragment eventGuestListFrameFragment, GraphQLResult graphQLResult) {
        if (graphQLResult != null && graphQLResult.e != null) {
            EventGuestCountsModel eventGuestCountsModel = (EventGuestCountsModel) graphQLResult.e;
            int size = eventGuestListFrameFragment.al.size();
            for (int i = 0; i < size; i++) {
                EventGuestSingleListModel eventGuestSingleListModel = (EventGuestSingleListModel) eventGuestListFrameFragment.al.get(i);
                Integer valueOf;
                switch (C26073.f18375a[eventGuestSingleListModel.a.ordinal()]) {
                    case 1:
                        if (eventGuestCountsModel.m() != null) {
                            valueOf = Integer.valueOf(eventGuestCountsModel.m().a());
                        } else {
                            valueOf = null;
                        }
                        eventGuestSingleListModel.b = valueOf;
                        break;
                    case 2:
                        if (eventGuestCountsModel.l() != null) {
                            valueOf = Integer.valueOf(eventGuestCountsModel.l().a());
                        } else {
                            valueOf = null;
                        }
                        eventGuestSingleListModel.b = valueOf;
                        break;
                    case 3:
                        if (eventGuestCountsModel.k() != null) {
                            valueOf = Integer.valueOf(eventGuestCountsModel.k().a());
                        } else {
                            valueOf = null;
                        }
                        eventGuestSingleListModel.b = valueOf;
                        break;
                    case 4:
                        if (eventGuestCountsModel.j() != null) {
                            valueOf = Integer.valueOf(eventGuestCountsModel.j().a());
                        } else {
                            valueOf = null;
                        }
                        eventGuestSingleListModel.b = valueOf;
                        break;
                    default:
                        break;
                }
            }
            eventGuestListFrameFragment.ao.b();
        }
    }

    private EventsGuestListInitializationModel aq() {
        return (EventsGuestListInitializationModel) this.s.getParcelable("GUEST_LIST_INITIALIZATION_MODEL");
    }
}
