package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ProgressBar;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.EventGuestListPager.PageState;
import com.facebook.events.permalink.guestlist.EventGuestListPagerAdapter.C26131;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.events.permalink.messageguests.EventBasicGuestListAdapter;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bridge_args= */
public class EventGuestListFragment extends FbFragment implements AnalyticsFragmentWithExtraData, EventGuestListPageListener {
    @Inject
    EventEventLogger f18364a;
    private final boolean al = true;
    public int am;
    public int an;
    public int ao;
    public C26131 ap;
    public EventActionContext aq;
    @Inject
    EventGuestListAdapterProvider f18365b;
    @Inject
    PerformanceLogger f18366c;
    @Inject
    public EventGuestListPager f18367d;
    @Inject
    @IsWorkBuild
    Boolean f18368e;
    private BetterListView f18369f;
    public EventGuestListAdapter f18370g;
    private FbTextView f18371h;
    private ProgressBar f18372i;

    /* compiled from: bridge_args= */
    class C26021 implements OnDrawListener {
        final /* synthetic */ EventGuestListFragment f18361a;

        C26021(EventGuestListFragment eventGuestListFragment) {
            this.f18361a = eventGuestListFragment;
        }

        public final boolean gD_() {
            if (!this.f18361a.f18370g.isEmpty()) {
                this.f18361a.f18366c.c(393228, "EventGuestListTTI");
                return true;
            } else if (this.f18361a.f18367d.f18402c != null || this.f18361a.f18367d.f18404e != PageState.ERROR) {
                return false;
            } else {
                this.f18361a.f18366c.f(393228, "EventGuestListTTI");
                return true;
            }
        }
    }

    /* compiled from: bridge_args= */
    class C26032 implements OnScrollListener {
        final /* synthetic */ EventGuestListFragment f18362a;

