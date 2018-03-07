package com.facebook.events.permalink.actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.PublicEventsActionBarGoingButtonSelector;
import com.facebook.events.permalink.interestednux.InterestedNuxController;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: c3412a7de706c2b616014c049a638d2b */
public class EventsToxicleActionBar extends InlineActionBar implements EventPermalinkStandardActionBar {
    @Inject
    EventsEventBus f18120a;
    @Inject
    EventsActionBarMenuHandlerProvider f18121b;
    @Inject
    Provider<PublicEventsActionBarGoingButtonSelector> f18122c;
    @Inject
    AnalyticsLogger f18123d;
    @Inject
    ImpressionManager f18124e;
    @Inject
    InterestedNuxController f18125f;
    @Inject
    QeAccessor f18126g;
    private boolean f18127h;
    private Event f18128i;
    private EventsActionBarMenuHandler f18129j;
    private ImmutableList<EventsActionBarButtonType> f18130k = RegularImmutableList.a;
    private final EventSavingEventSubscriber f18131l = new EventSavingEventSubscriber();
    private final EventUnsavingEventSubscriber f18132m = new EventUnsavingEventSubscriber();
    private EventAnalyticsParams f18133n;
    private int f18134o;

    /* compiled from: c3412a7de706c2b616014c049a638d2b */
    public class EventSavingEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventSavingEventSubscriber {
        public MenuItem f18118a;

        public final void m18476a(MenuItem menuItem) {
            this.f18118a = menuItem;
        }

        public final void m18477b(FbEvent fbEvent) {
            if (this.f18118a != null) {
                this.f18118a.setTitle(2131237030);
                this.f18118a.setEnabled(false);
            }
        }
    }

    /* compiled from: c3412a7de706c2b616014c049a638d2b */
    public class EventUnsavingEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUnsavingEventSubscriber {
        public MenuItem f18119a;

        public final void m18478a(MenuItem menuItem) {
            this.f18119a = menuItem;
        }

        public final void m18479b(FbEvent fbEvent) {
            if (this.f18119a != null) {
                this.f18119a.setTitle(2131237032);
                this.f18119a.setEnabled(false);
            }
        }
    }

    private static <T extends View> void m18487a(Class<T> cls, T t) {
        m18488a((Object) t, t.getContext());
    }

