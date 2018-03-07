package com.facebook.events.permalink.messageguests;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.EventGuestListPageListener;
import com.facebook.events.permalink.guestlist.EventGuestListPager;
import com.facebook.events.permalink.guestlist.EventGuestListPager.PageState;
import com.facebook.events.permalink.guestlist.EventGuestListSection;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: bf72ce643066c5e150eb92b94768dea1 */
public class EventMessageGuestsFragment extends FbFragment implements AnalyticsFragmentWithExtraData, EventGuestListPageListener {
    @Inject
    public EventEventLogger f18645a;
    public EventMessageGuestsFrameFragment al;
    public EventMessageGuestsAdapter am;
    @Inject
    public EventMessageGuestsAdapterProvider f18646b;
    @Inject
    public PerformanceLogger f18647c;
    @Inject
    public EventGuestListPager f18648d;
    public final Set<String> f18649e = Sets.a();
    public BetterListView f18650f;
    private FbTextView f18651g;
    private ProgressBar f18652h;
    private boolean f18653i;

    /* compiled from: bf72ce643066c5e150eb92b94768dea1 */
    class C26531 implements OnDrawListener {
        final /* synthetic */ EventMessageGuestsFragment f18641a;

        C26531(EventMessageGuestsFragment eventMessageGuestsFragment) {
            this.f18641a = eventMessageGuestsFragment;
        }

        public final boolean gD_() {
            if (!this.f18641a.am.isEmpty()) {
                this.f18641a.f18647c.c(393229, "EventMessageGuestsTTI");
                return true;
            } else if (this.f18641a.f18648d.f18402c != null || this.f18641a.f18648d.f18404e != PageState.ERROR) {
                return false;
            } else {
                this.f18641a.f18647c.f(393229, "EventMessageGuestsTTI");
                return true;
            }
        }
    }

    /* compiled from: bf72ce643066c5e150eb92b94768dea1 */
    class C26542 implements OnScrollListener {
        final /* synthetic */ EventMessageGuestsFragment f18642a;

