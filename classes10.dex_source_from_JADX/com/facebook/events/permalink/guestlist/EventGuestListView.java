package com.facebook.events.permalink.guestlist;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.event.FbEvent;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.RsvpChangeEvent;
import com.facebook.events.graphql.EventsGraphQLInterfaces.UserInEventFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventWatchersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventViewerCapabilityModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventViewerCapability;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.guestlist.EventGuestListCountView.EventGuestCountModel;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.events.permalink.guestlist.common.EventsGuestListFragmentNavigationHelper;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel.Builder;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.resources.ui.FbTextView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bookmarks_group */
public class EventGuestListView extends SegmentedLinearLayout {
    @Inject
    EventsEventBus f18479a;
    @Inject
    EventPermalinkController f18480b;
    @Inject
    EventsGuestListFragmentNavigationHelper f18481c;
    @Inject
    ViewerContextManager f18482d;
    @Inject
    MessengerAppUtils f18483e;
    @Inject
    EventEventLogger f18484f;
    @Inject
    EventsConnectionExperimentController f18485g;
    @Inject
    EventSocialContextFormatter f18486h;
    public Event f18487i;
    private boolean f18488j;
    private FbTextView f18489k;
    private PlaintextGuestSummaryView f18490l;
    public EventGuestTileRowView f18491m;
    private View f18492n;
    public EventGuestListCountsView f18493o;
    private final SendingInviteEventSubscriber f18494p = new SendingInviteEventSubscriber(this);
    private final SendingInviteFailedEventSubscriber f18495q = new SendingInviteFailedEventSubscriber(this);
    private final RsvpChangeEventSubscriber f18496r = new RsvpChangeEventSubscriber(this);

