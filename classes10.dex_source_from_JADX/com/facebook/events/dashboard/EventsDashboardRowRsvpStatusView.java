package com.facebook.events.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.eventsevents.EventsEvents.EventIgnoredEvent;
import com.facebook.events.model.Event;
import com.facebook.events.model.Event.Builder;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.actionbar.ActionItemDelete;
import com.facebook.events.permalink.actionbar.ActionItemEdit;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.events.permalink.actionbar.ActionItemRsvp;
import com.facebook.events.permalink.actionbar.ActionItemRsvp.C25546;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.events.widget.eventcard.EventActionButtonState;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector.PrivateEventOptionsPresenter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector.PublicEventOptionsPresenter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.events.widget.eventcard.EventsRsvpActionListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.location.intent.extra.geofence_list */
public class EventsDashboardRowRsvpStatusView extends ImageView {
    @Inject
    ActionItemRsvp f16729a;
    @Inject
    ActionItemEdit f16730b;
    @Inject
    ActionItemInvite f16731c;
    @Inject
    ActionItemDelete f16732d;
    @Inject
    EventsConnectionExperimentController f16733e;
    @Inject
    EventActionButtonStateSelectorProvider f16734f;
    @Inject
    EventsDashboardController f16735g;
    @Inject
    GlyphColorizer f16736h;
    public Event f16737i;
    private EventAnalyticsParams f16738j;
    private EventActionButtonState f16739k;
    private OnClickListener f16740l;
    private EventsRsvpActionListener f16741m;

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23331 implements OnClickListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16720a;

        C23331(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16720a = eventsDashboardRowRsvpStatusView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 553058111);
            if (this.f16720a.f16737i == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Event model is not set, use bindModel() before");
                Logger.a(2, EntryType.UI_INPUT_END, -1198585184, a);
                throw illegalStateException;
            }
            if (this.f16720a.f16737i.a(EventViewerCapability.ADMIN)) {
                EventsDashboardRowRsvpStatusView.m17132c(this.f16720a);
            } else if (!this.f16720a.f16737i.x && this.f16720a.f16737i.A) {
                this.f16720a.f16729a.m18407a(this.f16720a.f16737i.D(), this.f16720a, this.f16720a, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS, true);
            }
            LogUtils.a(1853968596, a);
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23342 implements EventsRsvpActionListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16721a;

        C23342(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16721a = eventsDashboardRowRsvpStatusView;
        }