        C26032(EventGuestListFragment eventGuestListFragment) {
            this.f18362a = eventGuestListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                this.f18362a.f18367d.m18769c();
            }
        }
    }

    /* compiled from: bridge_args= */
    /* synthetic */ class C26043 {
        static final /* synthetic */ int[] f18363a = new int[EventGuestListType.values().length];

        static {
            try {
                f18363a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18363a[EventGuestListType.PUBLIC_GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18363a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18363a[EventGuestListType.PUBLIC_WATCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18363a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18363a[EventGuestListType.PUBLIC_INVITED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18363a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static void m18707a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventGuestListFragment) obj).m18706a(EventEventLogger.m18119b(injectorLike), (EventGuestListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventGuestListAdapterProvider.class), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), EventGuestListPager.m18756b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public static EventGuestListFragment m18705a(Bundle bundle, EventGuestListType eventGuestListType) {
        EventGuestListFragment eventGuestListFragment = new EventGuestListFragment();
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("EVENT_GUEST_LIST_RSVP_TYPE", eventGuestListType.toString());
        eventGuestListFragment.g(bundle2);
        return eventGuestListFragment;
    }

    public final void m18718c(Bundle bundle) {
        boolean z;
        super.c(bundle);
        Class cls = EventGuestListFragment.class;
        m18707a((Object) this, getContext());
        this.f18366c.d(393228, "EventGuestListTTI");
        EventsGuestListInitializationModel az = az();
        if (Event.a(az.e()) && Event.a(az.d()) && az.g) {
            z = true;
        } else {
            z = false;
        }
        EventGuestListAdapterProvider eventGuestListAdapterProvider = this.f18365b;
        EventActionContext eventActionContext = az.a;
        if (this.aq == null) {
            this.aq = eventActionContext.a(ActionSource.GUESTS_VIEW);
        }
        this.f18370g = new EventGuestListAdapter(FriendingEventBus.a(eventGuestListAdapterProvider), (Context) eventGuestListAdapterProvider.getInstance(Context.class), this.aq, az, aB(), z);
        this.f18370g.f18337e = this;
        this.f18367d.m18765a(az, aB(), (EventGuestListPageListener) this, Boolean.valueOf(z));
    }

    public final View m18711a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1426561533);
        View inflate = layoutInflater.inflate(2130904038, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -267786980, a);
        return inflate;
    }

    public final void m18712a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f18371h = (FbTextView) e(2131561303);
        this.f18372i = (ProgressBar) e(2131561304);
        this.f18369f = (BetterListView) e(2131561302);
        this.f18369f.a(new C26021(this));
        this.f18369f.setAdapter(this.f18370g);
        this.f18369f.setDivider(null);
        this.f18369f.requestLayout();
        this.f18367d.m18769c();
        this.f18369f.setOnScrollListener(new C26032(this));
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2089233498);
        this.f18366c.a(393228, "EventGuestListTTI");
        this.f18371h = null;
        this.f18372i = null;
        this.f18369f = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1222184235, a);
    }

    public final void m18710I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1602335261);
        EventGuestListAdapter eventGuestListAdapter = this.f18370g;
        eventGuestListAdapter.f18344l.b(eventGuestListAdapter.f18345m);
        this.f18367d.m18770d();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 167154015, a);
    }

    public final Map<String, Object> m18717c() {
        return EventEventLogger.m18117a(aA());
    }

    public final String am_() {
        return "event_guest_list";
    }

    private void ay() {
        EventEventLogger eventEventLogger = this.f18364a;
        String aA = aA();
        if (!eventEventLogger.f17780b) {
            HoneyClientEventFast a = eventEventLogger.f17787i.a("view_event_guest_list", false);
            if (a.a()) {
                a.a("event_permalink").c(aA).b("Event").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b();
            }
            eventEventLogger.f17780b = true;
        }
    }

    public final void m18709G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1462533658);
        super.G();
        ay();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 636016164, a);
    }

    private int m18708b(EventGuestListType eventGuestListType) {
        switch (C26043.f18363a[eventGuestListType.ordinal()]) {
            case 1:
                if (this.f18368e.booleanValue()) {
                    return 2131237104;
                }
                return 2131237103;
            case 2:
                return 2131237109;
            case 3:
                return this.f18368e.booleanValue() ? 2131237106 : 2131237105;
            case 4:
                return 2131237113;
            case 5:
                return this.f18368e.booleanValue() ? 2131237108 : 2131237107;
            case 6:
                return 2131237114;
            case 7:
                return this.f18368e.booleanValue() ? 2131237111 : 2131237110;
            default:
                throw new IllegalStateException("No empty guest list text for currentRsvpType: " + eventGuestListType);
        }
    }

    public final void mo839a(EventGuestListType eventGuestListType) {
        if (this.f18372i != null) {
            this.f18372i.setVisibility(8);
        }
        if (this.f18371h != null && this.f18369f != null) {
            if (this.f18370g.getCount() == 0) {
                this.f18371h.setVisibility(0);
                this.f18371h.setText(m18708b(eventGuestListType));
                this.f18369f.setVisibility(8);
                this.f18366c.c(393228, "EventGuestListTTI");
                return;
            }
            this.f18371h.setVisibility(8);
            this.f18369f.setVisibility(0);
        }
    }

    public final void mo842e() {
        if (!this.f18370g.isEmpty()) {
            if (this.f18372i != null) {
                this.f18372i.setVisibility(8);
            }
            if (this.f18371h != null) {
                this.f18371h.setVisibility(8);
            }
            if (this.f18369f != null) {
                this.f18369f.setVisibility(0);
            }
        }
    }

    private void m18706a(EventEventLogger eventEventLogger, EventGuestListAdapterProvider eventGuestListAdapterProvider, PerformanceLogger performanceLogger, EventGuestListPager eventGuestListPager, Boolean bool) {
        this.f18364a = eventEventLogger;
        this.f18365b = eventGuestListAdapterProvider;
        this.f18366c = performanceLogger;
        this.f18367d = eventGuestListPager;
        this.f18368e = bool;
    }

    public final void mo841a(boolean z) {
        this.f18370g.m18673a(z);
    }

    public final void mo840a(ImmutableList<EventGuestListSection> immutableList) {
        this.f18370g.m18672a((ImmutableList) immutableList);
    }

    private String aA() {
        return az().b;
    }

    public final int aq() {
        if (this.f18370g == null) {
            return 0;
        }
        EventBasicGuestListAdapter eventBasicGuestListAdapter = this.f18370g;
        int i = 0;
        for (int i2 = 0; i2 < eventBasicGuestListAdapter.f18334h.size(); i2++) {
            i += ((EventGuestListSection) eventBasicGuestListAdapter.f18334h.get(i2)).e().size();
        }
        return i;
    }

    public final int ar() {
        if (this.f18370g == null) {
            return 0;
        }
        EventBasicGuestListAdapter eventBasicGuestListAdapter = this.f18370g;
        int i = 0;
        if (eventBasicGuestListAdapter.f18332f != null) {
            int[] iArr = eventBasicGuestListAdapter.f18332f;
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = (iArr[i2] + 1) + i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public final void m18713a(EventUser eventUser, @Nullable EventGuestListType eventGuestListType) {
        if (this.ap != null) {
            C26131 c26131 = this.ap;
            EventGuestListType aB = aB();
            for (int i = 0; i < c26131.f18418a; i++) {
                ((List) c26131.f18419b.f18433m.get(i)).remove(eventUser);
                ((List) c26131.f18419b.f18432l.get(i)).remove(eventUser);
                if (c26131.f18419b.f18429i.get(i) == aB) {
                    ((List) c26131.f18419b.f18433m.get(i)).add(eventUser);
                }
                if (c26131.f18419b.f18429i.get(i) == eventGuestListType) {
                    ((List) c26131.f18419b.f18432l.get(i)).add(eventUser);
                }
            }
        }
        if (this.f18370g != null) {
            EventGuestListAdapter eventGuestListAdapter = this.f18370g;
            eventGuestListAdapter.f18342j.put(eventUser.b, eventGuestListType);
        }
    }

    private EventGuestListType aB() {
        return EventGuestListType.fromString(this.s.getString("EVENT_GUEST_LIST_RSVP_TYPE"));
    }

    private EventsGuestListInitializationModel az() {
        return (EventsGuestListInitializationModel) this.s.getParcelable("GUEST_LIST_INITIALIZATION_MODEL");
    }
}
