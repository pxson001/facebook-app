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
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.PublicEventsActionBarGoingButtonSelector;
import com.facebook.events.permalink.interestednux.InterestedNuxController;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: callSMS */
public class EventsActionBar extends InlineActionBar {
    @Inject
    EventsConnectionExperimentController f18073a;
    @Inject
    EventsEventBus f18074b;
    @Inject
    EventsActionBarMenuHandlerProvider f18075c;
    @Inject
    Provider<PublicEventsActionBarGoingButtonSelector> f18076d;
    @Inject
    AnalyticsLogger f18077e;
    @Inject
    ImpressionManager f18078f;
    @Inject
    InterestedNuxController f18079g;
    @Inject
    QeAccessor f18080h;
    private boolean f18081i;
    private Event f18082j;
    public EventsActionBarMenuHandler f18083k;
    private ImmutableList<EventsActionBarButtonType> f18084l = RegularImmutableList.a;
    private EventSavingEventSubscriber f18085m = new EventSavingEventSubscriber();
    private EventUnsavingEventSubscriber f18086n = new EventUnsavingEventSubscriber();
    private EventAnalyticsParams f18087o;

    /* compiled from: callSMS */
    public class EventSavingEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventSavingEventSubscriber {
        public MenuItem f18071a;

        public final void m18434a(MenuItem menuItem) {
            this.f18071a = menuItem;
        }

        public final void m18435b(FbEvent fbEvent) {
            if (this.f18071a != null) {
                this.f18071a.setTitle(2131237030);
                this.f18071a.setEnabled(false);
            }
        }
    }

    /* compiled from: callSMS */
    public class EventUnsavingEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.EventUnsavingEventSubscriber {
        public MenuItem f18072a;

        public final void m18436a(MenuItem menuItem) {
            this.f18072a = menuItem;
        }

        public final void m18437b(FbEvent fbEvent) {
            if (this.f18072a != null) {
                this.f18072a.setTitle(2131237032);
                this.f18072a.setEnabled(false);
            }
        }
    }

    private static <T extends View> void m18443a(Class<T> cls, T t) {
        m18444a((Object) t, t.getContext());
    }