        public final void m17113a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
            this.f16721a.f16729a.m18408a(graphQLEventGuestStatus2, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS, true);
        }

        public final void m17114a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
            ActionItemRsvp actionItemRsvp = this.f16721a.f16729a;
            ActionMechanism actionMechanism = ActionMechanism.DASHBOARD_ROW_GUEST_STATUS;
            Event event = actionItemRsvp.f18030d;
            Builder builder = new Builder(actionItemRsvp.f18030d);
            builder.G = false;
            builder = builder;
            builder.C = graphQLEventWatchStatus2;
            builder = builder;
            builder.B = Event.a(graphQLEventWatchStatus2);
            Event b = builder.b();
            boolean z = graphQLEventWatchStatus2 == GraphQLEventWatchStatus.UNWATCHED;
            if (z) {
                actionItemRsvp.f18033g.a(new EventIgnoredEvent(b, false));
            }
            EventsProvider.a(actionItemRsvp.f18034h, actionItemRsvp.f18035i, b, actionItemRsvp.f18036j);
            actionItemRsvp.f18029b.a(actionItemRsvp, actionItemRsvp.f18043q.a(actionItemRsvp.f18030d.a, graphQLEventWatchStatus2, actionItemRsvp.f18031e, actionMechanism), new C25546(actionItemRsvp, z, b, event));
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23353 implements EventsRsvpActionListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16722a;

        C23353(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16722a = eventsDashboardRowRsvpStatusView;
        }

        public final void m17115a(GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2) {
            ActionItemRsvp actionItemRsvp = this.f16722a.f16729a;
            actionItemRsvp.m18400a(EventGraphQLModelHelper.m19259a(actionItemRsvp.f18030d), graphQLEventGuestStatus2, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS);
        }

        public final void m17116a(GraphQLEventWatchStatus graphQLEventWatchStatus, GraphQLEventWatchStatus graphQLEventWatchStatus2) {
            this.f16722a.f16729a.m18410b(graphQLEventWatchStatus2, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS);
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23364 implements OnMenuItemClickListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16723a;

        C23364(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16723a = eventsDashboardRowRsvpStatusView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16723a.f16731c.m18367a(this.f16723a.f16737i, ActionMechanism.DASHBOARD_ROW_GUEST_STATUS.toString());
            return true;
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23375 implements OnMenuItemClickListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16724a;

        C23375(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16724a = eventsDashboardRowRsvpStatusView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16724a.f16730b.m18348a(ActionMechanism.DASHBOARD_ROW_GUEST_STATUS);
            return true;
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    class C23386 implements OnMenuItemClickListener {
        final /* synthetic */ EventsDashboardRowRsvpStatusView f16725a;

        C23386(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
            this.f16725a = eventsDashboardRowRsvpStatusView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f16725a.f16732d.m18343a(ActionMechanism.DASHBOARD_ROW_GUEST_STATUS);
            return true;
        }
    }

    /* compiled from: com.google.android.location.intent.extra.geofence_list */
    public class State {
        Event f16726a;
        EventActionButtonState f16727b;
        EventAnalyticsParams f16728c;

        public State(Event event, EventActionButtonState eventActionButtonState, EventAnalyticsParams eventAnalyticsParams) {
            this.f16726a = event;
            this.f16727b = eventActionButtonState;
            this.f16728c = eventAnalyticsParams;
        }
    }

    private static <T extends View> void m17125a(Class<T> cls, T t) {
        m17126a((Object) t, t.getContext());
    }

    private static void m17126a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsDashboardRowRsvpStatusView) obj).m17124a(ActionItemRsvp.m18397b(injectorLike), ActionItemEdit.m18347b(injectorLike), ActionItemInvite.m18355a(injectorLike), ActionItemDelete.m18341b(injectorLike), EventsConnectionExperimentController.a(injectorLike), (EventActionButtonStateSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), EventsDashboardController.m16975a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    private void m17124a(ActionItemRsvp actionItemRsvp, ActionItemEdit actionItemEdit, ActionItemInvite actionItemInvite, ActionItemDelete actionItemDelete, EventsConnectionExperimentController eventsConnectionExperimentController, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, EventsDashboardController eventsDashboardController, GlyphColorizer glyphColorizer) {
        this.f16729a = actionItemRsvp;
        this.f16730b = actionItemEdit;
        this.f16731c = actionItemInvite;
        this.f16732d = actionItemDelete;
        this.f16733e = eventsConnectionExperimentController;
        this.f16734f = eventActionButtonStateSelectorProvider;
        this.f16735g = eventsDashboardController;
        this.f16736h = glyphColorizer;
    }

    public EventsDashboardRowRsvpStatusView(Context context) {
        super(context);
        m17123a();
    }

    public EventsDashboardRowRsvpStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17123a();
    }

    public EventsDashboardRowRsvpStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17123a();
    }

    private void m17123a() {
        m17125a(EventsDashboardRowRsvpStatusView.class, (View) this);
        this.f16740l = new C23331(this);
        this.f16741m = new C23342(this);
    }

    public final void m17134a(State state) {
        m17135a(state.f16726a, state.f16727b, state.f16728c);
    }

    public final void m17135a(Event event, @Nullable EventActionButtonState eventActionButtonState, @Nullable EventAnalyticsParams eventAnalyticsParams) {
        this.f16737i = event;
        this.f16739k = eventActionButtonState;
        this.f16738j = eventAnalyticsParams;
        if (eventAnalyticsParams == null || eventActionButtonState == null) {
            setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.f16729a.m18406a(event, eventAnalyticsParams);
        this.f16730b.m18350a(event, eventAnalyticsParams);
        this.f16732d.m18344a(event, eventAnalyticsParams);
        setVisibility(0);
        setImageDrawable(eventActionButtonState.a);
        setContentDescription(eventActionButtonState.b);
        setOnClickListener(eventActionButtonState.c);
    }

    private void m17129b() {
        this.f16741m = new C23353(this);
    }

    @Nullable
    private EventActionButtonState m17122a(Event event) {
        return m17133a(event, false);
    }

    @Nullable
    public final EventActionButtonState m17133a(Event event, boolean z) {
        if (this.f16735g.f16570c == DashboardFilterType.PAST || event.G) {
            return null;
        }
        if (z) {
            m17129b();
        }
        boolean z2 = true;
        if (event.a(EventViewerCapability.ADMIN)) {
            return new EventActionButtonState(m17119a(z2), getAdminContentDescription(), this.f16740l);
        }
        boolean a = Event.a(event);
        if (z2 && a) {
            GraphQLEventWatchStatus graphQLEventWatchStatus = event.C;
            if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED || graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING || graphQLEventWatchStatus == GraphQLEventWatchStatus.DECLINED) {
                if (z) {
                    return this.f16734f.a(this.f16741m).b(event.l, event.D(), graphQLEventWatchStatus);
                }
                return this.f16734f.a(this.f16741m).a(event.l, event.D(), graphQLEventWatchStatus);
            }
        }
        GraphQLEventGuestStatus D = event.D();
        if (D == GraphQLEventGuestStatus.GOING || D == GraphQLEventGuestStatus.MAYBE || D == GraphQLEventGuestStatus.NOT_GOING) {
            return z ? this.f16734f.a(this.f16741m).b(event.l, D, event.C) : new EventActionButtonState(m17120a(z2, D), m17131c(D), this.f16740l);
        }
        if (!event.D) {
            return null;
        }
        PublicEventOptionsPresenter publicEventOptionsPresenter;
        Drawable b = m17128b(z2);
        String savedContentDescription = getSavedContentDescription();
        EventActionButtonStateSelector a2 = this.f16734f.a(this.f16741m);
        if (event.l == GraphQLConnectionStyle.INTERESTED) {
            publicEventOptionsPresenter = new PublicEventOptionsPresenter(a2, EventsConnectionExperimentController.b(), null);
        } else {
            publicEventOptionsPresenter = new PrivateEventOptionsPresenter(a2, null);
        }
        return new EventActionButtonState(b, savedContentDescription, publicEventOptionsPresenter);
    }

    public void setOptimisticEvent(Event event) {
        m17135a(event, m17122a(event), this.f16738j);
    }

    public State getBoundModelAndState() {
        return new State(this.f16737i, this.f16739k, this.f16738j);
    }

    private Drawable m17119a(boolean z) {
        return z ? m17117a(2130839498) : m17117a(2130838370);
    }

    private Drawable m17120a(boolean z, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        return z ? m17118a(graphQLEventGuestStatus) : m17127b(graphQLEventGuestStatus);
    }

    private Drawable m17118a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return m17117a(2130839490);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return m17117a(2130839493);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return m17117a(2130839489);
        }
        return null;
    }

    private Drawable m17127b(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return m17117a(2130838369);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return m17117a(2130838372);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return m17117a(2130838358);
        }
        return null;
    }

    private Drawable m17128b(boolean z) {
        return z ? m17117a(2130839499) : m17117a(2130838373);
    }

    private String getAdminContentDescription() {
        return getResources().getString(2131237138);
    }

    private String getSavedContentDescription() {
        return getResources().getString(2131237137);
    }

    private String m17131c(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return getResources().getString(2131233852);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return getResources().getString(2131233853);
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return getResources().getString(2131233854);
        }
        return null;
    }

    private Drawable m17117a(int i) {
        return this.f16736h.a(i, -10972929);
    }

    public static void m17132c(EventsDashboardRowRsvpStatusView eventsDashboardRowRsvpStatusView) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(eventsDashboardRowRsvpStatusView.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        if (!eventsDashboardRowRsvpStatusView.f16737i.x) {
            MenuItemImpl a;
            if (eventsDashboardRowRsvpStatusView.f16738j != null) {
                a = c.a(2131237042);
                a.setIcon(2130838371);
                a.setOnMenuItemClickListener(new C23364(eventsDashboardRowRsvpStatusView));
            }
            a = c.a(2131237045);
            a.setIcon(2130838360);
            a.setOnMenuItemClickListener(new C23375(eventsDashboardRowRsvpStatusView));
        }
        MenuItemImpl a2 = c.a(2131237052);
        a2.setIcon(2130838359);
        a2.setOnMenuItemClickListener(new C23386(eventsDashboardRowRsvpStatusView));
        figPopoverMenuWindow.f(eventsDashboardRowRsvpStatusView);
    }
}