    /* compiled from: bookmarks_group */
    /* synthetic */ class C26273 {
        static final /* synthetic */ int[] f18473a = new int[EventGuestListType.values().length];
        static final /* synthetic */ int[] f18474b = new int[GraphQLEventGuestStatus.values().length];
        static final /* synthetic */ int[] f18475c = new int[EventStatus.values().length];

        static {
            try {
                f18475c[EventStatus.SENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18475c[EventStatus.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18474b[GraphQLEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18474b[GraphQLEventGuestStatus.MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18474b[GraphQLEventGuestStatus.INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18473a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18473a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18473a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f18473a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: bookmarks_group */
    class RsvpChangeEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.RsvpChangeEventSubscriber {
        final /* synthetic */ EventGuestListView f18476a;

        public RsvpChangeEventSubscriber(EventGuestListView eventGuestListView) {
            this.f18476a = eventGuestListView;
        }

        public final void m18795b(FbEvent fbEvent) {
            RsvpChangeEvent rsvpChangeEvent = (RsvpChangeEvent) fbEvent;
            if (rsvpChangeEvent != null && Objects.equal(rsvpChangeEvent.c.a, this.f18476a.f18487i.a)) {
                switch (C26273.f18475c[rsvpChangeEvent.a.ordinal()]) {
                    case 1:
                        switch (C26273.f18474b[rsvpChangeEvent.c.D().ordinal()]) {
                            case 1:
                                this.f18476a.f18493o.f18357a.m18692a();
                                break;
                            case 2:
                                this.f18476a.f18493o.f18358b.m18692a();
                                break;
                        }
                        this.f18476a.f18491m.m18832a(rsvpChangeEvent.c);
                        switch (C26273.f18474b[rsvpChangeEvent.b.D().ordinal()]) {
                            case 1:
                                this.f18476a.f18493o.f18357a.m18694b();
                                return;
                            case 2:
                                this.f18476a.f18493o.f18358b.m18694b();
                                return;
                            case 3:
                                this.f18476a.f18493o.f18359c.m18694b();
                                return;
                            default:
                                return;
                        }
                    case 2:
                        switch (C26273.f18474b[rsvpChangeEvent.c.D().ordinal()]) {
                            case 1:
                                this.f18476a.f18493o.f18357a.m18694b();
                                break;
                            case 2:
                                this.f18476a.f18493o.f18358b.m18694b();
                                break;
                        }
                        if (rsvpChangeEvent.b.D() != null) {
                            switch (C26273.f18474b[rsvpChangeEvent.b.D().ordinal()]) {
                                case 1:
                                    this.f18476a.f18491m.m18832a(rsvpChangeEvent.c);
                                    this.f18476a.f18493o.f18357a.m18692a();
                                    return;
                                case 2:
                                    this.f18476a.f18491m.m18832a(rsvpChangeEvent.c);
                                    this.f18476a.f18493o.f18358b.m18692a();
                                    return;
                                case 3:
                                    this.f18476a.f18491m.m18832a(rsvpChangeEvent.c);
                                    this.f18476a.f18493o.f18359c.m18692a();
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.f18476a.f18491m.m18832a(rsvpChangeEvent.c);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: bookmarks_group */
    class SendingInviteEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.SendingInviteEventSubscriber {
        final /* synthetic */ EventGuestListView f18477a;

        public SendingInviteEventSubscriber(EventGuestListView eventGuestListView) {
            this.f18477a = eventGuestListView;
        }

        public final void m18796b(FbEvent fbEvent) {
            this.f18477a.f18493o.f18359c.setInProgress(true);
        }
    }

    /* compiled from: bookmarks_group */
    class SendingInviteFailedEventSubscriber extends com.facebook.events.eventsevents.EventsEvents.SendingInviteFailedEventSubscriber {
        final /* synthetic */ EventGuestListView f18478a;

        public SendingInviteFailedEventSubscriber(EventGuestListView eventGuestListView) {
            this.f18478a = eventGuestListView;
        }

        public final void m18797b(FbEvent fbEvent) {
            this.f18478a.f18493o.f18359c.setInProgress(false);
        }
    }

    private static <T extends View> void m18802a(Class<T> cls, T t) {
        m18803a((Object) t, t.getContext());
    }

    private static void m18803a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventGuestListView) obj).m18799a(EventsEventBus.a(injectorLike), EventPermalinkController.m18262b(injectorLike), EventsGuestListFragmentNavigationHelper.b(injectorLike), ViewerContextManagerProvider.b(injectorLike), MessengerAppUtils.a(injectorLike), EventEventLogger.m18119b(injectorLike), EventsConnectionExperimentController.a(injectorLike), EventSocialContextFormatter.b(injectorLike));
    }

    private void m18799a(EventsEventBus eventsEventBus, EventPermalinkController eventPermalinkController, EventsGuestListFragmentNavigationHelper eventsGuestListFragmentNavigationHelper, ViewerContextManager viewerContextManager, MessengerAppUtils messengerAppUtils, EventEventLogger eventEventLogger, EventsConnectionExperimentController eventsConnectionExperimentController, EventSocialContextFormatter eventSocialContextFormatter) {
        this.f18479a = eventsEventBus;
        this.f18480b = eventPermalinkController;
        this.f18481c = eventsGuestListFragmentNavigationHelper;
        this.f18482d = viewerContextManager;
        this.f18483e = messengerAppUtils;
        this.f18484f = eventEventLogger;
        this.f18485g = eventsConnectionExperimentController;
        this.f18486h = eventSocialContextFormatter;
    }

    public EventGuestListView(Context context) {
        super(context);
        m18798a();
    }

    public EventGuestListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18798a();
    }

    private void m18798a() {
        m18802a(EventGuestListView.class, (View) this);
        setContentView(2130904040);
        this.f18492n = a(2131561308);
    }

    private static boolean m18804a(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        if (fetchEventPermalinkFragmentModel == null) {
            return false;
        }
        EventViewerCapabilityModel aF = fetchEventPermalinkFragmentModel.aF();
        if (aF == null) {
            return false;
        }
        GraphQLEventSeenState p = aF.p();
        if (p == GraphQLEventSeenState.SEEN || p == GraphQLEventSeenState.UNSEEN) {
            return true;
        }
        return false;
    }

    public final void m18822a(Event event, @Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, final EventActionContext eventActionContext) {
        boolean z = false;
        if (fetchEventPermalinkFragmentModel != null) {
            if (fetchEventPermalinkFragmentModel.af()) {
                this.f18487i = event;
                setVisibility(0);
                if (Event.a(event) && 1 != 0) {
                    z = true;
                }
                this.f18488j = z;
                if (this.f18492n != null) {
                    removeView(this.f18492n);
                    this.f18492n = null;
                    setContentView(2130904035);
                    this.f18490l = (PlaintextGuestSummaryView) a(2131561292);
                    this.f18491m = (EventGuestTileRowView) a(2131561291);
                    m18819d();
                    if (getEventGuestListTypes(this) && event.d == GraphQLEventPrivacyType.PRIVATE_TYPE && this.f18483e.a("19.0")) {
                        m18800a(fetchEventPermalinkFragmentModel, eventActionContext);
                    }
                    setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ EventGuestListView f18469c;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 670277543);
                            Builder builder = new Builder(fetchEventPermalinkFragmentModel.dL_());
                            builder.a = eventActionContext;
                            Builder builder2 = builder;
                            builder2.c = fetchEventPermalinkFragmentModel.dM_();
                            builder2 = builder2;
                            builder2.d = fetchEventPermalinkFragmentModel.B();
                            builder2 = builder2;
                            builder2.e = fetchEventPermalinkFragmentModel.k();
                            builder2 = builder2;
                            builder2.f = fetchEventPermalinkFragmentModel.o();
                            builder2 = builder2;
                            builder2.g = EventGuestListView.getEventGuestListTypes(this.f18469c);
                            builder2 = builder2;
                            builder2.h = this.f18469c.m18808b(fetchEventPermalinkFragmentModel);
                            builder2.i = EventGuestListView.m18804a(fetchEventPermalinkFragmentModel);
                            this.f18469c.f18481c.a(this.f18469c.getContext(), builder.a());
                            Logger.a(2, EntryType.UI_INPUT_END, -1551780248, a);
                        }
                    });
                }
                if (this.f18488j) {
                    m18815c(event, fetchEventPermalinkFragmentModel, eventActionContext);
                    return;
                } else {
                    m18811b(event, fetchEventPermalinkFragmentModel, eventActionContext);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    public static boolean m18812b(EventGuestListView eventGuestListView) {
        return eventGuestListView.f18487i.a(EventViewerCapability.ADMIN);
    }

    private boolean m18816c() {
        return Event.a(this.f18487i.d);
    }

    private ImmutableList<EventGuestSingleListModel> m18808b(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        ImmutableList eventGuestListTypes = getEventGuestListTypes(this);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = eventGuestListTypes.size();
        for (int i = 0; i < size; i++) {
            EventGuestListType eventGuestListType = (EventGuestListType) eventGuestListTypes.get(i);
            if (m18816c()) {
                int a;
                int a2;
                Integer valueOf;
                switch (C26273.f18473a[eventGuestListType.ordinal()]) {
                    case 1:
                        a = fetchEventPermalinkFragmentModel.at() != null ? fetchEventPermalinkFragmentModel.at().a() : 0;
                        if (fetchEventPermalinkFragmentModel.aD() != null) {
                            a2 = fetchEventPermalinkFragmentModel.aD().a();
                        } else {
                            a2 = 0;
                        }
                        if (fetchEventPermalinkFragmentModel.ax() != null) {
                            valueOf = Integer.valueOf(fetchEventPermalinkFragmentModel.ax().a());
                        } else {
                            valueOf = null;
                        }
                        builder.c(new EventGuestSingleListModel(eventGuestListType, valueOf, a + a2));
                        break;
                    case 2:
                        a = fetchEventPermalinkFragmentModel.aq() != null ? fetchEventPermalinkFragmentModel.aq().a() : 0;
                        if (fetchEventPermalinkFragmentModel.aA() != null) {
                            a2 = fetchEventPermalinkFragmentModel.aA().a();
                        } else {
                            a2 = 0;
                        }
                        if (fetchEventPermalinkFragmentModel.aw() != null) {
                            valueOf = Integer.valueOf(fetchEventPermalinkFragmentModel.aw().a());
                        } else {
                            valueOf = null;
                        }
                        builder.c(new EventGuestSingleListModel(eventGuestListType, valueOf, a + a2));
                        break;
                    case 3:
                        a = fetchEventPermalinkFragmentModel.as() != null ? fetchEventPermalinkFragmentModel.as().a() : 0;
                        if (fetchEventPermalinkFragmentModel.aC() != null) {
                            a2 = fetchEventPermalinkFragmentModel.aC().a();
                        } else {
                            a2 = 0;
                        }
                        if (fetchEventPermalinkFragmentModel.av() != null) {
                            valueOf = Integer.valueOf(fetchEventPermalinkFragmentModel.av().a());
                        } else {
                            valueOf = null;
                        }
                        builder.c(new EventGuestSingleListModel(eventGuestListType, valueOf, a + a2));
                        break;
                    case 4:
                        a = fetchEventPermalinkFragmentModel.ar() != null ? fetchEventPermalinkFragmentModel.ar().a() : 0;
                        if (fetchEventPermalinkFragmentModel.aB() != null) {
                            a2 = fetchEventPermalinkFragmentModel.aB().a();
                        } else {
                            a2 = 0;
                        }
                        if (fetchEventPermalinkFragmentModel.ao() != null) {
                            valueOf = Integer.valueOf(fetchEventPermalinkFragmentModel.ao().a());
                        } else {
                            valueOf = null;
                        }
                        builder.c(new EventGuestSingleListModel(eventGuestListType, valueOf, a + a2));
                        break;
                    default:
                        builder.c(new EventGuestSingleListModel(eventGuestListType));
                        break;
                }
            }
            builder.c(new EventGuestSingleListModel(eventGuestListType));
        }
        return builder.b();
    }

    public static ImmutableList getEventGuestListTypes(EventGuestListView eventGuestListView) {
        if (eventGuestListView.f18488j) {
            return ImmutableList.of(EventGuestListType.PUBLIC_WATCHED, EventGuestListType.PUBLIC_GOING, EventGuestListType.PUBLIC_INVITED);
        }
        return (eventGuestListView.m18816c() && getEventGuestListTypes(eventGuestListView)) ? ImmutableList.of(EventGuestListType.PRIVATE_GOING, EventGuestListType.PRIVATE_MAYBE, EventGuestListType.PRIVATE_INVITED, EventGuestListType.PRIVATE_NOT_GOING) : ImmutableList.of(EventGuestListType.PRIVATE_GOING, EventGuestListType.PRIVATE_MAYBE, EventGuestListType.PRIVATE_INVITED);
    }

    private void m18811b(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventActionContext eventActionContext) {
        boolean z;
        boolean z2;
        ImmutableList a;
        int size;
        int i;
        ImmutableList b;
        int b2;
        if (fetchEventPermalinkFragmentModel.aF() != null) {
            boolean o = fetchEventPermalinkFragmentModel.aF().o();
            GraphQLEventSeenState p = fetchEventPermalinkFragmentModel.aF().p();
            boolean z3 = p == GraphQLEventSeenState.SEEN || p == GraphQLEventSeenState.UNSEEN;
            z = z3;
            z2 = o;
        } else {
            z = false;
            z2 = false;
        }
        int c = m18813c(fetchEventPermalinkFragmentModel);
        int d = m18817d(fetchEventPermalinkFragmentModel);
        int e = m18820e(fetchEventPermalinkFragmentModel);
        FriendEventMembersFirst5Model aJ = fetchEventPermalinkFragmentModel.aJ();
        if (aJ != null) {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            a = aJ.a();
            size = a.size();
            for (i = 0; i < size; i++) {
                builder.c(((EdgesModel) a.get(i)).j());
            }
            b = builder.b();
            b2 = aJ.b();
        } else {
            b = ImmutableList.of();
            b2 = 0;
        }
        FriendEventMaybesFirst5Model aI = fetchEventPermalinkFragmentModel.aI();
        if (aI != null) {
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            ImmutableList a2 = aI.a();
            int size2 = a2.size();
            for (i = 0; i < size2; i++) {
                builder2.c(((FriendEventMaybesFirst5Model.EdgesModel) a2.get(i)).j());
            }
            a = builder2.b();
            size = aI.b();
        } else {
            a = ImmutableList.of();
            size = 0;
        }
        m18801a(event, fetchEventPermalinkFragmentModel, b, a);
        this.f18490l.m18860a(fetchEventPermalinkFragmentModel.o(), b, b2, a, size);
        Builder builder3 = new Builder(fetchEventPermalinkFragmentModel.dL_());
        builder3.a(fetchEventPermalinkFragmentModel.dM_()).a(fetchEventPermalinkFragmentModel.B()).a(fetchEventPermalinkFragmentModel.k()).a(fetchEventPermalinkFragmentModel.o()).a(z2).b(z).a(m18808b(fetchEventPermalinkFragmentModel)).a(eventActionContext);
        this.f18493o.m18700a(builder3.a(), new EventGuestCountModel(d, getContext().getString(2131237077), (EventGuestListType) getEventGuestListTypes(this).get(0)), new EventGuestCountModel(e, getContext().getString(2131237078), (EventGuestListType) getEventGuestListTypes(this).get(1)), new EventGuestCountModel(c, getContext().getString(2131237079), (EventGuestListType) getEventGuestListTypes(this).get(2)));
    }

    private static int m18813c(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int i = 0;
        int a = (fetchEventPermalinkFragmentModel.av() != null ? fetchEventPermalinkFragmentModel.av().a() : 0) + (fetchEventPermalinkFragmentModel.as() == null ? 0 : fetchEventPermalinkFragmentModel.as().a());
        if (fetchEventPermalinkFragmentModel.aC() != null) {
            i = fetchEventPermalinkFragmentModel.aC().a();
        }
        return a + i;
    }

    private static int m18817d(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int i = 0;
        int a = (fetchEventPermalinkFragmentModel.ax() != null ? fetchEventPermalinkFragmentModel.ax().a() : 0) + (fetchEventPermalinkFragmentModel.at() == null ? 0 : fetchEventPermalinkFragmentModel.at().a());
        if (fetchEventPermalinkFragmentModel.aD() != null) {
            i = fetchEventPermalinkFragmentModel.aD().a();
        }
        return a + i;
    }

    private static int m18820e(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int i = 0;
        int a = (fetchEventPermalinkFragmentModel.aw() != null ? fetchEventPermalinkFragmentModel.aw().a() : 0) + (fetchEventPermalinkFragmentModel.aq() == null ? 0 : fetchEventPermalinkFragmentModel.aq().a());
        if (fetchEventPermalinkFragmentModel.aA() != null) {
            i = fetchEventPermalinkFragmentModel.aA().a();
        }
        return a + i;
    }

    private void m18815c(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventActionContext eventActionContext) {
        boolean o;
        boolean z;
        int a;
        ImmutableList b;
        ImmutableList b2;
        if (fetchEventPermalinkFragmentModel.aF() != null) {
            o = fetchEventPermalinkFragmentModel.aF().o();
            GraphQLEventSeenState p = fetchEventPermalinkFragmentModel.aF().p();
            boolean z2 = p == GraphQLEventSeenState.SEEN || p == GraphQLEventSeenState.UNSEEN;
            z = o;
            o = z2;
        } else {
            z = false;
            o = false;
        }
        int a2 = fetchEventPermalinkFragmentModel.ax() != null ? fetchEventPermalinkFragmentModel.ax().a() : 0;
        int a3 = fetchEventPermalinkFragmentModel.aG() != null ? fetchEventPermalinkFragmentModel.aG().a() : 0;
        if (fetchEventPermalinkFragmentModel.av() != null) {
            a = fetchEventPermalinkFragmentModel.av().a();
        } else {
            a = 0;
        }
        FriendEventMembersFirst5Model aJ = fetchEventPermalinkFragmentModel.aJ();
        if (aJ != null) {
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList a4 = aJ.a();
            int size = a4.size();
            for (int i = 0; i < size; i++) {
                builder.c(((EdgesModel) a4.get(i)).j());
            }
            b = builder.b();
        } else {
            b = RegularImmutableList.a;
        }
        FriendEventWatchersFirst5Model aK = fetchEventPermalinkFragmentModel.aK();
        if (aK != null) {
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            ImmutableList a5 = aK.a();
            int size2 = a5.size();
            for (int i2 = 0; i2 < size2; i2++) {
                builder2.c(((FriendEventWatchersFirst5Model.EdgesModel) a5.get(i2)).j());
            }
            b2 = builder2.b();
        } else {
            b2 = ImmutableList.of();
        }
        m18801a(event, fetchEventPermalinkFragmentModel, b, b2);
        this.f18490l.setDefaultText(this.f18486h.a(event));
        String string = getContext().getString(2131237077);
        String string2 = getContext().getString(2131237080);
        String string3 = getContext().getString(2131237079);
        Builder builder3 = new Builder(fetchEventPermalinkFragmentModel.dL_());
        builder3.c = fetchEventPermalinkFragmentModel.dM_();
        Builder builder4 = builder3;
        builder4.d = fetchEventPermalinkFragmentModel.B();
        builder4 = builder4;
        builder4.e = fetchEventPermalinkFragmentModel.k();
        builder4 = builder4;
        builder4.f = fetchEventPermalinkFragmentModel.o();
        builder4 = builder4;
        builder4.g = z;
        builder4 = builder4;
        builder4.i = o;
        builder4 = builder4;
        builder4.h = m18808b(fetchEventPermalinkFragmentModel);
        builder4.a = eventActionContext;
        this.f18493o.m18700a(builder3.a(), new EventGuestCountModel(a3, string2, (EventGuestListType) getEventGuestListTypes(this).get(0)), new EventGuestCountModel(a2, string, (EventGuestListType) getEventGuestListTypes(this).get(1)), new EventGuestCountModel(a, string3, (EventGuestListType) getEventGuestListTypes(this).get(2)));
    }

    private void m18800a(@Nullable final FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, final EventActionContext eventActionContext) {
        this.f18489k = (FbTextView) a(2131561294);
        this.f18489k.setVisibility(0);
        this.f18489k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventGuestListView f18472c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1747454677);
                EventPermalinkController eventPermalinkController = this.f18472c.f18480b;
                Context context = this.f18472c.getContext();
                FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel = fetchEventPermalinkFragmentModel;
                EventActionContext eventActionContext = eventActionContext;
                ImmutableList eventGuestListTypes = EventGuestListView.getEventGuestListTypes(this.f18472c);
                Intent component = new Intent().setComponent((ComponentName) eventPermalinkController.f17857d.get());
                component.putExtra("target_fragment", ContentFragmentType.EVENTS_MESSAGE_GUESTS_FRAGMENT.ordinal());
                Bundle bundle = new Bundle();
                bundle.putString("EVENT_ID", fetchEventPermalinkFragmentModel.dL_());
                if (fetchEventPermalinkFragmentModel.aF() != null) {
                    GraphQLEventSeenState p = fetchEventPermalinkFragmentModel.aF().p();
                    String str = "EVENT_HAS_SEEN_STATE";
                    boolean z = p == GraphQLEventSeenState.SEEN || p == GraphQLEventSeenState.UNSEEN;
                    bundle.putBoolean(str, z);
                    bundle.putBoolean("EVENT_IS_HOST", fetchEventPermalinkFragmentModel.aF().o());
                }
                if (fetchEventPermalinkFragmentModel.B() != null) {
                    bundle.putString("EVENT_KIND", fetchEventPermalinkFragmentModel.B().toString());
                }
                bundle.putString("EVENT_NAME", fetchEventPermalinkFragmentModel.dM_());
                if (!(fetchEventPermalinkFragmentModel.ag() == null || fetchEventPermalinkFragmentModel.ag().k() == null || fetchEventPermalinkFragmentModel.ag().k().n() == null)) {
                    bundle.putString("EVENT_PHOTO_URL", fetchEventPermalinkFragmentModel.ag().k().n().b());
                }
                if (EventsDateUtil.a(fetchEventPermalinkFragmentModel.dN_())) {
                    bundle.putString("EVENT_TIME", fetchEventPermalinkFragmentModel.aL());
                }
                if (!(fetchEventPermalinkFragmentModel.ay() == null || fetchEventPermalinkFragmentModel.ay().dU_() == null)) {
                    bundle.putString("EVENT_LOCATION", fetchEventPermalinkFragmentModel.ay().dU_());
                }
                bundle.putParcelable("extras_event_action_context", eventActionContext);
                EventGuestListType.writeGuestListTypesList(bundle, "EVENT_GUEST_LIST_TYPES", eventGuestListTypes);
                component.putExtras(bundle);
                eventPermalinkController.f17855b.a(component, context);
                this.f18472c.f18484f.m18145d(fetchEventPermalinkFragmentModel.dL_());
                Logger.a(2, EntryType.UI_INPUT_END, -1472577029, a);
            }
        });
    }

    private void m18801a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, ImmutableList<UserInEventFragment> immutableList, ImmutableList<UserInEventFragment> immutableList2) {
        this.f18491m.m18833a(event, (ImmutableList) immutableList, (ImmutableList) immutableList2);
        if (m18807a(this.f18482d.d().mUserId, (ImmutableList) immutableList, (ImmutableList) immutableList2)) {
            a(2131561290).setVisibility(0);
        } else {
            a(2131561290).setVisibility(8);
        }
    }

    @VisibleForTesting
    private boolean m18807a(String str, ImmutableList<?> immutableList, ImmutableList<?> immutableList2) {
        return ((Strings.isNullOrEmpty(str) || !this.f18491m.m18834a()) && immutableList.isEmpty() && immutableList2.isEmpty()) ? false : true;
    }

    private void m18819d() {
        this.f18493o = (EventGuestListCountsView) a(2131561293);
        this.f18479a.a(this.f18494p);
        this.f18479a.a(this.f18495q);
        this.f18479a.a(this.f18496r);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1118748977);
        if (this.f18493o != null) {
            this.f18479a.b(this.f18496r);
            this.f18479a.b(this.f18495q);
            this.f18479a.b(this.f18494p);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -498089852, a);
    }
}