    private static void m18444a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventsActionBar) obj).m18439a(EventsConnectionExperimentController.a(fbInjector), EventsEventBus.a(fbInjector), (EventsActionBarMenuHandlerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventsActionBarMenuHandlerProvider.class), IdBasedProvider.a(fbInjector, 5634), AnalyticsLoggerMethodAutoProvider.a(fbInjector), ImpressionManager.a(fbInjector), InterestedNuxController.m18900b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m18446b(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(Event.a(this.f18082j));
        if (this.f18082j.A) {
            if (this.f18082j.a(EventViewerCapability.ADMIN)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            }
            if (this.f18082j.G) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_INVITED);
            } else {
                GraphQLEventWatchStatus graphQLEventWatchStatus = this.f18082j.C;
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED) {
                    if (((PublicEventsActionBarGoingButtonSelector) this.f18076d.get()).m18309b()) {
                        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON);
                    } else {
                        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_INTERESTED_SELECTED);
                        eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_GOING);
                    }
                } else if (graphQLEventWatchStatus != GraphQLEventWatchStatus.GOING) {
                    eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_INTERESTED);
                    eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_GOING);
                    this.f18081i = true;
                } else if (((PublicEventsActionBarGoingButtonSelector) this.f18076d.get()).m18308a()) {
                    eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_GOING_SELECTED_WITH_CHEVRON);
                } else {
                    eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_INTERESTED);
                    eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PUBLIC_GOING_SELECTED);
                }
            }
        } else if (this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18082j.x) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANCELLED);
        }
        m18449c(eventActionBarButtonsBuilder);
    }

    public EventsActionBar(Context context) {
        super(context);
        m18438a();
    }

    public EventsActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18438a();
    }

    public EventsActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18438a();
    }

    private void m18438a() {
        m18443a(EventsActionBar.class, (View) this);
        this.f18083k = this.f18075c.m18475a(this);
        this.b = this.f18083k;
        setVisibility(8);
        a(false, true, 0);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 393433339);
        super.onAttachedToWindow();
        this.f18074b.a(this.f18085m);
        this.f18074b.a(this.f18086n);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1747055118, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -639578496);
        this.f18074b.b(this.f18085m);
        this.f18074b.b(this.f18086n);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -220504957, a);
    }

    public final void b_(MenuBuilder menuBuilder) {
        HoneyClientEventFast a = this.f18077e.a("event_action_bar_overflow_button_click", true);
        if (a.a()) {
            String str;
            a.a("event_permalink");
            a.d(this.f18078f.b(getContext()));
            a.b("Event");
            if (this.f18082j != null) {
                str = this.f18082j.a;
            } else {
                str = null;
            }
            a.c(str);
            if (this.f18087o != null) {
                a.a("ref_module", this.f18087o.c);
                a.a("source_module", this.f18087o.d);
                a.a("ref_mechanism", this.f18087o.e);
            }
            a.b();
        }
        this.f18080h.a(Liveness.Cached, ExperimentsForEventsGatingModule.s);
    }

    @VisibleForTesting
    ImmutableList<EventsActionBarButtonType> getButtons() {
        return this.f18084l;
    }

    public final void m18454a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, @Nonnull EventAnalyticsParams eventAnalyticsParams, ActionItemPost actionItemPost, ActionItemInvite actionItemInvite) {
        this.f18087o = eventAnalyticsParams;
        PublicEventsActionBarGoingButtonSelector publicEventsActionBarGoingButtonSelector = (PublicEventsActionBarGoingButtonSelector) this.f18076d.get();
        boolean z = event.G;
        GraphQLEventWatchStatus graphQLEventWatchStatus = event.C;
        if (!z) {
            if (publicEventsActionBarGoingButtonSelector.f17895a == 0) {
                if (graphQLEventWatchStatus == GraphQLEventWatchStatus.GOING) {
                    publicEventsActionBarGoingButtonSelector.f17895a = 1;
                } else {
                    publicEventsActionBarGoingButtonSelector.f17895a = 2;
                }
            } else if (publicEventsActionBarGoingButtonSelector.f17895a == 1 && graphQLEventWatchStatus == GraphQLEventWatchStatus.UNWATCHED) {
                publicEventsActionBarGoingButtonSelector.f17895a = 2;
            }
        }
        this.f18083k.m18469a(eventAnalyticsParams, actionItemPost, actionItemInvite);
        m18440a(event, fetchEventPermalinkFragmentModel);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18081i && this.f18079g.m18902a()) {
            this.f18079g.m18901a(getChildAt(0));
        }
    }

    private void m18440a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f18082j = event;
        this.f18083k.m18471a(event, fetchEventPermalinkFragmentModel);
        m18448c();
    }

    private void m18448c() {
        if (this.f18082j != null) {
            EventActionBarButtonsBuilder eventActionBarButtonsBuilder = new EventActionBarButtonsBuilder(4);
            if (1 == 0) {
                m18450d(eventActionBarButtonsBuilder);
                m18452e(eventActionBarButtonsBuilder);
            } else if (Event.a(this.f18082j)) {
                m18446b(eventActionBarButtonsBuilder);
            } else {
                m18441a(eventActionBarButtonsBuilder);
            }
            m18453f(eventActionBarButtonsBuilder);
            setMaxNumOfVisibleButtons(eventActionBarButtonsBuilder.m18417a());
            ImmutableList copyOf = ImmutableList.copyOf(eventActionBarButtonsBuilder.iterator());
            if (!copyOf.equals(this.f18084l)) {
                this.f18084l = copyOf;
                m18451e();
            }
        }
    }

    private void m18441a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18082j.A) {
            if (this.f18082j.a(EventViewerCapability.ADMIN)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            }
            GraphQLEventGuestStatus D = this.f18082j.D();
            if (D == GraphQLEventGuestStatus.GOING) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PRIVATE_GOING_SELECTED);
            } else if (D == GraphQLEventGuestStatus.MAYBE) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PRIVATE_MAYBE_SELECTED);
            } else if (D == GraphQLEventGuestStatus.NOT_GOING) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PRIVATE_CANT_GO_SELECTED);
            } else if (this.f18082j.G || this.f18082j.ai != null) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PRIVATE_INVITED);
            } else {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.OPTIMISTIC_JOIN);
            }
        } else if (this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18082j.x) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANCELLED);
        }
        if (this.f18082j.as()) {
            m18442a(eventActionBarButtonsBuilder, true);
            if (this.f18082j.a(EventViewerCapability.INVITE)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.INVITE);
                return;
            }
            return;
        }
        if (this.f18082j.a(EventViewerCapability.INVITE)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.INVITE);
        }
        m18442a(eventActionBarButtonsBuilder, false);
    }

    private void m18442a(EventActionBarButtonsBuilder eventActionBarButtonsBuilder, boolean z) {
        if (this.f18082j.Z == null) {
            return;
        }
        if (z) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.PHOTOS);
        } else {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.PHOTOS, EventsActionBarButtonType.PHOTOS_OVERFLOW);
        }
    }

    private void m18449c(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18082j.a(EventViewerCapability.INVITE)) {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.INVITE, EventsActionBarButtonType.INVITE_OVERFLOW);
        }
        if (this.f18082j.a(EventViewerCapability.SHARE)) {
            eventActionBarButtonsBuilder.m18419a(EventsActionBarButtonType.SHARE, EventsActionBarButtonType.SHARE_OVERFLOW);
        }
    }

    private void m18450d(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18082j.A) {
            if (this.f18082j.a(EventViewerCapability.ADMIN)) {
                eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EDIT);
            }
            GraphQLEventGuestStatus D = this.f18082j.D();
            if (D == GraphQLEventGuestStatus.GOING) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.GOING_SELECTED);
            } else if (D == GraphQLEventGuestStatus.MAYBE) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.MAYBED);
            } else if (D == GraphQLEventGuestStatus.NOT_GOING) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANT_GO_SELECTED);
            } else if (this.f18082j.G || this.f18082j.ai != null) {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.GOING);
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.MAYBE);
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANT_GO);
            } else {
                eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.JOIN);
            }
        } else if (this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CREATOR_EDIT);
        } else if (this.f18082j.x) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.CANCELLED);
        }
    }

    private void m18452e(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18082j.a(EventViewerCapability.POST)) {
            eventActionBarButtonsBuilder.m18418a(EventsActionBarButtonType.POST);
        }
        m18449c(eventActionBarButtonsBuilder);
    }

    private void m18453f(EventActionBarButtonsBuilder eventActionBarButtonsBuilder) {
        if (this.f18083k.m18472a()) {
            EventsActionBarButtonType eventsActionBarButtonType;
            if (this.f18082j.D) {
                eventsActionBarButtonType = EventsActionBarButtonType.SAVED;
            } else {
                eventsActionBarButtonType = EventsActionBarButtonType.SAVE;
            }
            eventActionBarButtonsBuilder.m18420b(eventsActionBarButtonType);
        }
        if (this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.DELETE);
        }
        eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.COPY_LINK);
        if (this.f18080h.a(ExperimentsForEventsGatingModule.t, false)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.EXPORT_TO_CALENDAR);
        }
        this.f18082j.b();
        eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.NOTIFICATION_SETTINGS);
        if (this.f18080h.a(ExperimentsForEventsGatingModule.u, false) && this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.CANCEL_EVENT);
        }
        if (!this.f18082j.a(EventViewerCapability.ADMIN)) {
            eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.REPORT_EVENT);
        }
        eventActionBarButtonsBuilder.m18420b(EventsActionBarButtonType.CREATE_EVENT);
    }

    private void m18451e() {
        b();
        clear();
        int size = this.f18084l.size();
        for (int i = 0; i < size; i++) {
            EventsActionBarButtonType eventsActionBarButtonType = (EventsActionBarButtonType) this.f18084l.get(i);
            MenuItem icon = a(0, eventsActionBarButtonType.ordinal(), 0, eventsActionBarButtonType.getTitleResId()).setEnabled(m18445a(eventsActionBarButtonType)).setCheckable(true).setChecked(m18447b(eventsActionBarButtonType)).setIcon(eventsActionBarButtonType.getIconResId());
            if (eventsActionBarButtonType.isOverflow()) {
                MenuItemCompat.a(icon, 0);
            } else {
                MenuItemCompat.a(icon, 2);
            }
            if (eventsActionBarButtonType == EventsActionBarButtonType.SAVE) {
                this.f18085m.f18071a = icon;
            }
            if (eventsActionBarButtonType == EventsActionBarButtonType.SAVED) {
                this.f18086n.f18072a = icon;
            }
        }
        d();
        setVisibility(0);
    }

    private static boolean m18445a(EventsActionBarButtonType eventsActionBarButtonType) {
        return eventsActionBarButtonType != EventsActionBarButtonType.CANCELLED;
    }

    private static boolean m18447b(EventsActionBarButtonType eventsActionBarButtonType) {
        switch (eventsActionBarButtonType) {
            case CREATOR_EDIT:
            case PRIVATE_GOING_SELECTED:
            case PRIVATE_MAYBE_SELECTED:
            case PRIVATE_CANT_GO_SELECTED:
            case GOING_SELECTED:
            case MAYBED:
            case CANT_GO_SELECTED:
            case PUBLIC_INTERESTED_SELECTED:
            case PUBLIC_GOING_SELECTED:
            case PUBLIC_GOING_SELECTED_WITH_CHEVRON:
            case PUBLIC_INTERESTED_SELECTED_WITH_CHEVRON:
                return true;
            default:
                return false;
        }
    }

    private void m18439a(EventsConnectionExperimentController eventsConnectionExperimentController, EventsEventBus eventsEventBus, EventsActionBarMenuHandlerProvider eventsActionBarMenuHandlerProvider, Provider<PublicEventsActionBarGoingButtonSelector> provider, AnalyticsLogger analyticsLogger, ImpressionManager impressionManager, InterestedNuxController interestedNuxController, QeAccessor qeAccessor) {
        this.f18073a = eventsConnectionExperimentController;
        this.f18074b = eventsEventBus;
        this.f18075c = eventsActionBarMenuHandlerProvider;
        this.f18076d = provider;
        this.f18077e = analyticsLogger;
        this.f18078f = impressionManager;
        this.f18079g = interestedNuxController;
        this.f18080h = qeAccessor;
    }
}