    private static void m18488a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsToxicleActionBar) obj).m18481a(EventsEventBus.a(fbInjector), (EventsActionBarMenuHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventsActionBarMenuHandlerProvider.class), IdBasedProvider.a(fbInjector, 5634), AnalyticsLoggerMethodAutoProvider.a(fbInjector), ImpressionManager.a(fbInjector), InterestedNuxController.m18900b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public EventsToxicleActionBar(Context context) {
        super(context);
        m18493c();
    }

    public EventsToxicleActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18493c();
    }

    public EventsToxicleActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18493c();
    }

    private void m18493c() {
        m18487a(EventsToxicleActionBar.class, (View) this);
        setGravity(17);
        setBackgroundResource(2130843556);
        this.f18129j = this.f18121b.m18475a(this);
        this.b = this.f18129j;
        setVisibility(8);
        this.f18134o = getContext().getResources().getDimensionPixelSize(2131427416);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 35004738);
        super.onAttachedToWindow();
        this.f18120a.a(this.f18131l);
        this.f18120a.a(this.f18132m);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1648903022, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 427745373);
        this.f18120a.b(this.f18131l);
        this.f18120a.b(this.f18132m);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -79322111, a);
    }

    public final void b_(MenuBuilder menuBuilder) {
        HoneyClientEventFast a = this.f18123d.a("event_action_bar_overflow_button_click", true);
        if (a.a()) {
            String str;
            a.a("event_permalink");
            a.d(this.f18124e.b(getContext()));
            a.b("Event");
            if (this.f18128i != null) {
                str = this.f18128i.a;
            } else {
                str = null;
            }
            a.c(str);
            if (this.f18133n != null) {
                a.a("ref_module", this.f18133n.c);
                a.a("source_module", this.f18133n.d);
                a.a("ref_mechanism", this.f18133n.e);
            }
            a.b();
        }
    }

    public final void mo819a() {
    }

    public final void mo820a(boolean z) {
    }

    public void setBoostableStory(BoostableStoryModel boostableStoryModel) {
        this.f18129j.m18470a(boostableStoryModel);
    }

    @VisibleForTesting
    ImmutableList<EventsActionBarButtonType> getButtons() {
        return this.f18130k;
    }

    public final void m18504a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite, boolean z) {
        a(!z, true, this.f18134o);
        this.f18133n = eventAnalyticsParams;
        PublicEventsActionBarGoingButtonSelector publicEventsActionBarGoingButtonSelector = (PublicEventsActionBarGoingButtonSelector) this.f18122c.get();
        boolean z2 = event.G;
        GraphQLEventWatchStatus graphQLEventWatchStatus = event.C;
        if (!z2) {
            if (publicEventsActionBarGoingButtonSelector.f17895a == 0) {
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                    publicEventsActionBarGoingButtonSelector.f17895a = 1;
                } else {
                    publicEventsActionBarGoingButtonSelector.f17895a = 2;
                }
            } else if (publicEventsActionBarGoingButtonSelector.f17895a == 1 && (graphQLEventWatchStatus == GraphQLEventWatchStatus.UNWATCHED || graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED)) {
                publicEventsActionBarGoingButtonSelector.f17895a = 2;
            } else if (publicEventsActionBarGoingButtonSelector.f17895a == 2 && graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                publicEventsActionBarGoingButtonSelector.f17895a = 1;
            }
        }
        this.f18129j.m18469a(eventAnalyticsParams, actionItemPost, actionItemInvite);
        m18482a(event, fetchEventPermalinkFragmentModel);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18127h && this.f18125f.m18902a()) {
            this.f18125f.m18901a(getChildAt(0));
        }
    }

    private void m18482a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f18128i = event;
        this.f18129j.m18471a(event, fetchEventPermalinkFragmentModel);
        m18496e();
    }

    private void m18496e() {
        if (this.f18128i != null) {
            EventActionBarButtonsBuilder eventActionBarButtonsBuilder = new EventActionBarButtonsBuilder(4);
            boolean a = Event.a(this.f18128i);
            if (a) {
                m18490b(eventActionBarButtonsBuilder);
            } else {
                m18483a(eventActionBarButtonsBuilder);
            }
            m18491b(eventActionBarButtonsBuilder, a);
            if (!a) {
                m18486a(eventActionBarButtonsBuilder, this.f18128i.as());
            }
            m18502i(eventActionBarButtonsBuilder);
            setMaxNumOfVisibleButtons(eventActionBarButtonsBuilder.m18417a());
            ImmutableList copyOf = ImmutableList.copyOf(eventActionBarButtonsBuilder.iterator());
            if (!copyOf.equals(this.f18130k)) {
                this.f18130k = copyOf;
                m18498f();
            }
        }
    }

    private void m18486a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder, boolean z) {
        if (this.f18128i.Z == null) {
            return;
        }
        if (z) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PHOTOS);
        } else {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.PHOTOS, EventsActionBarButtonType.PHOTOS_OVERFLOW);
        }
    }

    private void m18483a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18128i.A) {
            if (this.f18128i.a(EventViewerCapability.ADMIN)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            }
            if (this.f18128i.G) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PRIVATE_GOING);
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PRIVATE_MAYBE);
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PRIVATE_CANT_GO);
                return;
            }
            m18484a(eventActionBarButtonsBuilder, this.f18128i.D());
        } else if (this.f18128i.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18128i.x) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANCELLED);
        }
    }

    private static void m18484a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        EventsActionBarButtonType a = m18480a(graphQLEventGuestStatus);
        if (a != null) {
            eventActionBarButtonsBuilder.m18418a(a);
        }
    }

    private static EventsActionBarButtonType m18480a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.GOING) {
            return EventsActionBarButtonType.TOXICLE_PRIVATE_GOING_SELECTED_WITH_CHEVRON;
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.MAYBE) {
            return EventsActionBarButtonType.TOXICLE_PRIVATE_MAYBE_SELECTED_WITH_CHEVRON;
        }
        if (graphQLEventGuestStatus == GraphQLEventGuestStatus.NOT_GOING) {
            return EventsActionBarButtonType.TOXICLE_PRIVATE_CANT_GO_SELECTED_WITH_CHEVRON;
        }
        return null;
    }

    private void m18490b(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        Preconditions.checkArgument(Event.a(this.f18128i));
        if (this.f18128i.a(EventViewerCapability.ADMIN) && ((this.f18128i.a(EventViewerCapability.PROMOTE) || this.f18128i.a(EventViewerCapability.EDIT_PROMOTION)) && this.f18126g.a(ExperimentsForEventsGatingModule.d, false))) {
            m18494c(eventActionBarButtonsBuilder);
        } else if (this.f18128i.A) {
            if (this.f18128i.a(EventViewerCapability.ADMIN)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            }
            if (this.f18128i.G) {
                m18497e(eventActionBarButtonsBuilder);
            } else {
                m18485a(eventActionBarButtonsBuilder, this.f18128i.C);
            }
        } else if (this.f18128i.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18128i.x) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANCELLED);
        }
    }

    private void m18494c(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        GraphQLEventWatchStatus graphQLEventWatchStatus = this.f18128i.C;
        if (!this.f18128i.A) {
            m18495d(eventActionBarButtonsBuilder);
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18128i.G) {
            m18497e(eventActionBarButtonsBuilder);
        } else {
            m18495d(eventActionBarButtonsBuilder);
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON);
            } else if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING_SELECTED_WITH_CHEVRON);
            } else {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING);
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED_OVERFLOW);
            }
        }
    }

    private void m18495d(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18128i.a(EventViewerCapability.PROMOTE)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_PROMOTE);
        } else if (this.f18128i.a(EventViewerCapability.EDIT_PROMOTION)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_PROMOTED);
        }
    }

    private static void m18497e(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED);
        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING);
        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_IGNORE);
    }

    private void m18485a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
            if (((PublicEventsActionBarGoingButtonSelector) this.f18122c.get()).m18309b()) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON);
                return;
            }
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED_SELECTED);
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING);
        } else if (graphQLEventWatchStatus != GraphQLEventWatchStatus.GOING) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED);
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING);
            this.f18127h = true;
        } else if (((PublicEventsActionBarGoingButtonSelector) this.f18122c.get()).m18308a()) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING_SELECTED_WITH_CHEVRON);
        } else {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_INTERESTED);
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.TOXICLE_PUBLIC_GOING_SELECTED);
        }
    }

    private void m18491b(EventActionBarButtonsBuilder eventActionBarButtonsBuilder, boolean z) {
        if (!z) {
            m18501h(eventActionBarButtonsBuilder);
        } else if (this.f18128i.m == GraphQLEventActionStyle.SEND) {
            m18500g(eventActionBarButtonsBuilder);
        } else if (this.f18128i.m == GraphQLEventActionStyle.SHARE) {
            m18499f(eventActionBarButtonsBuilder);
        } else {
            if (!this.f18126g.a(ExperimentsForEventsGatingModule.D, "").equals("invite")) {
                if (this.f18126g.a(ExperimentsForEventsGatingModule.D, "").equals("send")) {
                    m18500g(eventActionBarButtonsBuilder);
                    return;
                } else if (this.f18126g.a(ExperimentsForEventsGatingModule.D, "").equals("share")) {
                    m18499f(eventActionBarButtonsBuilder);
                    return;
                }
            }
            m18501h(eventActionBarButtonsBuilder);
        }
    }

    private static void m18499f(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.PUBLIC_INVITE_QE_SHARE, EventsActionBarButtonType.PUBLIC_INVITE_QE_SHARE_OVERFLOW);
    }

    private static void m18500g(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.PUBLIC_INVITE_QE_SEND, EventsActionBarButtonType.PUBLIC_INVITE_QE_SEND_OVERFLOW);
    }

    private void m18501h(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        boolean a = this.f18128i.a(EventViewerCapability.INVITE);
        boolean a2 = this.f18128i.a(EventViewerCapability.SHARE);
        if (a && a2) {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.INVITE_OR_SHARE, EventsActionBarButtonType.INVITE_OR_SHARE_OVERFLOW);
        } else if (a) {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.INVITE, EventsActionBarButtonType.INVITE_OVERFLOW);
        } else if (a2) {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.SHARE, EventsActionBarButtonType.SHARE_OVERFLOW);
        }
    }

    private void m18502i(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18129j.m18472a()) {
            EventsActionBarButtonType eventsActionBarButtonType;
            if (this.f18128i.D) {
                eventsActionBarButtonType = EventsActionBarButtonType.SAVED;
            } else {
                eventsActionBarButtonType = EventsActionBarButtonType.SAVE;
            }
            eventActionBarButtonsBuilder.m18420b(eventsActionBarButtonType);
        }
        if (this.f18128i.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.DELETE);
        }
        if (this.f18128i.l == GraphQLConnectionStyle.RSVP || !(this.f18128i.l != GraphQLConnectionStyle.INTERESTED || this.f18126g.a(ExperimentsForEventsGatingModule.D, "").equals("send") || this.f18126g.a(ExperimentsForEventsGatingModule.D, "").equals("share"))) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.COPY_LINK);
        }
        if (this.f18126g.a(ExperimentsForEventsGatingModule.t, false)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EXPORT_TO_CALENDAR);
        }
        this.f18128i.b();
        eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.NOTIFICATION_SETTINGS);
        if (this.f18126g.a(ExperimentsForEventsGatingModule.u, false) && this.f18128i.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.CANCEL_EVENT);
        }
        if (!this.f18128i.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.REPORT_EVENT);
        }
        eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.CREATE_EVENT);
    }

    private void m18498f() {
        b();
        clear();
        int size = this.f18130k.size();
        for (int i = 0; i < size; i++) {
            EventsActionBarButtonType eventsActionBarButtonType = (EventsActionBarButtonType) this.f18130k.get(i);
            MenuItem icon = a(0, eventsActionBarButtonType.ordinal(), 0, eventsActionBarButtonType.getTitleResId()).setEnabled(m18489a(eventsActionBarButtonType)).setCheckable(true).setChecked(m18492b(eventsActionBarButtonType)).setIcon(eventsActionBarButtonType.getIconResId());
            if (eventsActionBarButtonType.isOverflow()) {
                MenuItemCompat.a(icon, 0);
            } else {
                MenuItemCompat.a(icon, 2);
            }
            if (eventsActionBarButtonType == EventsActionBarButtonType.SAVE) {
                this.f18131l.f18118a = icon;
            }
            if (eventsActionBarButtonType == EventsActionBarButtonType.SAVED) {
                this.f18132m.f18119a = icon;
            }
        }
        d();
        setVisibility(0);
    }

    private static boolean m18489a(EventsActionBarButtonType eventsActionBarButtonType) {
        return eventsActionBarButtonType != EventsActionBarButtonType.CANCELLED;
    }

    private static boolean m18492b(EventsActionBarButtonType eventsActionBarButtonType) {
        switch (eventsActionBarButtonType) {
            case CREATOR_EDIT:
            case CREATOR_PROMOTED:
            case TOXICLE_PRIVATE_GOING_SELECTED_WITH_CHEVRON:
            case TOXICLE_PRIVATE_MAYBE_SELECTED_WITH_CHEVRON:
            case TOXICLE_PRIVATE_CANT_GO_SELECTED_WITH_CHEVRON:
            case TOXICLE_PUBLIC_INTERESTED_SELECTED:
            case TOXICLE_PUBLIC_GOING_SELECTED:
            case TOXICLE_PUBLIC_GOING_SELECTED_WITH_CHEVRON:
            case TOXICLE_PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON:
                return true;
            default:
                return false;
        }
    }

    private void m18481a(EventsEventBus eventsEventBus, EventsActionBarMenuHandlerProvider eventsActionBarMenuHandlerProvider, Provider<PublicEventsActionBarGoingButtonSelector> provider, AnalyticsLogger analyticsLogger, ImpressionManager impressionManager, InterestedNuxController interestedNuxController, QeAccessor qeAccessor) {
        this.f18120a = eventsEventBus;
        this.f18121b = eventsActionBarMenuHandlerProvider;
        this.f18122c = provider;
        this.f18123d = analyticsLogger;
        this.f18124e = impressionManager;
        this.f18125f = interestedNuxController;
        this.f18126g = qeAccessor;
    }
}