        C26542(EventMessageGuestsFragment eventMessageGuestsFragment) {
            this.f18642a = eventMessageGuestsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                this.f18642a.f18648d.m18769c();
            }
        }
    }

    /* compiled from: bf72ce643066c5e150eb92b94768dea1 */
    class C26553 implements OnItemClickListener {
        final /* synthetic */ EventMessageGuestsFragment f18643a;

        C26553(EventMessageGuestsFragment eventMessageGuestsFragment) {
            this.f18643a = eventMessageGuestsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EventMessageGuestsFragment eventMessageGuestsFragment = this.f18643a;
            EventUser eventUser = (EventUser) this.f18643a.f18650f.getAdapter().getItem(i);
            if (eventMessageGuestsFragment.f18649e.contains(eventUser.b)) {
                eventMessageGuestsFragment.f18649e.remove(eventUser.b);
            } else {
                eventMessageGuestsFragment.f18649e.add(eventUser.b);
            }
            eventMessageGuestsFragment.al.m18970a();
            eventUser.k = !eventUser.k;
            AdapterDetour.a(eventMessageGuestsFragment.am, 605232281);
        }
    }

    /* compiled from: bf72ce643066c5e150eb92b94768dea1 */
    /* synthetic */ class C26564 {
        static final /* synthetic */ int[] f18644a = new int[EventGuestListType.values().length];

        static {
            try {
                f18644a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18644a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18644a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m18952a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EventMessageGuestsFragment eventMessageGuestsFragment = (EventMessageGuestsFragment) obj;
        EventEventLogger b = EventEventLogger.m18119b(injectorLike);
        EventMessageGuestsAdapterProvider eventMessageGuestsAdapterProvider = (EventMessageGuestsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventMessageGuestsAdapterProvider.class);
        PerformanceLogger performanceLogger = (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike);
        EventGuestListPager b2 = EventGuestListPager.m18756b(injectorLike);
        eventMessageGuestsFragment.f18645a = b;
        eventMessageGuestsFragment.f18646b = eventMessageGuestsAdapterProvider;
        eventMessageGuestsFragment.f18647c = performanceLogger;
        eventMessageGuestsFragment.f18648d = b2;
    }

    public final void m18962c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventMessageGuestsFragment.class;
        m18952a((Object) this, getContext());
        this.f18653i = true;
        this.f18647c.d(393229, "EventMessageGuestsTTI");
        this.f18648d.m18766a(at(), Boolean.valueOf(this.s.getBoolean("EVENT_IS_HOST")), ar(), (EventGuestListPageListener) this);
        Fragment fragment = this.G;
        Preconditions.checkArgument(fragment instanceof EventMessageGuestsFrameFragment, "Parent fragment must implement EventMessageGuestsListener");
        this.al = (EventMessageGuestsFrameFragment) fragment;
        EventMessageGuestsAdapterProvider eventMessageGuestsAdapterProvider = this.f18646b;
        this.am = new EventMessageGuestsAdapter((Context) eventMessageGuestsAdapterProvider.getInstance(Context.class), ar());
    }

    public final View m18956a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1157550130);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625810)).inflate(2130904038, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1936655349, a);
        return inflate;
    }

    public final void m18957a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f18651g = (FbTextView) e(2131561303);
        this.f18652h = (ProgressBar) e(2131561304);
        this.f18650f = (BetterListView) e(2131561302);
        if (this.f18653i) {
            this.f18650f.a(new C26531(this));
        }
        this.f18650f.setAdapter(this.am);
        this.f18650f.requestLayout();
        this.f18648d.m18769c();
        this.f18650f.setOnScrollListener(new C26542(this));
        this.f18650f.setOnItemClickListener(new C26553(this));
    }

    public final Set<String> aq() {
        return ImmutableSet.copyOf(this.f18649e);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 563501765);
        if (this.f18653i) {
            this.f18647c.a(393229, "EventMessageGuestsTTI");
        }
        this.f18651g = null;
        this.f18652h = null;
        this.f18650f = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2091540947, a);
    }

    public final void m18955I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1716831897);
        this.f18648d.m18770d();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1273236655, a);
    }

    public final Map<String, Object> m18961c() {
        return EventEventLogger.m18117a(at());
    }

    public final String am_() {
        return "event_message_guests";
    }

    private void as() {
        EventEventLogger eventEventLogger = this.f18645a;
        String at = at();
        if (!eventEventLogger.f17781c) {
            HoneyClientEventFast a = eventEventLogger.f17787i.a("message_event_guests", false);
            if (a.a()) {
                a.a("event_permalink").c(at).b("Event").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).b();
            }
            eventEventLogger.f17781c = true;
        }
    }

    public final void m18954G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 573568723);
        super.G();
        as();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2117259665, a);
    }

    private static int m18953b(EventGuestListType eventGuestListType) {
        switch (C26564.f18644a[eventGuestListType.ordinal()]) {
            case 1:
                return 2131237103;
            case 2:
                return 2131237105;
            case 3:
                return 2131237107;
            default:
                throw new IllegalStateException("No empty guest list text for currentRsvpType: " + eventGuestListType);
        }
    }

    public final void mo839a(EventGuestListType eventGuestListType) {
        if (this.f18652h != null) {
            this.f18652h.setVisibility(8);
        }
        if (this.f18651g != null && this.f18650f != null) {
            if (this.am.getCount() == 0) {
                this.f18651g.setVisibility(0);
                this.f18651g.setText(m18953b(eventGuestListType));
                this.f18650f.setVisibility(8);
                if (this.f18653i) {
                    this.f18647c.c(393229, "EventMessageGuestsTTI");
                    return;
                }
                return;
            }
            this.f18651g.setVisibility(8);
            this.f18650f.setVisibility(0);
        }
    }

    public final void mo842e() {
        if (!this.am.isEmpty()) {
            if (this.f18652h != null) {
                this.f18652h.setVisibility(8);
            }
            if (this.f18651g != null) {
                this.f18651g.setVisibility(8);
            }
            if (this.f18650f != null) {
                this.f18650f.setVisibility(0);
            }
        }
    }

    public final void mo841a(boolean z) {
        this.am.m18673a(z);
    }

    public final void mo840a(ImmutableList<EventGuestListSection> immutableList) {
        this.am.m18672a((ImmutableList) immutableList);
    }

    private String at() {
        return this.s.getString("EVENT_ID");
    }

    public final EventGuestListType ar() {
        return EventGuestListType.fromString(this.s.getString("EVENT_GUEST_LIST_RSVP_TYPE"));
    }
}
