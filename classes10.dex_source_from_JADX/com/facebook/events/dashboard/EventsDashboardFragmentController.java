package com.facebook.events.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventIgnoredEvent;
import com.facebook.events.eventsevents.EventsEvents.EventIgnoredEventSubscriber;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.RespondingInviteEvent;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: commerce_insights */
public class EventsDashboardFragmentController {
    public GenericNotificationBanner f16653a;
    public EventAnalyticsParams f16654b;
    @Nullable
    public InviteCountChangeListener f16655c;
    public final PrefKey f16656d = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("events/")).a("subscriptions_megaphone"));
    public final FbTitleBarSupplier f16657e;
    public final EventsDashboardFragment f16658f;
    private final DashboardFilterType f16659g;
    public final boolean f16660h;
    public final EventPermalinkController f16661i;
    private final EventsDashboardPerformanceLogger f16662j;
    public final TipSeenTracker f16663k;
    public final EventsEventBus f16664l;
    public final IgnoredEventSubscriber f16665m;
    private final QeAccessor f16666n;
    public final RespondingInviteEventSubscriber f16667o;
    public final Set<Event> f16668p = new HashSet();

    /* compiled from: commerce_insights */
    public interface InviteCountChangeListener {
        int mo781a();

        void mo782a(int i);
    }

    /* compiled from: commerce_insights */
    public class C23241 implements OnDismissListener {
        final /* synthetic */ Megaphone f16645a;
        final /* synthetic */ EventsDashboardFragmentController f16646b;

        public C23241(EventsDashboardFragmentController eventsDashboardFragmentController, Megaphone megaphone) {
            this.f16646b = eventsDashboardFragmentController;
            this.f16645a = megaphone;
        }

        public final void m17058a(Megaphone megaphone) {
            this.f16645a.setVisibility(8);
            this.f16646b.f16663k.a();
        }
    }

    /* compiled from: commerce_insights */
    public class C23252 implements OnClickListener {
        final /* synthetic */ Megaphone f16647a;
        final /* synthetic */ EventsDashboardFragmentController f16648b;

        public C23252(EventsDashboardFragmentController eventsDashboardFragmentController, Megaphone megaphone) {
            this.f16648b = eventsDashboardFragmentController;
            this.f16647a = megaphone;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1897485206);
            this.f16648b.f16658f.ar();
            this.f16647a.setVisibility(8);
            this.f16648b.f16663k.a();
            Logger.a(2, EntryType.UI_INPUT_END, 2036581678, a);
        }
    }

    /* compiled from: commerce_insights */
    public class C23263 extends OnToolbarButtonListener {
        final /* synthetic */ EventsDashboardFragmentController f16649a;

        public final void m17059a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (titleBarButtonSpec.c == 2) {
                this.f16649a.f16661i.m18265a(EventsDashboardFragmentController.m17063k(this.f16649a), this.f16649a.f16654b, ActionMechanism.DASHBOARD_HEADER);
            }
        }

        public C23263(EventsDashboardFragmentController eventsDashboardFragmentController) {
            this.f16649a = eventsDashboardFragmentController;
        }
    }

    /* compiled from: commerce_insights */
    class C23274 implements OnClickListener {
        final /* synthetic */ EventsDashboardFragmentController f16650a;

        C23274(EventsDashboardFragmentController eventsDashboardFragmentController) {
            this.f16650a = eventsDashboardFragmentController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1247619817);
            this.f16650a.f16661i.m18265a(EventsDashboardFragmentController.m17063k(this.f16650a), this.f16650a.f16654b, ActionMechanism.DASHBOARD_FAB);
            Logger.a(2, EntryType.UI_INPUT_END, -1732224786, a);
        }
    }

    /* compiled from: commerce_insights */
    class IgnoredEventSubscriber extends EventIgnoredEventSubscriber {
        final /* synthetic */ EventsDashboardFragmentController f16651a;

        public IgnoredEventSubscriber(EventsDashboardFragmentController eventsDashboardFragmentController) {
            this.f16651a = eventsDashboardFragmentController;
        }

        public final void m17060b(FbEvent fbEvent) {
            EventIgnoredEvent eventIgnoredEvent = (EventIgnoredEvent) fbEvent;
            if (eventIgnoredEvent.a) {
                this.f16651a.f16668p.remove(eventIgnoredEvent.b);
            } else {
                this.f16651a.f16668p.add(eventIgnoredEvent.b);
            }
        }
    }

    /* compiled from: commerce_insights */
    class RespondingInviteEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.RespondingInviteEventSubscriber {
        final /* synthetic */ EventsDashboardFragmentController f16652a;

        public RespondingInviteEventSubscriber(EventsDashboardFragmentController eventsDashboardFragmentController) {
            this.f16652a = eventsDashboardFragmentController;
        }

        public final void m17061b(FbEvent fbEvent) {
            RespondingInviteEvent respondingInviteEvent = (RespondingInviteEvent) fbEvent;
            if (this.f16652a.f16655c != null) {
                int a = this.f16652a.f16655c.mo781a();
                if (respondingInviteEvent.a == EventStatus.SENDING) {
                    this.f16652a.f16655c.mo782a(a - 1);
                } else if (respondingInviteEvent.a == EventStatus.FAILURE) {
                    this.f16652a.f16655c.mo782a(a + 1);
                }
            }
        }
    }

    @Inject
    public EventsDashboardFragmentController(@Assisted EventsDashboardFragment eventsDashboardFragment, @Assisted DashboardFilterType dashboardFilterType, @Assisted Boolean bool, QeAccessor qeAccessor, FbTitleBarSupplier fbTitleBarSupplier, EventPermalinkController eventPermalinkController, EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger, TipSeenTracker tipSeenTracker, EventsEventBus eventsEventBus) {
        this.f16658f = eventsDashboardFragment;
        this.f16659g = dashboardFilterType;
        this.f16660h = bool.booleanValue();
        this.f16666n = qeAccessor;
        this.f16657e = fbTitleBarSupplier;
        this.f16661i = eventPermalinkController;
        this.f16662j = eventsDashboardPerformanceLogger;
        this.f16663k = tipSeenTracker;
        this.f16664l = eventsEventBus;
        this.f16665m = new IgnoredEventSubscriber(this);
        this.f16664l.a(this.f16665m);
        this.f16667o = new RespondingInviteEventSubscriber(this);
        this.f16664l.a(this.f16667o);
    }

    private Bundle m17062j() {
        return this.f16658f.s;
    }

    public static Context m17063k(EventsDashboardFragmentController eventsDashboardFragmentController) {
        return eventsDashboardFragmentController.f16658f.getContext();
    }

    public final void m17066a() {
        EventActionContext eventActionContext;
        if (this.f16659g != DashboardFilterType.BIRTHDAYS) {
            this.f16662j.m17095a();
        }
        Bundle j = m17062j();
        if (j != null) {
            ActionSource actionSource = (ActionSource) j.getParcelable("action_ref");
            if (actionSource != null) {
                if (ActionSource.LAUNCHER.equals(actionSource)) {
                    eventActionContext = new EventActionContext(ActionSource.DASHBOARD, actionSource, true);
                } else {
                    eventActionContext = new EventActionContext(ActionSource.DASHBOARD, actionSource, false);
                }
                this.f16654b = new EventAnalyticsParams(eventActionContext, m17064m(), this.f16658f.am_().toString(), null);
            }
        }
        eventActionContext = EventActionContext.b;
        this.f16654b = new EventAnalyticsParams(eventActionContext, m17064m(), this.f16658f.am_().toString(), null);
    }

    public final void m17068b() {
        this.f16653a = (GenericNotificationBanner) this.f16658f.e(2131560231);
    }

    public final void m17069c() {
        Object obj;
        if (this.f16660h) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (((HasTitleBar) this.f16658f.a(HasTitleBar.class)) != null) {
                FbTitleBar fbTitleBar = (FbTitleBar) this.f16657e.get();
                if (fbTitleBar != null) {
                    fbTitleBar.setButtonSpecs(new ArrayList());
                    fbTitleBar.setOnToolbarButtonListener(new C23263(this));
                }
            }
            if (this.f16666n.a(ExperimentsForEventsGatingModule.y, false) || this.f16666n.a(ExperimentsForEventsGatingModule.B, false)) {
                m17065o();
            }
        } else {
            m17065o();
        }
        this.f16668p.clear();
    }

    private String m17064m() {
        String string = m17062j().getString("event_source_module");
        return string != null ? string : "unknown".toString();
    }

    public final void m17067a(NotificationBannerType notificationBannerType) {
        this.f16653a.a(notificationBannerType);
    }

    public final void m17070h() {
        this.f16653a.a();
    }

    private void m17065o() {
        View e = this.f16658f.e(2131560261);
        e.setOnClickListener(new C23274(this));
        e.setVisibility(0);
    }

    public final ImmutableSet<Event> m17071i() {
        return ImmutableSet.copyOf(this.f16668p);
    }
}
